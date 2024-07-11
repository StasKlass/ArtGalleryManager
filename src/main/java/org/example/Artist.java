package org.example;

import java.time.LocalDate;

public class Artist {
    private final String name;
    private final LocalDate birthDate;
    private final String countryOfOrigin;

    public Artist(String name, LocalDate birthDate, String countryOfOrigin) {
        this.name = name;
        this.birthDate = birthDate;
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s - %s, %s", name, birthDate.toString(), countryOfOrigin);
    }
}
