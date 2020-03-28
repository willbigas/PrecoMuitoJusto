package br.com.willbigas.util;

import java.text.NumberFormat;

public class DecimalFormat {

    public static String deDecimalParaString(String decimal) {
        return NumberFormat.getCurrencyInstance().format(decimal.toString());

    }

    public static String deDecimalParaString(Double decimal) {
        return NumberFormat.getCurrencyInstance().format(decimal);
    }

    public static String deDecimalParaString(Float decimal) {
        return NumberFormat.getCurrencyInstance().format(decimal);
    }
}
