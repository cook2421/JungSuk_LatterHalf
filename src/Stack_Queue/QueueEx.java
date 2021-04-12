package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
    public static void main(String[] args) {

        Queue que = new LinkedList();

        que.add("A");
        que.add("B");
        que.add("C");

        while(!que.isEmpty()){
            System.out.println(que.poll());
        }
    }
}
