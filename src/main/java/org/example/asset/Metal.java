package org.example.asset;

import java.time.LocalDate;

public record Metal(String name,
                    LocalDate purchaseDate,
                    double weight,
                    double pricePerUnit
) implements Asset {
}
