package ar.com.ada.learn.component.data;

import ar.com.ada.learn.model.entity.TypeOfCourse;
import ar.com.ada.learn.model.repository.TypeOfCourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TypeOfCourseLoader implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeOfCourseLoader.class);

    @Autowired
    @Qualifier("typeOfCourseRepository")
    private TypeOfCourseRepository typeOfCourseRepository;

    @Value("${spring.application.env}")
    private String appEnv;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("Environment: " + appEnv);
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Loading TypeOfCourse initial data...");

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
}