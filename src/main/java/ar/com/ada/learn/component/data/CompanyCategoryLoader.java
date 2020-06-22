package ar.com.ada.learn.component.data;

import ar.com.ada.learn.model.entity.CompanyCategory;
import ar.com.ada.learn.model.repository.CompanyCategoryRepository;
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
public class CompanyCategoryLoader implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyCategoryLoader.class);

    @Value("${spring.application.env}")
    private String appEnv;

    @Autowired
    @Qualifier("companyCategoryRepository")
    private CompanyCategoryRepository companyCategoryRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        LOGGER.info("Environment: " + appEnv);
        if (appEnv.equals("dev") || appEnv.equals("qa")) {
            LOGGER.info("Loading Actor initial data...");

            List<CompanyCategory> companyCategoryList = Arrays.asList(
                    new CompanyCategory(1L, "Marketing y publicidad"),
                    new CompanyCategory(2L, "Comercio"),
                    new CompanyCategory(3L, "Metalurgica"),
                    new CompanyCategory(4L, "Servicios")
            );

            companyCategoryList.forEach(companyCategory -> companyCategoryRepository.save(companyCategory));
        }
    }
}