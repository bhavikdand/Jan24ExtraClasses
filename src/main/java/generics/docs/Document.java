package generics.docs;

public abstract class Document {
    String content;

    public Document(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "content:" + content;
    }
}
