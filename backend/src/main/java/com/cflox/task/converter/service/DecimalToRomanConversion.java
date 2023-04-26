package com.cflox.task.converter.service;


import com.cflox.task.converter.enums.ConversionType;
import com.cflox.task.converter.utils.ConversionUtils;
import org.springframework.stereotype.Service;

@Service
public class DecimalToRomanConversion implements ConversionService {

    @Override
    public boolean matches(ConversionType from, ConversionType to) {
        return ConversionType.DECIMAL.equals(from) && ConversionType.ROMAN.equals(to);
    }

    @Override
    public String convert(String input) {
        try {
            int decimal = Integer.valueOf(input);
            return ConversionUtils.decimalToRoman(decimal);
        } catch (NumberFormatException e) {
            //log
        }

        return null;
    }
}
