package com.cflox.task.converter;

import com.cflox.task.converter.controller.NumberConversionController;
import com.cflox.task.converter.dto.ConversionRequest;
import com.cflox.task.converter.enums.ConversionType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(NumberConversionController.class)
public class NumberConversionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenValidConversionRequest_whenPostRequestWithBinaryToRoman_thenStatus200() throws Exception {
        // given
        ConversionRequest request = new ConversionRequest(ConversionType.BINARY, ConversionType.ROMAN, "101010");
        // when
        MvcResult mvcResult = mockMvc.perform(post("/api/v1/conversions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isOk())
                .andReturn();

        // then
        assertEquals("XLII", mvcResult.getResponse().getContentAsString());
    }

}
