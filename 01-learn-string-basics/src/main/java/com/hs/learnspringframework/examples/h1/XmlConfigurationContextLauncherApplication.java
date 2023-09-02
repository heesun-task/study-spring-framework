package com.hs.learnspringframework.examples.h1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@Configuration
@ComponentScan("com.hs.learnspringframework.examples.a1")
public class XmlConfigurationContextLauncherApplication {

    public static void main(String[] args) {
        var context =
                new ClassPathXmlApplicationContext("contextConfiguration.xml");

        try(context) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("game"));
        }
    }
}