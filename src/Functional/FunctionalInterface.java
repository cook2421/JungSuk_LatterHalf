package Functional;

class PastLambdaFunction {}

@java.lang.FunctionalInterface
interface LambdaFunction {
    int max(int a, int b);
}

public class FunctionalInterface {
    public static void main(String[] args) {

        // 기존의 익명 함수
        System.out.println(new PastLambdaFunction(){
            public int max(int a, int b){
                return a > b ? a : b;
            }
        }.max(3, 5));


        // 람다식을 이용한 익명함수
        LambdaFunction lambdaFunction = (int a, int b) -> a > b ? a : b;
        System.out.println(lambdaFunction.max(3,5));
    }
}
