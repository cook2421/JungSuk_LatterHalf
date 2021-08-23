package Lambda;


@FunctionalInterface
interface MyFunction3 {
    void myMethod();
}

class Outer {
    int val = 10;       // Outer.this.val

    class Inner {
        int val = 20;   // this.val

        void method(int i) {    // void method(final int i) {
            int val = 30;       // final int val = 30;
//            i = 10;             // 에러. 상수의 값을 변경할 수 없음.

            MyFunction3 f = () -> {                                 // MyFunction3 f = (i) -> {     에러. 외부 지역변수와 이름이 중복됨.
                System.out.println("             i :" + i);                     // 100
                System.out.println("           val :" + val);                   // 30
                System.out.println("      this.val :" + ++this.val);            // 21
                System.out.println("Outer.this.val :" + ++Outer.this.val);      // 11
            };

            f.myMethod();
        }
    }   // Inner 클래스의 끝
}   // Outer 클래스의 끝


public class E_외부_변수를_참조하는_람다식 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);
    }
}

/*
이 예제는 람다식 내에서 외부에 선언된 변수에 접근하는 방법을 보여준다.
람다식 내에서 참조하는 지역변수는 final이 붙지 않았어도 상수로 간주된다.
람다식 내에서 지역변수 i와 val을 참조하고 있으므로 람다식 내에서나 다른 어느 곳에서도 이 변수들의 값을 변경하는 일은 허용되지 않는다.

반면에 Inner 클래스와 Outer 클래스의 인스턴스 변수인 this.val과 Outer.this.val은 상수로 간주되지 않으므로 값을 변경해도 된다.

그리고 외부 지역변수와 같은 이름의 람다식 매개변수는 허용되지 않는다.
*/
