package com.inpost.qa.inpost.responses.getPaczkomatyResponse.meta;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Meta {
    String href;
    int count;
    int page;
    int per_page;
    int total_pages;
}
