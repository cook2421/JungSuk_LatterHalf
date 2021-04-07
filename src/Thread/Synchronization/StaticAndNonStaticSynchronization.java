package Thread.Synchronization;

public class StaticAndNonStaticSynchronization {
    private static String HERO;

    public static void main(String[] agrs) {

        System.out.println("Test start!");

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                StaticAndNonStaticSynchronization.batman();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                StaticAndNonStaticSynchronization.superman();
            }
        }).start();

        StaticAndNonStaticSynchronization sfunction = new StaticAndNonStaticSynchronization();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                sfunction.ironman();
            }
        }).start();

        System.out.println("Test end!");
    }

    public static synchronized void batman() {
        HERO = "batman";
        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
            if ("batman".equals(HERO) == false) {
                System.out.println("synchronization broken - batman");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void superman() {
        HERO = "superman";
        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
            if ("superman".equals(HERO) == false) {
                System.out.println("synchronization broken - superman");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void ironman() {
        HERO = "ironman";
        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
            if ("ironman".equals(HERO) == false) {
                System.out.println("synchronization broken - ironman");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*

batman()과 superman()은 class를 lock으로 사용하지만 ironman()은 생성된 객체를 기준으로 lock을 잡기 때문에 서로 따로 논다.
따라서 ironman이 "HERO" 변수를 계속 바꿔치기 하기 때문에 전부 lock이 틀어지는 것이다.

multi-thread 환경에서는 new로 객체를 생성해서 쓰는게 가장 좋다.
그게 아니라면 자바에서 지원하는 다음 동기화 기법들을 잘 활용하면 된다.

* synchronized
* 동기화 지원 자료구조
* Atomic
* java8의 stream
* completableFuture

*/
