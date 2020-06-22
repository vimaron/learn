package ar.com.ada.learn.controller;


import ar.com.ada.learn.model.dto.CourseDTO;
import ar.com.ada.learn.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {


    @Autowired
    @Qualifier("courseService")
    private CourseService courseService;

    @GetMapping({"/courses/isOpen/{isOpen}", "/courses/isOpen/{isOpen}/"})
    public ResponseEntity getAllCoursesOpen(){return null;}


    @GetMapping({"/courses/category/{categoryId}", "courses/category/{categoryId}/"})
    public ResponseEntity getAllCoursesByCategory(@PathVariable Long categoryId){
        List<CourseDTO> coursesByCategory = courseService.getAllCoursesByCategory(categoryId);
        return ResponseEntity.ok(coursesByCategory);
    }

    @GetMapping({"/courses/companies/{companyId}", "/courses/company/{companyId}/"})
    public ResponseEntity getAllCoursesByCompany(  @PathVariable Long companyId){
        List<CourseDTO> courseByCompany = courseService.getAllCoursesByCompany(companyId);
        return ResponseEntity.ok(courseByCompany);
    }

    @GetMapping({"/courses/student/{studentId}/status/{isClosed}", "/courses/student/{studentId}/status/{isClosed}/"})
    public ResponseEntity getAllOngoingOrClosedCoursesByStudent(  @PathVariable Long studentId, @PathVariable String isClosed){
        List<CourseDTO> coursesByStudent = courseService.getAllCoursesByStudentAndStatus(studentId, isClosed);
        return ResponseEntity.ok(coursesByStudent);
    }

    @GetMapping({"/courses/category/{categoryId}/company/{companyId}",
            "/courses/category/{categoryId}/company/{companyId}/"})
    public ResponseEntity getAllCoursesByCompanyAndCategory( @PathVariable Long companyId,
                                                            @PathVariable Long categoryId){
        List<CourseDTO> coursesByCompanyAndCategory = courseService.getAllCoursesByCompanyAndCategory(companyId, categoryId);
        return ResponseEntity.ok(coursesByCompanyAndCategory);
    }

}
