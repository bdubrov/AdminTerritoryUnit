package com.dubrov.adminterritoryunit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RegionTest {
    @Test
    public void IsNewRegionSuccessfullyCreatedWithAllCorrectParameters() {
        Locality capital = new Locality("Capital", 200.5);
        District district = new District("district", 102, capital, 5.3);
        ArrayList<Territory> districts = new ArrayList<>();
        districts.add(district);

        Region region = new Region("Region", 500.1, capital, 12.3, districts);

        assertNotEquals(null, region);
    }

    @Test
    public void IsNewRegionSuccessfullyCreatedWithoutDistricts() {
        Locality capital = new Locality("Capital", 200.5);

        Region region = new Region("Region", 500.1, capital, 12.3);

        assertNotEquals(null, region);
    }
}