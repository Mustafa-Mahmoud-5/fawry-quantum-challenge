package org.example.models.implementations;

import org.example.models.interfaces.IExpirable;

import java.time.LocalDate;

public class ExpirableImpel implements IExpirable {
    private LocalDate expirationDate;

    public ExpirableImpel(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }
}
