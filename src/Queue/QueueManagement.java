package Queue;

import java.util.LinkedList;
import java.util.Scanner;

public class QueueManagement {
    Scanner sc = new Scanner(System.in);
    MyQueue wait = new MyQueue();
    int stt = 0;
    LinkedList<Customer> serving = new LinkedList<Customer>();
    LinkedList<Customer> served = new LinkedList<Customer>();

    public void run() {


        while (true) {
            System.out.println("choose 1 option:");
            System.out.println("1. go to wait list");
            System.out.println("2. get first customer in wait list to serving list");
            System.out.println("3. choose 1 customer in serving list and add to served list");
            System.out.println("4. report one customer");
            System.out.println("5. exit");

            System.out.println("your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addToWaitList();
                    break;
                case 2:
                    addToServingList();
                    break;
                case 3:
                    addToServedList();
                    break;
                case 4:
                    report();
                    break;
                case 5:
                    System.out.println("exit...");
                    System.exit(0);
                default:
                    System.out.println("not an option");
            }
            if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                break;
            }
        }


    }

    void report() {
try{
    if (!wait.isEmpty()) {
        System.out.println("display wait list:");
        wait.display();
    } else System.out.println("no one in wait list");

    if (!serving.isEmpty()) {
        System.out.println("display serving list: ");
        for (Customer customer : serving) {
            System.out.println(customer.getId() + " - " + customer.getName() + " - " + customer.getWork());
        }
    } else System.out.println("no one in serving list");


    if (!served.isEmpty()) {
        System.out.println("display served list: ");
        for (Customer customer : served) {
            System.out.println(customer.getId() + " - " + customer.getName() + " - " + customer.getWork());
        }
    } else System.out.println("no one in served list");
}catch (Exception e){
    System.out.println("no one to report");
}


    }

    void addToServedList() {
        try{
            if (!serving.isEmpty()) {
                System.out.println("display serving list: ");
                for (Customer customer : serving) {
                    System.out.println(customer.getId() + " - " + customer.getName() + " - " + customer.getWork());
                }
            } else System.out.println("no one in serving list");
            System.out.println("id of customer has been served : ");
            int id = sc.nextInt();
            sc.nextLine();
            boolean cohayko = false;
            for (Customer customer : serving) {
                if (customer.getId() == id) {
                    served.add(customer);
                    serving.remove(customer);
                    cohayko = true;
                }
            }
            if (cohayko == false) System.out.println("not existed id");
            if (!served.isEmpty()) {
                System.out.println("display served list: ");
                for (Customer customer : served) {
                    System.out.println(customer.getId() + " - " + customer.getName() + " - " + customer.getWork());
                }
            } else System.out.println("no one in served list");
        }catch (Exception e){
            System.out.println("no one to be served");
        }

    }

    void addToServingList() {
        try{
            Customer firstone = wait.dequeue();
            serving.add(firstone);
            if (!serving.isEmpty()) {
                System.out.println("display serving list: ");
                for (Customer customer : serving) {
                    System.out.println(customer.getId() + " - " + customer.getName() + " - " + customer.getWork());
                }
            } else System.out.println("no one in serving list");

        }catch (Exception e){
            System.out.println("no one in wait list");
        }

    }

    void addToWaitList() {
        System.out.println("input customer information: ");
        System.out.print("name: ");
        String name = sc.nextLine();
        System.out.print("work: ");
        String work = sc.nextLine();
        stt++;
        Customer customer = new Customer(stt, name, work);
        wait.enqueue(customer);
        if (!wait.isEmpty()) {
            System.out.println("display wait list:");
            wait.display();
        } else System.out.println("no one in wait list");

    }
}
