package ar.com.ada.learn.controller;

import ar.com.ada.learn.model.dto.SocioeconomicDTO;
import ar.com.ada.learn.model.dto.StudentDTO;
import ar.com.ada.learn.service.SocioEconomicService;
import ar.com.ada.learn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired @Qualifier("studentService")
    private StudentService studentService;

    @Autowired @Qualifier("socioEconomicService")
    private SocioEconomicService socioEconomicService;

    @GetMapping({"", "/"})
    public ResponseEntity getAllStudents(){
        List<StudentDTO> all = studentService.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping({"/socioEconomic", "/socioEconomic/"})
    public ResponseEntity addNewSocioEconomic(@Valid @RequestBody SocioeconomicDTO socioeconomicDTO){
        SocioeconomicDTO socioeconomicDTOSaved = socioEconomicService.save(socioeconomicDTO);
        return ResponseEntity.ok(socioeconomicDTOSaved);
    }

    @PostMapping({"", "/"})
    public ResponseEntity addNewStudent(@Valid @RequestBody StudentDTO studentDto){
        StudentDTO studentDTOSaved = studentService.save(studentDto);
        return ResponseEntity.ok(studentDTOSaved);
    }


}
