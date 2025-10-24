public class Main {
    public static void main(String[] args) {
        Book book = new Book("Design Patterns in Java");
        Author author1 = new Author("Erich", "Gamma");
        Author author2 = new Author("Richard", "Helm");
        Author author3 = new Author("Ralph", "Johnson");
        Author author4 = new Author("John", "Vissides");

        book.addAuthor(author1);
        book.addAuthor(author2);
        book.addAuthor(author3);
        book.addAuthor(author4);

        Section intro = new Section("Introduction");
        intro.add(new Paragraph("This book discusses classic software design patterns."));
        intro.add(new Image("intro-image.png"));

        Section strategy = new Section("Strategy Pattern");
        strategy.add(new Paragraph("The strategy pattern defines a family of algorithms."));
        strategy.add(new Table("Strategy Comparison Table"));
        strategy.add(new Image("strategy-diagram.jpg"));

        Section implementation = new Section("Implementation");
        implementation.add(new Paragraph("We can implement strategy pattern using interfaces."));
        implementation.add(new Image("uml-diagram.png"));
        strategy.add(implementation);
        book.add(new TableOfContents("1. Introduction\n2. Strategy Pattern"));
        book.add(intro);
        book.add(strategy);

        book.print();
    }
}
