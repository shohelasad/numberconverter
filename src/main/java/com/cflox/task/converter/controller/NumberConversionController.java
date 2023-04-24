package com.cflox.task.converter.controller;

import com.cflox.task.converter.dto.ConversionRequest;
import com.cflox.task.converter.factory.ConversionFactory;
import com.cflox.task.converter.service.ConversionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class NumberConversionController {

    private ConversionService conversionService;

    @PostMapping("/conversions")
    public String getConversion(@RequestBody ConversionRequest request){
        conversionService = new ConversionFactory().process(request.getFrom(), request.getTo());
        return conversionService.convert(request.getNumber());
    }

}
