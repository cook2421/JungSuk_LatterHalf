package Recursive;

public class WithEndCondition {
    static void printHello(int endNum){
        if(endNum > 0){
            printHello(endNum-1);
            System.out.println("hello " + endNum);
        }
    }

    public static void main(String[] args) {
        printHello(5);
    }
}
