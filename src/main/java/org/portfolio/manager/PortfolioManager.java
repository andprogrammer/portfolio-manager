package org.portfolio.manager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.portfolio.asset.Money;
import org.portfolio.asset.impl.Asset;
import org.portfolio.asset.monetaryUnit.MonetaryUnit;

import java.io.File;
import java.io.IOException;
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
        assets.forEach(asset -> System.out.printf(
                "%s | %s | %s | %.2f %s | %.2f %s%n",
                asset.type().getDisplayName(),
                asset.name(),
                asset.purchaseDate(),
                asset.purchaseValue().amount(),
                asset.purchaseValue().currency(),
                asset.profit().amount(),
                asset.profit().currency()
        ));
    }

    public void showAssets() {
        if (assets.isEmpty()) {
            System.out.println("No assets");
        } else {
            assets.forEach(System.out::println);
        }
    }

    public void serializeAssets() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.findAndRegisterModules();

        // write
        try {
            mapper.writeValue(new File("portfolio.json"), assets);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // read
        try {
            List<Asset> loadedAssets = mapper.readValue(
                    new File("portfolio.json"),
                    new TypeReference<List<Asset>>() {}
            );

            assets.clear();
            assets.addAll(loadedAssets);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
