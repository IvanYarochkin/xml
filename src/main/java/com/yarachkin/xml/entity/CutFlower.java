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
    private BigInteger freshness;

    public BigInteger getFreshness() {
        if ( freshness == null ) {
            return new BigInteger("100");
        } else {
            return freshness;
        }
    }

    public void setFreshness(BigInteger value) {
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