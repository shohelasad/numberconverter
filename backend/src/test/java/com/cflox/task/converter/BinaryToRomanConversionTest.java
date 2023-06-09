package com.cflox.task.converter;

import com.cflox.task.converter.enums.ConversionType;
import com.cflox.task.converter.service.BinaryToRomanConversion;
import com.cflox.task.converter.service.ConversionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryToRomanConversionTest {

    private ConversionService conversion = new BinaryToRomanConversion();

    @Test
    public void testMatches() {
        Assertions.assertTrue(conversion.matches(ConversionType.BINARY.name(), ConversionType.ROMAN.name()));
    }

    @Test
    public void testConvertValidInput() {
        String result = conversion.convert("1010");
        Assertions.assertEquals("X", result);
    }
}
