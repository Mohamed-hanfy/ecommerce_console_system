package org.example.product.expire;

public class NonExpirable implements ExpireStrategy {
    @Override
    public boolean isExpired() {
        return false;
    }
}
