import Stack.StackManagement;
import Queue.QueueManagement;
import Tree.Bai1;
import Tree.TreeSearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSearch tree = new TreeSearch();
        try (BufferedReader reader = new BufferedReader(new FileReader("Data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                for (String part : parts) {
                    tree.insert(Integer.parseInt(part));
                }
            }
            System.out.println("Du lieu da duoc load tu Data.txt.");
        } catch (IOException e) {
            System.out.println("Loi: Khong the load du lieu tu Data.txt.");
        }
        System.out.println("So can search: ");
        int so = sc.nextInt();
        sc.nextLine();
        System.out.println(tree.search(so));

    }
}