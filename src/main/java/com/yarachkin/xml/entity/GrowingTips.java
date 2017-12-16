package com.yarachkin.xml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "growing-tips", propOrder = {"temperature", "lighting", "watering"})
public class GrowingTips {

    private double temperature;
    private boolean lighting;
    private double watering;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double value) {
        this.temperature = value;
    }

    public boolean isLighting() {
        return lighting;
    }

    public void setLighting(boolean value) {
        this.lighting = value;
    }

    public double getWatering() {
        return watering;
    }

    public void setWatering(double value) {
        this.watering = value;
    }
}