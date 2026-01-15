package org.portfolio.asset.core;

import org.junit.jupiter.api.Test;
import org.portfolio.asset.unit.Currency;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValuableAssetTest {

    @Test
    void shouldCalculateProfitAsCurrentMinusPurchase() {
        ValuableAsset asset = new ValuableAsset() {

            @Override
            public Money purchaseValue() {
                return new Money(100, Currency.PLN);
            }

            @Override
            public Money currentValue() {
                return new Money(130, Currency.PLN);
            }

            @Override
            public AssetType type() {
                return AssetType.BOND;
            }

            @Override
            public String name() {
                return "Test Asset";
            }

            @Override
            public LocalDate purchaseDate() {
                return LocalDate.now();
            }
        };

        Money profit = asset.profit();

        assertEquals(30, profit.amount());
        assertEquals(Currency.PLN, profit.currency());
    }
}
