package com.cflox.task.converter;


import com.cflox.task.converter.utils.ConversionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConversionUtilsTest {
    @Test
    void decimalToRomanTest() {
        assertEquals("IV", ConversionUtils.decimalToRoman(4));
    }
}
