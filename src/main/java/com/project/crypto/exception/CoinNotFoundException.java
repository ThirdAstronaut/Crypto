package com.project.crypto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CoinNotFoundException extends RuntimeException {

    public CoinNotFoundException(String coinName) {
        super("Coin: " + coinName + " not found");
    }

}
