package ar.com.ada.learn.service;

import ar.com.ada.learn.component.BusinessLogicExceptionComponent;
import ar.com.ada.learn.model.dto.StudentHasCourseDTO;
import ar.com.ada.learn.model.entity.Course;
import ar.com.ada.learn.model.entity.Student;
import ar.com.ada.learn.model.entity.StudentHasCourse;
import ar.com.ada.learn.model.entity.StudentHasCourseId;
import ar.com.ada.learn.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.learn.model.mapper.StudentHasCourseMapper;
import ar.com.ada.learn.model.repository.CourseRepository;
import ar.com.ada.learn.model.repository.StudentHasCourseRepository;
import ar.com.ada.learn.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("studentHasCourseService")
public class StudentHasCourseService {

    BusinessLogicExceptionComponent businessLogicExceptionComponent;

    private StudentHasCourseMapper studentHasCourseMapper = StudentHasCourseMapper.MAPPER;

    @Autowired @Qualifier("studentRepository")
    private StudentRepository studentRepository;

    @Autowired @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired @Qualifier("studentHasCourseRepository")
    private StudentHasCourseRepository studentHasCourseRepository;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    public StudentHasCourseDTO save(StudentHasCourseDTO dto, Long studentId, Long courseId){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> businessLogicExceptionComponent.getExceptionEntityNotFound("Student", studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> businessLogicExceptionComponent.getExceptionEntityNotFound("Course", courseId));

        StudentHasCourseId studentHasCourseId = new StudentHasCourseId()
                .setStudentId(studentId)
                .setCourseId(courseId);
        StudentHasCourse studentHasCourseToSave = studentHasCourseMapper.toEntity(dto, context);
        studentHasCourseToSave.setId(studentHasCourseId);
        studentHasCourseToSave.setCourse(course);
        studentHasCourseToSave.setStudent(student);
        StudentHasCourse studentHasCourseSaved = studentHasCourseRepository.save(studentHasCourseToSave);
        StudentHasCourseDTO studentHasCourseDTOSaved = studentHasCourseMapper.toDto(studentHasCourseSaved, context);
        return studentHasCourseDTOSaved;
    }

}
