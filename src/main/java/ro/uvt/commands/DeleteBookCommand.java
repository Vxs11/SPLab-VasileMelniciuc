package ro.uvt.commands;

public class DeleteBookCommand implements Command<Boolean> {

    private final CommandContext ctx;

    public DeleteBookCommand(CommandContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Boolean execute() {
        return ctx.getBooksService().delete(ctx.getId());
    }
}
