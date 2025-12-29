package org.portfolio.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.portfolio.asset.Bond;
import org.portfolio.asset.Money;
import org.portfolio.asset.monetaryUnit.Currency;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PortfolioManagerTest {

    PortfolioManager manager;

    @BeforeEach
    void setUp() {
        manager = new PortfolioManager();
    }

    @Test
    void addAsset() {
        Bond bond = new Bond("Obligacja Skarbowa",
                new Money(10000, Currency.PLN),
                LocalDate.of(2025, 2, 5),
                5.75,
                36);
        manager.addAsset(bond);
        assertEquals(bond.name(), manager.findAll().getFirst().name());
        assertEquals(bond.purchaseDate(), manager.findAll().getFirst().purchaseDate());
//        assertEquals(bond.annualInterestRate(), manager.findAll().getFirst().annualInterestRate());
//        assertEquals(bond.durationMonths(), manager.findAll().getFirst().durationMonths());
    }
}
