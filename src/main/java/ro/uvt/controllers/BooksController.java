package ro.uvt.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.commands.*;
import ro.uvt.models.Book;
import ro.uvt.persistence.CrudRepository;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final CrudRepository<Book, Integer> booksRepository;

    public BooksController(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    @GetMapping
    public List<Book> getAll() {
        CommandContext ctx = new CommandContext();
        ctx.setBooksRepository(booksRepository);
        return new GetAllBooksCommand(ctx).execute();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Integer id) {
        CommandContext ctx = new CommandContext();
        ctx.setBooksRepository(booksRepository);
        ctx.setId(id);

        Book book = new GetBookByIdCommand(ctx).execute();
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Book create(@RequestBody Book request) {
        CommandContext ctx = new CommandContext();
        ctx.setBooksRepository(booksRepository);
        ctx.setTitle(request.getTitle());

        return new CreateBookCommand(ctx).execute();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id,
                                       @RequestBody Book request) {
        CommandContext ctx = new CommandContext();
        ctx.setBooksRepository(booksRepository);
        ctx.setId(id);
        ctx.setTitle(request.getTitle());

        Book updated = new UpdateBookCommand(ctx).execute();
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        CommandContext ctx = new CommandContext();
        ctx.setBooksRepository(booksRepository);
        ctx.setId(id);

        boolean deleted = new DeleteBookCommand(ctx).execute();
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
