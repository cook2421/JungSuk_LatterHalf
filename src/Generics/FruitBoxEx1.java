package Generics;

import java.util.ArrayList;

class Fruit1               { public String toString() { return "Fruit"; }}
class Apple1 extends Fruit1 { public String toString() { return "Apple"; }}
class Grape1 extends Fruit1 { public String toString() { return "Grape"; }}
class Toy1                 { public String toString() { return "Toy";   }}


class Fruit1BoxEx1 {
    public static void main(String[] args) {
        Box1<Fruit1> FruitBox = new Box1<>();
        Box1<Apple1> AppleBox = new Box1<>();
        Box1<Toy1>   ToyBox   = new Box1<>();
//      Box<Grape1> GrapeBox = new Box<Apple1>();  // 에러. 타입 불일치

        FruitBox.add(new Fruit1());
        FruitBox.add(new Apple1());   // OK. void add(Fruit1 item)

        AppleBox.add(new Apple1());
        AppleBox.add(new Apple1());
//      Apple1Box.add(new Toy1());     // 에러. Box<Apple1>에는 Apple1만 담을 수 있음

        ToyBox.add(new Toy1());
//      ToyBox.add(new Apple1());     // 에러. Box<Toy1>에는 Apple1을 담을 수 없음

        System.out.println(FruitBox);
        System.out.println(AppleBox);
        System.out.println(ToyBox);
    } // main의 끝
}


class Box1<T> {
    ArrayList<T> list = new ArrayList<>();

    void add(T item) { list.add(item);     }
    T get(int i)     { return list.get(i); }
    int size()       { return list.size(); }
    public String toString() { return list.toString(); }
}