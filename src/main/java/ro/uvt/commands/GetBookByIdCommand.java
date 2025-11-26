package ro.uvt.commands;

import ro.uvt.models.Book;

public class GetBookByIdCommand implements Command<Book> {

    private final CommandContext ctx;

    public GetBookByIdCommand(CommandContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Book execute() {
        return ctx.getBooksRepository()
                .findById(ctx.getId())
                .orElse(null);
    }
}
