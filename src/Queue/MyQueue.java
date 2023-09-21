package Queue;

import java.util.LinkedList;

public class MyQueue {
    LinkedList<Customer> t;

    MyQueue() {
        t = new LinkedList<Customer>();
    }

    void clear() {
        t.clear();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }


    void enqueue(Customer x) {
        t.addLast(x);
    }

    Customer dequeue() {
        if (isEmpty()) return (null);
        return (t.removeFirst());
    }

    Customer getFirst() {
        return t.getFirst();
    }

    void display() {
        for (Customer customer : t) {
            System.out.println(customer.getId() + " - " + customer.getName() + " - " + customer.getWork());
        }
    }


}
