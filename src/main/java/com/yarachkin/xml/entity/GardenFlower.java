package com.yarachkin.xml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "garden-flower", propOrder = {"growingTips"})
public class GardenFlower extends Flower {
    @XmlElement(name = "growing-tips", required = true)
    private GrowingTips growingTips;
    @XmlAttribute(name = "soil")
    private String soil;

    public GrowingTips getGrowingTips() {
        return growingTips;
    }

    public void setGrowingTips(GrowingTips value) {
        this.growingTips = value;
    }

    public String getSoil() {
        if ( soil == null ) {
            return "unpaved";
        } else {
            return soil;
        }
    }

    public void setSoil(String value) {
        this.soil = value;
    }

    @Override
    public String toString() {
        return "GardenFlower{" +
                "id='" + getId() +
                ", name='" + getName() +
                ", origin='" + getOrigin() +
                ", visualParameters=" + getVisualParameters() +
                ", multiplying=" + getMultiplying() +
                ", growingTips=" + growingTips +
                ", soil='" + soil +
                '}';
    }
}