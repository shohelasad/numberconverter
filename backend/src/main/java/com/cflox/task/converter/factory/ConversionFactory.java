package com.cflox.task.converter.factory;

import com.cflox.task.converter.enums.ConversionType;
import com.cflox.task.converter.service.BinaryToRomanConversion;
import com.cflox.task.converter.service.ConversionService;
import com.cflox.task.converter.service.DecimalToRomanConversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversionFactory {

    private final List<ConversionService> conversions = new ArrayList<>();

    public ConversionFactory(){
        this(new BinaryToRomanConversion(), new DecimalToRomanConversion());
    }

    public ConversionFactory(ConversionService... conversions) {
        this.conversions.addAll(Arrays.asList(conversions));
    }

    public ConversionService process(ConversionType from, ConversionType to) {
        for (ConversionService service : conversions) {
            if (service.matches(from, to)) {
                return service;
            }
        }
        return null;
    }
}
