package com.dubrov.adminterritoryunit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {
    @Test
    public void CountrySuccessfullyCreatedIfAllParametersCorrect() {
        Locality capital = new Locality("Capital", 200.5);

        Country country = new Country("Country", 2000.0, capital, 150.3, new ArrayList<>(), new ArrayList<>());

        assertNotEquals(null, country);
    }

    @Test
    public void isNotNullNewRegionSuccessfullyAddedToCountry() {
        Locality capital = new Locality("Capital", 200.5);
        Region region = new Region("Region", 500.1, capital, 12.3);

        Country country = new Country("Country", 2000.0, capital, 150.3, new ArrayList<>(), new ArrayList<>());

        try {
            country.addRegion(region);
        } catch (AddNullRegionException e) {
            e.printStackTrace();
        }

        assertEquals(1, country.getRegions().size());
    }

    @Test
    public void isFailToAddTwoSimilarRegion() {
        Locality capital = new Locality("Capital", 200.5);
        Region region = new Region("Region", 500.1, capital, 12.3);

        Country country = new Country("Country", 2000.0, capital, 150.3, new ArrayList<>(), new ArrayList<>());

        try {
            country.addRegion(region);
        } catch (AddNullRegionException e) {
            e.printStackTrace();
        }
        try {
            country.addRegion(region);
        } catch (AddNullRegionException e) {
            e.printStackTrace();
        }

        assertEquals(1, country.getRegions().size());
    }

    @Test
    public void SearchingExistRegionByCorrectName() {
        Locality capital = new Locality("Capital", 200.5);
        Region region1 = new Region("Region1", 500.1, capital, 12.3);
        Region region2 = new Region("Region2", 500.1, capital, 12.3);
        Region region3 = new Region("Region3", 500.1, capital, 12.3);

        ArrayList<Region> regionList = new ArrayList<>();
        regionList.add(region1);
        regionList.add(region2);
        regionList.add(region3);

        Country country = new Country("Country", 2000.0, capital, 150.3, regionList, new ArrayList<>());


        assertEquals(region2, country.getRegionByName(region2.getName()));
    }

    @Test
    public void NullIfSearchingNotExistRegionByName() {
        Locality capital = new Locality("Capital", 200.5);
        Region region1 = new Region("Region1", 500.1, capital, 12.3);

        ArrayList<Region> regionList = new ArrayList<>();
        regionList.add(region1);

        Country country = new Country("Country", 2000.0, capital, 150.3, regionList, new ArrayList<>());


        assertEquals(null, country.getRegionByName("Region2"));
    }

    @Test
    public void findCorrectNumberOfPeopleOfAllRegionalCityCenter() {
        Locality capital = new Locality("Kiev", 4000);
        ArrayList<Region> regions = new ArrayList<>();
        ArrayList<Locality> cities = new ArrayList<>();
        cities.add(capital);
        cities.add(new Locality("Brovary", 100));
        cities.add(new Locality("Chernihiv", 120));
        cities.add(new Locality("Kalinovka", 5.704));
        cities.add(new Locality("Zazimye", 4.259));
        regions.add(
                new Region(
                        "Kiev region",
                        1781.0,
                        cities.get(0),
                        28121
                )
        );
        regions.add(
                new Region(
                        "Chernihiv region",
                        200,
                        cities.get(2),
                        40000
                )
        );
        regions.add(
                new Region(
                        "Brovary district",
                        150,
                        cities.get(1),
                        1000
                )
        );
        Country country = new Country("Ukraine", 38000, capital, 3800, regions, cities);

        assertEquals(4220, country.findNumberOfPeopleOfAllRegionalCityCenter());
    }

    @Test
    public void IsSuccessfullyFindRegionWithMaxArea() {
        Locality capital = new Locality("Kiev", 4000);
        ArrayList<Region> regions = new ArrayList<>();
        ArrayList<Locality> cities = new ArrayList<>();
        cities.add(capital);
        cities.add(new Locality("Brovary", 100));
        cities.add(new Locality("Chernihiv", 120));
        cities.add(new Locality("Kalinovka", 5.704));
        cities.add(new Locality("Zazimye", 4.259));
        regions.add(
                new Region(
                        "Kiev region",
                        1781.0,
                        cities.get(0),
                        28121
                )
        );
        regions.add(
                new Region(
                        "Chernihiv region",
                        200,
                        cities.get(2),
                        40000
                )
        );
        regions.add(
                new Region(
                        "Brovary district",
                        150,
                        cities.get(1),
                        1000
                )
        );
        Country country = new Country("Ukraine", 38000, capital, 3800, regions, cities);

        assertEquals(regions.get(1), country.findRegionWithMaxArea());
        assertEquals(regions.get(1), country.findRegionWithMaxAreaUpdated());
    }

    @Test
    public void IsSuccessfullyFindAverageAreaOfRegions() {
        Locality capital = new Locality("Kiev", 4000);
        ArrayList<Region> regions = new ArrayList<>();
        ArrayList<Locality> cities = new ArrayList<>();
        cities.add(capital);
        cities.add(new Locality("Brovary", 100));
        cities.add(new Locality("Chernihiv", 120));
        cities.add(new Locality("Kalinovka", 5.704));
        cities.add(new Locality("Zazimye", 4.259));
        regions.add(
                new Region(
                        "Kiev region",
                        1781.0,
                        cities.get(0),
                        200d
                )
        );
        regions.add(
                new Region(
                        "Chernihiv region",
                        200,
                        cities.get(2),
                        300d
                )
        );
        regions.add(
                new Region(
                        "Brovary district",
                        150,
                        cities.get(1),
                        100d
                )
        );
        Country country = new Country("Ukraine", 38000, capital, 100000, regions, cities);

        assertEquals(200d, country.findAverageAreaOfRegions());
    }

    @Test
    public void IsSuccessfullyFindAllLocalityByType() {
        ArrayList<Person> kievDeputies = new ArrayList<>();
        kievDeputies.add(
                new Person(
                        "Bohdan",
                        "Dubrov",
                        19,
                        "Deputy"
                )
        );
        kievDeputies.add(
                new Person(
                        "Ivan",
                        "Ivanov",
                        30,
                        "Deputy"
                )
        );
        kievDeputies.add(
                new Person(
                        "Petro",
                        "Petrov",
                        25,
                        "Deputy"
                )
        );
        ArrayList<Person> chernihivDeputies = new ArrayList<>();
        chernihivDeputies.add(
                new Person(
                        "Ivan",
                        "Petrov",
                        19,
                        "Deputy"
                )
        );
        chernihivDeputies.add(
                new Person(
                        "Ivan",
                        "Fedorov",
                        30,
                        "Deputy"
                )
        );
        chernihivDeputies.add(
                new Person(
                        "Petro",
                        "Ivanov",
                        25,
                        "Deputy"
                )
        );
        ArrayList<Region> regions = new ArrayList<>();
        ArrayList<Locality> cities = new ArrayList<>();
        cities.add(new Locality("Kiev", 4000, kievDeputies.get(0), kievDeputies));
        cities.add(new Locality("Chernihiv", 120, chernihivDeputies.get(0), chernihivDeputies));
        Country country = new Country("Ukraine", 38000, cities.get(0), 3800, regions, cities);

        assertEquals("Ivan", country.findMostPopularNameInAllParliaments());
    }
}