package ar.com.ada.learn.controller;

import ar.com.ada.learn.model.dto.SocioeconomicDTO;
import ar.com.ada.learn.service.SocioEconomicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/socioEconomics")
public class SocioEconomicController {

    @Autowired @Qualifier("socioEconomicService")
    private SocioEconomicService socioEconomicService;

    @PostMapping({"", "/"})
    public ResponseEntity addNewSocioEconomic(@Valid @RequestBody SocioeconomicDTO socioeconomicDTO){
        SocioeconomicDTO socioeconomicDTOSaved = socioEconomicService.save(socioeconomicDTO);
        return ResponseEntity.ok(socioeconomicDTOSaved);
    }
}
