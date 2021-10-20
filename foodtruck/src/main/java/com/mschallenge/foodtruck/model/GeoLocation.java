package com.mschallenge.foodtruck.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@EqualsAndHashCode
public class GeoLocation {

    @EqualsAndHashCode.Include
    private double latitude;

    @EqualsAndHashCode.Include
    private double longitude;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private String address;

}
