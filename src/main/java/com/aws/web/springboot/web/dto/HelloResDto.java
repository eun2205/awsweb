package com.aws.web.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResDto {
    private final String name;
    private final int amount;
}
