package com.service.weather.model.v1;

public class ThirdPartyApiWind {

    private double speed;
    private int deg;

    public ThirdPartyApiWind() {
        super();
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }
}
