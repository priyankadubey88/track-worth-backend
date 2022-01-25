package com.intuit.trackworth.datamodel;

import org.springframework.boot.jackson.JsonComponent;

import java.math.BigDecimal;

@JsonComponent
public class AssetAndLiabilityDataModelRequest {
    private BigDecimal[] assets;
    private BigDecimal[] liabilities;

    public BigDecimal[] getAssets() {
        return assets;
    }

    public void setAssets(BigDecimal[] assets) {
        this.assets = assets;
    }

    public BigDecimal[] getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(BigDecimal[] liabilities) {
        this.liabilities = liabilities;
    }
}
