package org.example.onlinefoodstorage.enums.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserStatus {
    ACTIVE("ACTIVE"),
    NO_ACTIVE("NO_ACTIVE"),
    BLOCK("BLOCK");
    private final String value;
}
