public class TableOfContents implements Element {
    private String something;

    public TableOfContents(String something) {
        this.something = something;
    }

    @Override
    public void print() {
        System.out.println("Table of Contents: " + something);
    }

    @Override
    public void add(Element element) { throw new UnsupportedOperationException(); }
    @Override
    public void remove(Element element) { throw new UnsupportedOperationException(); }
    @Override
    public Element get(int index) { throw new UnsupportedOperationException(); }
}
