package ar.com.ada.learn.component.data;

import ar.com.ada.learn.model.entity.TypeOfCompany;
import ar.com.ada.learn.model.repository.TypeOfCompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.lang.ref.PhantomReference;
import java.util.Arrays;
import java.util.List;

@Component
public class TypeOfCompanyLoader implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeOfCompanyLoader.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired
    @Qualifier("typeOfCompanyRepository")
    private TypeOfCompanyRepository typeOfCompanyRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        LOGGER.info("Environment: " + appEnv);
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Loading TypeOfCompany initial data...");

            List<TypeOfCompany> typeOfCompanyList = Arrays.asList(
                    new TypeOfCompany("S.A."),
                    new TypeOfCompany("S.R.L.")
            );

            typeOfCompanyList.forEach(typeOfCompany -> typeOfCompanyRepository.save(typeOfCompany));
        }
    }
}