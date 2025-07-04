package org.example.product.expire;

import java.time.LocalDate;

public class Expirable implements ExpireStrategy {
    private final LocalDate expireDate;

    public Expirable(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expireDate);
    }
}
