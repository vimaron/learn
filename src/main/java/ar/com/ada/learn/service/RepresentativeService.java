package ar.com.ada.learn.service;

import ar.com.ada.learn.component.BusinessLogicExceptionComponent;
import ar.com.ada.learn.model.dto.RepresentativeDTO;
import ar.com.ada.learn.model.entity.Company;
import ar.com.ada.learn.model.entity.Representative;
import ar.com.ada.learn.model.mapper.CompanyMapper;
import ar.com.ada.learn.model.mapper.RepresentativeMapper;
import ar.com.ada.learn.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.learn.model.repository.CompanyRepository;
import ar.com.ada.learn.model.repository.RepresentativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("representativeService")
public class RepresentativeService implements Services<RepresentativeDTO>{

    private RepresentativeMapper representativeMapper = RepresentativeMapper.MAPPER;

    private CompanyMapper companyMapper = CompanyMapper.MAPPER;

    BusinessLogicExceptionComponent businessLogicExceptionComponent;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    @Autowired @Qualifier("representativeRepository")
    private RepresentativeRepository representativeRepository;

    @Autowired @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Override
    public List<RepresentativeDTO> findAll() {
        List<Representative> representativeEntityList = representativeRepository.findAll();
        List<RepresentativeDTO> representativeDTOSList = representativeMapper.toDto(representativeEntityList, context);
        return representativeDTOSList;
    }

    @Override
    public RepresentativeDTO save(RepresentativeDTO dto) {
        Long companyId = dto.getCompanyId();
        Company company = companyRepository
                .findById(companyId).orElseThrow(() -> businessLogicExceptionComponent
                        .getExceptionEntityNotFound("Company", companyId));

        Representative representativeToSave = representativeMapper.toEntity(dto, context);
        representativeToSave.setCompany(company);
        Representative representativeSaved = representativeRepository.save(representativeToSave);
        RepresentativeDTO representativeDTOSaved = representativeMapper.toDto(representativeSaved, context);
        return representativeDTOSaved;
    }

    @Override
    public void delete(Long id) {

    }
}
