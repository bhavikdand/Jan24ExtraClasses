package generics.intro;

// Unbounded Generic
public class GenericPrinter<DT> {
    DT thingToPrint;

    public GenericPrinter(DT thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print(){
        System.out.println(thingToPrint);
    }
}
