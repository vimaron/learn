package ar.com.ada.learn.model.mapper;


import ar.com.ada.learn.model.dto.CompanyDTO;
import ar.com.ada.learn.model.entity.Company;
import ar.com.ada.learn.model.mapper.circular.DataCycleMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CompanyMapper extends DataCycleMapper<CompanyDTO, Company> {


    Company toEntity(CompanyDTO dto);

    CompanyDTO toDto(Company entity);


}
