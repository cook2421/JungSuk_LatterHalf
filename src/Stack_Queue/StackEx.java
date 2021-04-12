package Stack_Queue;

import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {

        Stack stk = new Stack();

        stk.push("A");
        stk.push("B");
        stk.push("C");

        while(!stk.empty()){
            System.out.println(stk.pop());
        }
    }
}
