package Thread;

import java.util.HashMap;

public class SynchronizedBlock2 {
    private HashMap<String, String> mMap1 = new HashMap<>();
    private HashMap<String, String> mMap2 = new HashMap<>();

    public static void main(String[] agrs) {
        SynchronizedBlock2 SynchronizedBlock2 = new SynchronizedBlock2();
        System.out.println("Test start!");
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                SynchronizedBlock2.put1("A", "B");
                SynchronizedBlock2.get2("C");
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                SynchronizedBlock2.put2("C", "D");
                SynchronizedBlock2.get1("A");
            }
        }).start();
        System.out.println("Test end!");
    }

    public void put1(String key, String value) {
        synchronized (this) {
            mMap1.put(key, value);
        }
    }

    public String get1(String key) {
        synchronized (this) {
            return mMap1.get(key);
        }
    }

    public void put2(String key, String value) {
        synchronized (this) {
            mMap2.put(key, value);
        }
    }

    public String get2(String key) {
        synchronized (this) {
            return mMap2.get(key);
        }
    }
}

/*

1. 일반 함수 put1(), get1(), put2(), get2()를 갖는 SynchronizedBlock2 객체를 생성한다.
2. 객체는 두 개의 hashMap을 갖는다.
3. 네 개의 함수 내부에 동기화가 필요한 부분을 synchronized(this) {...} 로 묶는다.
4. 두 개의 쓰레드로 서로 번갈아 가면서 네 개의 함수를 만 번 호출한다.

이 경우 네 개의 메소드 안의 synchronized(this) 블럭으로 감싸진 부분은 동시에 호출되지 않는다.
어떤 쓰레드든지 synchronized(this) block에 들어가는 순간 자원을 선점하고 lock을 걸어둔다.
단, lock의 주체가 this이기 때문에 this로 걸려있는 동기화 block은 해당 lock이 풀릴 때까지 대기해야 한다.

*/