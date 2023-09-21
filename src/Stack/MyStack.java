package Stack;

import java.util.LinkedList;

public class MyStack {
    LinkedList<Integer> list = new LinkedList<>();

    public MyStack() {
    }

    public MyStack(LinkedList<Integer> list) {
        this.list = new LinkedList<Integer>();
    }

    void clear() {
        list.clear();
    }

    boolean isEmpty() {
        return (list.isEmpty());
    }

    void push(Integer x) {
        if (list.isEmpty()) list.add(x);
        else list.addLast(x);
    }

    Integer pop() {
        if (isEmpty()) return (null);
        return (list.removeLast());
    }

    Integer top() {
        if (isEmpty()) return (null);
        return (list.getLast());
    }
}

