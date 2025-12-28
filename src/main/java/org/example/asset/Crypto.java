package org.example.asset;

import java.time.LocalDate;

public record Crypto(String cryptoName,
                     LocalDate purchaseDate,
                     double amount) implements Asset {

    @Override
    public String name() {
        return "Crypto (" + cryptoName + ")";
    }
}
