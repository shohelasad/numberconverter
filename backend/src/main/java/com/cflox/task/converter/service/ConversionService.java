package com.cflox.task.converter.service;

import com.cflox.task.converter.enums.ConversionType;

public interface ConversionService {
    boolean matches(ConversionType from, ConversionType to);
    String convert(String input);
}
