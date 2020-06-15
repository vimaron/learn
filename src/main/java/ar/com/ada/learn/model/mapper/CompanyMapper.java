package ar.com.ada.learn.model.mapper;


import ar.com.ada.learn.model.dto.CompanyDTO;
import ar.com.ada.learn.model.entity.Company;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends DataCycleMapper<CompanyDTO, Company> {

    CompanyMapper MAPPER = Mappers.getMapper(CompanyMapper.class);

    @InheritInverseConfiguration
    @Mapping(target = "typeOfCompanyId", ignore = true)
    @Mapping(target = "companyCategoryId", ignore = true)
    CompanyDTO toDto(Company entity, @Context CycleAvoidingMappingContext context);


}
