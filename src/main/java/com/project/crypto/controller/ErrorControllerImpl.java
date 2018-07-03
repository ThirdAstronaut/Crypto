package com.project.crypto.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rafał on 2017-09-05.
 */
@RestController
public class ErrorControllerImpl implements ErrorController {

    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = PATH)
    public String errorMsg(){
        return "Sorry, bad gateway!";
    }
}
