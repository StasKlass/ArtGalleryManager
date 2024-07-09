package org.example;

import java.util.ArrayList;
import java.util.List;

public class Exhibition {
    private String name;
    private String startDate;
    private String endDate;
    private List<String> artworks;

    public Exhibition(String name, String startDate, String endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.artworks = new ArrayList<>();
    }

    public void addArtwork(String artworkTitle) {
        artworks.add(artworkTitle);
    }

    @Override
    public String toString() {
        return String.format("Выставка \"%s\" с %s по %s. Включает произведения: %s",
                name, startDate, endDate, String.join(", ", artworks));
    }
}
