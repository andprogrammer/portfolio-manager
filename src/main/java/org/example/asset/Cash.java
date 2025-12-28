package org.example.asset;

import java.time.LocalDate;

public record Cash(String currency,
                   LocalDate purchaseDate,
                   double amount
) implements Asset {

    @Override
    public String name() {
        return "Cash(" + currency + ")";
    }
}
