package com.cflox.task.converter.factory;

import com.cflox.task.converter.enums.ConversionType;
import com.cflox.task.converter.service.BinaryToRomanConversion;
import com.cflox.task.converter.service.ConversionService;
import com.cflox.task.converter.service.DecimalToRomanConversion;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ConversionFactory {
    private final List<ConversionService> conversions = new ArrayList<>();

    public ConversionFactory(BinaryToRomanConversion binaryToRomanConversion, DecimalToRomanConversion decimalToRomanConversion){
        this.conversions.add(decimalToRomanConversion);
        this.conversions.add(binaryToRomanConversion);
    }

    public ConversionService process(String from, String to) {
        for (ConversionService service : conversions) {
            if (service.matches(from, to)) {
                return service;
            }
        }

        throw new UnsupportedOperationException(
                String.format("Cannot convert from %s to %s", from, to));
    }
}
