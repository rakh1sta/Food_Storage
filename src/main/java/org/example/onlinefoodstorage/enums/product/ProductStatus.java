package org.example.onlinefoodstorage.enums.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductStatus {
    AVAILABLE("AVAILABLE"),
    OUT_OF_STOCK("OUT_OF_STOCK"),
    DISCONTINUED("DISCONTINUED"),
    ON_SALE("ON_SALE"),
    LIMITED_EDITION("LIMITED_EDITION");
    private final String value;
}
