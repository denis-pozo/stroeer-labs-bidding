package com.stroeerlabs.domain;

import lombok.Value;

import java.util.List;

@Value
public class Campaign {

    private final String id;
    private final List<String> segments;

    /**
     * This method returns true when every segment of this campaign is in the list passed in, otherwise false.
     *
     * @param segList list of segments to be compared
     * @return true if the segments of the campaign are contained in list passed in, else false
     */
    public boolean matches(List<String> segList) {
        for(String segment : segments) {
            if(!segList.contains(segment)) return false;
        }

        return true;
    }
}
