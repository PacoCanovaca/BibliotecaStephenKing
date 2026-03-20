import controller.APIController;
import controller.LibraryController;
import model.Book;
import model.Library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LibraryController libraryController = new LibraryController();
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> libraryController.importLibraryAPI(); // Importar libros API
            case 2 -> libraryController.printBooksSimpleData(); // Mostrar info básica de todos los libros
            case 3 -> {
                System.out.println("Introduce el id del libro sobre el que quieres información detallada:");
                int id = scanner.nextInt();
                libraryController.getBookInfo(id); // Buscar info detallada de un libro
            }
            case 4 -> {
                System.out.println("Introduce el id del libro que quieres añadir como favorito:");
                int id = scanner.nextInt();
                libraryController.addFavoriteBook(id);
            }
            case 5 -> libraryController.printFavoritesSimpleData(); // Mostrar info básica de cada libro favorito
        }
        scanner.close();

    }

}
