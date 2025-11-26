package ro.uvt.commands;

import ro.uvt.models.Book;

import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {

    private final CommandContext ctx;

    public GetAllBooksCommand(CommandContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public List<Book> execute() {
        return ctx.getBooksRepository().findAll();
    }
}
