package org.example;

import org.example.asset.*;
import org.example.asset.monetaryUnit.CryptoCurrency;
import org.example.asset.monetaryUnit.Currency;
import org.example.manager.PortfolioManager;

import java.time.LocalDate;

public class PortfolioService {
    public static void run() {
        PortfolioManager manager = new PortfolioManager();

        manager.addAsset(new Bond("Obligacja 3-letnie TOS",
                LocalDate.of(2025, 2, 5),
                10000,
                5.75,
                36));

        manager.addAsset(new Cash(Currency.PLN,
                LocalDate.of(2025, 2, 5),
                999));

        manager.addAsset(new Crypto(CryptoCurrency.BTC,
                LocalDate.of(2024, 3, 2),
                0.3));

        manager.addAsset(new Deposit("Lokata Mobilna",
                LocalDate.of(2025, 3, 6),
                4.5,
                6));

        manager.addAsset(new Fund("PKO Technologii i Innowacji Globalny",
                LocalDate.of(2025, 3, 6),
                85,
                250));

        manager.addAsset(new Metal(org.example.asset.monetaryUnit.Metal.GOLD,
                LocalDate.of(2024, 3, 8),
                31.1,
                3500));

        manager.addAsset(new SavingsAccount("Oko Bonus",
                "ING",
                LocalDate.of(2025, 2, 7),
                15000,
                5.2));

        manager.addAsset(new Stock("PKN Orlen",
                LocalDate.of(2025, 2, 7),
                4,
                65.3));
    }
}
