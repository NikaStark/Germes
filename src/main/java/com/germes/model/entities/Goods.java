package com.germes.model.entities;

import java.util.Date;
import java.util.UUID;

public class Goods implements Identified<UUID> {

    public static final String TABLE_NAME = "goods";
    public static final String ID_COLUMN = "id";
    public static final String PARCEL_COLUMN = "id_parcel";
    public static final String WEIGHT_COLUMN = "weight";
    public static final String LENGTH_COLUMN = "length";
    public static final String WIDTH_COLUMN = "width";
    public static final String HEIGHT_COLUMN = "height";
    public static final String ASSESSED_VALUE_COLUMN = "assessed_value";
    public static final String COUNT = "count";

    private UUID id;
    private UUID parcel;
    private Float weight;
    private Integer length;
    private Integer width;
    private Integer height;
    private Float assessedValue;

    public Goods() {
    }

    public Goods(UUID parcel, Float weight, Integer length, Integer width, Integer height, Float assessedValue) {
        this.id = new UUID(new Date().getTime(), -new Date().getTime());
        this.parcel = parcel;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.assessedValue = assessedValue;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getParcel() {
        return parcel;
    }

    public void setParcel(UUID parcel) {
        this.parcel = parcel;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Float getAssessedValue() {
        return assessedValue;
    }

    public void setAssessedValue(Float assessedValue) {
        this.assessedValue = assessedValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (!id.equals(goods.id)) return false;
        if (!parcel.equals(goods.parcel)) return false;
        if (!weight.equals(goods.weight)) return false;
        if (!length.equals(goods.length)) return false;
        if (!width.equals(goods.width)) return false;
        if (!height.equals(goods.height)) return false;
        return assessedValue.equals(goods.assessedValue);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + parcel.hashCode();
        result = 31 * result + weight.hashCode();
        result = 31 * result + length.hashCode();
        result = 31 * result + width.hashCode();
        result = 31 * result + height.hashCode();
        result = 31 * result + assessedValue.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", parcel=" + parcel +
                ", weight=" + weight +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", assessedValue=" + assessedValue +
                '}';
    }

}
