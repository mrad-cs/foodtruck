package com.mschallenge.foodtruck.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
public class MobileFoodTruckPermit {

    @JsonProperty("objectid")
    private String objectId;

    private String applicant;

    @JsonProperty("facilitytype")
    private String facilityType;

    private String cnn;

    @JsonProperty("locationdescription")
    private String locationDescription;

    private String address;

    @JsonProperty("blocklot")
    private String blockLot;

    private String block;

    private String lot;

    private String permit;

    private String status;

    @JsonProperty("fooditems")
    private String foodItems;

    private String x;

    private String y;

    private String latitude;

    private String longitude;

    private String schedule;

    @JsonProperty("dayshours")
    private String daysHours;

    @JsonProperty("noisent")
    private String NOISent;

    private String approved;

    private String received;

    @JsonProperty("priorpermit")
    private String priorPermit;

    @JsonProperty("expirationdate")
    private String expirationDate;

    @JsonProperty("location")
    private GeoLocation location;

    @JsonProperty(":@computed_region_yftq_j783")
    private String firePreventionDistricts;

    @JsonProperty(":@computed_region_p5aj_wyqh")
    private String policeDistricts;

    @JsonProperty(":@computed_region_rxqg_mtj9")
    private String supervisorDistricts;

    @JsonProperty(":@computed_region_bh8s_q3mv")
    private String zipCodes;

    @JsonProperty(":@computed_region_fyvs_ahh9")
    private String neighborhoods;
}
