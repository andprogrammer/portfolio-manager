package org.portfolio.asset;

import org.junit.jupiter.api.Test;
import org.portfolio.asset.core.Money;
import org.portfolio.asset.model.Bond;
import org.portfolio.asset.unit.Currency;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BondTest {

    @Test
    void shouldCalculateCurrentValueCorrectly() {
        Bond bond = new Bond(
                "Test Bond",
                new Money(10_000, Currency.PLN),
                LocalDate.of(2024, 1, 1),
                5.0,
                24
        );

        Money currentValue = bond.currentValue();

        // 2 years * 5% = 10%
        assertEquals(11_000, currentValue.amount(), 0.01);
        assertEquals(Currency.PLN, currentValue.currency());
    }

    @Test
    void shouldReturnCorrectMaturityDate() {
        Bond bond = new Bond(
                "Test Bond",
                new Money(1_000, Currency.PLN),
                LocalDate.of(2024, 1, 1),
                5.0,
                12
        );

        assertEquals(
                LocalDate.of(2025, 1, 1),
                bond.maturityDate()
        );
    }

    @Test
    void shouldDetectMaturedBond() {
        Bond bond = new Bond(
                "Old Bond",
                new Money(1_000, Currency.PLN),
                LocalDate.now().minusMonths(13),
                5.0,
                12
        );

        assertTrue(bond.isMatured());
    }
}
