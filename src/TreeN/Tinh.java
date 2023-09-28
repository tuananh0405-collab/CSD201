package TreeN;

import java.util.HashMap;
import java.util.Map;

public class Tinh {
    private String maTinh;
    private String tenTinh;
    private Map<String, Huyen> huyenMap;

    public Tinh(String maTinh, String tenTinh) {
        this.maTinh = maTinh;
        this.tenTinh = tenTinh;
        this.huyenMap = new HashMap<>();

    }

    public String getMaTinh() {
        return maTinh;
    }

    public String getTenTinh() {
        return tenTinh;
    }public Map<String, Huyen> getHuyenMap() {
        return huyenMap;
    }

    public void addHuyen(Huyen huyen) {
        huyenMap.put(huyen.getMaHuyen(), huyen);
    }
}
