package org.portfolio;

import org.portfolio.asset.*;
import org.portfolio.asset.monetaryUnit.CryptoCurrency;
import org.portfolio.asset.monetaryUnit.Currency;
import org.portfolio.manager.PortfolioManager;

import java.time.LocalDate;

public class PortfolioService {
    public static void run() {
        PortfolioManager manager = new PortfolioManager();

        manager.addAsset(new Bond("Obligacja 3-letnie TOS",
                10000,
                LocalDate.of(2025, 2, 5),
                5.75,
                36));

        manager.addAsset(new Cash(800,
                Currency.PLN,
                LocalDate.of(2025, 2, 5)));

        manager.addAsset(new Crypto(CryptoCurrency.BTC,
                Currency.EUR,
                LocalDate.of(2024, 3, 2),
                0.3,
                39000));

        manager.addAsset(new Deposit("Lokata Mobilna",
                12000,
                Currency.PLN,
                LocalDate.of(2025, 3, 6),
                4.5,
                6));

        manager.addAsset(new Fund("PKO Technologii i Innowacji Globalny",
                LocalDate.of(2025, 3, 6),
                85,
                250));

        manager.addAsset(new Metal(org.portfolio.asset.monetaryUnit.Metal.GOLD,
                LocalDate.of(2024, 3, 8),
                2,
                31.1,
                3500));

        manager.addAsset(new SavingsAccount("Oko Bonus",
                "ING",
                15000,
                Currency.PLN,
                LocalDate.of(2025, 2, 7),
                5.2));

        manager.addAsset(new Stock("PKN Orlen",
                Currency.PLN,
                LocalDate.of(2025, 2, 7),
                4,
                65.3));

        manager.report();
    }
}
