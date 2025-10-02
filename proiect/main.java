public class Main {
    public static void main(String[] args) {
        Book book = new Book("Design Patterns");
        Author author = new Author("Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides");
        Chapter chapter1 = new Chapter("Introduction");
        SubChapter subChapter1 = new SubChapter("What is a Design Pattern?");
        Paragraph paragraph1 = new Paragraph("A design pattern is a general repeatable solution to a commonly occurring problem in software design.");
        Image image1 = new Image("design_patterns.png");
        Table table1 = new Table("Pattern Categories");
        TableOfContents toc = new TableOfContents();

        book.print();
        author.print();
        chapter1.print();
        subChapter1.print();
        paragraph1.print();
        image1.print();
        table1.print();
        toc.print();
        
    }
}