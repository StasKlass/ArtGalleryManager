package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArtGalleryManager {
    private final List<Artwork> artworks = new ArrayList<>();
    private final List<Artist> artists = new ArrayList<>();
    private final List<Exhibition> exhibitions = new ArrayList<>();
    private final Scanner scanner;

    public ArtGalleryManager() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Добро пожаловать в менеджер галереи искусства!");
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addArtwork();
                    break;
                case 2:
                    addArtist();
                    break;
                case 3:
                    organizeExhibition();
                    break;
                case 4:
                    viewAllArtworks();
                    break;
                case 5:
                    viewAllArtists();
                    break;
                case 6:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить произведение искусства");
        System.out.println("2. Добавить художника");
        System.out.println("3. Организовать выставку");
        System.out.println("4. Просмотреть все произведения");
        System.out.println("5. Просмотреть всех художников");
        System.out.println("6. Выход");
        System.out.print("Введите ваш выбор: ");
    }

    private void addArtwork() {
        System.out.println("Вы выбрали добавление нового произведения искусства.");
        System.out.print("Введите название произведения: ");
        String title = scanner.nextLine();

        System.out.print("Введите имя художника: ");
        String artistName = scanner.nextLine();
        Artist artist = findOrCreateArtist(artistName);

        System.out.print("Введите год создания: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите стиль: ");
        String style = scanner.nextLine();

        System.out.print("Введите оценочную стоимость (в евро): ");
        double estimatedValue = scanner.nextDouble();
        scanner.nextLine();

        Artwork artwork = new Artwork(title, artist, year, style, estimatedValue);
        artworks.add(artwork);

        System.out.printf("Произведение искусства \"%s\" успешно добавлено!\n", title);
    }

    private Artist findOrCreateArtist(String name) {
        for (Artist artist : artists) {
            if (artist.getName().equalsIgnoreCase(name)) {
                return artist;
            }
        }
        System.out.print("Введите дату рождения (формат ГГГГ-ММ-ДД): ");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr);

        System.out.print("Введите страну происхождения: ");
        String country = scanner.nextLine();

        Artist newArtist = new Artist(name, birthDate, country);
        artists.add(newArtist);
        System.out.printf("Художник %s успешно добавлен!\n", name);
        return newArtist;
    }

    private void addArtist() {
        System.out.println("Вы выбрали добавление нового художника.");
        System.out.print("Введите имя художника: ");
        String name = scanner.nextLine();

        Artist artist = findOrCreateArtist(name);
        artists.add(artist);
    }

    private void organizeExhibition() {
        System.out.println("Вы выбрали организацию выставки.");
        System.out.print("Введите название выставки: ");
        String name = scanner.nextLine();

        System.out.print("Введите дату начала выставки (формат ГГГГ-ММ-ДД): ");
        String startDateStr = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(startDateStr);

        System.out.print("Введите дату окончания выставки (формат ГГГГ-ММ-ДД): ");
        String endDateStr = scanner.nextLine();
        LocalDate endDate = LocalDate.parse(endDateStr);

        Exhibition exhibition = new Exhibition(name, startDate, endDate);

        System.out.print("Введите названия произведений для выставки, разделённые запятой: ");
        String artworkNamesLine = scanner.nextLine();
        String[] artworkNames = artworkNamesLine.split(", ");

        for (String artworkName : artworkNames) {
            Artwork artwork = findArtworkByName(artworkName);
            if (artwork != null) {
                exhibition.addArtwork(artwork);
            }
        }

        exhibitions.add(exhibition);
        System.out.printf("Выставка \"%s\" успешно организована и будет проходить с %s по %s.\n",
                name, startDate, endDate);
        System.out.println("Включает произведения:");
        for (Artwork artwork : exhibition.getArtworks()) {
            System.out.println("- " + artwork.getTitle());
        }
    }

    private Artwork findArtworkByName(String name) {
        for (Artwork artwork : artworks) {
            if (artwork.getTitle().equalsIgnoreCase(name)) {
                return artwork;
            }
        }
        System.out.printf("Произведение искусства с названием \"%s\" не найдено.\n", name);
        return null;
    }

    private void viewAllArtworks() {
        System.out.println("Вы выбрали просмотр всех произведений искусства.");
        System.out.println("Список всех произведений:");
        for (int i = 0; i < artworks.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, artworks.get(i).toString());
        }
    }

    private void viewAllArtists() {
        System.out.println("Вы выбрали просмотр всех художников.");
        System.out.println("Список всех художников:");
        for (int i = 0; i < artists.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, artists.get(i).toString());
        }
    }

    public static void main(String[] args) {
        ArtGalleryManager manager = new ArtGalleryManager();
        manager.run();
    }
}
