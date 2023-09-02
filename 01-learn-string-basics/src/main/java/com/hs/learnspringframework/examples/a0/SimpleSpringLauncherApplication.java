package com.hs.learnspringframework.examples.a0;

import com.hs.learnspringframework.examples.a1.DependencyInjectionLauncherApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("com.hs.learnspringframework.examples.a1")
public class SimpleSpringLauncherApplication {

    public static void main(String[] args) {
        var context =
                new AnnotationConfigApplicationContext
                        (DependencyInjectionLauncherApplication.class);

        try(context) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }
    }
}