import Stack.StackManagement;
import Queue.QueueManagement;
import Tree.Bai1;
import Tree.TreeSearch;
import TreeN.QuanLyDanCu;
import com.sun.source.tree.BinaryTree;
import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        TreeSearch tree = new TreeSearch();
//        try (BufferedReader reader = new BufferedReader(new FileReader("Data.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(" ");
//                for (String part : parts) {
//                    tree.insert(Integer.parseInt(part));
//                }
//            }
//            System.out.println("Du lieu da duoc load tu Data.txt.");
//        } catch (IOException e) {
//            System.out.println("Loi: Khong the load du lieu tu Data.txt.");
//        }
//        System.out.println("So can search: ");
//        int so = sc.nextInt();
//        sc.nextLine();
//        System.out.println(tree.search(so));


//        System.out.println("1.duyet truoc 2.duyet sau 3.duyet giua");
//        int choice = sc.nextInt();
//        sc.nextLine();
//        switch (choice){
//            case 1:
//                tree.printPreorder(tree.getRoot());
//                break;
//            case 2:
//                tree.printPostorder(tree.root);
//
//                break;
//            case 3:
//                tree.printInorder(tree.root);
//                break;
//            default:
//        }

        QuanLyDanCu quanLyDanCu = new QuanLyDanCu();
        quanLyDanCu.loadDuLieu();
        quanLyDanCu.createTree();
        quanLyDanCu.thongKe();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập CCCD: ");
        String CCCD = scanner.nextLine();
        quanLyDanCu.hienThongTinCCCD(CCCD);
        quanLyDanCu.printTreeInOrder(quanLyDanCu.country);


        scanner.close();

    }
}