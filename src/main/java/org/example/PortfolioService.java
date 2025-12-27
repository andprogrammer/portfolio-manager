package org.example;

import org.example.asset.Bond;
import org.example.asset.Deposit;
import org.example.manager.PortfolioManager;

import java.time.LocalDate;

public class PortfolioService {
    public static void run() {
        PortfolioManager manager = new PortfolioManager();

        manager.addAsset(new Bond("Obligacja Skarbowa",
                LocalDate.of(2025, 2, 5),
                5.75,
                36));

        manager.addAsset(new Deposit("Lokata Bankowa",
                LocalDate.of(2025, 3, 6),
                4.5,
                6));
    }
}
