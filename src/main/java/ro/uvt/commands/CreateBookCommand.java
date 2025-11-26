package ro.uvt.commands;

import ro.uvt.models.Book;

public class CreateBookCommand implements Command<Book> {

    private final CommandContext ctx;

    public CreateBookCommand(CommandContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Book execute() {
        Book book = new Book();
        book.setTitle(ctx.getTitle());
        return ctx.getBooksRepository().save(book);
    }
}
