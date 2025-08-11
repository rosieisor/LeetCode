import java.util.*;

class MyStack {

    // 1. Deque 사용
    // Deque<Integer> deque;

    // 2. 두 개의 Queue 사용
    Queue<Integer> q1;      // 큐
    Queue<Integer> q2;      // 리버스 큐

    public MyStack() {
        // deque = new LinkedList<>();

        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        // deque.offer(x);

        q1.offer(x);
    }
    
    public int pop() {
        // return deque.pollLast();

        System.out.println(q1.size());
        while(q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int data = q1.poll();
        q1 = q2;
        q2 = new LinkedList<>();

        return data;
    }
    
    public int top() {
        // return deque.getLast();

        while(q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int data = q1.poll();
        q2.offer(data);
        q1 = q2;
        q2 = new LinkedList<>();

        return data;
    }
    
    public boolean empty() {
        // return deque.isEmpty();

        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */