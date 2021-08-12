package Generics;

import java.util.ArrayList;

class Fruit2 implements Eatable {
    public String toString() { return "Fruit"; }
}
class Apple2 extends Fruit2 { public String toString() { return "Apple"; }}
class Grape2 extends Fruit2 { public String toString() { return "Grape"; }}
class Toy2                 { public String toString() { return "Toy";   }}


interface Eatable {}


public class FruitBoxEx2 {
    public static void main(String[] args) {
        FruitBox1<Fruit2> fruitBox  = new FruitBox1<>();
        FruitBox1<Apple2> appleBox  = new FruitBox1<>();
        FruitBox1<Grape2> grapeBox  = new FruitBox1<>();
//      FruitBox<Grape2> grapeBox2 = new FruitBox<Apple2>();    // 에러. 타입 불일치
//      FruitBox<Toy2>   toyBox    = new FruitBox<Toy2>();      // 에러. 타입 변수 불일치

        fruitBox.add(new Fruit2());
        fruitBox.add(new Apple2());
        fruitBox.add(new Grape2());
        appleBox.add(new Apple2());
//      appleBox.add(new Grape2());     // 에러. Grape는 Apple의 자손이 아님
        grapeBox.add(new Grape2());

        System.out.println("fruitBox-"+fruitBox);
        System.out.println("appleBox-"+appleBox);
        System.out.println("grapeBox-"+grapeBox);
    } // main
}

/** 클래스 Fruit2의 자손이면서 Eatable 인터페이스도 구현해야 한다면 **/
class FruitBox1<T extends Fruit2 & Eatable> extends Box2<T> {}


class Box2<T> {
    ArrayList<T> list = new ArrayList<>();

    void add(T item)    { list.add(item);     }
    T get(int i)        { return list.get(i); }
    int size()          { return list.size(); }
    public String toString() { return list.toString(); }
}