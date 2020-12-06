package com.dubrov.adminterritoryunit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Country country;
        Map<String, Region> regions = new HashMap<>();
        Map<String, District> districts = new HashMap<>();
        Map<String, Locality> locations = new HashMap<>();
        locations.put("Kiev", new Locality("Kiev", 2000.0));
        locations.put("Brovary", new Locality("Brovary", 105.349));
        locations.put("Kalinovka", new Locality("Kalinovka", 5.704));
        locations.put("Zazimye", new Locality("Zazimye", 4.259));
        districts.put("Brovarsky district",
                new District(
                        "Brovarsky district",
                        68.688,
                        locations.get("Brovary"),
                        1188.0
                )
        );
        regions.put("Kiev region",
                new Region(
                        "Kiev region",
                        1781.0,
                        locations.get("Kiev"),
                        28121,
                        new HashSet<>(districts.values())
                )
        );
        regions.put("Chernihiv region",
                new Region(
                        "Chernihiv region",
                        200,
                        locations.get("Kiev"),
                        40000,
                        new HashSet<>(districts.values())
                )
        );

        country = new Country(
                "Ukraine",
                4198.0,
                locations.get("Kiev"),
                603628,
                new HashSet<>(regions.values()),
                new HashSet<>(locations.values())
        );
        country.printInfo();

        try {
            country.addRegion(regions.get("Kiev region"));
        } catch (AddNullRegionException ex) {
            System.err.println(ex.getMessage());
        }

        country.printInfo();

        AdminTerritorialUnit kievRegion = country.getRegionByName("Kiev region");
        kievRegion.printInfo();

        System.out.println("\n\n");
        locations.get("Kiev").printInfo();
        Locality kievModified = (Locality) locations.get("Kiev");
        kievModified.getParliament().addOneDeputy("Bohdan Dubrov 19 deputy");
        locations.put("Kiev", kievModified);
        System.out.println("\n\n");
        locations.get("Kiev").printInfo();

        System.out.println("\n\n Country advanced print\n");
        country.advancedPrintInfo();

        try {
            country.addRegion(null);
        } catch (AddNullRegionException ex) {
            System.err.println(ex.getMessage());
        }


        System.out.println("Кількість людей, що проживають у регіональних центрах країни: " +
                country.findNumberOfPeopleOfAllRegionalCityCenter() + " тисяч");

        System.out.println("Регіон країни з максимальною площею:");
        country.findRegionWithMaxArea().printInfo();
        System.out.println("Регіон країни з максимальною площею:");
        country.findRegionWithMaxAreaUpdated().printInfo();

        System.out.println("Середня площа регіону в країні: " + country.findAverageAreaOfRegions());

        System.out.println("Список міст регіонального значення країни:");
        country.findAllLocalityByType(LocalityType.REGIONAL_CITY).get(true).forEach(Locality::printInfo);

        System.out.println("Найпопулярніше ім`я серед усіх депутатів в країні: " + country.findMostPopularNameInAllParliaments());
    }
}
