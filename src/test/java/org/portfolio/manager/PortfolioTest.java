package org.portfolio.manager;

import org.junit.jupiter.api.Test;
import org.portfolio.asset.core.Money;
import org.portfolio.asset.model.Bond;
import org.portfolio.asset.model.Cash;
import org.portfolio.asset.unit.Currency;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PortfolioTest {

    @Test
    void shouldSumPurchaseValuesByCurrency() {
        Portfolio portfolio = new Portfolio();

        portfolio.addAsset(new Cash(
                new Money(500, Currency.PLN),
                LocalDate.now()
        ));

        portfolio.addAsset(new Cash(
                new Money(300, Currency.PLN),
                LocalDate.now()
        ));

        Map<?, Double> totals = portfolio.totalPurchaseValueByCurrency();

        assertEquals(800, totals.get(Currency.PLN));
    }

    @Test
    void shouldCalculateProfitOnlyForValuableAssets() {
        Portfolio portfolio = new Portfolio();

        portfolio.addAsset(new Bond(
                "Bond",
                new Money(1_000, Currency.PLN),
                LocalDate.now().minusYears(1),
                10,
                12
        ));

        portfolio.addAsset(new Cash(
                new Money(500, Currency.PLN),
                LocalDate.now()
        ));

        Map<?, Double> profits = portfolio.totalProfitByCurrency();

        assertEquals(100, profits.get(Currency.PLN), 0.01);
    }
}
