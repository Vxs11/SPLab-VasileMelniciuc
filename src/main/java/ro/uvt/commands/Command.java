package ro.uvt.commands;

public interface Command<R> {
    R execute();
}
