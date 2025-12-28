package org.example.asset;

import java.time.LocalDate;

public record Fund(String fundName,
                   LocalDate purchaseDate,
                   double units,
                   double purchaseUnitPrice,
                   double currencyUnitPrice
) implements ValuableAsset {

    @Override
    public String name() {
        return "Fund (" + fundName + ")";
    }

    @Override
    public double purchaseValue() {
        return units * purchaseUnitPrice;
    }

    @Override
    public double currentValue() {
        return units * currencyUnitPrice;
    }
}
