package ru.sbt.bit.ood.solid.homework;

import java.time.LocalDate;

public class LocalDateRange {
    private final LocalDate from;
    private final LocalDate to;

    public LocalDateRange(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }
}
