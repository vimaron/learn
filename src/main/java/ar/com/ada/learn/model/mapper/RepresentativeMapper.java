package ar.com.ada.learn.model.mapper;

import ar.com.ada.learn.model.dto.RepresentativeDTO;
import ar.com.ada.learn.model.entity.Representative;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {})
public interface RepresentativeMapper extends DataCycleMapper<RepresentativeDTO, Representative> {
    RepresentativeMapper MAPPER = Mappers.getMapper(RepresentativeMapper.class);

}
