package org.example.manager;

import org.example.asset.Bond;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
                10000,
                LocalDate.of(2025, 2, 5),
                5.75,
                36);
        manager.addAsset(bond);
        assertEquals(bond.name(), manager.getAssets().getFirst().name());
        assertEquals(bond.purchaseDate(), manager.getAssets().getFirst().purchaseDate());
//        assertEquals(bond.interestRate(), manager.getAssets().getFirst().interestRate());
//        assertEquals(bond.durationMonths(), manager.getAssets().getFirst().durationMonths());
    }
}
