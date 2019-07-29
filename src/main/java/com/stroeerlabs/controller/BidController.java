package com.stroeerlabs.controller;

import com.stroeerlabs.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bid")
@RestController
public class BidController {

    @Autowired
    CampaignService campaignService;

    @GetMapping
    @ResponseBody
    public String getCampaignIds(@RequestParam(name = "seg") List<String> segmentIds) {

        return formatResponse(campaignService.getCampaigns(segmentIds));
    }

    private String formatResponse(List<String> campaigns) {
        if(campaigns.size() == 0) return "";

        StringBuilder str = new StringBuilder();

        for(int i = 0 ; i < campaigns.size()-1 ; i ++) {
            str.append(campaigns.get(i) + ",");
        }

        str.append(campaigns.get(campaigns.size()-1));
        return str.toString();
    }
}
