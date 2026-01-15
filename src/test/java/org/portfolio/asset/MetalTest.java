package org.portfolio.asset;

import org.junit.jupiter.api.Test;
import org.portfolio.asset.core.Money;
import org.portfolio.asset.unit.Currency;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void shouldAddMoneyWithSameCurrency() {
        Money m1 = new Money(100, Currency.PLN);
        Money m2 = new Money(50, Currency.PLN);

        Money result = m1.add(m2);

        assertEquals(150, result.amount());
        assertEquals(Currency.PLN, result.currency());
    }

    @Test
    void shouldThrowWhenAddingDifferentCurrencies() {
        Money m1 = new Money(100, Currency.PLN);
        Money m2 = new Money(50, Currency.EUR);

        assertThrows(IllegalArgumentException.class, () -> m1.add(m2));
    }

    @Test
    void shouldSubtractMoneyWithSameCurrency() {
        Money m1 = new Money(100, Currency.USD);
        Money m2 = new Money(40, Currency.USD);

        Money result = m1.subtract(m2);

        assertEquals(60, result.amount());
    }

    @Test
    void shouldAllowNegativeAmounts() {
        Money loss = new Money(-100, Currency.PLN);
        assertEquals(-100, loss.amount());
    }

    @Test
    void shouldRejectNaN() {
        assertThrows(IllegalArgumentException.class,
                () -> new Money(Double.NaN, Currency.PLN));
    }

    @Test
    void shouldRejectInfinity() {
        assertThrows(IllegalArgumentException.class,
                () -> new Money(Double.POSITIVE_INFINITY, Currency.PLN));
    }

    @Test
    void shouldRejectNullCurrency() {
        assertThrows(NullPointerException.class,
                () -> new Money(100, null));
    }
}
