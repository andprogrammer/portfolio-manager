package org.example.asset;

public interface ValuableAsset extends Asset {

    double purchaseValue();
    double currentValue();

    default double profit() {
        return currentValue() - purchaseValue();
    }
}
