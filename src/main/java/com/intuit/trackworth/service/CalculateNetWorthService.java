package com.intuit.trackworth.service;

import com.intuit.trackworth.datamodel.AssetAndLiabilityDataModelRequest;
import com.intuit.trackworth.datamodel.AssetAndLiabilityDataModelResponse;
import com.intuit.trackworth.exception.NegativeNumberFoundException;
import com.intuit.trackworth.utils.Validator;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class CalculateNetWorthService {
    public AssetAndLiabilityDataModelResponse calculateNetWorth(AssetAndLiabilityDataModelRequest request) throws NegativeNumberFoundException {
        if ((request.getAssets() != null && Validator.hasNegativeValue(request.getAssets()))
                || (request.getLiabilities() != null && Validator.hasNegativeValue(request.getLiabilities()))) {
            throw new NegativeNumberFoundException();
        }

        BigDecimal totalAssetValue = BigDecimal.ZERO;
        BigDecimal totalLiabilityValue = BigDecimal.ZERO;

        if (request.getAssets() != null) {
            totalAssetValue = Arrays.stream(request.getAssets()).reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        if (request.getLiabilities() != null) {
            totalLiabilityValue = Arrays.stream(request.getLiabilities()).reduce(BigDecimal.ZERO, BigDecimal::add);
        }


        BigDecimal totalWorth = totalAssetValue.subtract(totalLiabilityValue);

        return new AssetAndLiabilityDataModelResponse(totalAssetValue, totalLiabilityValue, totalWorth);
    }
}
