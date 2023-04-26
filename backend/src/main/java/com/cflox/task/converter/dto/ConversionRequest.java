package com.cflox.task.converter.dto;

import com.cflox.task.converter.enums.ConversionType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ConversionRequest {

    @NotNull
    private ConversionType from;

    @NotNull
    private ConversionType to;

    @NotNull
    private String number;
}
