package Thread;

public class BasicSynchronization2 {
    private String mMessage;

    public static void main(String[] agrs) {
        BasicSynchronization1 temp1 = new BasicSynchronization1();
        BasicSynchronization1 temp2 = new BasicSynchronization1();

        System.out.println("Test start!");

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                temp1.callMe("Thread1");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                temp2.callMe("Thread2");
            }
        }).start();

        System.out.println("Test end!");
    }

    public synchronized void callMe(String whoCallMe) {
        mMessage = whoCallMe;

        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!mMessage.equals(whoCallMe)) {
            System.out.println(whoCallMe + " | " + mMessage);
        }
    }
}

/*

이번에는 두 개의 객체를 만들어서 각각 thread에서 불렀다.

그리고 callMe() 함수는 더이상 synchronized 함수가 아니다.

이런 경우 thread는 호출하고 있는 각 객체가 다르기 때문에 callMe() 함수에서 로그를 찍지 않는다.

즉, 함수에 synchronized를 걸면 그 함수가 포함된 해당 객체(this)에 lock을 거는 것과 같다.

*/

