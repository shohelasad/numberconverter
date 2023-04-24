package com.cflox.task.converter.dto;

import com.cflox.task.converter.enums.ConversionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ConversionRequest {

    private ConversionType from;

    private ConversionType to;

    private String number;
}
