package com.cflox.task.converter.dto;

import com.cflox.task.converter.enums.ConversionType;

import javax.validation.constraints.NotNull;

public class ConversionRequest {

    @NotNull
    private ConversionType from;

    @NotNull
    private ConversionType to;

    @NotNull
    private String number;

    public ConversionRequest(ConversionType from, ConversionType to, String number) {
        this.from = from;
        this.to = to;
        this.number = number;
    }

    public ConversionType getFrom() {
        return from;
    }

    public void setFrom(ConversionType from) {
        this.from = from;
    }

    public ConversionType getTo() {
        return to;
    }

    public void setTo(ConversionType to) {
        this.to = to;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
