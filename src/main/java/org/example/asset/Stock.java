package org.example.asset;

import java.time.LocalDate;

public record Stock(String stockName,
                    LocalDate purchaseDate,
                    int quantity,
                    double purchasePrice
) implements Asset {

    @Override
    public AssetType type() {
        return AssetType.STOCK;
    }

    @Override
    public String name() {
        return stockName;
    }
}
