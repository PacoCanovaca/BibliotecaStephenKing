package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.OffsetDateTime;

@lombok.Data
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private long year;
    private String title;
    private String handle;
    private String publisher;
    private String isbn;
    private long pages;
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