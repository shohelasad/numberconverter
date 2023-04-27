package com.cflox.task.converter.dto;

import javax.validation.constraints.NotNull;

public class ConversionRequest {

    @NotNull
    private String from;

    @NotNull
    private String to;

    @NotNull
    private String number;

    public ConversionRequest(String from, String to, String number) {
        this.from = from;
        this.to = to;
        this.number = number;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
