package ar.com.ada.learn.service;

import ar.com.ada.learn.model.dto.SocioeconomicDTO;
import ar.com.ada.learn.model.dto.StudentDTO;
import ar.com.ada.learn.model.entity.SocioEconomic;
import ar.com.ada.learn.model.entity.Student;
import ar.com.ada.learn.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.learn.model.repository.SocioEconomicRepository;
import ar.com.ada.learn.model.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class SocioEconomicServiceTest {


    @Mock
    private SocioEconomicRepository socioEconomicRepository;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private CycleAvoidingMappingContext context;

    @InjectMocks
    private SocioEconomicService socioEconomicService;

    @Test
    public void returnSocioEconomicWhenSaved(){
        Student newStudent = new Student()
                .setId(5L)
                .setName("Alejandr")
                .setLastName("Maron")
                .setAddress("casita")
                .setGender("male");

        SocioEconomic newSocioeconomic = new SocioEconomic()
                .setId(2l)
                .setFamily(3)
                .setFamily(3)
                .setInChargeOfFamily(true)
                .setIncome(true)
                .setMonthlyIncome(40000.00)
                .setStudent(newStudent)
                .setStudy(true)
                .setJob(true);

        when(socioEconomicRepository.save(any(SocioEconomic.class))).thenReturn(newSocioeconomic);
        when(studentRepository.findById(any(Long.class))).thenReturn(Optional.of(newStudent));


        SocioeconomicDTO dto = new SocioeconomicDTO()
                .setId(2l)
                .setFamily(3)
                .setFamily(3)
                .setInChargeOfFamily(true)
                .setIncome(true)
                .setMonthlyIncome(40000.00)
                .setStudy(true)
                .setJob(true)
                .setStudentId(5L);

        SocioeconomicDTO dtoSaved = socioEconomicService.save(dto);

        assertThat(dtoSaved.getId()).isEqualTo(2);
    }

}