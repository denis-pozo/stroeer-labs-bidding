package com.stroeerlabs.service;

import java.util.List;

public interface CampaignService {

    boolean addCampaign(String campaignId, List<String> segments);

    boolean deleteAllCampaigns();

    List<String> findMatchingCampaigns(List<String> segmentIds);

}
