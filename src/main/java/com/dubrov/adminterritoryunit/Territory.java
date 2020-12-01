package com.dubrov.adminterritoryunit;

import java.util.Objects;

public abstract class Territory implements AdminTerritorialUnit {
    protected String name;
    protected double numberOfPeople;
    protected AdminTerritorialUnit regionCenter;
    protected double regionArea;

    public Territory(String name, double numberOfPeople, AdminTerritorialUnit regionCenter, double regionArea) {
        this.name = name;
        this.numberOfPeople = numberOfPeople;
        this.regionCenter = regionCenter;
        this.regionArea = regionArea;
    }

    @Override
    public void changeName(String newName) {
        name = newName;
    }

    @Override
    public void changeNumberOfPeople(double newNumberOfPeople) {
        numberOfPeople = newNumberOfPeople;
    }

    @Override
    public void printInfo() {
        StringBuilder localityInfo = new StringBuilder();
        localityInfo.append("\tTerritory name: ").append(name);
        localityInfo.append("\n\tNumber of people: ").append(numberOfPeople).append("thousands");
        localityInfo.append("\n\tTerritory area ").append(regionArea);
        localityInfo.append("\n\tTerritory main city ").append(regionCenter);
        System.out.println(localityInfo);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfPeople, regionCenter, regionArea);
    }

    public AdminTerritorialUnit getRegionCenter() {
        return regionCenter;
    }

    public void setRegionCenter(AdminTerritorialUnit regionCenter) {
        this.regionCenter = regionCenter;
    }

    public double getRegionArea() {
        return regionArea;
    }

    public void setRegionArea(double regionArea) {
        this.regionArea = regionArea;
    }
}
