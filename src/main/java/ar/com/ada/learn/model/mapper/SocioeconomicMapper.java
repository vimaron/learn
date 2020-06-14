package ar.com.ada.learn.model.mapper;

import ar.com.ada.learn.model.dto.SocioeconomicDTO;
import ar.com.ada.learn.model.entity.SocioEconomic;
import ar.com.ada.learn.model.mapper.circular.DataCycleMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface SocioeconomicMapper extends DataCycleMapper <SocioeconomicDTO, SocioEconomic>{
    SocioEconomic toEntity(SocioeconomicDTO dto);

    SocioeconomicDTO toDto(SocioEconomic entity);

    default SocioEconomic fromId(Long id) {
        if (id == null) return null;
        return new SocioEconomic(id);
    }
}
