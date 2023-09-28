package TreeN;

import java.util.ArrayList;
import java.util.List;

public class Xa {
    private String maXa;
    private String maHuyen;
    private String tenXa;
    private List<Dan> danList;

    public Xa(String maXa, String maHuyen, String tenXa) {
        this.maXa = maXa;
        this.maHuyen = maHuyen;
        this.tenXa = tenXa;
        this.danList = new ArrayList<>();

    }

    public String getMaXa() {
        return maXa;
    }

    public String getMaHuyen() {
        return maHuyen;
    }

    public String getTenXa() {
        return tenXa;
    }
    public List<Dan> getDanList() {
        return danList;
    }

    public void addDan(Dan dan) {
        danList.add(dan);
    }
}
