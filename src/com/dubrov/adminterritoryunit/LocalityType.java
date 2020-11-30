package com.dubrov.adminterritoryunit;

public enum LocalityType {
    REGIONAL_CITY("City of regional significance", 50),
    DISTRICT_CITY("City of district significance", 10),
    URBAN_VILLAGE("Urban village", 5),
    VILLAGE("Village", 0);
    private String fullName;
    private double minNumberOfPeople;
    LocalityType(String fullName, int minNumberOfPeople) {
        this.fullName = fullName;
        this.minNumberOfPeople = minNumberOfPeople;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getMinNumberOfPeople() {
        return minNumberOfPeople;
    }

    public void setMinNumberOfPeople(double minNumberOfPeople) {
        this.minNumberOfPeople = minNumberOfPeople;
    }

    @Override
    public String toString() {
        return "LocalityType{" +
                "Full name of Locality type = " + fullName + '\n' +
                ", min number of people in this type of location = " + minNumberOfPeople +
                " thousand\n}";
    }
}
