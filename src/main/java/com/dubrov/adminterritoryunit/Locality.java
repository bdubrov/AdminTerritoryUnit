package com.dubrov.adminterritoryunit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import static com.dubrov.adminterritoryunit.LocalityType.*;

public class Locality implements AdminTerritorialUnit {
    private String name;
    private double numberOfPeople;
    private Person leader;
    private Parliament parliament;
    private LocalityType localityType;

    public static class Parliament {
        private int numOfDeputies;
        private Collection<Person> deputies;

        public Parliament() {
            deputies = new ArrayList<>();
            numOfDeputies = 0;
        }

        public Parliament(Collection<Person> deputies) {
            this.numOfDeputies = deputies.size();
            this.deputies = deputies;
        }

        public int getNumOfDeputies() {
            return numOfDeputies;
        }

        public void setNumOfDeputies(int numOfDeputies) {
            this.numOfDeputies = numOfDeputies;
        }

        public void addOneDeputy(Person newDeputy) {
            boolean allowAdd = true;
            if (newDeputy != null) {
                for (Person deputy : deputies) {
                    if (newDeputy.equals(deputy)) {
                        allowAdd = false;
                        break;
                    }
                }
                if (allowAdd) {
                    deputies.add(newDeputy);
                    this.numOfDeputies += 1;
                }
            }
        }

        public void addOneDeputy(String deputyInfoString) {
            String[] deputyInfo = deputyInfoString.split(" ", 4);
            Person newDeputy = new Person(deputyInfo[0], deputyInfo[1], Integer.parseInt(deputyInfo[2]), deputyInfo[3]);
            boolean allowAdd = true;
            if (deputies != null) {
                for (Person deputy : deputies) {
                    if (newDeputy.equals(deputy)) {
                        allowAdd = false;
                        break;
                    }
                }
            }
            if (allowAdd) {
                deputies.add(newDeputy);
                this.numOfDeputies += 1;
            }

        }

        public Collection<Person> getDeputies() {
            return deputies;
        }

        public void setDeputies(ArrayList<Person> deputies) {
            this.deputies = deputies;
        }

        @Override
        public String toString() {
            StringBuilder parliamentString = new StringBuilder();
            if (deputies.size() != 0) {
                parliamentString.append("Parliament:");
                parliamentString.append("\tNumber of deputies = ").append(numOfDeputies);
                parliamentString.append("\n\tdeputies = ");
                for (Person deputy : deputies) {
                    parliamentString.append("\n\t\t").append(deputy.getName()).append(" ").append(deputy.getSurname());
                }
            } else {
                parliamentString.append("Parliament does not exist");
            }
            parliamentString.append('\n');
            return parliamentString.toString();
        }
    }

    public Locality(String name, double numberOfPeople, Person leader, Collection<Person> deputies) {
        this.name = name;
        this.numberOfPeople = numberOfPeople;
        this.leader = leader;
        this.localityType = determineTypeByNumberOfPeople(numberOfPeople);
        parliament = new Parliament(deputies);
    }

    public Locality(String name, double numberOfPeople) {
        this.name = name;
        this.numberOfPeople = numberOfPeople;
        this.localityType = determineTypeByNumberOfPeople(numberOfPeople);
        this.parliament = new Parliament();
    }

    public LocalityType determineTypeByNumberOfPeople(double numberOfPeople) {
        LocalityType localityType;
        if (numberOfPeople < URBAN_VILLAGE.getMinNumberOfPeople()) {
            localityType = VILLAGE;
        } else if (numberOfPeople < DISTRICT_CITY.getMinNumberOfPeople()) {
            localityType = URBAN_VILLAGE;
        } else if (numberOfPeople < REGIONAL_CITY.getMinNumberOfPeople()) {
            localityType = DISTRICT_CITY;
        } else {
            localityType = REGIONAL_CITY;
        }
        return localityType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void changeName(String newName) {
        name = newName;
    }

    @Override
    public void changeNumberOfPeople(double newNumberOfPeople) {
        numberOfPeople = newNumberOfPeople;
        this.localityType = determineTypeByNumberOfPeople(numberOfPeople);
    }

    @Override
    public double getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public void printInfo() {
        StringBuilder localityInfo = new StringBuilder();
        localityInfo.append("\tLocality name: ").append(name);
        localityInfo.append("\n\tNumber of people: ").append(numberOfPeople).append(" thousands");
        localityInfo.append("\n\tLocality type: ").append(localityType.getFullName());
        if (leader != null) {
            localityInfo.append("\n\t").append(leader.getName()).append(" ").append(leader.getSurname());
        }
        if (parliament != null) {
            localityInfo.append("\n\t").append(parliament);
        }
        System.out.println(localityInfo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Locality)) return false;
        Locality locality = (Locality) o;
        return Double.compare(locality.numberOfPeople, numberOfPeople) == 0 &&
                name.equals(locality.name) &&
                leader.equals(locality.leader) &&
                parliament.equals(locality.parliament) &&
                localityType == locality.localityType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfPeople, leader, parliament, localityType);
    }

    public Person getLeader() {
        return leader;
    }

    public void setLeader(Person leader) {
        this.leader = leader;
    }

    public Parliament getParliament() {
        return parliament;
    }

    public void setParliament(Collection<Person> deputies) {
        this.parliament = new Parliament(deputies);
    }

    public LocalityType getLocalityType() {
        return localityType;
    }

    public void setLocalityType(LocalityType localityType) {
        this.localityType = localityType;
    }


}
