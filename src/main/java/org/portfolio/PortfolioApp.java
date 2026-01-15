package org.portfolio;

import org.portfolio.manager.Portfolio;
import org.portfolio.manager.report.ConsolePortfolioReporter;

public final class PortfolioApp {

    private PortfolioApp() {}

    public static void run() {
        Portfolio portfolio = DemoPortfolio.create();
        ConsolePortfolioReporter.print(portfolio.reportLines());
    }

    public static void main(String[] args) {
        run();
    }
}
