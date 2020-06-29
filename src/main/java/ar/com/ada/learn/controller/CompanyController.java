package ar.com.ada.learn.controller;

import ar.com.ada.learn.model.dto.CompanyDTO;
import ar.com.ada.learn.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    @Qualifier("companyService")
    private CompanyService companyService;


    @PostMapping({"", "/"})
 //   @PreAuthorize("has role ('ADMIN')")
    public ResponseEntity addNewCompany(@Valid @RequestBody CompanyDTO companyDTO) throws URISyntaxException {
        CompanyDTO companySaved = companyService.save(companyDTO);
        return ResponseEntity
                .created(new URI("/compnies/" + companySaved.getId()))
                .body(companySaved);
    }

}
