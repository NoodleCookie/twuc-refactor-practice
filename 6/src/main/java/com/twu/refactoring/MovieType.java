package com.twu.refactoring;

public enum MovieType {
    REGULAR(2.0,2.0,1.5)
    ,NEW_RELEASE(0.0,0.0,3.0)
    ,CHILDREN(1.5,3.0,1.5);

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public void setBasePricePerDay(double basePricePerDay) {
        this.basePricePerDay = basePricePerDay;
    }

    public double getIncrementDays() {
        return incrementDays;
    }

    public void setIncrementDays(double incrementDays) {
        this.incrementDays = incrementDays;
    }

    public double getIncrementPricePerDay() {
        return incrementPricePerDay;
    }

    public void setIncrementPricePerDay(double incrementPricePerDay) {
        this.incrementPricePerDay = incrementPricePerDay;
    }

    private double basePricePerDay;
    private double incrementDays;
    private double incrementPricePerDay;

    MovieType(double basePricePerDay, double incrementDays, double incrementPricePerDay) {
        this.basePricePerDay = basePricePerDay;
        this.incrementDays = incrementDays;
        this.incrementPricePerDay = incrementPricePerDay;
    }
}
