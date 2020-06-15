package ar.com.ada.learn.service;

import ar.com.ada.learn.component.BusinessLogicExceptionComponent;
import ar.com.ada.learn.model.dto.SocioeconomicDTO;
import ar.com.ada.learn.model.entity.SocioEconomic;
import ar.com.ada.learn.model.entity.Student;
import ar.com.ada.learn.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.learn.model.mapper.SocioeconomicMapper;
import ar.com.ada.learn.model.repository.SocioEconomicRepository;
import ar.com.ada.learn.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("socioEconomicService")
public class SocioEconomicService implements Services<SocioeconomicDTO>{

    private SocioeconomicMapper socioeconomicMapper = SocioeconomicMapper.MAPPER;

    BusinessLogicExceptionComponent businessLogicExceptionComponent;

    @Autowired @Qualifier("studentRepository")
    private StudentRepository studentRepository;

    @Autowired @Qualifier("socioEconomicRepository")
    private SocioEconomicRepository socioEconomicRepository;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    @Override
    public List<SocioeconomicDTO> findAll() {
        return null;
    }

    @Override
    public SocioeconomicDTO save(SocioeconomicDTO dto) {
        Long studentId = dto.getStudentId();
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> businessLogicExceptionComponent
                .getExceptionEntityNotFound("Student", studentId));

        SocioEconomic socioEconomicToSave = socioeconomicMapper.toEntity(dto, context);
        socioEconomicToSave.setStudent(student);
        SocioEconomic socioEconomicSaved = socioEconomicRepository.save(socioEconomicToSave);
        SocioeconomicDTO socioeconomicDTOSaved = socioeconomicMapper.toDto(socioEconomicSaved, context);
        return socioeconomicDTOSaved;
    }

    @Override
    public void delete(Long id) {

    }
}
