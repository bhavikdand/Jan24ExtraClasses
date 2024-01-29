package generics.intro;

public class LongPrinter {

    Long longToPrint;

    public LongPrinter(Long longToPrint) {
        this.longToPrint = longToPrint;
    }

    public void print(){
        System.out.println(longToPrint);
    }
}
