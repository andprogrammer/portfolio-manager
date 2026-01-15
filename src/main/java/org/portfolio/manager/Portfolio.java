package org.portfolio.manager;

import org.portfolio.asset.core.Asset;
import org.portfolio.asset.core.Money;
import org.portfolio.asset.core.ValuableAsset;
import org.portfolio.asset.unit.MonetaryUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Portfolio {

    private final List<Asset> assets = new ArrayList<>();

    public void addAsset(Asset asset) {
        if (asset != null) {
            assets.add(asset);
        }
    }

    /**
     * Sum of purchase values grouped by currency.
     * Applies to ALL assets.
     */
    public Map<MonetaryUnit, Double> totalPurchaseValueByCurrency() {
        return assets.stream()
                .map(Asset::purchaseValue)
                .collect(Collectors.groupingBy(
                        Money::currency,
                        Collectors.summingDouble(Money::amount)
                ));
    }

    /**
     * Sum of profits grouped by currency.
     * Applies ONLY to valuable assets.
     */
    public Map<MonetaryUnit, Double> totalProfitByCurrency() {
        return assets.stream()
                .filter(ValuableAsset.class::isInstance)
                .map(ValuableAsset.class::cast)
                .map(ValuableAsset::profit)
                .collect(Collectors.groupingBy(
                        Money::currency,
                        Collectors.summingDouble(Money::amount)
                ));
    }

    public List<Asset> findAll() {
        return List.copyOf(assets);
    }

    /**
     * Detailed report.
     * Profit shown only where applicable.
     */
    public void report() {
        // Print header with extended Name column
        System.out.printf(
                "%-20s | %-50s | %-12s | %-12s | %-12s | %-12s%n",
                "Asset Type", "Name", "Purchase Date", "Purchase Value", "Currency", "Profit"
        );
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        // Print each asset
        assets.forEach(asset -> {
            System.out.printf(
                    "%-20s | %-50s | %-12s | %12.2f | %-12s",
                    asset.type().getDisplayName(),
                    asset.name(),
                    asset.purchaseDate(),
                    asset.purchaseValue().amount(),
                    asset.purchaseValue().currency()
            );

            if (asset instanceof ValuableAsset valuableAsset) {
                Money profit = valuableAsset.profit();
                System.out.printf(" | %12.2f %s", profit.amount(), profit.currency());
            } else {
                System.out.print(" | N/A");
            }

            System.out.println();
        });
    }

    public void showAssets() {
        if (assets.isEmpty()) {
            System.out.println("No assets");
        } else {
            assets.forEach(System.out::println);
        }
    }
}
