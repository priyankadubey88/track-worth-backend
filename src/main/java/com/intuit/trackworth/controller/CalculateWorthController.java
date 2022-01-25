package com.intuit.trackworth.controller;

import com.intuit.trackworth.datamodel.AssetAndLiabilityDataModelRequest;
import com.intuit.trackworth.datamodel.AssetAndLiabilityDataModelResponse;
import com.intuit.trackworth.exception.NegativeNumberFoundException;
import com.intuit.trackworth.service.CalculateNetWorthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/worth")
public class CalculateWorthController {
    private final CalculateNetWorthService calculateNetWorthService;

    @Autowired
    public CalculateWorthController(CalculateNetWorthService calculateNetWorthService) {
        this.calculateNetWorthService = calculateNetWorthService;
    }

    @PostMapping("/asset-and-liability")
    public AssetAndLiabilityDataModelResponse calculateAssetAndLiability(@RequestBody AssetAndLiabilityDataModelRequest request) throws NegativeNumberFoundException {
        return calculateNetWorthService.calculateNetWorth(request);
    }
}
