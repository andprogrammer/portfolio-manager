package org.portfolio.asset.Impl;

public interface ValuableAsset extends Asset {

    double currentValue();

    default double profit() {
        return currentValue() - purchaseValue();
    }
}
