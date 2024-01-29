package generics.intro;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        IntegerPrinter ip = new IntegerPrinter(10);
        ip.print();

        LongPrinter lp = new LongPrinter(23L);
        lp.print();

        ObjectPrinter op1 = new ObjectPrinter(1.0D);
        op1.print();
//        Integer i = (Integer) op1.get();

        ObjectPrinter op2 = new ObjectPrinter("Bhavik");
        op2.print();

        GenericPrinter<Integer> gpi = new GenericPrinter<>(4);
        gpi.print();

        GenericPrinter<String> gps = new GenericPrinter<>("ABCD");
        gps.print();

        GenericPrinter<Animal> gpa = new GenericPrinter<>(new Animal("Dog", 10));
        gpa.print();

        // I want to store a students roll no (int) and the name of the student(String) together
        Pair<Integer, String> pairIS = new Pair<>(1, "ABCD");
        System.out.println(pairIS.getFirst());
        Integer i = pairIS.getFirst();
        String s = pairIS.getSecond();

        // I want to store a students name and class name together
        Pair<String, String> pairSS = new Pair<>("A", "B");
        Pair<String, Pair<Integer, String>> nestedPair = new Pair<>("ABCD", pairIS);

        Pair<Integer, String> second = nestedPair.getSecond();

        print("ABCD");
        print(10);
        print(34L);
        print(3.4D);

        String s1 = printAndGet("ABCD");
        Integer i1 = printAndGet(10);
        Long l = printAndGet(34L);
        Double v = printAndGet(3.4D);

        String s2 = printAndReturnString(34L);

        List<Integer> li = Arrays.asList(1,2,3,4,5);
        List<Double> ld = Arrays.asList(1.0, 2.0, 3.0);
        List<String> ls = Arrays.asList("A", "B", "C");

        System.out.println(calcAvg(li));
        System.out.println(calcAvg(ld));
        // System.out.println(calcAvg(ls)); String is not a child of number
    }

    // ? means any data type can come here
    // ? can be bounded using extends
    // ? is called as wilcard
    // Wildcards can be only be used with generic methods, generic classes cannot be created
    // Wildcard generic method can be converted in to a non wildcard generic method
    // Wildcards are mostly used when we care developing frameworks
    public static double calcAvg(List<? extends Number> list){
        double ans = 0;
        for (Number i: list){
            ans += i.intValue();
        }
        return ans / list.size();
    }

    public static <T extends Number> double calcAvg2(List<T> list){
        double ans = 0;
        for (Number i: list){
            ans += i.intValue();
        }
        return ans / list.size();
    }

    public static <T> void print(T thingToPrint){
        System.out.println(thingToPrint);
    }

    public static <T> T printAndGet(T thingToPrintAndGet){
        System.out.println(thingToPrintAndGet);
        return thingToPrintAndGet;
    }

    public static <T> String printAndReturnString(T t){
        System.out.println(t);
        return "Hi !" + t.toString();
    }

    public static <T extends Number> void add(T a, T b){

    }
}

class Animal{
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", age: " + this.age;
    }
}

class Pair <K,V>{
   K first;
   V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond(){
        return second;
    }
}
