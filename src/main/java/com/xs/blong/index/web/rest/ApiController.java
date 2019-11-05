package com.xs.blong.index.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/ok")
    public String ok() {
        return "ok";
    }

}
