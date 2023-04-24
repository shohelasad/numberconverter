package com.cflox.task.converter.factory;

import net.javaguides.springboot.enums.ConversionType;
import net.javaguides.springboot.service.BinaryToRomanConversion;
import net.javaguides.springboot.service.ConversionService;
import net.javaguides.springboot.service.DecimalToRomanConversion;

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
