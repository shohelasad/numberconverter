package com.cflox.task.converter.service;


import com.cflox.task.converter.enums.ConversionType;
import org.springframework.stereotype.Service;

@Service
public class DecimalToRomanConversion implements ConversionService {

    @Override
    public boolean matches(ConversionType from, ConversionType to) {
        return true;
    }

    @Override
    public String convert(String input) {
        return null;
    }
}
