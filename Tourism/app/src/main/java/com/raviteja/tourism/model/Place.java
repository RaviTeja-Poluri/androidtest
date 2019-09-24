package com.raviteja.tourism.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Place {

    private Long id;
    private String name;
    private String description;
    private Collection<String> placePics;
    private String nearestRailwayStation;
    private String nearestAirport;
    private String nearestBusTerminal;
    private long stateId;
    private long cityId;
    private String villageOrCity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<String> getPlacePics() {
        return placePics;
    }

    public void setPlacePics(Collection<String> placePics) {
        this.placePics = placePics;
    }

    public String getNearestRailwayStation() {
        return nearestRailwayStation;
    }

    public void setNearestRailwayStation(String nearestRailwayStation) {
        this.nearestRailwayStation = nearestRailwayStation;
    }

    public String getNearestAirport() {
        return nearestAirport;
    }

    public void setNearestAirport(String nearestAirport) {
        this.nearestAirport = nearestAirport;
    }

    public String getNearestBusTerminal() {
        return nearestBusTerminal;
    }

    public void setNearestBusTerminal(String nearestBusTerminal) {
        this.nearestBusTerminal = nearestBusTerminal;
    }

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getVillageOrCity() {
        return villageOrCity;
    }

    public void setVillageOrCity(String villageOrCity) {
        this.villageOrCity = villageOrCity;
    }
}
