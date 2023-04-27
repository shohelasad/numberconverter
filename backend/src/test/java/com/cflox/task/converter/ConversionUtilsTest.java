package com.cflox.task.converter;


import com.cflox.task.converter.utils.ConversionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConversionUtilsTest {
    @Test
    void decimalToRomanTest() {
        assertEquals("IV", ConversionUtils.decimalToRoman(4));
        assertEquals("IX", ConversionUtils.decimalToRoman(9));
        assertEquals("XIV", ConversionUtils.decimalToRoman(14));
        assertEquals("XX", ConversionUtils.decimalToRoman(20));
        assertEquals("XLVII", ConversionUtils.decimalToRoman(47));
        assertEquals("XCIX", ConversionUtils.decimalToRoman(99));
        assertEquals("CXXVIII", ConversionUtils.decimalToRoman(128));
        assertEquals("DCCCXC", ConversionUtils.decimalToRoman(890));
        assertEquals("MCMXCVI", ConversionUtils.decimalToRoman(1996));
        assertEquals("MMXXI", ConversionUtils.decimalToRoman(2021));
    }
}
