package com.stroeerlabs.controller;

import com.stroeerlabs.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/config")
public class CampaignController {

    private static final HttpStatus SUCCESS_201 = HttpStatus.CREATED;
    private static final HttpStatus NO_CONTENT_204 = HttpStatus.NO_CONTENT;
    private static final HttpStatus SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR;


    @Autowired
    CampaignService campaignService;

    @PostMapping
    public ResponseEntity postConfiguration(
            @RequestParam(name = "id") String campaignId,
            @RequestParam(name = "seg", required = false) List<String> segments) {


        if(campaignId == " ") return new ResponseEntity(NO_CONTENT_204);
        if(campaignService.addCampaign(campaignId, segments)) return new ResponseEntity(NO_CONTENT_204);
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
