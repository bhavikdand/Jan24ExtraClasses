package generics.docs;

// Bounded generic
public class DocumentPrinter<Doc extends Document> {

    Doc document;

    public DocumentPrinter(Doc document) {
        this.document = document;
    }

    public void print(){
        System.out.println(document);
    }
}
