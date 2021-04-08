package Recursive;

public class PrintFibonacciNumber {

    // 2 이상의 정수 n이 주어질 때 피보나치 수열을 n항까지 출력하라
    static int num1 = 0, num2 = 1, num3 = 0;    // 초기값

    static void printFibonacciNumber(int count) {   // 10, 9, 8, 7, 6, 5, 4, 3, 2

        if (count > 1) {
            num3 = num1 + num2;     // 1, 2, 3, 5, 8, 13, 21, 34, 55
            num1 = num2;    // 1, 1, 2, 3, 5, 8, 13, 21, 34
            num2 = num3;    // 1, 2, 3, 5, 8, 13, 21, 34, 55

            System.out.println(num3 + " ");
            printFibonacciNumber(count-1);
        }
    }

    public static void main(String[] args) {
        int num = 10;
        System.out.printf("0 1 ");
        printFibonacciNumber(num);
    }
}
