public class Image implements Element {
    private String url;

    public Image(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Image with URL: " + url);
    }

    @Override
    public void add(Element element) { throw new UnsupportedOperationException(); }
    @Override
    public void remove(Element element) { throw new UnsupportedOperationException(); }
    @Override
    public Element get(int index) { throw new UnsupportedOperationException(); }
}
