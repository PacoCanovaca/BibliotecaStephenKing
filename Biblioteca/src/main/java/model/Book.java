package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.OffsetDateTime;

@lombok.Data
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    // He tenido que añadir todas estas anotaciones @JsonProperty porque el nombre con la primera en mayúscula de la API chocaba a la hora de ser importado, y no bastaba con cambiar directamente el nombre de la variable aquí en la clase
    @JsonProperty("Year")
    private long year;
    @JsonProperty("Title")
    private String title;
    private String handle;
    @JsonProperty("Publisher")
    private String publisher;
    @JsonProperty("ISBN")
    private String isbn;
    @JsonProperty("Pages")
    private long pages;
    @JsonProperty("Notes")
    private String[] notes;
    @JsonIgnore
    private OffsetDateTime created_at;
    private Villain[] villains;

    public void printData() {
        System.out.println("Id = " + id);
        System.out.println("Title = " + title);
        System.out.println("ISBN = " + isbn);
        System.out.println("Publisher = " + publisher);
        System.out.println("Number of pages = " + pages);
    }

}

@lombok.Data
class Villain {
    private String name;
    private String url;
}