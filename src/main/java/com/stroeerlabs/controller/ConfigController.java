package com.stroeerlabs.controller;

import com.stroeerlabs.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/config")
public class ConfigController {

    @Autowired
    ConfigurationService configurationService;

    @PostMapping
    public void postConfiguration(
            @RequestParam(name = "id") String configId,
            @RequestParam( name = "seg", required = false) String segments) {

    }

}
