package ar.com.ada.learn.component.data;

import ar.com.ada.learn.model.entity.CompanyCategory;
import ar.com.ada.learn.model.entity.TypeOfCourse;
import ar.com.ada.learn.model.repository.TypeOfCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TypeOfCourseLoader implements ApplicationRunner {

    @Autowired @Qualifier("typeOfCourseRepository")
    private TypeOfCourseRepository typeOfCourseRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<TypeOfCourse> typeOfCourseList = Arrays.asList(
                new TypeOfCourse("Desarrollo"),
                new TypeOfCourse("Negocios"),
                new TypeOfCourse("Informatica y Software"),
                new TypeOfCourse("Desarrollo personal"),
                new TypeOfCourse("Diseno"),
                new TypeOfCourse("Marketing"),
                new TypeOfCourse("Salud y fitness"),
                new TypeOfCourse("Arte")
        );

        typeOfCourseList.forEach(typeOfCourse -> typeOfCourseRepository.save(typeOfCourse));

    }
}
