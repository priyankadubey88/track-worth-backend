package com.intuit.trackworth.utils;

import java.math.BigDecimal;
import java.util.Arrays;

public class Validator {

    public static boolean hasNegativeValue(BigDecimal[] input){
        return Arrays.stream(input).anyMatch(i->i.compareTo(BigDecimal.ZERO)<0);
    }
}
