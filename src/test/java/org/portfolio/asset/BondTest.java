package org.portfolio.asset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.portfolio.asset.model.Bond;
import org.portfolio.asset.model.Money;
import org.portfolio.asset.unit.Currency;

import java.time.LocalDate;

class BondTest {

    Bond bond;

    @BeforeEach
    void setUp() {
        bond = new Bond("Obligacja Skarbowa",
                new Money(10000, Currency.PLN),
                LocalDate.of(2025, 2, 5),
                5.75,
                36);
    }

    @Test
    void name() {
        Assertions.assertEquals("Obligacja Skarbowa", bond.name());
    }

    @Test
    void purchaseDate() {
        Assertions.assertEquals(LocalDate.of(2025, 2, 5), bond.purchaseDate());
    }

    @Test
    void interestRate() {
        Assertions.assertEquals(5.75, bond.annualInterestRate());
    }

    @Test
    void durationMonths() {
        Assertions.assertEquals(36, bond.durationMonths());
    }
}