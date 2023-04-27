package com.cflox.task.converter;

import com.cflox.task.converter.enums.ConversionType;
import com.cflox.task.converter.service.ConversionService;
import com.cflox.task.converter.service.DecimalToRomanConversion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecimalToRomanConversionTest {

    private ConversionService conversion = new DecimalToRomanConversion();

    @Test
    public void testMatches() {
        Assertions.assertTrue(conversion.matches(ConversionType.DECIMAL.name(), ConversionType.ROMAN.name()));
    }

    @Test
    public void testConvertValidInput() {
        String result = conversion.convert("1010");
        Assertions.assertEquals("MX", result);
    }
}
