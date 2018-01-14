package com.germes.model.entities;

import java.util.Date;
import java.util.UUID;

public class Delivery implements Identified<UUID> {

    public static final String TABLE_NAME = "deliveries";
    public static final String ID_COLUMN = "id";
    public static final String PARCEL_COLUMN = "id_parcel";
    public static final String IS_DELIVERED_COLUMN = "is_delivered";
    public static final String CITY_COLUMN = "id_city";
    public static final String STREET_COLUMN = "street";
    public static final String STREET_NUMBER_COLUMN = "street_number";

    private UUID id;
    private UUID parcel;
    private Boolean isDelivered;
    private Integer city;
    private String street;
    private String streetNumber;

    public Delivery() {
    }

    public Delivery(UUID parcel, Boolean isDelivered, Integer city, String street, String streetNumber) {
        this.id = new UUID(new Date().getTime(), -new Date().getTime());
        this.parcel = parcel;
        this.isDelivered = isDelivered;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
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

    public Boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Delivery delivery = (Delivery) o;

        if (!id.equals(delivery.id)) return false;
        if (!parcel.equals(delivery.parcel)) return false;
        if (!isDelivered.equals(delivery.isDelivered)) return false;
        if (!city.equals(delivery.city)) return false;
        if (!street.equals(delivery.street)) return false;
        return streetNumber.equals(delivery.streetNumber);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + parcel.hashCode();
        result = 31 * result + isDelivered.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + streetNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", parcel=" + parcel +
                ", isDelivered=" + isDelivered +
                ", city=" + city +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                '}';
    }

}
