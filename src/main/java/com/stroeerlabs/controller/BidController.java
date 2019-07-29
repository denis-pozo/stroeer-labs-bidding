package com.stroeerlabs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/bid")
public class BidController {

    @GetMapping
    public List<String> getCampaignIds(@RequestParam(name = "seg") List<String> segmentÌds) {

        return new ArrayList<String>();
    }
}
