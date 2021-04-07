package Functional;

import java.util.Objects;



@java.lang.FunctionalInterface
interface Supplier<T> {
    T get();
}
/*
(1) 정의
Supplier는 매개변수 없이 반환값만 갖는 함수형 인터페이스이다.
Supplier는 T get()을 추상 메소드를 갖고 있다.
*/



@java.lang.FunctionalInterface
interface Consumer<T> {
    void accept(T t);
    default Consumer<T> andThen(Consumer<? super T> after){
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}
/*
(2) 정의
Consumer는 객체 T를 매개변수로 받아서 사용하며, 반환값은 없는 함수형 인터페이스이다.
Consumer는 void accept(T t)를 추상메소드로 갖는다.
또한 Consumer는 andThen이라는 함수를 제공하고 있는데,
이를 통해 하나의 함수가 끝난 후 다음 Consumer를 연쇄적으로 이용할 수 있다.
아래의 예제에서는 먼저 accept로 받아들인 Consumer를 먼저 처리하고, andThen으로 받은 두번째 Consumer를 처리하고 있다.
*/



@java.lang.FunctionalInterface
interface Function<T, R> {
    R apply(T t);
    default <V> Function<V, R>compose(Function<? super V, ? extends T> before){
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }
    default <V> Function<T, V>andThen(Function<? super R, ? extends V> after){
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }
    static <T> Function<T, T>identity(){
        return t -> t;
    }
}
/*
(3) 정의
Function은 객체 T를 매개변수로 받아서 처리한 후 R로 반환하는 함수형 인터페이스이다.
Function은 R apply(T t)를 추상메소드로 갖는다.
또한 Function은 Consumer와 마찬가지로 andThen을 제공하고 있으며, 추가적으로 compose를 제공하고 있다.
앞에서 andThen은 첫번째 함수가 실행된 이후에 다음 함수를 연쇄적으로 실행하도록 연결해준다고 하였다.
하지만 compose는 첫번째 함수 실행 이전에 먼저 함수를 실행하여 연쇄적으로 연결해준다는 점에서 차이가 있다.
또한 identity 함수가 존재하는데, 이는 자기 자신을 반환하는 static 함수이다.
*/



@java.lang.FunctionalInterface
interface Predicate<T>{
    boolean test(T t);
    default Predicate<T> and(Predicate<? super T> other){
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }
    default Predicate<T> negate(){
        return (t) -> !test(t);
    }
    default Predicate<T> or(Predicate<? super T> other){
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }
    static <T> Predicate<T> isEqual(Object targetRef){
        return (null == targetRef) ? Objects::isNull : object -> targetRef.equals(object);
    }
}
/*
(4) 정의
Predicate는 객체 T를 매개 변수로 받아 처리한 후 Boolean을 반환한다.
Supplier는 Boolean test(T t)을 추상 메소드로 갖고 있다.
*/





public class JavaFunctionalInterface {
    public static void main(String[] args) {

        // (1) 사용 예시
        Supplier<String> supplier = () -> "Hello World!";
        System.out.println(supplier.get());

        // (2) 사용 예시
        Consumer<String> consumer = (str) -> System.out.println(str.split(" ")[0]);
        consumer.andThen(System.out::println).accept("Hello World");

        // (3) 사용 예시
        Function<String, Integer> function = str -> str.length();
        function.apply("Hello World");

        // (4) 사용 예시
        Predicate<String> predicate = (str) -> str.equals("Hello World");
        predicate.test("Hello World");
    }
}
