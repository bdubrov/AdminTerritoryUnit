package com.dubrov.adminterritoryunit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LocalityTest {
    @Test
    public void IsNewLocalitySuccessfullyCreatedWithoutPersons() {
        String name = "name";
        double numberOfPeople = 100;

        Locality locality = new Locality(name, numberOfPeople);

        assertNotEquals(null, locality);
    }

    @Test
    public void IsNewLocalitySuccessfullyCreatedWithoutAllParameters() {
        String name = "name";
        double numberOfPeople = 100;
        Person leader = new Person("person name", "person surname", 20, "Leader");
        ArrayList<Person> deputies = new ArrayList<>();
        deputies.add(new Person("name1", "surname1", 30, "Deputy"));
        deputies.add(new Person("name2", "surname2", 20, "Deputy"));
        deputies.add(new Person("name3", "surname3", 25, "Deputy"));

        Locality locality = new Locality(name, numberOfPeople, leader, deputies);

        assertNotEquals(null, locality);
        assertEquals(deputies.size(), locality.getParliament().getNumOfDeputies());
    }

    @Test
    public void IsLocalityTypeSuccessfullyDeterminedByNumberOfPeople() {
        String name = "name";
        double numberOfPeople = 12.5;

        Locality locality = new Locality(name, numberOfPeople);

        assertEquals("City of district significance", locality.determineTypeByNumberOfPeople(locality.getNumberOfPeople()).getFullName());
    }

    @Test
    public void IsNewEmptyParliamentSuccessfullyCreated() {
        Locality.Parliament parliament = new Locality.Parliament();

        assertNotEquals(null, parliament);
    }

    @Test
    public void IsNewParliamentWithDeputiesSuccessfullyCreated() {
        ArrayList<Person> deputies = new ArrayList<>();
        deputies.add(new Person("name1", "surname1", 22, "Deputy"));
        deputies.add(new Person("name2", "surname2", 22, "Deputy"));
        deputies.add(new Person("name3", "surname3", 22, "Deputy"));
        deputies.add(new Person("name4", "surname4", 22, "Deputy"));

        Locality.Parliament parliament = new Locality.Parliament(deputies);

        assertNotEquals(null, parliament);
        assertEquals(deputies.size(), parliament.getNumOfDeputies());
    }

    @Test
    public void IsOneDeputySuccessfullyAddedToParliamentByPerson() {
        Person person = new Person("name1", "surname1", 22, "Deputy");
        Locality.Parliament parliament = new Locality.Parliament();

        parliament.addOneDeputy(person);

        assertNotEquals(null, parliament);
        assertEquals(1, parliament.getNumOfDeputies());
    }

    @Test
    public void IsOneDeputySuccessfullyAddedToParliamentByStringInfo() {
        String personInfoString = "name1 surname1 22 Deputy";
        Locality.Parliament parliament = new Locality.Parliament();

        parliament.addOneDeputy(personInfoString);

        assertNotEquals(null, parliament);
        assertEquals(1, parliament.getNumOfDeputies());
    }
}
