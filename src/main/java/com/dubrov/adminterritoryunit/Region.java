package com.dubrov.adminterritoryunit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Region extends Territory {
    private Collection<Territory> districts;

    public Region(String name, double numberOfPeople, AdminTerritorialUnit regionCenter, double regionArea) {
        super(name, numberOfPeople, regionCenter, regionArea);
        districts = new ArrayList<>();
    }

    public Region(String name, double numberOfPeople, AdminTerritorialUnit regionCenter, double regionArea,
                  Collection<Territory> districts) {
        super(name, numberOfPeople, regionCenter, regionArea);
        this.districts = districts;
    }

    public void printInfo() {
        StringBuilder localityInfo = new StringBuilder();
        localityInfo.append("\tRegion name: ").append(name);
        localityInfo.append("\n\tNumber of people: ").append(numberOfPeople).append(" thousands");
        localityInfo.append("\n\tRegion area ").append(regionArea);
        localityInfo.append("\n\tRegion center ").append(regionCenter.getName());
        if (districts != null) {
            localityInfo.append("\n\tRegion districts:");
            for (Territory district : districts) {
                localityInfo.append("\n\t\t").append(district.name);
            }
        }
        System.out.println(localityInfo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Region)) return false;
        if (!super.equals(o)) return false;
        Region region = (Region) o;
        return districts.equals(region.districts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), districts);
    }

    public Collection<Territory> getDistricts() {
        return districts;
    }

    public void setDistricts(Collection<Territory> districts) {
        this.districts = districts;
    }

    public void addDistrict(Territory district) {
        this.districts.add(district);
    }
}
