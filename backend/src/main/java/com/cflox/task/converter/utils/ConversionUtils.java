package com.cflox.task.converter.utils;

import com.cflox.task.converter.exception.BadRequestException;
import com.cflox.task.converter.service.BinaryToRomanConversion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpClientErrorException;

public class ConversionUtils {
    private static final int MAX_NUMBER = 3999;

    public static String decimalToRoman(int decimal) {
        if(decimal > MAX_NUMBER) {
            throw new BadRequestException("Number can not be larger than 3999!");
        }
        StringBuilder roman = new StringBuilder();
        int[] decimalValues = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < decimalValues.length; i++) {
            while (decimal >= decimalValues[i]) {
                roman.append(romanNumerals[i]);
                decimal -= decimalValues[i];
            }
        }

        return roman.toString();
    }

    public static int binaryToDecimal(int binary) {
        int decimal = 0, power = 0;
        while (binary > 0) {
            int digit = binary % 10;
            if(digit > 1) {
               throw new BadRequestException(binary + " is not valid binary number!");
            }
            decimal += digit * Math.pow(2, power);
            binary /= 10;
            power++;
        }

        return decimal;
    }
}
