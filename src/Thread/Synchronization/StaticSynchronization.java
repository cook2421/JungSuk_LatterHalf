package Thread.Synchronization;

public class StaticSynchronization {

    private static String HERO;

    public static void main(String[] agrs) {
        System.out.println("Test start!");

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                StaticSynchronization.batman();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                StaticSynchronization.superman();
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
}

/*

1. static synchronized 함수가 두 개인 Singleton 클래스를 만든다.
2. 두 개의 thread가 static synchronized 함수인 batman()과 superman()을 각각 백만 번씩 호출한다.
3. batman(), superman() 함수는 "HERO"란 static 변수에 각각 다른 값을 세팅하고, 랜덤하게 sleep한 후에 값이 변했는지 체크한다.
4. 값이 변했다면 "synchronization broken" 메시지를 찍는다.

이 예제는 절대 "synchronized broken ...' 로그가 찍히지 않는다.
즉, static 함수라도 함수간 동기화가 잘 지켜진다.
static 함수의 경우 해당 class에 lock을 건다.

*/