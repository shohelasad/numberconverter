package com.cflox.task.converter.utils;

import com.cflox.task.converter.exception.BadRequestException;

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
}
