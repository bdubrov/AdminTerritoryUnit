package com.dubrov.adminterritoryunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DistrictTest {
    @Test
    public void IsNewDistrictSuccessfullyCreatedWithParametersIfAllParametersIsRight() {
        String name = "District 1";
        double numberOfPeople = 1000.0;
        Locality regionCenter = new Locality("City 1", 200.0);
        double regionArea = 321.5;

        District district = new District(name, numberOfPeople, regionCenter, regionArea);

        assertNotNull(district);
        assertEquals(name, district.getName());
        assertEquals(numberOfPeople, district.getNumberOfPeople());
        assertEquals(regionCenter, district.getRegionCenter());
        assertEquals(regionArea, district.getRegionArea());
    }
}