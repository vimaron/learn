package ar.com.ada.learn.controller;

import ar.com.ada.learn.model.dto.CourseHasFinishedDTO;
import ar.com.ada.learn.model.dto.ScholarshipApprovalDTO;
import ar.com.ada.learn.model.dto.StudentCourseApplicationDTO;
import ar.com.ada.learn.model.dto.StudentHasCourseDTO;
import ar.com.ada.learn.service.StudentHasCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/studentHasCourses")
public class StudentHasCourseController {

    @Autowired @Qualifier("studentHasCourseService")
    private StudentHasCourseService studentHasCourseService;

    @PostMapping({"/student/{studentId}/course/{courseId}", "/student/{studentId}/course/{courseId}/"})
    public ResponseEntity addNewStudentToCourse(
            @Valid @RequestBody StudentCourseApplicationDTO studentCourseApplicationDTO,
            @PathVariable Long studentId, @PathVariable Long courseId){
        StudentHasCourseDTO studentHasCourseDTOSaved = studentHasCourseService.save(studentCourseApplicationDTO, studentId, courseId);
        return ResponseEntity.ok(studentHasCourseDTOSaved);
    }


    @PostMapping({"/student/{studentId}/course/{courseId}/approval", "/student/{studentId}/course/{courseId}/approval/"})
    public ResponseEntity scholarshipApproval(@Valid @RequestBody ScholarshipApprovalDTO scholarshipApprovalDTO,
                                              @PathVariable Long courseId, @PathVariable Long studentId){
        StudentHasCourseDTO studentHasCourseDTOUpdated = studentHasCourseService
                .scholarshipApproval(scholarshipApprovalDTO, courseId, studentId);

        return ResponseEntity.ok(studentHasCourseDTOUpdated);
    }

    @PostMapping({"/student/{studentId}/course/{courseId}/finished", "/student/{studentId}/course/{courseId}/finished/"})
    public ResponseEntity finishedCourseDTO(@Valid @RequestBody CourseHasFinishedDTO courseHasFinishedDTO,
                                            @PathVariable Long courseId, @PathVariable Long studentId){
        StudentHasCourseDTO studentHasCourseDTOUpdated = studentHasCourseService.courseFinished(courseHasFinishedDTO, courseId, studentId);
        return ResponseEntity.ok(studentHasCourseDTOUpdated);
    }


}
