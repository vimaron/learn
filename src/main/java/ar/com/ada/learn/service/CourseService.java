package ar.com.ada.learn.service;

import ar.com.ada.learn.component.BusinessLogicExceptionComponent;
import ar.com.ada.learn.model.dto.CourseDTO;
import ar.com.ada.learn.model.entity.Course;
import ar.com.ada.learn.model.mapper.CourseMapper;
import ar.com.ada.learn.model.mapper.circular.CycleAvoidingMappingContext;
import ar.com.ada.learn.model.mapper.circular.CourseCycleMapper;
import ar.com.ada.learn.model.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("courseService")
public class CourseService implements Services<CourseDTO>{

    private CourseCycleMapper courseCycleMapper = CourseCycleMapper.MAPPER;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    BusinessLogicExceptionComponent businessLogicExceptionComponent;

    @Autowired @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    private CourseMapper courseMapper;

    public CourseService(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public List<CourseDTO> findAll() {
        List<Course> courseEntityList = courseRepository.findAll();
        List<CourseDTO> coursesDtoList = courseCycleMapper.toDto(courseEntityList);
        return coursesDtoList;
    }

    @Override
    public CourseDTO save(CourseDTO dto) {
        Course courseToSave = courseMapper.toEntity(dto);
        Course courseSaved = courseRepository.save(courseToSave);
        CourseDTO courseDtoSaved = courseMapper.toDto(courseSaved);
        return courseDtoSaved;
    }

    @Override
    public void delete(Long id) {
    }

    public CourseDTO findCourseById(Long id){

        Optional<Course> byIdOptional = courseRepository.findById(id);

        CourseDTO courseDTO = null;

        if (byIdOptional.isPresent()){
            Course courseById = byIdOptional.get();
            courseDTO = courseMapper.toDto(courseById);
        }else {
            businessLogicExceptionComponent.throwExceptionEntityNotFound("Course", id);

        }
        return courseDTO;
    }
}
