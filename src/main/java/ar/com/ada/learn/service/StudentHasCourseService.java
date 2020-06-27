package ar.com.ada.learn.service;

import ar.com.ada.learn.component.BusinessLogicExceptionComponent;
import ar.com.ada.learn.model.dto.CourseHasFinishedDTO;
import ar.com.ada.learn.model.dto.ScholarshipApprovalDTO;
import ar.com.ada.learn.model.dto.StudentCourseApplicationDTO;
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

    @Autowired
    @Qualifier("studentRepository")
    private StudentRepository studentRepository;

    @Autowired
    @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired
    @Qualifier("studentHasCourseRepository")
    private StudentHasCourseRepository studentHasCourseRepository;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    public StudentHasCourseDTO save(StudentCourseApplicationDTO dto, Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> businessLogicExceptionComponent.getExceptionEntityNotFound("Student", studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> businessLogicExceptionComponent.getExceptionEntityNotFound("Course", courseId));

        StudentHasCourseId id = new StudentHasCourseId().setCourseId(course.getId()).setStudentId(student.getId());

        studentHasCourseRepository.findById(id).ifPresent(studentHasCourse -> {
            throw businessLogicExceptionComponent.getExceptionApplicationAlreadyExists(id);
        });

        StudentHasCourse studentHasCourseToSave = new StudentHasCourse()
                .setId(id)
                .setStudent(student)
                .setCourse(course);


        StudentHasCourseDTO studentHasCourseDTOSaved;
        if (dto.getAdjType() == "Direct"){
            studentHasCourseDTOSaved = this.saveDirectApplication(studentHasCourseToSave);

        }else {
            studentHasCourseDTOSaved = this.saveScholarshipApplication(studentHasCourseToSave);
        }

        return studentHasCourseDTOSaved;
    }


    private StudentHasCourseDTO saveDirectApplication(StudentHasCourse studentHasCourseToSave){
        Integer counter = studentHasCourseToSave.getCourse().getDirectPurchaseCounter();

        if (counter == 0)
            throw businessLogicExceptionComponent.getExceptionSoldOut(studentHasCourseToSave.getCourse().getName());

        studentHasCourseToSave.setAdjType("Direct");
        studentHasCourseToSave.setStatus(true);
        studentHasCourseToSave.getCourse().setDirectPurchaseCounter(counter - 1);

        StudentHasCourse studentHasCourseSave = studentHasCourseRepository.save(studentHasCourseToSave);
        StudentHasCourseDTO studentHasCourseDTOSaved = studentHasCourseMapper.toDto(studentHasCourseSave, context);


        return studentHasCourseDTOSaved;
    }


    private StudentHasCourseDTO saveScholarshipApplication(StudentHasCourse studentHasCourseToSave){
        studentHasCourseToSave.setAdjType("scholarship");

        StudentHasCourse studentHasCourseSave = studentHasCourseRepository.save(studentHasCourseToSave);
        StudentHasCourseDTO studentHasCourseSaved = studentHasCourseMapper.toDto(studentHasCourseSave, context);

        return studentHasCourseSaved;
    }

    public StudentHasCourseDTO scholarshipApproval(ScholarshipApprovalDTO dto, Long courseId, Long studentId){
        StudentHasCourseId id = new StudentHasCourseId().setCourseId(courseId).setStudentId(studentId);
        StudentHasCourse studentHasCourse = studentHasCourseRepository
                .findById(id)
                .orElseThrow(() -> businessLogicExceptionComponent.throwExceptionEntityNotFound("StudentHasCourse", id));
        Integer scholarshipCounter = studentHasCourse.getCourse().getScholarshipCounter();

        if (scholarshipCounter == 0){
            throw  businessLogicExceptionComponent.getExceptionSoldOut(studentHasCourse.getCourse().getName());
        }
        if (dto.getApproved()){
            studentHasCourse.setStatus(dto.getApproved());
            studentHasCourse.setPercentage(dto.getScholarshipPercentage());
            studentHasCourse.getCourse().setScholarshipCounter(scholarshipCounter - 1);
        }else {
            studentHasCourse.setStatus(dto.getApproved());
            studentHasCourse.setPercentage(0);
        }

        StudentHasCourseDTO studentHasCourseDTOUpdated = studentHasCourseMapper.toDto(studentHasCourse, context);

        return studentHasCourseDTOUpdated;
    }


    public StudentHasCourseDTO courseFinished(CourseHasFinishedDTO dto, Long courseId, Long studentId){
        StudentHasCourseId id = new StudentHasCourseId().setCourseId(courseId).setStudentId(studentId);
        StudentHasCourse studentHasCourse = studentHasCourseRepository.findById(id)
                .orElseThrow(() -> businessLogicExceptionComponent.throwExceptionEntityNotFound("StudentHasCourse", id));

        if (!studentHasCourse.getFinished() && dto.getCourseFinished()){
            studentHasCourse.setFinished(dto.getCourseFinished());
        }

        StudentHasCourseDTO studentHasCourseDTOUpdated = studentHasCourseMapper.toDto(studentHasCourse, context);

        return studentHasCourseDTOUpdated;
    }


}

