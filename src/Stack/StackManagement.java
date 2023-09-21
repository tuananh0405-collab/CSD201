package Stack;

import java.util.Scanner;

public class StackManagement {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        String num;
        do {
            System.out.print("user enter a positive number: ");
            num = sc.nextLine();

            if (!isPositive(num)) System.out.println("input again");
        } while (!isPositive(num));

        convertToBinary(num);


    }

    public static boolean isPositive(String x) {
        return String.valueOf(x).matches("[0-9]+") && Integer.parseInt(x) > 0;

    }

    public static void convertToBinary(String numb) {
        Integer num = Integer.parseInt(numb);
        MyStack stack = new MyStack();

        while (num > 0) {
            int r = num % 2;
            stack.push(r);
            num /= 2;
        }

        System.out.print("Binary equivalent: ");

        while (!(stack.isEmpty())) {
            System.out.print(stack.pop());
        }

    }
}
