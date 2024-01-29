package generics.docs;

public class Main {
    public static void main(String[] args) {
        PDF pdf = new PDF("I am pdf");
        CSV csv = new CSV("A,B,C,D");

        DocumentPrinter<PDF> pdfPrinter = new DocumentPrinter<>(pdf);
        pdfPrinter.print();

        DocumentPrinter<CSV> csvPrinter = new DocumentPrinter<>(csv);
        csvPrinter.print();

//        DocumentPrinter<String> stringDocumentPrinter = new DocumentPrinter<>("I dont belong here");
//        stringDocumentPrinter.print();

        DocumentPrinter<SpecialPDF> specialPDFDocumentPrinter = new DocumentPrinter<>(new SpecialPDF("I am special"));
        specialPDFDocumentPrinter.print();
    }
}
