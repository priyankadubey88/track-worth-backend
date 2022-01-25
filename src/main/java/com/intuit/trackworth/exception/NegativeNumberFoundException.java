package com.intuit.trackworth.exception;

import java.math.BigDecimal;

public class NegativeNumberFoundException extends Exception{
    public NegativeNumberFoundException() {
        super("Negative value is not accepted");
    }

}
