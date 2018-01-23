package com.germes.model.entities;

public class City implements Identified<Integer> {

    public static final String TABLE_NAME = "cities";
    public static final String ID_COLUMN = "id";
    public static final String COUNTRY_COLUMN = "id_country";
    public static final String NAME_COLUMN = "name";
    public static final String LATITUDE_COLUMN = "latitude";
    public static final String LONGITUDE_COLUMN = "longitude";
    public static final String TARIFF_COLUMN = "tariff";
    public static final String COUNT = "count";

    private Integer id;
    private Integer country;
    private String name;
    private Float latitude;
    private Float longitude;
    private Float tariff;

    public City() {
    }

    public City(Integer country, String name, Float latitude, Float longitude, Float tariff) {
        this.country = country;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tariff = tariff;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getTariff() {
        return tariff;
    }

    public void setTariff(Float tariff) {
        this.tariff = tariff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (!id.equals(city.id)) return false;
        if (!country.equals(city.country)) return false;
        if (!name.equals(city.name)) return false;
        if (!latitude.equals(city.latitude)) return false;
        if (!longitude.equals(city.longitude)) return false;
        return tariff.equals(city.tariff);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + latitude.hashCode();
        result = 31 * result + longitude.hashCode();
        result = 31 * result + tariff.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", country=" + country +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", tariff=" + tariff +
                '}';
    }

}
