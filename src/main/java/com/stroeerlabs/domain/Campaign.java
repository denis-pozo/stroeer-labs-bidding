package com.stroeerlabs.domain;

import lombok.Value;

import java.util.List;

@Value
public class Campaign {

    private final String id;
    private final List<String> segments;

}
