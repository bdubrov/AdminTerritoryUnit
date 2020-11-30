package com.dubrov.adminterritoryunit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Country country;
        Map<String, Territory> regions = new HashMap<>();
        Map<String, Territory> districts = new HashMap<>();
        Map<String, AdminTerritorialUnit> locations = new HashMap<>();
        locations.put("Kiev", new Locality("Kiev", 2884.0));
        locations.put("Brovary", new Locality("Brovary", 108.349));
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

        country = new Country(
                "Ukraine",
                4198.0,
                locations.get("Kiev"),
                603628,
                new HashSet<AdminTerritorialUnit>(regions.values()),
                new HashSet<AdminTerritorialUnit>(locations.values())
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
    }
}
