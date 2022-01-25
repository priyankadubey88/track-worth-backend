package com.intuit.trackworth.service;

import com.intuit.trackworth.datamodel.AssetAndLiabilityDataModelRequest;
import com.intuit.trackworth.datamodel.AssetAndLiabilityDataModelResponse;
import com.intuit.trackworth.exception.NegativeNumberFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculateNetWorthServiceTest {
    @Autowired
    CalculateNetWorthService service;

    @Test
    void givenAssetAndLiabilityThenReturnTotal() throws NegativeNumberFoundException {
        AssetAndLiabilityDataModelRequest request = new AssetAndLiabilityDataModelRequest();
        request.setAssets(new BigDecimal[]{BigDecimal.valueOf(100.55), BigDecimal.valueOf(555L)});
        request.setLiabilities(new BigDecimal[]{BigDecimal.valueOf(50L), BigDecimal.valueOf(40L)});

        AssetAndLiabilityDataModelResponse response = service.calculateNetWorth(request);
        assertEquals(BigDecimal.valueOf(655.55), response.getTotalAssetValue());
        assertEquals(BigDecimal.valueOf(90L), response.getTotalLiabilityValue());
        assertEquals(BigDecimal.valueOf(565.55), response.getNetWorthValue());
    }

    @Test
    void givenAssetThenReturnTotal() throws NegativeNumberFoundException {
        AssetAndLiabilityDataModelRequest request = new AssetAndLiabilityDataModelRequest();
        request.setAssets(new BigDecimal[]{BigDecimal.valueOf(100.55), BigDecimal.valueOf(555L)});

        AssetAndLiabilityDataModelResponse response = service.calculateNetWorth(request);
        assertEquals(BigDecimal.valueOf(655.55), response.getTotalAssetValue());
        assertEquals(BigDecimal.ZERO, response.getTotalLiabilityValue());
        assertEquals(BigDecimal.valueOf(655.55), response.getNetWorthValue());
    }

    @Test
    void givenLiabilityThenReturnTotal() throws NegativeNumberFoundException {
        AssetAndLiabilityDataModelRequest request = new AssetAndLiabilityDataModelRequest();
        request.setLiabilities(new BigDecimal[]{BigDecimal.valueOf(50L), BigDecimal.valueOf(40L)});

        AssetAndLiabilityDataModelResponse response = service.calculateNetWorth(request);
        assertEquals(BigDecimal.ZERO, response.getTotalAssetValue());
        assertEquals(BigDecimal.valueOf(90L), response.getTotalLiabilityValue());
        assertEquals(BigDecimal.valueOf(-90L), response.getNetWorthValue());
    }

    @Test
    void givenNothingThenReturnTotal() throws NegativeNumberFoundException {
        AssetAndLiabilityDataModelRequest request = new AssetAndLiabilityDataModelRequest();

        AssetAndLiabilityDataModelResponse response = service.calculateNetWorth(request);
        assertEquals(BigDecimal.ZERO, response.getTotalAssetValue());
        assertEquals(BigDecimal.ZERO, response.getTotalLiabilityValue());
        assertEquals(BigDecimal.ZERO, response.getNetWorthValue());
    }

    @Test
    void givenNegativeAssetThenReturnException() {
        AssetAndLiabilityDataModelRequest request = new AssetAndLiabilityDataModelRequest();
        request.setAssets(new BigDecimal[]{BigDecimal.valueOf(-100.55), BigDecimal.valueOf(555L)});
        request.setLiabilities(new BigDecimal[]{BigDecimal.valueOf(50L), BigDecimal.valueOf(40L)});
        assertThrows(NegativeNumberFoundException.class, () ->
                service.calculateNetWorth(request)
        );
    }

    @Test
    void givenNegativeLiabilityThenReturnException() {
        AssetAndLiabilityDataModelRequest request = new AssetAndLiabilityDataModelRequest();
        request.setAssets(new BigDecimal[]{BigDecimal.valueOf(100.55), BigDecimal.valueOf(555L)});
        request.setLiabilities(new BigDecimal[]{BigDecimal.valueOf(-50L), BigDecimal.valueOf(40L)});
        assertThrows(NegativeNumberFoundException.class, () ->
                service.calculateNetWorth(request)
        );
    }


}