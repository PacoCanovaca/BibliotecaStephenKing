package controller;

import lombok.Getter;
import model.Book;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LibraryController {
    private final List<Book> library;
    private final List<Book> favorites;

    public LibraryController() {
        library = new ArrayList<>();
        favorites = new ArrayList<>();
    }

    public void importLibraryAPI() {
        APIController apiController = new APIController();
        for (Book book : apiController.importLibrary().getData()) {
            library.add(book);
        }
    }

    public void printBooksSimpleData() {
        library.forEach(Book::printSimpleData);
    }

    public void getBookInfo(int id) {
        String url = "https://stephen-king-api.onrender.com/api/book/" + id;
        APIController apiController = new APIController();
        apiController.importBook(url).printData();
    }

    public void addFavoriteBook(int id) {
        favorites.add(library.get(id - 1));
    }

    public void printFavoritesSimpleData() {
        favorites.forEach(Book::printData);
    }

}
