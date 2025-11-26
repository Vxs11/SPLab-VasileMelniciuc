package ro.uvt.commands;

public class DeleteBookCommand implements Command<Boolean> {

    private final CommandContext ctx;

    public DeleteBookCommand(CommandContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Boolean execute() {
        if (ctx.getBooksRepository().findById(ctx.getId()).isEmpty()) {
            return false;
        }
        ctx.getBooksRepository().deleteById(ctx.getId());
        return true;
    }
}
