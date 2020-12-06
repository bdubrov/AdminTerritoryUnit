package com.dubrov.adminterritoryunit;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class Country extends Territory {
    private Collection<Region> regions;
    private Collection<Locality> localities;

    Country(String nameOfCountry, double numberOfPeople, AdminTerritorialUnit capital, double regionArea, Collection<Region> regions, Collection<Locality> localities) {
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
        Iterator<Locality> iterator = localities.iterator();
        while (iterator.hasNext()) {
            AdminTerritorialUnit locality = iterator.next();
            locality.printInfo();
        }

    }

    public void addRegion(Region newRegion) throws AddNullRegionException {
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

    public double findNumberOfPeopleOfAllRegionalCityCenter() {
        return localities.stream()
                .filter(locality -> locality.getLocalityType() == LocalityType.REGIONAL_CITY)
                .mapToDouble(Locality::getNumberOfPeople)
                .sum();
    }

    public Region findRegionWithMaxArea() {
        return regions.stream()
                .max((region1, region2) -> Double.compare(region1.getRegionArea(), region2.getRegionArea()))
                .get();
    }

    public Region findRegionWithMaxAreaUpdated() {
        return regions.stream()
                .max(Comparator.comparing(Territory::getRegionArea))
                .get();
    }

    public double findAverageAreaOfRegions() {
        return regions.stream()
                .mapToDouble(Territory::getRegionArea)
                .average()
                .getAsDouble();
    }

    public Map<Boolean, List<Locality>> findAllLocalityByType(LocalityType localityType) {
        return localities.stream()
                .collect(Collectors.partitioningBy(locality -> locality.getLocalityType() == localityType));
    }

    public String findMostPopularNameInAllParliaments() {
        return localities.stream()
                .flatMap(locality -> locality.getParliament().getDeputies().stream())
                .collect(Collectors.groupingBy(x -> x, counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey()
                .getName();
    }

    public Collection<Region> getRegions() {
        return regions;
    }

    public void setRegions(Collection<Region> regions) {
        this.regions = regions;
    }

    public Collection<Locality> getLocalities() {
        return localities;
    }

    public void setLocalities(Collection<Locality> localities) {
        this.localities = localities;
    }

    public void addLocality(Locality locality) {
        this.localities.add(locality);
    }
}
