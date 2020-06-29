package ar.com.ada.learn.controller;

import ar.com.ada.learn.model.dto.RepresentativeDTO;
import ar.com.ada.learn.service.RepresentativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/representatives")
public class RepresentativeController {

    @Autowired @Qualifier("representativeService")
    private RepresentativeService representativeService;

    @GetMapping({"", "/"})
    public ResponseEntity getAllRepresentatives(){
        List<RepresentativeDTO> all = representativeService.findAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping({"", "/"})
    public ResponseEntity addNewRepresentative(@Valid @RequestBody RepresentativeDTO representativeDTO) throws URISyntaxException {

        RepresentativeDTO representativeSaved = representativeService.save(representativeDTO);

        return ResponseEntity
                .created(new URI("/representative/" + representativeSaved.getId()))
                .body(representativeSaved);
    }
}
