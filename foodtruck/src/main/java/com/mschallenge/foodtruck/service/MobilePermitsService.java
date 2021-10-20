package com.mschallenge.foodtruck.service;

import com.mschallenge.foodtruck.client.PermitsWebClient;
import com.mschallenge.foodtruck.model.GeoLocation;
import com.mschallenge.foodtruck.model.MobileFoodTruckPermit;
import com.mschallenge.foodtruck.model.OpenFoodTruck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MobilePermitsService {
    private final PermitsWebClient permitsWebClient;

    @Autowired
    public MobilePermitsService(PermitsWebClient permitsWebClient) {
        this.permitsWebClient = permitsWebClient;
    }

    // TODO Add Cache for permits
    public HashMap<GeoLocation, List<OpenFoodTruck>> retrieveGeoCoordinatedTrucks() {
        HashMap<GeoLocation, List<OpenFoodTruck>> locationTrucksMap = new HashMap<>();
        List<MobileFoodTruckPermit> permits = permitsWebClient.retrievePermits().block();

        for (MobileFoodTruckPermit permit : permits) {
            OpenFoodTruck openFoodTruck = OpenFoodTruck.builder()
                    .applicant(permit.getApplicant())
                    .address(permit.getAddress())
                    .foodItems(permit.getFoodItems())
                    .daysHours(permit.getDaysHours())
                    .build();
            locationTrucksMap.computeIfAbsent(permit.getLocation(),
                    k -> new ArrayList<>()).add(openFoodTruck);
        }
        return locationTrucksMap;
    }
}
