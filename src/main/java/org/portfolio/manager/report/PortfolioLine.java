package org.portfolio.manager.report;

import org.portfolio.asset.core.Asset;
import org.portfolio.asset.core.Money;
import org.portfolio.asset.core.ValuableAsset;

import java.time.LocalDate;

public record PortfolioLine(
        String assetType,
        String name,
        LocalDate purchaseDate,
        Money purchaseValue,
        Money profit
) {

    public static PortfolioLine from(Asset asset) {
        Money profit = (asset instanceof ValuableAsset valuableAsset)
                ? valuableAsset.profit()
                : null;

        return new PortfolioLine(
                asset.type().getDisplayName(),
                asset.name(),
                asset.purchaseDate(),
                asset.purchaseValue(),
                profit
        );
    }
}
