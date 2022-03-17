package com.inpost.qa.inpost.responses;

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
public class GetPaczkomatyItemsResponse {

    String href;
    int count;
    int page;
    int per_page;
    int total_pages;
    List<ItemsDetails> items;
    Meta meta;

}
