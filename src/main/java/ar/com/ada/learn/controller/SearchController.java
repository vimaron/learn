package ar.com.ada.learn.controller;

import ar.com.ada.learn.model.dto.CourseDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Query("FROM Course WHERE status = open")
    public ResponseEntity getAllCoursesOpen(){return null;}

    @GetMapping({"/courses/category/{categoryId}", "courses/category/{categoryId}/"})
    public ResponseEntity getAllCoursesByCategory(@PathVariable Long categoryId){
        return null;}

    @GetMapping({"/companies/{companyId}", "/company/{companyId}/"})
    public ResponseEntity getAllCoursesByCompany(  @PathVariable Long companyId){
        return null;}

    @GetMapping({"/student/{studentId}", "/student/{studentId}/"})
    public ResponseEntity getAllOngoingCoursesByStudent(  @PathVariable Long StudentId){
        return null;}

    @GetMapping({"/student/{studentId}", "/student/{studentId}/"})
    public ResponseEntity getAllFinishedCoursesByStudent(  @PathVariable Long StudentId){
        return null;}

    @GetMapping({"/courses/category/{categoryId}/companies/{companiesId}",
            "/courses/category/{categoryId}/companies/{companiesId}/"})
    public ResponseEntity getAllCoursesByCompanyAndCategory( @PathVariable Long companiesId,
                                                            @PathVariable Long categoryId){
        return null;}

}
