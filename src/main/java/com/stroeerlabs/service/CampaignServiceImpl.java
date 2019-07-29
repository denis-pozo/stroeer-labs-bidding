package com.stroeerlabs.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CampaignServiceImpl implements CampaignService {

    private Map<String, List<String>> segmentsById = new HashMap<>();

    @Override
    public boolean addCampaign(String campaignId, List<String> segments) {
        segmentsById.put(campaignId, segments);
        return true;
    }

    @Override
    public boolean deleteAllTransactions() {
        segmentsById.clear();
        return true;
    }

    @Override
    public List<String> getCampaigns(List<String> segmentIds) {
        List<String> campaigns = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry : segmentsById.entrySet()) {
            if(segmentIds.isEmpty() && entry.getValue().isEmpty()) campaigns.add(entry.getKey());
            else if(entry.getValue().containsAll(segmentIds)) campaigns.add(entry.getKey());
        }

        return campaigns;
    }
}
