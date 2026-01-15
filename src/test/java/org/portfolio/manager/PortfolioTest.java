package org.portfolio.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.portfolio.asset.model.Bond;
import org.portfolio.asset.core.Money;
import org.portfolio.asset.unit.Currency;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PortfolioTest {

    Portfolio portfolio;

    @BeforeEach
    void setUp() {
        portfolio = new Portfolio();
    }

    @Test
    void addAsset() {
        Bond bond = new Bond("Obligacja Skarbowa",
                new Money(10000, Currency.PLN),
                LocalDate.of(2025, 2, 5),
                5.75,
                36);
        portfolio.addAsset(bond);
        assertEquals(bond.name(), portfolio.findAll().getFirst().name());
        assertEquals(bond.purchaseDate(), portfolio.findAll().getFirst().purchaseDate());
    }
}
