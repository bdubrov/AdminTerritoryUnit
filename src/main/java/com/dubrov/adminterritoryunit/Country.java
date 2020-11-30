package com.dubrov.adminterritoryunit;

import java.util.Collection;
import java.util.Iterator;

public class Country extends Territory {
    private Collection<AdminTerritorialUnit> regions;
    private Collection<AdminTerritorialUnit> localities;

    Country(String nameOfCountry, double numberOfPeople, AdminTerritorialUnit capital, double regionArea, Collection<AdminTerritorialUnit> regions, Collection<AdminTerritorialUnit> localities) {
        super(nameOfCountry, numberOfPeople, capital, regionArea);
        this.regions = regions;
        this.localities = localities;
    }

    public void printInfo() {
        StringBuilder localityInfo = new StringBuilder();
        localityInfo.append("Country name: ").append(name);
        localityInfo.append("\nNumber of people: ").append(numberOfPeople).append(" thousands");
        localityInfo.append("\nCountry territory area: ").append(regionArea);
        localityInfo.append("\nCapital: ");
        System.out.println(localityInfo);
        regionCenter.printInfo();
    }

    public void advancedPrintInfo() {
        StringBuilder localityInfo = new StringBuilder();
        localityInfo.append("Country name: ").append(name);
        localityInfo.append("\nNumber of people: ").append(numberOfPeople).append(" thousands");
        localityInfo.append("\nCountry territory area: ").append(regionArea);
        localityInfo.append("\nCapital: ");
        System.out.println(localityInfo);
        regionCenter.printInfo();
        System.out.println("Localities:");
        Iterator<AdminTerritorialUnit> iterator = localities.iterator();
        while (iterator.hasNext()) {
            AdminTerritorialUnit locality = iterator.next();
            locality.printInfo();
        }

    }

    public void addRegion(AdminTerritorialUnit newRegion) throws AddNullRegionException {
        if (newRegion == null) {
            throw new AddNullRegionException("Can`t add empty region!");
        }
        for (AdminTerritorialUnit region : regions) {
            if (region.equals(newRegion)) {
                System.out.println("Can`t add new region to country because this region is already exist!");
                return;
            }
        }
        this.regions.add(newRegion);
        System.out.println("New region \"" + newRegion.getName() + "\" add successfully");

    }

    public AdminTerritorialUnit getRegionByName(String regionName) {
        AdminTerritorialUnit ret = null;
        for (AdminTerritorialUnit region : regions) {
            if (region.getName().equals(regionName)) {
                ret = region;
                break;
            }
        }
        return ret;
    }

    public Collection<AdminTerritorialUnit> getRegions() {
        return regions;
    }

    public void setRegions(Collection<AdminTerritorialUnit> regions) {
        this.regions = regions;
    }

    public Collection<AdminTerritorialUnit> getLocalities() {
        return localities;
    }

    public void setLocalities(Collection<AdminTerritorialUnit> localities) {
        this.localities = localities;
    }

    public void addLocality(AdminTerritorialUnit locality) {
        this.localities.add(locality);
    }
}
