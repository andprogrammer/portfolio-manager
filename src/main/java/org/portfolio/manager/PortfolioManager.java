package org.portfolio.manager;

import org.portfolio.asset.Money;
import org.portfolio.asset.impl.Asset;
import org.portfolio.asset.monetaryUnit.MonetaryUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PortfolioManager {

    private final List<Asset> assets = new ArrayList<>();

    public void addAsset(Asset asset) {
        if (asset != null) {
            assets.add(asset);
        }
    }

    public Map<MonetaryUnit, Double> totalPurchaseValueByCurrency() {
        return assets.stream()
                .map(Asset::purchaseValue)
                .collect(Collectors.groupingBy(
                        Money::currency,
                        Collectors.summingDouble(Money::amount)
                ));
    }

    public Map<MonetaryUnit, Double> totalProfitByCurrency() {
        return assets.stream()
                .map(Asset::profit)
                .collect(Collectors.groupingBy(
                        Money::currency,
                        Collectors.summingDouble(Money::amount)
                ));
    }

    public List<Asset> findAll() {
        return List.copyOf(assets);
    }

    public void report() {
        assets.forEach(asset -> {
            System.out.printf(asset.name(), asset.purchaseDate(), asset.purchaseValue(), asset.profit());
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
