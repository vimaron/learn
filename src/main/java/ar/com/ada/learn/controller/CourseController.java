package ar.com.ada.learn.controller;

import ar.com.ada.learn.model.dto.CourseDTO;
import ar.com.ada.learn.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping({"", "/"})
    public ResponseEntity addNewCourse(@Valid @RequestBody CourseDTO courseDTO){

        CourseDTO courseSaved = courseService.save(courseDTO);

        return ResponseEntity.ok(courseDTO);
    }

}
