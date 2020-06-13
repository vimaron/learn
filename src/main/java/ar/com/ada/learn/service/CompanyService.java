package ar.com.ada.learn.service;

import ar.com.ada.learn.model.dto.CompanyDTO;
import ar.com.ada.learn.model.entity.Company;
import ar.com.ada.learn.model.mapper.CompanyMapper;
import ar.com.ada.learn.model.mapper.circular.CompanyCycleMapper;
import ar.com.ada.learn.model.mapper.circular.CycleAvoidingMappingContext;
import ar.com.ada.learn.model.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class CompanyService implements Services<CompanyDTO>{

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private CompanyCycleMapper companyCycleMapper = CompanyCycleMapper.MAPPER;

    private CompanyMapper companyMapper;

    @Autowired @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Override
    public List<CompanyDTO> findAll() {
        return null;
    }

    @Override
    public CompanyDTO save(CompanyDTO dto) {

        Company companyToSave = companyCycleMapper.toEntity(dto);
        Company companySaved = companyRepository.save(companyToSave);
        CompanyDTO companyDtoSaved = companyMapper.toDto(companySaved);
        return companyDtoSaved;
    }

    @Override
    public void delete(Long id) {

    }
}
