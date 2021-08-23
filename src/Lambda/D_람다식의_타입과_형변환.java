package Lambda;


@FunctionalInterface
interface MyFunction2 {
    void myMethod();        // public abstract void myMethod();
}

public class D_람다식의_타입과_형변환 {
    public static void main(String[] args) {
        MyFunction2 f = () -> {};                   // MyFunction f = (MyFunction)(() -> {});
        Object obj = (MyFunction2)(() -> {});       // Object 타입으로 형변환이 생략됨. 원래 (Object)(MyFunction2)(() -> {})
        String str = ((Object)(MyFunction2)(() -> {})).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);

//        System.out.println(() -> {});                             // 에러. 람다식은 Object 타입으로 형변환 안됨.
        System.out.println((MyFunction2)(() -> {}));
//        System.out.println((MyFunction2)(() -> {}).toString());   // 에러.
        System.out.println(((Object)(MyFunction2)(() -> {})).toString());
    }
}

/*
Functional.jungsuk.LambdaEx2$$Lambda$14/0x0000000800066840@6b71769e
Functional.jungsuk.LambdaEx2$$Lambda$15/0x0000000800066c40@2752f6e2
Functional.jungsuk.LambdaEx2$$Lambda$16/0x0000000800066040@6bdf28bb
Functional.jungsuk.LambdaEx2$$Lambda$17/0x0000000800066440@1cd072a9
Functional.jungsuk.LambdaEx2$$Lambda$18/0x0000000800065840@4c203ea1

실행결과를 보면, 컴파일러가 람다식의 타입을 어떤 형식으로 만들어내는지 알 수 있다.
일반적인 익명 객체라면, 객체의 타입이 '외부클래스이름$번호'와 같은 형식으로 타입이 결정되었을텐데,
람다식의 타입은 '외부클래스이름.$$Lambda$번호'와 같은 형식으로 되어 있는 것을 확인할 수 있다.


*/
