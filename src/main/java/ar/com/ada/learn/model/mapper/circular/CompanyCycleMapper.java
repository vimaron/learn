package ar.com.ada.learn.model.mapper.circular;

import ar.com.ada.learn.model.dto.CompanyDTO;
import ar.com.ada.learn.model.entity.Company;
import org.mapstruct.factory.Mappers;

public interface CompanyCycleMapper extends DataCycleMapper<CompanyDTO, Company> {

    CompanyCycleMapper MAPPER = Mappers.getMapper(CompanyCycleMapper.class);
}
