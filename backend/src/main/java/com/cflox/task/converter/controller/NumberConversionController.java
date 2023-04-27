package com.cflox.task.converter.controller;

import com.cflox.task.converter.dto.ConversionRequest;
import com.cflox.task.converter.exception.ResourceNotFoundException;
import com.cflox.task.converter.factory.ConversionFactory;
import com.cflox.task.converter.service.ConversionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class NumberConversionController {

    private ConversionService conversionService;

    @PostMapping("/conversions")
    public String doConversion(@Valid @RequestBody ConversionRequest request) {
        conversionService = new ConversionFactory().process(request.getFrom(), request.getTo());
        if(conversionService == null) {
            throw new ResourceNotFoundException("Conversion not found for " + request.getFrom() + " -> " + request.getTo());
        }

        return conversionService.convert(request.getNumber());
    }

}
