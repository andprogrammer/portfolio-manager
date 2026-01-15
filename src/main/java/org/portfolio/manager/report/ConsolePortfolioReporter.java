package org.portfolio.manager.report;

import org.portfolio.asset.core.Money;

import java.util.List;

public final class ConsolePortfolioReporter {

    private ConsolePortfolioReporter() {
    }

    public static void print(List<PortfolioLine> lines) {
        printHeader();

        lines.forEach(line -> {
            System.out.printf(
                    "%-20s | %-50s | %-12s | %12.2f | %-12s | %s%n",
                    line.assetType(),
                    line.name(),
                    line.purchaseDate(),
                    line.purchaseValue().amount(),
                    line.purchaseValue().currency(),
                    formatProfit(line.profit())
            );
        });
    }

    private static void printHeader() {
        System.out.printf(
                "%-20s | %-50s | %-12s | %-12s | %-12s | %-12s%n",
                "Asset Type", "Name", "Purchase Date",
                "Purchase Value", "Currency", "Profit"
        );
        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }

    private static String formatProfit(Money profit) {
        if (profit == null) {
            return "N/A";
        }
        return String.format("%.2f %s", profit.amount(), profit.currency());
    }
}
