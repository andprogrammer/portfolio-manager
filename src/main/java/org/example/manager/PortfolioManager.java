package org.example.manager;

import org.example.asset.Impl.Asset;

import java.util.ArrayList;
import java.util.List;

public class PortfolioManager {

    private final List<Asset> assets = new ArrayList<>();

    public void addAsset(Asset asset) {
        if (asset != null) {
            assets.add(asset);
        }
    }

    public List<Asset> getAssets() {
        return List.copyOf(assets);
    }

    public void showAssets() {
        if (assets.isEmpty()) {
            System.out.println("No assets");
        } else {
            assets.forEach(System.out::println);
        }
    }
}
