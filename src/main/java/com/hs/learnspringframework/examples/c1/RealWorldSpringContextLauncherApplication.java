package com.hs.learnspringframework.examples.c1;
;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("com.hs.learnspringframework.examples.c1")
public class RealWorldSpringContextLauncherApplication {

    public static void main(String[] args) {
        var context =
                new AnnotationConfigApplicationContext
                        (RealWorldSpringContextLauncherApplication.class);

        try(context) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            var max = context.getBean(BusinessCalculationService.class).findMax();
            System.out.println(max);
        }
    }
}