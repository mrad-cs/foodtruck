package com.mschallenge.foodtruck.controller;

import com.mschallenge.foodtruck.model.GeoOpenFoodTruck;
import com.mschallenge.foodtruck.service.OpenFoodTruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/api/geo", produces = {"application/json", "text/xml"})
@CrossOrigin(origins = "*")
public class FoodTruckController {
    private final OpenFoodTruckService openFoodTruckService;

    @Autowired
    public FoodTruckController(OpenFoodTruckService openFoodTruckService) {
        this.openFoodTruckService = openFoodTruckService;
    }

    @GetMapping("/trucks")
    @ResponseBody
    public List<GeoOpenFoodTruck> getOpenFoodTruck() {
        return openFoodTruckService.retrieveOpenFoodTruck();
    }

}
