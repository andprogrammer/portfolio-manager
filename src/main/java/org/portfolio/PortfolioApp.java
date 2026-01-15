package org.portfolio;

import org.portfolio.portfolio.Portfolio;

public final class PortfolioApp {

    private PortfolioApp() {}

    public static void run() {
        Portfolio portfolio = DemoPortfolio.create();

        // show detailed report
        portfolio.report();
    }

    public static void main(String[] args) {
        run();
    }
}
