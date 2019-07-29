package com.stroeerlabs.domain;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.*;

@Log4j2
public class CampaignTest {

    @Test
    public void whenCampaignIsEmpty_ThenEverySegmentListShouldReturnTrue() {
        log.info("Test: when campaign is empty, every segment list should match the campaing");
        Campaign campaign = new Campaign("test", new ArrayList<>());
        List<String> segments = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assertTrue(campaign.matches(segments));
    }

    @Test
    public void whenCampaignIsEmpty_ThenMatchesAnEmptyListOfSegmentsShouldReturnTrue() {
        log.info("Test: when campaign is empty, matches returns true with empty list of segments");
        Campaign campaign = new Campaign("test", new ArrayList<>());
        List<String> segments = new ArrayList<>();
        assertTrue(campaign.matches(segments));
    }

    @Test
    public void whenCampaignIsNotEmpty_ThenMatchesAnEmptyListOfSegmentsShouldReturnFalse() {
        log.info("Test: when campaign is not empty, an empty list of segments passed in should not match");
        Campaign campaign = new Campaign("test", new ArrayList<>(Arrays.asList("abc")));
        List<String> segments = new ArrayList<>();
        assertFalse(campaign.matches(segments));
    }

    @Test
    public void whenSegmentsArePresentInCampaign_ThenMatchesShouldReturnTrue() {
        log.info("Test: when segments are present in campaign, matches is true");
        Campaign campaign = new Campaign("test", new ArrayList<>(Arrays.asList("a")));
        List<String> segments = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assertTrue(campaign.matches(segments));
    }

    @Test
    public void whenOneSegmentIsMissing_ThenMatchesShouldReturnFalse() {
        log.info("Test: when one of the segments passed in is missing, there is no match");
        Campaign campaign = new Campaign("test", new ArrayList<>(Arrays.asList("a, b")));
        List<String> segments = new ArrayList<>(Arrays.asList("a"));
        assertFalse(campaign.matches(segments));
    }
}
