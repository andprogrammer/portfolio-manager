package org.portfolio.asset.core;

public interface ValuableAsset extends Asset {

    Money currentValue();

    default Money profit() {
        return currentValue().subtract(purchaseValue());
    }
}
