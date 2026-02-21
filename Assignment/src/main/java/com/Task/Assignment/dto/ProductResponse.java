package com.Task.Assignment.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

    private Integer id;
    private String productName;
    private String createdBy;
}