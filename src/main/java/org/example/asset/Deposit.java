package org.example.asset;

import java.time.LocalDate;

public record Deposit(String name,
                      LocalDate purchaseDate,
                      double interestRate,
                      int durationMonths
) implements Asset {
}
