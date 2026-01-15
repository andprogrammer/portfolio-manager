package org.portfolio;

import org.portfolio.asset.core.Money;
import org.portfolio.asset.model.*;
import org.portfolio.asset.unit.CryptoCurrency;
import org.portfolio.asset.unit.Currency;
import org.portfolio.manager.PortfolioManager;

import java.time.LocalDate;

public final class PortfolioService {

    private PortfolioService() {
    }

    public static void run() {
        PortfolioManager manager = new PortfolioManager();

        manager.addAsset(new Bond(
                "Obligacja 3-letnie TOS",
                new Money(10_000, Currency.PLN),
                LocalDate.of(2025, 2, 5),
                5.75,
                36
        ));

        manager.addAsset(new Cash(
                new Money(800, Currency.PLN),
                LocalDate.of(2025, 2, 5)
        ));

        manager.addAsset(new Crypto(
                CryptoCurrency.BTC,
                Currency.EUR,
                LocalDate.of(2024, 3, 2),
                0.3,
                39_000
        ));

        manager.addAsset(new Deposit(
                "Lokata Mobilna",
                new Money(12_000, Currency.PLN),
                LocalDate.of(2025, 3, 6),
                4.5,
                6
        ));

        manager.addAsset(new Fund(
                "PKO Technologii i Innowacji Globalny",
                LocalDate.of(2025, 3, 6),
                Currency.PLN,
                85,
                250
        ));

        manager.addAsset(new Metal(
                org.portfolio.asset.unit.Metal.GOLD,
                LocalDate.of(2024, 3, 8),
                Currency.USD,
                2,
                31.1,
                3_500
        ));

        manager.addAsset(new SavingsAccount(
                "Oko Bonus",
                "ING",
                new Money(15_000, Currency.PLN),
                LocalDate.of(2025, 2, 7),
                5.2
        ));

        manager.addAsset(new Stock(
                "PKN Orlen",
                Currency.PLN,
                LocalDate.of(2025, 2, 7),
                4,
                65.3
        ));

        manager.report();
    }
}
