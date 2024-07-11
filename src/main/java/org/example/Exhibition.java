package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Exhibition {
    private final String name;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final List<Artwork> artworks;

    public Exhibition(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.artworks = new ArrayList<>();
    }

    public List<Artwork> getArtworks() {
        return artworks;
    }

    public void addArtwork(Artwork artwork) {
        artworks.add(artwork);
    }

    @Override
    public String toString() {
        return String.format("Выставка \"%s\" с %s по %s, включает произведения: %s",
                name, startDate, endDate, artworks);
    }
}
