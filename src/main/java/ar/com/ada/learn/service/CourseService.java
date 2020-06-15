package ar.com.ada.learn.service;

import ar.com.ada.learn.component.BusinessLogicExceptionComponent;
import ar.com.ada.learn.model.dto.CourseDTO;
import ar.com.ada.learn.model.entity.Course;
import ar.com.ada.learn.model.entity.CourseMode;
import ar.com.ada.learn.model.entity.TypeOfCourse;
import ar.com.ada.learn.model.mapper.CourseMapper;
import ar.com.ada.learn.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.learn.model.repository.CourseModelRepository;
import ar.com.ada.learn.model.repository.CourseRepository;
import ar.com.ada.learn.model.repository.TypeOfCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("courseService")
public class CourseService implements Services<CourseDTO>{

    private CourseMapper courseMapper = CourseMapper.MAPPER;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    BusinessLogicExceptionComponent businessLogicExceptionComponent;

    @Autowired @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired @Qualifier("typeOfCourseRepository")
    private TypeOfCourseRepository typeOfCourseRepository;

    @Autowired @Qualifier("courseModelRepository")
    private CourseModelRepository courseModelRepository;

    public CourseService(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public List<CourseDTO> findAll() {
        List<Course> courseEntityList = courseRepository.findAll();
        List<CourseDTO> coursesDtoList = courseMapper.toDto(courseEntityList, context);
        return coursesDtoList;
    }

    @Override
    public CourseDTO save(CourseDTO dto) {
        Long typeOfCourseId = dto.getTypeOfCourseId();
        TypeOfCourse typeOfCourse = typeOfCourseRepository.findById(typeOfCourseId)
                .orElseThrow(() -> businessLogicExceptionComponent
                        .getExceptionEntityNotFound("TypeOfCourse", typeOfCourseId));

        Long courseModeId = dto.getCourseModeId();
        CourseMode courseMode = courseModelRepository.findById(courseModeId)
                .orElseThrow(() -> businessLogicExceptionComponent
                        .getExceptionEntityNotFound("CourseMode", courseModeId));

        Course courseToSave = courseMapper.toEntity(dto, context);
        courseToSave.setCourseMode(courseMode);
        courseToSave.setTypeOfCourse(typeOfCourse);
        Course courseSaved = courseRepository.save(courseToSave);
        CourseDTO courseDTOSaved = courseMapper.toDto(courseSaved, context);

        return courseDTOSaved;
    }

    @Override
    public void delete(Long id) {
    }

    public CourseDTO findCourseById(Long id){

        Optional<Course> byIdOptional = courseRepository.findById(id);

        CourseDTO courseDTO = null;

        if (byIdOptional.isPresent()){
            Course courseById = byIdOptional.get();
            courseDTO = courseMapper.toDto(courseById, context);
        }else {
            businessLogicExceptionComponent.throwExceptionEntityNotFound("Course", id);

        }
        return courseDTO;
    }
}
