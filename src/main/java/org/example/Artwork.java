package org.example;

public class Artwork {
    private String title;
    private String artistName;
    private int year;
    private String style;
    private double estimatedValue;

    public Artwork(String title, String artistName, int year, String style, double estimatedValue) {
        this.title = title;
        this.artistName = artistName;
        this.year = year;
        this.style = style;
        this.estimatedValue = estimatedValue;
    }

    @Override
    public String toString() {
        return String.format("Название: %s, Художник: %s, Год: %d, Стиль: %s, Оценочная стоимость: %.2f",
                title, artistName, year, style, estimatedValue);
    }
}
