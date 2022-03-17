package com.inpost.qa.inpost.responses.getPaczkomatyResponse.itemDetails;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemsDetails {

    String name;
    List<String> type;
    Location location;
    String location_date;
    String opening_hours;
    Address address;
    AddressDetails address_details;
    List<String> functions;
    int partner_id;
    String apm_doubled;
    Boolean location_247;
    String image_url;
    Boolean easy_access_zone;
}
