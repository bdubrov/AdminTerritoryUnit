package com.dubrov.adminterritoryunit;

public interface AdminTerritorialUnit {
    String getName();

    void changeName(String newName);

    void changeNumberOfPeople(double newNumberOfPeople);

    double getNumberOfPeople();

    void printInfo();
}
