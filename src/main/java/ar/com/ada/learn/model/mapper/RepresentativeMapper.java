package ar.com.ada.learn.model.mapper;

import ar.com.ada.learn.model.dto.CompanyDTO;
import ar.com.ada.learn.model.dto.RepresentativeDTO;
import ar.com.ada.learn.model.entity.Company;
import ar.com.ada.learn.model.entity.Representative;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {})
public interface RepresentativeMapper extends DataCycleMapper<RepresentativeDTO, Representative> {
    RepresentativeMapper MAPPER = Mappers.getMapper(RepresentativeMapper.class);

    @InheritInverseConfiguration
    @Mapping(target = "companyId", ignore = true)
    RepresentativeDTO toDto(Representative entity, @Context CycleAvoidingMappingContext context);

}
