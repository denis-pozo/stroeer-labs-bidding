package com.stroeerlabs.domain;

import lombok.Value;

import java.util.List;

@Value
public class Campaign {

    private final String id;
    private final List<String> segments;

    public boolean matches(List<String> segList) {
        for(String segment : segments) {
            if(!segList.contains(segment)) return false;
        }

        return true;
    }
}
