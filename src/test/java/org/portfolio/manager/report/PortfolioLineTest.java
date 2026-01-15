package org.portfolio.manager.report;

import org.junit.jupiter.api.Test;
import org.portfolio.asset.core.Money;
import org.portfolio.asset.model.SavingsAccount;
import org.portfolio.asset.unit.Currency;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class PortfolioLineTest {

    @Test
    void shouldCreateLineWithProfitForValuableAsset() {
        SavingsAccount account = new SavingsAccount(
                "My savings",
                "Bank",
                new Money(1000, Currency.EUR),
                LocalDate.now().minusYears(1),
                10
        );

        PortfolioLine line = PortfolioLine.from(account);

        assertThat(line.assetType()).isEqualTo("Savings Account");
        assertThat(line.name()).isEqualTo("My savings");
        assertThat(line.purchaseValue().amount()).isEqualTo(1000);
        assertThat(line.profit()).isNotNull();
    }
}
