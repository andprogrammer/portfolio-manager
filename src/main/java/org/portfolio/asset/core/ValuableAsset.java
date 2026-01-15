package org.portfolio.asset.core;

import org.portfolio.asset.model.Money;

public interface ValuableAsset extends Asset {

    Money currentValue();

    default Money profit() {
        return currentValue().subtract(purchaseValue());
    }
}
