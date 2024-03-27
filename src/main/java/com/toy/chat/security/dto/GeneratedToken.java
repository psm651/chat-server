package com.toy.chat.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Builder @ToString
public class GeneratedToken {

    private String accessToken;
    private String refreshToken;
}