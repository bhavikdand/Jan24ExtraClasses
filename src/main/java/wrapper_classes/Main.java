package wrapper_classes;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int i = 42;
        Integer wrappedNum = new Integer(42);
        System.out.println("DEBUG");

        // Autoboxing
        wrappedNum = i;
        wrappedNum = 50;

        System.out.println("DEBUG");

        //Unboxing
        int n = wrappedNum;

        System.out.println("DEBUG");

//        List<int> list = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Object obj = new Object();
        obj = new Animal("Dog");
        System.out.println(obj);
    }
}

class Animal{
    String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Name: " + this.name;
    }
}
