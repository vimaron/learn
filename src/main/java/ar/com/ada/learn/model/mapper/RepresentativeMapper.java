package ar.com.ada.learn.model.mapper;

import ar.com.ada.learn.model.dto.RepresentativeDTO;
import ar.com.ada.learn.model.entity.Representative;
import ar.com.ada.learn.model.mapper.circular.DataCycleMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RepresentativeMapper extends DataCycleMapper<RepresentativeDTO, Representative> {

    Representative toEntity(RepresentativeDTO dto);

    RepresentativeDTO toDto(Representative entity);

    default Representative fromId(Long id) {
        if (id == null) return null;
        return new Representative(id);
    }
}
