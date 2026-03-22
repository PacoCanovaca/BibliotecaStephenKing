import controller.APIController;
import controller.FileController;
import controller.LibraryController;
import model.Book;
import model.Library;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LibraryController libraryController = new LibraryController();
        FileController fileController = new FileController();
        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> favorites = fileController.importFavorites();
        favorites.forEach(book -> libraryController.getFavorites().add(book)); // Estas dos líneas sirven para asegurarse de que, en el momento en que se ejecuta el programa, se importan los favoritos ya guardados en el archivo (y así tenerlos cargados y evitar sobreescribir el archivo y perder lo registrado anteriormente

        int option;
        do {
            System.out.print("--- MENÚ ---\n1. Importar biblioteca completa de Stephen King.\n2. Mostrar información básica de todos los libros.\n3. Buscar información detallada de un libro.\n4. Añadir un libro a la lista de favoritos.\n5. Mostrar información básica de los libros favoritos.\n6. Exportar los libros favoritos.\n7. Importar los libros favoritos registrados.\n0. Salir\n\nIntroduce tu opción: ");
            option = scanner.nextInt();
            switch (option) {
                case 1 -> libraryController.importLibraryAPI();
                case 2 -> libraryController.printBooksSimpleData();
                case 3 -> {
                    System.out.println("Introduce el id del libro sobre el que quieres información detallada:");
                    int id = scanner.nextInt();
                    libraryController.getBookInfo(id);
                }
                case 4 -> {
                    System.out.println("Introduce el id del libro que quieres añadir como favorito:");
                    int id = scanner.nextInt();
                    libraryController.addFavoriteBook(id);
                }
                case 5 -> libraryController.printFavoritesSimpleData();
                case 6 -> {
                    if (libraryController.getFavorites().isEmpty()) {
                        System.out.println("Debes importar primero los libros exportados en el archivo 'favoritos.obj'");
                    }
                    fileController.exportFavorites(libraryController.getFavorites());
                    libraryController.getFavorites().clear();
                }
                case 7 -> {
                    if (!libraryController.getFavorites().isEmpty()) {
                        System.out.println("Debes exportar primero los libros que has registrado en esta sesión.");
                        continue;
                    }
                    favorites = fileController.importFavorites();
                    favorites.forEach(book -> libraryController.getFavorites().add(book));
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no registrada.");
            }
        } while (option != 0);

        scanner.close();

    }

}
