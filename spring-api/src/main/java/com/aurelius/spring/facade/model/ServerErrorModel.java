package com.aurelius.spring.facade.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServerErrorModel {
    private String path;
    private String description;
    private int internalErrorCode;
}
