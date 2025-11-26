package ro.uvt.services;

import org.springframework.stereotype.Service;
import ro.uvt.models.Book;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BooksService {

    private final Map<Integer, Book> books = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    public List<Book> getAll() {
        return new ArrayList<>(books.values());
    }

    public Book getById(Integer id) {
        return books.get(id);
    }

    public Book create(String title) {
        int id = counter.incrementAndGet();
        Book book = new Book(id, title);
        books.put(id, book);
        return book;
    }

    public Book update(Integer id, String title) {
        Book book = books.get(id);
        if (book != null) {
            book.setTitle(title);
        }
        return book;
    }

    public boolean delete(Integer id) {
        return books.remove(id) != null;
    }
}
