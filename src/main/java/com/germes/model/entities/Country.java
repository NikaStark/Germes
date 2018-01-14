package com.germes.model.entities;

public class Country implements Identified<Integer> {

    public static final String TABLE_NAME = "countries";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String TARIFF_COLUMN = "tariff";

    private Integer id;
    private String name;
    private Float tariff;

    public Country() {
    }

    public Country(String name, Float tariff) {
        this.name = name;
        this.tariff = tariff;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        Country country = (Country) o;

        if (!id.equals(country.id)) return false;
        if (!name.equals(country.name)) return false;
        return tariff.equals(country.tariff);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + tariff.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tariff=" + tariff +
                '}';
    }

}
