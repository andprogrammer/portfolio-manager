package org.example.asset;

import java.time.LocalDate;

public record Stock(String stockName,
                    LocalDate purchaseDate,
                    int quantity,
                    double purchasePrice,
                    double currencyPrice
) implements ValuableAsset {

    @Override
    public String name() {
        return "Stock (" + stockName + ")";
    }

    @Override
    public double purchaseValue() {
        return quantity * purchasePrice;
    }

    @Override
    public double currentValue() {
        return quantity * purchasePrice;
    }
}
