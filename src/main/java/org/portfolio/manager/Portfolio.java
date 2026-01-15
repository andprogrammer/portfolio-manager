package org.portfolio.manager;

import org.portfolio.asset.core.Asset;
import org.portfolio.asset.core.Money;
import org.portfolio.asset.core.ValuableAsset;
import org.portfolio.asset.unit.MonetaryUnit;
import org.portfolio.manager.report.PortfolioLine;

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

    public List<Asset> findAll() {
        return List.copyOf(assets);
    }

    public List<PortfolioLine> reportLines() {
        return assets.stream()
                .map(PortfolioLine::from)
                .toList();
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
                .filter(ValuableAsset.class::isInstance)
                .map(ValuableAsset.class::cast)
                .map(ValuableAsset::profit)
                .collect(Collectors.groupingBy(
                        Money::currency,
                        Collectors.summingDouble(Money::amount)
                ));
    }
}
