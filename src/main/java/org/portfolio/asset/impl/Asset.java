package org.portfolio.asset.impl;

import org.portfolio.asset.Bond;
import org.portfolio.asset.Crypto;
import org.portfolio.asset.Money;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.*;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "assetType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Bond.class, name = "BOND"),
        @JsonSubTypes.Type(value = Crypto.class, name = "CRYPTO")
})
public interface Asset {

    @JsonIgnore
    AssetType type();
    String name();
    LocalDate purchaseDate();
    Money purchaseValue();
    default Money profit() {
        return purchaseValue();
    }
}
