package controller;

import model.Book;

import java.io.*;
import java.util.ArrayList;

public class FileController {

    public void exportFavorites(ArrayList<Book> favorites) {
        File file = new File("src/main/java/ressources/favoritos.obj");
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            for (Book book : favorites) {
                objectOutputStream.writeObject(book);
            }
            System.out.println("Exportación realizada correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Error en la escritura. Archivo no encontrado.");
        } catch (IOException e) {
            System.out.println("Error genérico en la escritura.");
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el objeto de escritura.");
            }
        }
    }

    public ArrayList<Book> importFavorites() {
        File file = new File("src/main/java/ressources/favoritos.obj");
        ObjectInputStream objectInputStream = null;
        ArrayList<Book> favorites = new ArrayList<>();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            while(true) {
                favorites.add((Book)objectInputStream.readObject());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error en la lectura. Archivo no encontrado.");
        } catch (EOFException e) {
            System.out.println("Importación terminada correctamente."); // He añadido esta excepción para que el bucle de importación de objetos de clase Book termine cuando ya no haya nada más dentro del archivo, ya que no encontraba otra manera de indicarle al bucle que terminase
        } catch (IOException e) {
            System.out.println("Error genérico en la lectura.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en la lectura. No se ha encontrado la clase indicada.");
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el objeto de lectura.");
            }
        }
        return favorites;
    }

}
