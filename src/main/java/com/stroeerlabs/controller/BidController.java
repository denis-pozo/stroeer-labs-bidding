package com.stroeerlabs.controller;

import com.stroeerlabs.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/bid")
public class BidController {

    @Autowired
    CampaignService campaignService;

    @GetMapping
    public List<String> getCampaignIds(@RequestParam(name = "seg") List<String> segmentIds) {

        return campaignService.getCampaigns(segmentIds);
    }
}
