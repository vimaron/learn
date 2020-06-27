package ar.com.ada.learn.controller;


import ar.com.ada.learn.model.dto.CourseDTO;
import ar.com.ada.learn.service.CourseService;
import ar.com.ada.learn.service.StudentHasCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/search")
public class SearchController {


    @Autowired
    @Qualifier("courseService")
    private CourseService courseService;

    @GetMapping({"/courses/isOpen/{isOpen}", "/courses/isOpen/{isOpen}/"})
    public ResponseEntity getAllCoursesOpen(){return null;}

    @Autowired @Qualifier("studentHasCourseService")
    private StudentHasCourseService studentHasCourseService;

    @GetMapping({"/courses/category/{categoryId}", "courses/category/{categoryId}/"})
    public ResponseEntity getAllCoursesByCategory(@RequestParam Optional<Integer> page, @PathVariable Long categoryId){
        List<CourseDTO> coursesByCategory = courseService.getAllCoursesByCategory(categoryId, page.orElse(0));
        return ResponseEntity.ok(coursesByCategory);
    }

    @GetMapping({"/courses/companies/{companyId}", "/courses/company/{companyId}/"})
    public ResponseEntity getAllCoursesByCompany(@RequestParam Optional<Integer> page, @PathVariable Long companyId){
        List<CourseDTO> courseByCompany = courseService.getAllCoursesByCompany(companyId, page.orElse(0));
        return ResponseEntity.ok(courseByCompany);
    }

    @GetMapping({"/courses/student/{studentId}/status/{isClosed}", "/courses/student/{studentId}/status/{isClosed}/"})
    public ResponseEntity getAllOngoingOrClosedCoursesByStudent(@RequestParam Optional<Integer> page, @PathVariable Long studentId, @PathVariable Boolean finished){
        List<CourseDTO> coursesByStudent = courseService.getAllCoursesByStudentAndStatus(finished, page.orElse(0));
        return ResponseEntity.ok(coursesByStudent);
    }

    @GetMapping({"/courses/category/{categoryId}/company/{companyId}",
            "/courses/category/{categoryId}/company/{companyId}/"})
    public ResponseEntity getAllCoursesByCompanyAndCategory( @RequestParam Optional<Integer> page,
                                                             @PathVariable Long companyId,
                                                            @PathVariable Long categoryId){
        List<CourseDTO> coursesByCompanyAndCategory = courseService.getAllCoursesByCompanyAndCategory(companyId, categoryId, page.orElse(0));
        return ResponseEntity.ok(coursesByCompanyAndCategory);
    }

}
