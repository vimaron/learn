package ar.com.ada.learn.service;

import ar.com.ada.learn.model.dto.SocioeconomicDTO;
import ar.com.ada.learn.model.entity.SocioEconomic;
import ar.com.ada.learn.model.mapper.SocioeconomicMapper;
import ar.com.ada.learn.model.repository.SocioEconomicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("socioEconomicService")
public class SocioEconomicService implements Services<SocioeconomicDTO>{

    private SocioeconomicMapper socioeconomicMapper;

    @Autowired @Qualifier("socioEconomicRepository")
    private SocioEconomicRepository socioEconomicRepository;

    @Override
    public List<SocioeconomicDTO> findAll() {
        return null;
    }

    @Override
    public SocioeconomicDTO save(SocioeconomicDTO dto) {
        SocioEconomic socioEconomicToSave = socioeconomicMapper.toEntity(dto);
        SocioEconomic socioEconomicSaved = socioEconomicRepository.save(socioEconomicToSave);
        SocioeconomicDTO socioeconomicDTOSaved = socioeconomicMapper.toDto(socioEconomicSaved);
        return socioeconomicDTOSaved;
    }

    @Override
    public void delete(Long id) {

    }
}
