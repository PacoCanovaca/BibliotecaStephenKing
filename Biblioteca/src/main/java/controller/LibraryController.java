package controller;

import lombok.Getter;
import model.Book;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LibraryController {
    private final List<Book> library;

    public LibraryController() {
        library = new ArrayList<>();
    }

}
