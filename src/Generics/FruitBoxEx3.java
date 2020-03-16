package Generics;

import java.util.ArrayList;

class Fruit3                { public String toString() { return "Fruit"; }}
class Apple3 extends Fruit3 { public String toString() { return "Apple"; }}
class Grape3 extends Fruit3 { public String toString() { return "Grape"; }}


class Juice {
    String name;

    Juice(String name)       { this.name = name + "Juice"; }
    public String toString() { return name;                }
}


class Juicer {
    static <T extends Fruit3> Juice makeJuice(FruitBox2<T> box) {  // 지네릭 메서드
//  static Juice makeJuice(FruitBox2<? extends Fruit3> box) {
        String tmp = "";

        for(Fruit3 f : box.getList())
            tmp += f + " ";
        return new Juice(tmp);
    }
}


public class FruitBoxEx3 {
    public static void main(String[] args) {
        FruitBox2<Fruit3> fruitBox = new FruitBox2<>();
        FruitBox2<Apple3> appleBox = new FruitBox2<>();

        fruitBox.add(new Apple3());
        fruitBox.add(new Grape3());
        appleBox.add(new Apple3());
        appleBox.add(new Apple3());

        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(appleBox));
    } // main
}


class FruitBox2<T extends Fruit3> extends Box3<T> {}


class Box3<T> {
    ArrayList<T> list = new ArrayList<>();

    void add(T item)         { list.add(item);         }
    T get(int i)             { return list.get(i);     }
    ArrayList<T> getList()   { return list;            }
    int size()               { return list.size();     }
    public String toString() { return list.toString(); }
}





/*
*       <? extends T>  :  와일드카드의 상한 제한. T와 그 자손들만 가능
*       <? super T>    :  와일드카드의 하한 제한. T와 그 조상들만 가능
*       <?>            :  제한 없음. 모든 타입이 가능. <? extends object>와 동일
* */