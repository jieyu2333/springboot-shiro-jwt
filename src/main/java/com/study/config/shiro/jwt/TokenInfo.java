package com.study.config.shiro.jwt;

import lombok.Data;

@Data
public class TokenInfo {

    private String token;

    private String refreshToken;

    public TokenInfo() {
    }

    public TokenInfo(String token) {
        this.token = token;
    }



    public TokenInfo(String token, String refreshToken) {
        this.token = token;
        this.refreshToken = refreshToken;
    }
}
