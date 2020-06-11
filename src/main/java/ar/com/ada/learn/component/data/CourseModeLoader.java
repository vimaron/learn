package ar.com.ada.learn.component.data;


import ar.com.ada.learn.model.entity.CourseMode;
import ar.com.ada.learn.model.entity.TypeOfCompany;
import ar.com.ada.learn.model.repository.CourseModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CourseModeLoader implements ApplicationRunner {

    @Autowired @Qualifier("courseModelRepository")
    private CourseModelRepository courseModelRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<CourseMode> courseModeList = Arrays.asList(
                new CourseMode("Online"),
                new CourseMode("Presencial"),
                new CourseMode("Semi-Presencial")
        );

        courseModeList.forEach(courseMode -> courseModelRepository.save(courseMode));
    }
}
