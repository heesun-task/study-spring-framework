package com.hs.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) { };

record Address(String firstLine, String city) { };

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "Ranga";
    }

    @Bean
    public int age() {
        return 25;
    }

    @Bean
    @Primary
    public Person person() {
        return new Person("Scott", 26, new Address("Baker Street", "London"));
    }

    @Bean
    public Person person2() {
        return new Person(name(), age(), new Address("Baker Street", "London"));
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3) {
        return new Person(name, age, address3);
    }

    @Bean
    public Person person4Parameters(String name, int age, Address address) {
        return new Person(name, age, address);
    }
    @Bean
    public Person Person5Qualifier(String name, int age, @Qualifier("address4qualifier") Address address) {
        return new Person(name, age, address);
    }

    @Bean(name = "address2")
    @Primary
    public Address address2() {
        return new Address("Baker Street", "London");
    }

    @Bean(name = "address3")
    public Address address3() {
        return new Address("Myundong", "Seoul");
    }
    @Bean(name = "address4")
    @Qualifier("address4qualifier")
    public Address address4() {
        return new Address("QTEST", "Seoul");
    }
}
