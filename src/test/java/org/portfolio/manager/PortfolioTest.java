package org.portfolio.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.portfolio.asset.core.Asset;
import org.portfolio.asset.core.Money;
import org.portfolio.asset.core.ValuableAsset;
import org.portfolio.asset.unit.Currency;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PortfolioTest {

    private Portfolio portfolio;

    @BeforeEach
    void setUp() {
        portfolio = new Portfolio();
    }

    @Test
    void shouldAddAsset() {
        Asset asset = mock(Asset.class);

        portfolio.addAsset(asset);

        assertEquals(1, portfolio.findAll().size());
    }

    @Test
    void shouldIgnoreNullAsset() {
        portfolio.addAsset(null);

        assertTrue(portfolio.findAll().isEmpty());
    }

    @Test
    void shouldCalculateTotalPurchaseValueByCurrency() {
        Asset asset1 = mock(Asset.class);
        when(asset1.purchaseValue()).thenReturn(new Money(100, Currency.PLN));

        Asset asset2 = mock(Asset.class);
        when(asset2.purchaseValue()).thenReturn(new Money(50, Currency.PLN));

        Asset asset3 = mock(Asset.class);
        when(asset3.purchaseValue()).thenReturn(new Money(200, Currency.EUR));

        portfolio.addAsset(asset1);
        portfolio.addAsset(asset2);
        portfolio.addAsset(asset3);

        Map<?, Double> totals = portfolio.totalPurchaseValueByCurrency();

        assertEquals(150, totals.get(Currency.PLN));
        assertEquals(200, totals.get(Currency.EUR));
    }

    @Test
    void shouldCalculateTotalProfitOnlyForValuableAssets() {
        ValuableAsset valuableAsset = mock(ValuableAsset.class);
        when(valuableAsset.profit()).thenReturn(new Money(30, Currency.PLN));

        Asset nonValuableAsset = mock(Asset.class);

        portfolio.addAsset(valuableAsset);
        portfolio.addAsset(nonValuableAsset);

        Map<?, Double> profits = portfolio.totalProfitByCurrency();

        assertEquals(1, profits.size());
        assertEquals(30, profits.get(Currency.PLN));
    }
}
