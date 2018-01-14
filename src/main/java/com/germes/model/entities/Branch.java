package com.germes.model.entities;

public class Branch implements Identified<Integer> {

    public static final String TABLE_NAME = "branches";
    public static final String ID_COLUMN = "id";
    public static final String CITY_COLUMN = "id_city";
    public static final String STREET_COLUMN = "street";
    public static final String STREET_NUMBER_COLUMN = "street_number";

    private Integer id;
    private Integer city;
    private String street;
    private String streetNumber;

    public Branch() {
    }

    public Branch(Integer city, String street, String streetNumber) {
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

        Branch branch = (Branch) o;

        if (!id.equals(branch.id)) return false;
        if (!city.equals(branch.city)) return false;
        if (!street.equals(branch.street)) return false;
        return streetNumber.equals(branch.streetNumber);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + streetNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", city=" + city +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                '}';
    }

}
