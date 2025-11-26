package ro.uvt.commands;

import ro.uvt.models.Book;

public class CreateBookCommand implements Command<Book> {

    private final CommandContext ctx;

    public CreateBookCommand(CommandContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Book execute() {
        return ctx.getBooksService().create(ctx.getTitle());
    }
}
