package ro.uvt.commands;

import ro.uvt.models.Book;
import ro.uvt.persistence.CrudRepository;

public class CommandContext {

    private CrudRepository<Book, Integer> booksRepository;
    private Integer id;
    private String title;

    public CrudRepository<Book, Integer> getBooksRepository() {
        return booksRepository;
    }

    public void setBooksRepository(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
