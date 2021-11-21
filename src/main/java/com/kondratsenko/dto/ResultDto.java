package com.kondratsenko.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ResultDto {
    private String name;
    private String type;
    private int price;
}
