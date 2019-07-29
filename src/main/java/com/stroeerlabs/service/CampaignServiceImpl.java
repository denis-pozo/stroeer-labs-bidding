package com.stroeerlabs.service;

import com.stroeerlabs.domain.Campaign;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CampaignServiceImpl implements CampaignService {

    private Map<String, Campaign> campaignsById = new HashMap<>();

    @Override
    public boolean addCampaign(String campaignId, List<String> segments) {
        Campaign campaign = new Campaign(campaignId, segments);
        campaignsById.put(campaignId, campaign);
        return true;
    }

    /* Note: I have implemented this method for it-testing purposes, although I know it is not requested */
    @Override
    public boolean deleteAllCampaigns() {
        campaignsById.clear();
        return true;
    }

    @Override
    public List<String> getCampaigns(List<String> segmentIds) {
        List<String> campaigns = new ArrayList<>();

        for(Campaign campaign : campaignsById.values()) {
            if(campaign.matches(segmentIds)) campaigns.add(campaign.getId());
        }

        return campaigns;
    }
}
