package com.hs.learnspringframework.examples.g1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class BusinessService {
    private DataService dataService;

    public DataService getDataService() {
        System.out.println("BusinessService.getDataService");
        return dataService;
    }


    @Autowired
    public void setDataService(DataService dataService) {
        System.out.println("BusinessService.setDataService");
        this.dataService = dataService;
    }
}

@Component
class DataService {

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

    public static void main(String[] args) {
        var context =
                new AnnotationConfigApplicationContext
                        (CdiContextLauncherApplication.class);

        try (context) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }
}
