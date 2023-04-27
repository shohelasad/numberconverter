package com.cflox.task.converter.service;

import com.cflox.task.converter.enums.ConversionType;

import javax.management.BadAttributeValueExpException;

public interface ConversionService {
    boolean matches(String from, String to);
    String convert(String input);
}
