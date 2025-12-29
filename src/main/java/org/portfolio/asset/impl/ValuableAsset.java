package org.portfolio.asset.impl;

import org.portfolio.asset.Money;

public interface ValuableAsset extends Asset {

    Money currentValue();

    default Money profit() {
        return currentValue().subtract(purchaseValue());
    }
}
