package com.mschallenge.foodtruck.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@Builder
public class GeoOpenFoodTruck {

    @JsonProperty("location")
    private GeoLocation location;

    @JsonProperty("open_food_trucks")
    private List<OpenFoodTruck> openFoodTrucks;
}
