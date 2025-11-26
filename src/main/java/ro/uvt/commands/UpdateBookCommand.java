package ro.uvt.commands;

import ro.uvt.models.Book;

public class UpdateBookCommand implements Command<Book> {

    private final CommandContext ctx;

    public UpdateBookCommand(CommandContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Book execute() {
        return ctx.getBooksService().update(ctx.getId(), ctx.getTitle());
    }
}
