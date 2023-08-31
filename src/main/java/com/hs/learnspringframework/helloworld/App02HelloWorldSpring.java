package com.hs.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        // 1. Launch a Spring Context
        try(var context =
                    new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {

            // 2. Configure the things that we want Spring to manage - @Configuration
            var name = context.getBean("name");
            var age = context.getBean("age");
            var person = context.getBean("person");
            var address = context.getBean("address2");

            // 3. Retrieving the Beans managed by Spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean(Address.class)); //ERROR
            System.out.println(context.getBean(Person.class));
            System.out.println(context.getBean("Person5Qualifier"));

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            context.getBeanDefinitionNames();

        }
    }

}
