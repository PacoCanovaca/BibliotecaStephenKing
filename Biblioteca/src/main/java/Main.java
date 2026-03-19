import controller.APIController;
import model.Book;

public class Main {

    public static void main(String[] args) {

        APIController apiController = new APIController();

        Book book = apiController.importBook("https://stephen-king-api.onrender.com/api/book/19");
        book.printData();

    }

}
