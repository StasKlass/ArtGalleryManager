package org.example;

public class Artist {
    private String name;
    private String birthDate;
    private String countryOfOrigin;

    public Artist(String name, String birthDate, String countryOfOrigin) {
        this.name = name;
        this.birthDate = birthDate;
        this.countryOfOrigin = countryOfOrigin;
    }

    @Override
    public String toString() {
        return String.format("%s - %s, %s", name, birthDate, countryOfOrigin);
    }
}
