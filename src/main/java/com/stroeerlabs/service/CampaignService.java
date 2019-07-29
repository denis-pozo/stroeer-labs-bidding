package com.stroeerlabs.service;

import java.util.List;

public interface CampaignService {

    boolean addCampaign(String campaignId, List<String> segments);

    boolean deleteAllTransactions();

    List<String> getCampaigns(List<String> segmentIds);

}
