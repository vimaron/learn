package ar.com.ada.learn.service;

import ar.com.ada.learn.component.BusinessLogicExceptionComponent;
import ar.com.ada.learn.model.dto.CompanyDTO;
import ar.com.ada.learn.model.entity.Company;
import ar.com.ada.learn.model.entity.CompanyCategory;
import ar.com.ada.learn.model.mapper.CompanyMapper;
import ar.com.ada.learn.model.mapper.circular.CompanyCycleMapper;
import ar.com.ada.learn.model.mapper.circular.CycleAvoidingMappingContext;
import ar.com.ada.learn.model.repository.CompanyCategoryRepository;
import ar.com.ada.learn.model.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

public class CompanyService implements Services<CompanyDTO>{


    CompanyMapper companyMapper;

    BusinessLogicExceptionComponent businessLogicExceptionComponent;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private CompanyCycleMapper companyCycleMapper = CompanyCycleMapper.MAPPER;

    @Autowired @Qualifier("companyCategoryRepository")
    private CompanyCategoryRepository companyCategoryRepository;

    @Autowired @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Override
    public List<CompanyDTO> findAll() {
        return null;
    }

    @Override
    public CompanyDTO save(CompanyDTO dto) {
        return null;
    }

    public CompanyDTO save(CompanyDTO dto, Long companyCategoryId, Long typeOfCompanyId) {

        CompanyCategory category = companyCategoryRepository.findById(companyCategoryId);
        CompanyDTO companyDtoSaved = null;

        if (category == null){
            businessLogicExceptionComponent.throwExceptionEntityNotFound(
                    "company_category", companyCategoryId);

        }else {
            Company companyToSave = companyCycleMapper.toEntity(dto);
            companyToSave.setCompanyCategory(category);
            Company companySaved = companyRepository.save(companyToSave);
            companyDtoSaved = companyMapper.toDto(companySaved);
        }

        return companyDtoSaved;
    }

    @Override
    public void delete(Long id) {

    }
}
