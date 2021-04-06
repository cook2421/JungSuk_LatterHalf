package Thread;

public class BasicSynchronization3 {
    private String mHero;

    public static void main(String[] agrs) {
        BasicSynchronization3 tmain = new BasicSynchronization3();
        System.out.println("Test start!");
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                tmain.batman();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                tmain.superman();
            }
        }).start();
        System.out.println("Test end!");
    }

    public synchronized void batman() {
        mHero = "batman";
        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
            if ("batman".equals(mHero) == false) {
                System.out.println("synchronization broken");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void superman() {
        mHero = "superman";
        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
            if ("superman".equals(mHero) == false) {
                System.out.println("synchronization broken");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*

1. synchronized 함수가 두 개인 BasicSynchronization3 클래스의 객체를 생성한다.
2. 두 개의 thread가 객체의 synchronized 함수인 batman()과 superman()을 각각 백만 번 호출한다.
3. batman(), superman() 함수는 mHero란 멤버변수에 각각 다른 값을 세팅하고, 랜덤하게 sleep한 후에 값이 변했는지 체크한다.
4. 값이 변했다면 "synchronization broken" 메시지를 찍는다.

synchronized 함수는 객체에 lock을 건다고 했다.
따라서, 해당 로그는 절대 찍히지 않는다.

두 개의 thread가 각기 다른 synchronized 함수를 호출하지만 객체에 lock이 걸리기 때문에 동시에 호출할 수가 없다.

synchronized로 인하여 객체에 포함된 다른 모든 synchronized의 접근까지 lock이 걸린다.
그래서 synchronized block이 존재한다.

*/
