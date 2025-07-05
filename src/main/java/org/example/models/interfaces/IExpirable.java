package org.example.models.interfaces;

import java.time.LocalDate;

public interface IExpirable {
    LocalDate getExpirationDate();
    void setExpirationDate(LocalDate expirationDate);
    boolean isExpired();
}
