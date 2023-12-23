package com.test.nedugatest.data.models;

public class RatingModel {
    private double rate;
    private int count;

    public RatingModel(double rate, int count) {
        this.rate = rate;
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "{ \"rate\":"+rate+", \"count\":"+count+'}';
    }
}
