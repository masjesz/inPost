package com.inpost.qa.session;

import lombok.Getter;

@Getter
public enum SessionHeaders {
    HOST("api-pl-points.easypack24.net");

    private final String headerName;

    SessionHeaders(String headerName) {
        this.headerName = headerName;
    }

}
