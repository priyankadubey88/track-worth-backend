package com.intuit.trackworth.datamodel;

import org.springframework.boot.jackson.JsonComponent;

import java.math.BigDecimal;

@JsonComponent
public class AssetAndLiabilityDataModelResponse {
    private BigDecimal totalAssetValue;
    private BigDecimal totalLiabilityValue;
    private BigDecimal netWorthValue;

    public AssetAndLiabilityDataModelResponse() {
    }

    public AssetAndLiabilityDataModelResponse(BigDecimal totalAssetValue,
                                              BigDecimal totalLiabilityValue,
                                              BigDecimal netWorthValue) {
        this.totalAssetValue = totalAssetValue;
        this.totalLiabilityValue = totalLiabilityValue;
        this.netWorthValue = netWorthValue;
    }

    public BigDecimal getTotalAssetValue() {
        return totalAssetValue;
    }

    public void setTotalAssetValue(BigDecimal totalAssetValue) {
        this.totalAssetValue = totalAssetValue;
    }

    public BigDecimal getTotalLiabilityValue() {
        return totalLiabilityValue;
    }

    public void setTotalLiabilityValue(BigDecimal totalLiabilityValue) {
        this.totalLiabilityValue = totalLiabilityValue;
    }

    public BigDecimal getNetWorthValue() {
        return netWorthValue;
    }

    public void setNetWorthValue(BigDecimal netWorthValue) {
        this.netWorthValue = netWorthValue;
    }
}
