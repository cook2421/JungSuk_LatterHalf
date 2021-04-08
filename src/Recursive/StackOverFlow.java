package Recursive;

public class StackOverFlow {
    static void printHelloInfinite(){
        System.out.println("hello");
        printHelloInfinite();
    }

    public static void main(String[] args) {
        printHelloInfinite();
    }
}
