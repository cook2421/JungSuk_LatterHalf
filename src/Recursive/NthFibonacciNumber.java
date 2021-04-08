package Recursive;

public class NthFibonacciNumber {
    // 0 이상의 정수 n이 주어질 때 n번째 피보나치 수를 구하라
    static int getNthFibonacciNumber(int n){
        if(n < 2){
            return n;
        } else {
            return getNthFibonacciNumber(n - 2) + getNthFibonacciNumber(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("10th Fibonacci number is " + getNthFibonacciNumber(10));
    }
}
