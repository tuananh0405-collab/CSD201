package TreeN;

import java.util.HashMap;
import java.util.Map;

public class Huyen {
    private String maHuyen;
    private String maTinh;
    private String tenHuyen;
    private Map<String, Xa> xaMap;

    public Huyen(String maHuyen, String maTinh, String tenHuyen) {
        this.maHuyen = maHuyen;
        this.maTinh = maTinh;
        this.tenHuyen = tenHuyen;
        this.xaMap = new HashMap<>();

    }

    public String getMaHuyen() {
        return maHuyen;
    }

    public String getMaTinh() {
        return maTinh;
    }

    public String getTenHuyen() {
        return tenHuyen;
    }public Map<String, Xa> getXaMap() {
        return xaMap;
    }

    public void addXa(Xa xa) {
        xaMap.put(xa.getMaXa(), xa);
    }
}
