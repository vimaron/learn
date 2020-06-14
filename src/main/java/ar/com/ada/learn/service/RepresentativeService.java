package ar.com.ada.learn.service;

import ar.com.ada.learn.model.dto.RepresentativeDTO;
import ar.com.ada.learn.model.entity.Representative;
import ar.com.ada.learn.model.mapper.RepresentativeMapper;
import ar.com.ada.learn.model.mapper.circular.CycleAvoidingMappingContext;
import ar.com.ada.learn.model.mapper.circular.RepresentativeCycleMapper;
import ar.com.ada.learn.model.repository.RepresentativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("representativeService")
public class RepresentativeService implements Services<RepresentativeDTO>{

    private RepresentativeCycleMapper representativeCycleMapper = RepresentativeCycleMapper.MAPPER;

    private RepresentativeMapper representativeMapper;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    @Autowired @Qualifier("representativeRepository")
    private RepresentativeRepository representativeRepository;

    @Override
    public List<RepresentativeDTO> findAll() {
        List<Representative> representativeEntityList = representativeRepository.findAll();
        List<RepresentativeDTO> representativeDTOSList = representativeCycleMapper.toDto(representativeEntityList);
        return representativeDTOSList;
    }

    @Override
    public RepresentativeDTO save(RepresentativeDTO dto) {
        Representative representativeToSave = representativeCycleMapper.toEntity(dto);
        Representative representativeSaved = representativeRepository.save(representativeToSave);
        RepresentativeDTO representativeDTOSaved = representativeMapper.toDto(representativeSaved);
        return representativeDTOSaved;
    }

    @Override
    public void delete(Long id) {

    }
}
