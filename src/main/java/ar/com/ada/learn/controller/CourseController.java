package ar.com.ada.learn.controller;

import ar.com.ada.learn.model.dto.CourseDTO;
import ar.com.ada.learn.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired@Qualifier("courseService")
    private CourseService courseService;

    @GetMapping({"", "/"})
    public ResponseEntity getAllCourses(){
        List<CourseDTO> all = courseService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity getCourseById(@PathVariable Long id){

        CourseDTO courseById = courseService.findCourseById(id);

        return ResponseEntity.ok(courseById);
    }
    

}
