package com.mschallenge.foodtruck.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class OpenFoodTruck {

    @JsonProperty("name")
    private String applicant;

    @JsonProperty("address")
    private String address;

    @JsonProperty("fooditems")
    private String foodItems;

    @JsonProperty("dayshours")
    private String daysHours;
}
