package org.portfolio.asset.impl;

public interface ValuableAsset extends Asset {

    double currentValue();

    default double profit() {
        return currentValue() - purchaseValue();
    }
}
