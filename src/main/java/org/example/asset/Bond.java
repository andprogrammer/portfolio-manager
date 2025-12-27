package org.example.asset;

import java.time.LocalDate;

public record Bond(String name,
                   LocalDate purchaseDate,
                   double interestRate,
                   int durationMonths
) implements Asset {
}
