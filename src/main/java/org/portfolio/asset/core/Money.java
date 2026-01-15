package org.portfolio.asset.core;

import org.portfolio.asset.unit.MonetaryUnit;

public record Money(double amount, MonetaryUnit currency) {

    public Money add(Money other) {
        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currencies must match to add");
        }
        return new Money(amount + other.amount, currency);
    }

    public Money subtract(Money other) {
        if (!currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currencies must match to subtract");
        }
        return new Money(amount - other.amount, currency);
    }
}
