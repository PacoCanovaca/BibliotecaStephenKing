package controller;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Book;
import model.Data;
import model.Library;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class APIController {

    public Library importLibrary() {
        try {
            URL url = new URL("https://stephen-king-api.onrender.com/api/books");
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(url, Library.class);
        } catch (MalformedURLException e) {
            System.out.println("No se ha podido importar la biblioteca. URL incorrecta.");
        } catch (StreamReadException e) {
            System.out.println("No se ha podido importar la biblioteca. Lectura de datos incorrecta");
        } catch (DatabindException e) {
            System.out.println("No se ha podido importar la biblioteca. La conversión de datos a la clase Library ha fallado.");
        } catch (IOException e) {
            System.out.println("No se ha podido importar la biblioteca. Error genérico.");
        }
        return null;
    }

    public Book importBook(String urlString) {
        try {
            URL url = new URL(urlString);
            ObjectMapper objectMapper = new ObjectMapper();
            Data data = objectMapper.readValue(url, Data.class);
            return data.getData();
        } catch (MalformedURLException e) {
            System.out.println("No se ha podido importar el libro. URL incorrecta.");
        } catch (StreamReadException e) {
            System.out.println("No se ha podido importar el libro. Lectura de datos incorrecta");
        } catch (DatabindException e) {
            System.out.println("No se ha podido importar el libro. La conversión de datos a la clase Book ha fallado.");
        } catch (IOException e) {
            System.out.println("No se ha podido importar el libro. Error genérico.");
        }
        return null;
    }

}
