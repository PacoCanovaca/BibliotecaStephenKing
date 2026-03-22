package controller;

import lombok.Getter;
import model.Book;

import java.util.ArrayList;

@Getter
public class LibraryController {
    private final ArrayList<Book> library;
    private ArrayList<Book> favorites;

    public LibraryController() {
        library = new ArrayList<>();
        favorites = new ArrayList<>();
    }

    public void importLibraryAPI() {
        APIController apiController = new APIController();
        library.clear(); // Para que no se acumule cada importación (en caso de que el usuario use varias veces esta opción)
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
        Book book = library.get(id - 1);
        for (Book item : favorites) {
            if (item.getId() == id) {
                System.out.println("El libro con el id introducido ya se encuentra en la lista de favoritos");
                return;
            }
        }
        favorites.add(book);
    }

    public void printFavoritesSimpleData() {
        favorites.forEach(Book::printSimpleData);
    }

}
