package com.stroeerlabs.service;

import com.stroeerlabs.domain.Campaign;

public interface CampaignService {
    
    boolean add(Campaign campaign);

    boolean deleteAllTransactions();
}
