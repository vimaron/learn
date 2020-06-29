package ar.com.ada.learn.service;

import ar.com.ada.learn.component.BusinessLogicExceptionComponent;
import ar.com.ada.learn.model.dto.CompanyDTO;
import ar.com.ada.learn.model.entity.Company;
import ar.com.ada.learn.model.entity.CompanyCategory;
import ar.com.ada.learn.model.entity.TypeOfCompany;
import ar.com.ada.learn.model.mapper.CompanyMapper;
import ar.com.ada.learn.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.learn.model.repository.CompanyCategoryRepository;
import ar.com.ada.learn.model.repository.CompanyRepository;
import ar.com.ada.learn.model.repository.TypeOfCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("companyService")
public class CompanyService implements Services<CompanyDTO>{


    BusinessLogicExceptionComponent businessLogicExceptionComponent;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private CompanyMapper companyMapper = CompanyMapper.MAPPER;

    @Autowired @Qualifier("companyCategoryRepository")
    private CompanyCategoryRepository companyCategoryRepository;

    @Autowired @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Autowired
    @Qualifier("typeOfCompanyRepository")
    private TypeOfCompanyRepository typeOfCompanyRepository;

    @Override
    public List<CompanyDTO> findAll() {
        return null;
    }

    @Override
    public CompanyDTO save(CompanyDTO dto) {
        Long companyCategoryId = dto.getCompanyCategoryId();
        CompanyCategory companyCategory = companyCategoryRepository
                .findById(companyCategoryId).orElseThrow(() -> businessLogicExceptionComponent
                        .getExceptionEntityNotFound("CompanyCategory", companyCategoryId));
        Long typeOfCompanyId = dto.getTypeOfCompanyId();
        TypeOfCompany typeOfCompany = typeOfCompanyRepository.findById(typeOfCompanyId)
                .orElseThrow(() -> businessLogicExceptionComponent
                        .getExceptionEntityNotFound("TypeOfCompany", typeOfCompanyId));

        Company companyToSave = companyMapper.toEntity(dto, context);
        companyToSave.setCompanyCategory(companyCategory);
        companyToSave.setTypeOfCompany(typeOfCompany);
        Company companySaved = companyRepository.save(companyToSave);
        CompanyDTO companyDTOSaved = companyMapper.toDto(companySaved, context);
        return companyDTOSaved;
    }



    @Override
    public void delete(Long id) {

    }
}
