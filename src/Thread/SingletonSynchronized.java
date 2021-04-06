package Thread;

import java.util.ArrayList;

public class SingletonSynchronized {

    public ArrayList<Integer> mList = new ArrayList<>();

    private SingletonSynchronized() {
    }

    private static class Holder {
        public static final SingletonSynchronized sHolderSingleton = new SingletonSynchronized();
    }

    public static SingletonSynchronized getInstance() {
        return Holder.sHolderSingleton;
    }

    public static void main(String[] agrs) throws InterruptedException {
        System.out.println("Test start!");
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                SingletonSynchronized.getInstance().add(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                SingletonSynchronized.getInstance().add(i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(SingletonSynchronized.getInstance().mList.size());
        System.out.println("Test end!");
    }

    public synchronized void add(int val) {
        if (mList.contains(val) == false) {
            mList.add(val);
        }
    }
}

/*

1. holder pattern으로 singleton 객체를 생성하도록 한다. (singleton 객체 생성에 동기화 이슈를 해결)
2. 각 thread에서 getInstance()를 통하여 객체를 얻고 10000번 add() 함수를 부른다.
3. add 함수는 synchronized가 되어있으므로 this를 lock으로 사용하게 된다.

사실 singleton이라고 해서 다르지 않다는걸 알 수 있다.
따라서 singleton 객체는 multi-thread를 사용하는 환경에서는 그닥 좋은 패턴이 아니다.
singleton에 synchronized 함수가 많을수록 multi-thread는 병목 현상을 겪게 되므로 애껏, multi-thread로 만들어 놓고
singleton을 만나면서 single thread처럼 동작하게 되는 것이다.

따라서 multi-thread 환경에서는 공유해야 할 객체가 아니라면, new로 객체를 새로 생성하는 것을 추천한다.
필요할 때마다 new 생성해서 쓰고 버리면 된다.
버리는건 GC가 알아서 해주기 때문이다.

*/