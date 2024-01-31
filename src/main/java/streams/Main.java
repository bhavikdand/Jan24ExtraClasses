package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,2,3,4,4,5);

        Stream<Integer> stream = l.stream();
        stream.forEach((element) -> System.out.println(element));

        System.out.println("******");
        l.stream()
                .filter(e ->  e % 2 == 0)
                .forEach(e -> System.out.println(e));

        System.out.println("******");
        l.stream()
                .filter(e -> e%2 == 0)
                .distinct()
                .forEach(e -> System.out.println(e));

        System.out.println("******");
        Stream<Integer> s1 = l.stream();
        s1= s1.filter(e -> e%2 == 0);
        s1 =s1.distinct();
        s1.forEach(e -> System.out.println(e));

        // Map (intermediate op)
        // 1. change data type of the underlying stream
        List<String> strings = Arrays.asList("Bhavik", "Riya", "Sushil", "Ejazul", "Bhavna");
        // Create a new list which contains length of strings in the original list:
        // [6, 4, 6, 6]
        List<Integer> collect = strings.stream()
//                .filter(e -> e.startsWith("B"))
                .map(e -> e.length())
                .collect(Collectors.toList());
        System.out.println(collect);
        // 2. change the data of the underlying stream
        // Take all distinct even numbers and square them up and print it

        System.out.println("******");
        l.stream()
                .filter(e -> e%2 == 0)
                .distinct()
                .map(e -> e*e)
                .forEach(e -> System.out.println(e));

        // Lazy evalutation

        //Arrays.asList("Bhavik", "Riya", "Sushil", "Ejazul", "Bhavna");
        List<Integer> collect1 = strings.stream()
                .filter(e -> {
                    System.out.println("Filtering:" + e);
                    return e.length() > 4;
                })
                .map(e -> {
                    System.out.println("Mapping:" + e);
                    return e.length();
                })
                .collect(Collectors.toList());

        List<Integer> ans = new ArrayList<>();
        for(String s: strings){
            if(s.length() > 4){ // filter
                ans.add(s.length()); // map +  collect
            }
        }

        // print the count of even element in the list

        long count = l.stream()
                .filter(e -> e % 2 == 0)
                .count();
        System.out.println("Even count: " + count);

        List<Integer> li = Arrays.asList(43,21,16,-10,35,5600,-7900);
        // Create a new list of odd numbers in sorted format
        List<Integer> sortedOdd = li.parallelStream()
                .filter(e -> e % 2 != 0)
                .sorted((o1,o2) -> o2-o1)
                .collect(Collectors.toList());

        System.out.println("Sorted odd: " + sortedOdd);

        List<Student> students = Arrays.asList(new Student("A", 10), new Student("A", 20), new Student("B", 30));
        Collections.shuffle(students);
        System.out.println("List:" + students);
        students= students.stream()
                .sorted((o1,o2) -> {
                    if(o1.name.equals(o2.name)){
                        return o1.age -o2.age;
                    }
                    return o1.name.compareTo(o2.name);
                })
                .collect(Collectors.toList());

        System.out.println(students);
    }
}

class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name:" + name + ", age:" + age;
    }
}
