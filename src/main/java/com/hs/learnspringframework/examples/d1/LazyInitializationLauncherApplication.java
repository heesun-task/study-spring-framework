package com.hs.learnspringframework.examples.d1;

import com.hs.learnspringframework.examples.c1.BusinessCalculationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component

@Configuration
@ComponentScan("com.hs.learnspringframework.examples.c1")
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {
        var context =
                new AnnotationConfigApplicationContext
                        (LazyInitializationLauncherApplication.class);

        try(context) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            var max = context.getBean(BusinessCalculationService.class).findMax();
            System.out.println(max);
        }
    }
}