package BookStore;
import java.util.Map;
import java.util.HashMap;

public class BookStore {
    private final Map<String , Book> books;

    public BookStore(){
        books = new HashMap<>();
    }

    public void addBook(Book book){
        books.put(book.getId() , book);
    }

    public int getWordCount(String bookId , String word){
        Book book = books.get(bookId);

        if(book == null){
            return 0; 
        }
        return book.getWordCount(word);
    }
}
