package ar.com.ada.learn.model.mapper.circular;

import ar.com.ada.learn.model.dto.RepresentativeDTO;
import ar.com.ada.learn.model.entity.Representative;
import org.mapstruct.factory.Mappers;

public interface RepresentativeCycleMapper extends DataCycleMapper<RepresentativeDTO, Representative>{

    RepresentativeCycleMapper MAPPER = Mappers.getMapper(RepresentativeCycleMapper.class);
}
