package org.example.onlinefoodstorage.enums.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CategoryStatus {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    ARCHIVED("ARCHIVED");
    private final String value;
}
