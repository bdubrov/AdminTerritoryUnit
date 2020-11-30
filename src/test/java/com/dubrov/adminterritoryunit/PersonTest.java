package com.dubrov.adminterritoryunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonTest {
    @Test
    public void IsNewPersonSuccessfullyCreatedWithParametersIfAllParametersIsRight() {
        String name = "Bohdan";
        String surname = "Dubrov";
        int age = 19;
        String position = "Student";

        Person person = new Person(name, surname, age, position);

        assertNotNull(person);
        assertEquals(name, person.getName());
        assertEquals(surname, person.getSurname());
        assertEquals(age, person.getAge());
        assertEquals(position, person.getPosition());
    }
}