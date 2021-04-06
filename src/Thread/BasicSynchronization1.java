package Thread;

public class BasicSynchronization1 {
    private String mMessage;

    public static void main(String[] agrs) {
        BasicSynchronization1 temp = new BasicSynchronization1();
        System.out.println("Test start!");

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                temp.callMe("Thread1");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                temp.callMe("Thread2");
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

callMe() 함수는 값을 받아서 아래와 같은 작업을 한다.

1. parameter 값을 멤버 변수에 저장하고
2. 랜덤하게 sleep한 후
3. 멤버변수와 parameter와 값이 같지 않으면 로그를 찍는다.

위 함수에서는 절대 로그가 찍히지 않는다.

단, 'synchronized'를 제거하면 로그가 주르륵 찍히는걸 볼 수 있다.

*/