package com.dubrov.adminterritoryunit;

public class District extends Territory {

    public District(String name, double numberOfPeople, Locality regionCenter, double regionArea) {
        super(name, numberOfPeople, regionCenter, regionArea);
    }

    public void printInfo() {
        StringBuilder localityInfo = new StringBuilder();
        localityInfo.append("\tDistrict name: ").append(name);
        localityInfo.append("\n\tNumber of people: ").append(numberOfPeople).append(" thousands");
        localityInfo.append("\n\tDistrict area ").append(regionArea);
        localityInfo.append("\n\tDistrict center ").append(regionCenter.getName());
        System.out.println(localityInfo);
    }
}
