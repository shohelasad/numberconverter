package com.cflox.task.converter.dto;

import com.cflox.task.converter.enums.ConversionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


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
