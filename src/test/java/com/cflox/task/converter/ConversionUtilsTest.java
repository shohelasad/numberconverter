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

    @Test
    void binaryToDecimalTest() {
        assertEquals(1, ConversionUtils.binaryToDecimal(1));
        assertEquals(2, ConversionUtils.binaryToDecimal(10));
        assertEquals(3, ConversionUtils.binaryToDecimal(11));
        assertEquals(4, ConversionUtils.binaryToDecimal(100));
        assertEquals(5, ConversionUtils.binaryToDecimal(101));
        assertEquals(10, ConversionUtils.binaryToDecimal(1010));
        assertEquals(42, ConversionUtils.binaryToDecimal(101010));
        assertEquals(100, ConversionUtils.binaryToDecimal(1100100));
        assertEquals(109, ConversionUtils.binaryToDecimal(1101101));
        assertEquals(976, ConversionUtils.binaryToDecimal(1111010000));
    }
}
