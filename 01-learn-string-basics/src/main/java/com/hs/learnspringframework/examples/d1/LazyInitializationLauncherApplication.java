package com.hs.learnspringframework.examples.d1;

import com.hs.learnspringframework.examples.c1.BusinessCalculationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

}
@Component
@Lazy
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("---ClassB constructor");
        this.classA = classA;
    }

    public void doSth() {
        System.out.println("do sth");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {
        var context =
                new AnnotationConfigApplicationContext
                        (LazyInitializationLauncherApplication.class);

        try(context) {
//            Arrays.stream(context.getBeanDefinitionNames())
//                    .forEach(System.out::println);

            System.out.println("Initialization of context is completed");

            context.getBean(ClassB.class).doSth();
        }
    }
}