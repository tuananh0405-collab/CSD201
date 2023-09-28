package TreeN;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QuanLyDanCu {
    private Map<String, Tinh> tinhMap;
    private Map<String, Huyen> huyenMap;
    private Map<String, Xa> xaMap;
    private Map<String, Dan> danMap;

    public TreeNode country = new TreeNode("Vietnam");; // Represents the root of the tree

    public QuanLyDanCu() {
        tinhMap = new HashMap<>();
        huyenMap = new HashMap<>();
        xaMap = new HashMap<>();
        danMap = new HashMap<>();
    }

    public void loadDuLieu() {
        try {
            BufferedReader reader;

            // Load dữ liệu Tỉnh
            reader = new BufferedReader(new FileReader("Tinh.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String maTinh = parts[0].trim();
                String tenTinh = parts[1].trim();
                Tinh tinh = new Tinh(maTinh, tenTinh);
                tinhMap.put(maTinh, tinh);
            }
            reader.close();

            // Load dữ liệu Huyện
            reader = new BufferedReader(new FileReader("Huyen.txt"));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String maHuyen = parts[0].trim();
                String maTinh = parts[1].trim();
                String tenHuyen = parts[2].trim();
                Huyen huyen = new Huyen(maHuyen, maTinh, tenHuyen);
                huyenMap.put(maHuyen, huyen);
            }
            reader.close();

            // Load dữ liệu Xã
            reader = new BufferedReader(new FileReader("Xa.txt"));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String maXa = parts[0].trim();
                String maHuyen = parts[1].trim();
                String tenXa = parts[2].trim();
                Xa xa = new Xa(maXa, maHuyen, tenXa);
                xaMap.put(maXa, xa);
            }
            reader.close();

            // Load dữ liệu Dân
            reader = new BufferedReader(new FileReader("Dan.txt"));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String maXa = parts[0].trim();
                String CCCD = parts[1].trim();
                String ten = parts[2].trim();
                String ngaySinh = parts[3].trim();
                Dan dan = new Dan(maXa, CCCD, ten, ngaySinh);
                danMap.put(CCCD, dan);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createTree() {
        for (Tinh tinh : tinhMap.values()) {
            TreeNode tinhNode = new TreeNode(tinh.getTenTinh());

            for (Huyen huyen : huyenMap.values()) {
                if (huyen.getMaTinh().equals(tinh.getMaTinh())) {
                    TreeNode huyenNode = new TreeNode(huyen.getTenHuyen());

                    for (Xa xa : xaMap.values()) {
                        if (xa.getMaHuyen().equals(huyen.getMaHuyen())) {
                            TreeNode xaNode = new TreeNode(xa.getTenXa());

                            for (Dan dan : danMap.values()) {
                                if (dan.getMaXa().equals(xa.getMaXa())) {
                                    TreeNode danNode = new TreeNode(dan.getTen());
                                    xaNode.addChild(danNode);
                                }
                            }

                            huyenNode.addChild(xaNode);
                        }
                    }

                    tinhNode.addChild(huyenNode);
                }
            }

            country.addChild(tinhNode);
        }
    }
    public void printTreeInOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        // Traverse left subtree (Tinh, Huyen, Xa, Dan)
        for (TreeNode child : node.getChildren().values()) {
            printTreeInOrder(child);
        }

        // Print the node's name (Country, Tinh, Huyen, Xa, Dan)
        System.out.println(node.getName());
    }    public void thongKe() {
        int soLuongTinh = tinhMap.size();
        int soLuongHuyen = huyenMap.size();
        int soLuongXa = xaMap.size();
        System.out.println("Số lượng tỉnh: " + soLuongTinh);
        System.out.println("Số lượng huyện: " + soLuongHuyen);
        System.out.println("Số lượng xã: " + soLuongXa);
    }

    public void hienThongTinCCCD(String CCCD) {
        if (danMap.containsKey(CCCD)) {
            Dan dan = danMap.get(CCCD);
            String maXa = dan.getMaXa();
            String maHuyen = xaMap.get(maXa).getMaHuyen();
            String maTinh = huyenMap.get(maHuyen).getMaTinh();

            Tinh tinh = tinhMap.get(maTinh);
            Huyen huyen = huyenMap.get(maHuyen);
            Xa xa = xaMap.get(maXa);

            System.out.println("Thông tin CCCD: " + CCCD);
            System.out.println("Tên tỉnh: " + tinh.getTenTinh());
            System.out.println("Tên huyện: " + huyen.getTenHuyen());
            System.out.println("Tên xã: " + xa.getTenXa());
            System.out.println("Họ tên: " + dan.getTen());
            System.out.println("Ngày sinh: " + dan.getNgaySinh());
        } else {
            System.out.println("Không tìm thấy thông tin cho CCCD " + CCCD);
        }
    }

}
