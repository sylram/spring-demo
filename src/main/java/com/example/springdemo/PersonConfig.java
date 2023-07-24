package com.example.springdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;


@Configuration
public class PersonConfig {

    @Autowired
    private PersonRepository repository;

    @PostConstruct
    public void setup() throws ParseException {

        Person person1 = new Person();
        person1.setFirstName("mar");
        person1.setLastName("alv");
        person1.setBirthdate(new SimpleDateFormat("yyyy-MM-dd").parse("1988-08-13"));

        Person person2 = new Person();
        person2.setFirstName("Jim");
        person2.setLastName("But");

        repository.saveAll(Arrays.asList(person1,person2));
    }
}
