package com.mschallenge.foodtruck.service;

import com.mschallenge.foodtruck.model.GeoLocation;
import com.mschallenge.foodtruck.model.GeoOpenFoodTruck;
import com.mschallenge.foodtruck.model.OpenFoodTruck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OpenFoodTruckService {
    private final MobilePermitsService mobilePermitsService;

    @Autowired
    public OpenFoodTruckService(MobilePermitsService mobilePermitsService) {
        this.mobilePermitsService = mobilePermitsService;
    }

    public List<GeoOpenFoodTruck> retrieveOpenFoodTruck() {
        HashMap<GeoLocation, List<OpenFoodTruck>> locationTrucksMap = mobilePermitsService.retrieveGeoCoordinatedTrucks();
        List<GeoOpenFoodTruck> geoOpenFoodTrucks = new ArrayList<>();
        for (GeoLocation key : locationTrucksMap.keySet()){
            GeoOpenFoodTruck geoOpenFoodTruck = GeoOpenFoodTruck.builder()
                    .location(key)
                    .openFoodTrucks(locationTrucksMap.get(key))
                    .build();
            geoOpenFoodTrucks.add(geoOpenFoodTruck);
        }
        return geoOpenFoodTrucks;
    }
}
