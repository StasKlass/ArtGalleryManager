package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArtGalleryManager {
    private List<Artwork> artworks;
    private List<Artist> artists;
    private List<Exhibition> exhibitions;

    public ArtGalleryManager() {
        this.artworks = new ArrayList<>();
        this.artists = new ArrayList<>();
        this.exhibitions = new ArrayList<>();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в менеджер галереи искусства!");

        while (true) {
            printMainMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addArtwork(scanner);
                    break;
                case 2:
                    addArtist(scanner);
                    break;
                case 3:
                    organizeExhibition(scanner);
                    break;
                case 4:
                    viewAllArtworks();
                    break;
                case 5:
                    viewAllArtists();
                    break;
                case 6:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить произведение искусства");
        System.out.println("2. Добавить художника");
        System.out.println("3. Организовать выставку");
        System.out.println("4. Просмотреть все произведения");
        System.out.println("5. Просмотреть всех художников");
        System.out.println("6. Выход");
        System.out.print("Введите ваш выбор: ");
    }

    private void addArtwork(Scanner scanner) {
        System.out.println("Вы выбрали добавление нового произведения искусства.");

        System.out.print("Введите название произведения: ");
        String title = scanner.nextLine();

        System.out.print("Введите имя художника: ");
        String artistName = scanner.nextLine();

        System.out.print("Введите год создания: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите стиль: ");
        String style = scanner.nextLine();

        System.out.print("Введите оценочную стоимость (в евро): ");
        double estimatedValue = scanner.nextDouble();
        scanner.nextLine();

        Artwork artwork = new Artwork(title, artistName, year, style, estimatedValue);
        artworks.add(artwork);

        System.out.println("Произведение искусства успешно добавлено!");
    }

    private void addArtist(Scanner scanner) {
        System.out.println("Вы выбрали добавление нового художника.");

        System.out.print("Введите имя художника: ");
        String name = scanner.nextLine();

        System.out.print("Введите дату рождения: ");
        String birthDate = scanner.nextLine();

        System.out.print("Введите страну происхождения: ");
        String countryOfOrigin = scanner.nextLine();

        Artist artist = new Artist(name, birthDate, countryOfOrigin);
        artists.add(artist);

        System.out.println("Художник успешно добавлен!");
    }

    private void organizeExhibition(Scanner scanner) {
        System.out.println("Вы выбрали организацию выставки.");

        System.out.print("Введите название выставки: ");
        String name = scanner.nextLine();

        System.out.print("Введите дату начала выставки: ");
        String startDate = scanner.nextLine();

        System.out.print("Введите дату окончания выставки: ");
        String endDate = scanner.nextLine();

        Exhibition exhibition = new Exhibition(name, startDate, endDate);

        System.out.print("Введите названия произведений для выставки, разделённые запятой: ");
        String artworkNamesLine = scanner.nextLine();
        String[] artworkNames = artworkNamesLine.split(", ");

        for (String artworkName : artworkNames) {
            exhibition.addArtwork(artworkName);
        }

        exhibitions.add(exhibition);

        System.out.println("Выставка успешно организована!");
    }

    private void viewAllArtworks() {
        System.out.println("Список всех произведений:");
        for (Artwork artwork : artworks) {
            System.out.println(artwork);
        }
    }

    private void viewAllArtists() {
        System.out.println("Список всех художников:");
        for (Artist artist : artists) {
            System.out.println(artist);
        }
    }

    public static void main(String[] args) {
        ArtGalleryManager manager = new ArtGalleryManager();
        manager.run();
    }
}
