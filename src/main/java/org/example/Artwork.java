package org.example;

import java.time.LocalDate;

public class Artwork {
    private final String title;
    private final Artist artist;
    private final int year;
    private final String style;
    private final double estimatedValue;

    public Artwork(String title, Artist artist, int year, String style, double estimatedValue) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.style = style;
        this.estimatedValue = estimatedValue;
    }

    public static void main(String[] args) {
        Artist artist = new Artist("Клод Моне", LocalDate.of(1840, 11, 14), "Франция");
        Artwork artwork = new Artwork("Впечатление, восходящее солнце", artist, 1872, "Импрессионизм", 5000000.00);

        System.out.println(artwork);
    }

    @Override
    public String toString() {
        return String.format("Название: %s, Художник: %s, Год: %d, Стиль: %s, Оценочная стоимость: %.2f",
                title, artist.getName(), year, style, estimatedValue);
    }

    public String getTitle() {
        return this.title;
    }
}
