package com.stroeerlabs.controller;

import com.stroeerlabs.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/config")
@RestController
public class CampaignConfigController {

    private static final HttpStatus SUCCESS_201 = HttpStatus.CREATED;
    private static final HttpStatus NO_CONTENT_204 = HttpStatus.NO_CONTENT;
    private static final HttpStatus SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR;


    @Autowired
    CampaignService campaignService;

    @PostMapping
    public ResponseEntity postConfiguration(
            @RequestParam(name = "id") String campaignId,
            @RequestParam(name = "seg", required = false) List<String> segments) {

        if(segments == null) segments = new ArrayList<>();
        if(!campaignService.addCampaign(campaignId, segments)) return new ResponseEntity(SERVER_ERROR);

        return new ResponseEntity(SUCCESS_201);
    }

    @DeleteMapping
    public ResponseEntity deleteAllCampaigns () {

        if(campaignService.deleteAllTransactions()) {
            return new ResponseEntity(NO_CONTENT_204);
        }

        return new ResponseEntity(SERVER_ERROR);
    }

}
