package lambdas;

public class Main {

    public static void main(String[] args) {
        A a = new A(){
            public void show(){
                System.out.println("I am in B");
            }
        };
        a.show();

        B b = new B(){
            public void doSomething(){
                System.out.println("I am in do something");
            }
        };
        b.doSomething();



        C c = new C(){
            @Override
            public void show() {

                System.out.println("I am in abs class show");
            }

            @Override
            public void demo() {
                System.out.println("I am in abs class demo");
            }

        };
        c.demo();
        c.show();

        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println("I am in new thread: " + Thread.currentThread().getName());
            }
        };
        Thread t = new Thread(r);
        t.start();


        Runnable r1 = () -> System.out.println("I am in new thread with lambda: " + Thread.currentThread().getName());
        Thread t1 = new Thread(r1);
        t1.start();

        D d = num -> {
          num = num +5;
            System.out.println("Modified num: " + num);
        };
        d.demo(10);

        Math m = (num1, num2)  -> System.out.println("Ans:" + (num1+num2));
        m.add(1,2);

        Math1 m1 = (num1, num2) -> {
            System.out.println("Nums: " + num1 + ", " + num2);
            return num1-num2;
        };
        System.out.println(m1.sub(5,3));

        Math1 m2 = (num1, num2) -> num1-num2;

        System.out.println(m2.sub(10, 15));

        // Break for 5 mins, till 10.12 PM

    }
}

class A {
    public void show(){
        System.out.println("I am in A");
    }
}

@FunctionalInterface
interface B {
    void doSomething();

}

abstract class C{
    public abstract void show();
    public abstract void demo();
}

interface D{
    void demo(int n);
}

interface Math {
    void add(int a, int b);
}

interface Math1{
    int sub(int a, int b);
}
