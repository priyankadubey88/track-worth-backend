package com.intuit.trackworth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.trackworth.datamodel.AssetAndLiabilityDataModelRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CalculateWorthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void calculateAssetAndLiability() throws Exception {
        AssetAndLiabilityDataModelRequest request = new AssetAndLiabilityDataModelRequest();
        request.setAssets(new BigDecimal[]{BigDecimal.valueOf(100L), BigDecimal.valueOf(555L)});
        request.setLiabilities(new BigDecimal[]{BigDecimal.valueOf(50L), BigDecimal.valueOf(40L)});

        mockMvc.perform(post("/worth/asset-and-liability")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.totalAssetValue", is(655)))
                .andExpect(jsonPath("$.totalLiabilityValue", is(90)))
                .andExpect(jsonPath("$.netWorthValue", is(565)));
    }
}