package com.yarachkin.xml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cut-flower")
public class CutFlower extends Flower {

    @XmlAttribute(name = "freshness")
    private int freshness = 100;

    public int getFreshness() {
        return freshness;
    }

    public void setFreshness(int value) {
        this.freshness = value;
    }

    @Override
    public String toString() {
        return "CutFlower{" +
                "id='" + getId() +
                ", name='" + getName() +
                ", origin='" + getOrigin() +
                ", visualParameters=" + getVisualParameters() +
                ", multiplying=" + getMultiplying() +
                ", freshness=" + freshness +
                '}';
    }
}