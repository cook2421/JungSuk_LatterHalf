package Recursive;

public class Recursion {

    // Recursion Example1
    static void printHelloInfinite(){
        System.out.println("hello");
        printHelloInfinite();
    }

    // Recursion Example2
    static void printHello(int endNum){
        if(endNum > 0){
            System.out.println("hello " + endNum);
            printHello(endNum-1);
        }
    }

    // Recursion Example3
    static int factorial(int i){
        if(i == 1) return 1;
        else return i * factorial(i - 1);
    }

    // Recursion Example4
    // 0 이상의 정수 n이 주어질 때 n번째 피보나치 수를 구하라
    static int getNthFibonacciNumber(int n){
        if(n < 2) return n;
        else return getNthFibonacciNumber(n - 2) + getNthFibonacciNumber(n - 1);
    }

    // Recursion Example5
    // 2 이상의 정수 n이 주어질 때 피보나치 수열을 n항까지 출력하라
    static int num1 = 0, num2 = 1, num3 = 0;    // 초기값
    static void printFibonacciNumber(int count) {   // 10, 9, 8, 7, 6, 5, 4, 3, 2
        if (count > 1) {
            num3 = num1 + num2;     // 1, 2, 3, 5, 8, 13, 21, 34, 55
            num1 = num2;            // 1, 1, 2, 3, 5, 8, 13, 21, 34
            num2 = num3;            // 1, 2, 3, 5, 8, 13, 21, 34, 55

            System.out.printf(num3 + " ");
            printFibonacciNumber(count-1);
        }
    }

    public static void main(String[] args) {

        System.out.println("======== Recursion Example1 ========");
        System.out.println("This code causes an error.");
        //printHelloInfinite();

        System.out.println("======== Recursion Example2 ========");
        printHello(5);

        System.out.println("======== Recursion Example3 ========");
        System.out.println("5!=" + factorial(5));

        System.out.println("======== Recursion Example4 ========");
        System.out.println("10th Fibonacci number is " + getNthFibonacciNumber(10));

        System.out.println("======== Recursion Example5 ========");
        int num = 10;
        System.out.printf("0 1 ");
        printFibonacciNumber(num);
    }
}
