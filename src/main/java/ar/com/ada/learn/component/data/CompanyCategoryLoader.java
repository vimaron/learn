package ar.com.ada.learn.component.data;

import ar.com.ada.learn.model.entity.CompanyCategory;
import ar.com.ada.learn.model.repository.CompanyCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CompanyCategoryLoader implements ApplicationRunner {

    @Autowired @Qualifier("companyCategoryRepository")
    private CompanyCategoryRepository companyCategoryRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        List<CompanyCategory> companyCategoryList = Arrays.asList(
                new CompanyCategory("Marketing y publicidad"),
                new CompanyCategory("Comercio"),
                new CompanyCategory("Metalurgica"),
                new CompanyCategory("Servicios")
        );

        companyCategoryList.forEach(companyCategory -> companyCategoryRepository.save(companyCategory));

    }
}
