package com.hs.learnspringframework.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class someClass{
    private SomeDependency someDependency;

    public someClass(SomeDependency someDependency) {
        this.someDependency = someDependency;
        System.out.println("All dependencies are injected");
    }

    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Clean up");
    }
}

@Component
class SomeDependency{
    public SomeDependency() {
        System.out.println("SomeDependency constructor");
    }

    public void getReady() {
        System.out.println("SomeDependency is ready");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {

    public static void main(String[] args) {
        var context =
                new AnnotationConfigApplicationContext
                        (PrePostAnnotationContextLauncherApplication.class);

        try (context) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }
    }
}
