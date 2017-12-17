package com.yarachkin.xml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "visual-parameters", propOrder = {"stemColor", "leafColor", "flowerHeight"})
public class VisualParameters {
    @XmlElement(name = "stem-color", required = true)
    private String stemColor;
    @XmlElement(name = "leaf-color", required = true)
    private String leafColor;
    @XmlElement(name = "flower-height")
    private double flowerHeight;

    public String getStemColor() {
        return stemColor;
    }

    public void setStemColor(String value) {
        this.stemColor = value;
    }

    public String getLeafColor() {
        return leafColor;
    }

    public void setLeafColor(String value) {
        this.leafColor = value;
    }

    public double getFlowerHeight() {
        return flowerHeight;
    }

    public void setFlowerHeight(double value) {
        this.flowerHeight = value;
    }

    @Override
    public String toString() {
        return "VisualParameters{" +
                "stemColor='" + stemColor + '\'' +
                ", leafColor='" + leafColor + '\'' +
                ", flowerHeight=" + flowerHeight +
                '}';
    }
}