package com.cflox.task.converter.service;


import com.cflox.task.converter.enums.ConversionType;
import com.cflox.task.converter.exception.BadRequestException;
import com.cflox.task.converter.utils.ConversionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BinaryToRomanConversion implements ConversionService {

    @Override
    public boolean matches(String from, String to) {
        return ConversionType.BINARY.name().equals(from) && ConversionType.ROMAN.name().equals(to);
    }

    @Override
    public String convert(String input) {
        try {
            int decimal = Integer.parseInt(input, 2);
            return ConversionUtils.decimalToRoman(decimal);
        } catch (NumberFormatException e) {
            throw new BadRequestException(input + " can not be parsed to number");
        }
    }
}
