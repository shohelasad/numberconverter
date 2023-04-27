package com.cflox.task.converter;

import com.cflox.task.converter.controller.NumberConversionController;
import com.cflox.task.converter.dto.ConversionRequest;
import com.cflox.task.converter.enums.ConversionType;
import com.cflox.task.converter.factory.ConversionFactory;
import com.cflox.task.converter.service.ConversionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(NumberConversionController.class)
public class NumberConversionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConversionFactory conversionFactory;

    @Test
    public void givenValidConversionRequest_whenPostRequestWithDecimalToRoman_thenStatus200() throws Exception {
        // given
        String expected = "CMXXXI";
        ConversionService mockConversionService = mock(ConversionService.class);
        when(mockConversionService.convert("931")).thenReturn(expected);
        when(conversionFactory.process(ConversionType.DECIMAL.name(), ConversionType.ROMAN.name())).thenReturn(mockConversionService);

        ConversionRequest request = new ConversionRequest(ConversionType.DECIMAL.name(), ConversionType.ROMAN.name(), "931");

        // when
        MvcResult mvcResult = mockMvc.perform(post("/api/v1/conversions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk())
                .andReturn();

        // then
        String actual = mvcResult.getResponse().getContentAsString();
        assertEquals(expected, actual);
    }

    @Test
    public void givenValidConversionRequest_whenPostRequestWithBinaryToRoman_thenStatus200() throws Exception {
        // given
        String expected = "XLII";
        ConversionService mockConversionService = mock(ConversionService.class);
        when(mockConversionService.convert("101010")).thenReturn(expected);
        when(conversionFactory.process(ConversionType.BINARY.name(), ConversionType.ROMAN.name())).thenReturn(mockConversionService);

        ConversionRequest request = new ConversionRequest(ConversionType.BINARY.name(), ConversionType.ROMAN.name(), "101010");

        // when
        MvcResult mvcResult = mockMvc.perform(post("/api/v1/conversions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk())
                .andReturn();

        // then
        String actual = mvcResult.getResponse().getContentAsString();
        assertEquals(expected, actual);
    }

}
