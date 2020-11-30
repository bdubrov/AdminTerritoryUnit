package com.dubrov.adminterritoryunit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CountryTest {
    @Test
    public void CountrySuccessfullyCreatedIfAllParametersCorrect() {
        Locality capital = new Locality("Capital", 200.5);

        Country country = new Country("Country", 2000.0, capital, 150.3, new ArrayList<AdminTerritorialUnit>(), new ArrayList<AdminTerritorialUnit>());

        assertNotEquals(null, country);
    }

    @Test
    public void isNotNullNewRegionSuccessfullyAddedToCountry() {
        Locality capital = new Locality("Capital", 200.5);
        Region region = new Region("Region", 500.1, capital, 12.3);

        Country country = new Country("Country", 2000.0, capital, 150.3, new ArrayList<AdminTerritorialUnit>(),new ArrayList<AdminTerritorialUnit>());

        country.addRegion(region);

        assertEquals(1, country.getRegions().size());
    }

    @Test/* (expected = AddNullRegionException.class)*/
    public void isFailToAddTwoSimilarRegion() {
        Locality capital = new Locality("Capital", 200.5);
        Region region = new Region("Region", 500.1, capital, 12.3);

        Country country = new Country("Country", 2000.0, capital, 150.3, new ArrayList<AdminTerritorialUnit>(),new ArrayList<AdminTerritorialUnit>());

        country.addRegion(region);
        country.addRegion(region);

        assertEquals(1, country.getRegions().size());
    }

    @Test
    public void SearchingExistRegionByCorrectName() {
        Locality capital = new Locality("Capital", 200.5);
        AdminTerritorialUnit region1 = new Region("Region1", 500.1, capital, 12.3);
        AdminTerritorialUnit region2 = new Region("Region2", 500.1, capital, 12.3);
        AdminTerritorialUnit region3 = new Region("Region3", 500.1, capital, 12.3);

        ArrayList<AdminTerritorialUnit> regionList = new ArrayList<>();
        regionList.add(region1);
        regionList.add(region2);
        regionList.add(region3);

        Country country = new Country("Country", 2000.0, capital, 150.3, regionList,new ArrayList<AdminTerritorialUnit>());


        assertEquals(region2, country.getRegionByName(region2.getName()));
    }

    @Test
    public void NullIfSearchingNotExistRegionByName() {
        Locality capital = new Locality("Capital", 200.5);
        AdminTerritorialUnit region1 = new Region("Region1", 500.1, capital, 12.3);

        ArrayList<AdminTerritorialUnit> regionList = new ArrayList<>();
        regionList.add(region1);

        Country country = new Country("Country", 2000.0, capital, 150.3, regionList,new ArrayList<AdminTerritorialUnit>());


        assertEquals(null, country.getRegionByName("Region2"));
    }
}