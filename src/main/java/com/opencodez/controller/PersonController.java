package com.opencodez.controller;

import com.opencodez.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @GetMapping("/person")
    public Person getPerson() {
        return new Person("Arash", "Farahani");
    }
}
