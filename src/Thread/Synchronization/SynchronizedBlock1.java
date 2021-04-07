package Thread.Synchronization;

import java.util.ArrayList;

public class SynchronizedBlock1 {

    public ArrayList<Integer> mList = new ArrayList<>();

    public static void main(String[] agrs) throws InterruptedException {

        SynchronizedBlock1 SynchronizedBlock1 = new SynchronizedBlock1();

        System.out.println("Test start!");

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                SynchronizedBlock1.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                SynchronizedBlock1.add(i);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(SynchronizedBlock1.mList.size());

        System.out.println("Test end!");
    }

    public void add(int val) { /* * Code for synchronization is not needed * */
        synchronized (this) {
            if (mList.contains(val) == false) {
                mList.add(val);
            }
        }
    }
}

/*

1. SynchronizedBlock1 객체를 하나 만든다.
2. SynchronizedBlock1 객체에는 add() 함수가 있고, 내부에 동기화가 필요한 부분에만 synchronized(this) 블록으로 처리한다.
3. 두 개의 thread로 동시에 생성한 SynchronizedBlock1 객체의 add() 함수를 호출한다.

예제에서는 "Code for synchronization is not needed"로 주석으로 표시해 놓은 곳에 동기화가 필요없는
다른 코드를 넣으면 된다.

*/