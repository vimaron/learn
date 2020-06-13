package ar.com.ada.learn.controller;

import ar.com.ada.learn.model.dto.CompanyDTO;
import ar.com.ada.learn.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    @Qualifier("courseService")
    private CompanyService companyService;

    @PostMapping({"", "/"})
    public ResponseEntity addNewCourse(@Valid @RequestBody CompanyDTO companyDTO){

        CompanyDTO companySaved = companyService.save(companyDTO);

        return ResponseEntity.ok(companyDTO);
    }

}
