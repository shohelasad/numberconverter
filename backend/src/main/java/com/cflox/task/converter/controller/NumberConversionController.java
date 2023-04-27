package com.cflox.task.converter.controller;

import com.cflox.task.converter.dto.ConversionRequest;
import com.cflox.task.converter.factory.ConversionFactory;
import com.cflox.task.converter.service.ConversionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class NumberConversionController {

    private final ConversionFactory conversionFactory;

    public NumberConversionController(ConversionFactory conversionFactory) {
        this.conversionFactory = conversionFactory;
    }

    @PostMapping("/conversions")
    public String doConversion(@Valid @RequestBody ConversionRequest request) {
        ConversionService conversionService = conversionFactory.process(request.getFrom(), request.getTo());
        return conversionService.convert(request.getNumber());
    }

}
