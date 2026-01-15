package org.portfolio.asset.core;

import org.junit.jupiter.api.Test;
import org.portfolio.asset.unit.Currency;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void shouldCreateMoneyWithNegativeAmount() {
        Money loss = new Money(-100, Currency.PLN);
        assertEquals(-100, loss.amount());
    }

    @Test
    void shouldRejectNullCurrency() {
        assertThrows(NullPointerException.class,
                () -> new Money(100, null));
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
    void shouldAddMoneyWithSameCurrency() {
        Money a = new Money(100, Currency.PLN);
        Money b = new Money(50, Currency.PLN);

        Money result = a.add(b);

        assertEquals(150, result.amount());
        assertEquals(Currency.PLN, result.currency());
    }

    @Test
    void shouldThrowWhenAddingDifferentCurrencies() {
        Money pln = new Money(100, Currency.PLN);
        Money eur = new Money(10, Currency.EUR);

        assertThrows(IllegalArgumentException.class,
                () -> pln.add(eur));
    }

    @Test
    void shouldSubtractMoney() {
        Money a = new Money(100, Currency.PLN);
        Money b = new Money(30, Currency.PLN);

        Money result = a.subtract(b);

        assertEquals(70, result.amount());
    }
}
