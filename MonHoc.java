import java.util.Scanner;

public class MonHoc {
    Scanner sc = new Scanner(System.in);
    private static  int nextId = 100;
    private int maMh;
    private String tenMon;
    private int soDonViHocTrinh;
    private String loaiMon;

    public MonHoc(String tenMon, int soDonViHocTrinh, String loaiMon){
        this.maMh = nextId++;
        this.tenMon = tenMon;
        this.soDonViHocTrinh= soDonViHocTrinh;
        this.loaiMon = loaiMon;
    }

    public int getMaMh() {
        return maMh;
    }

    public void setMaMh(int maMh) {
        this.maMh = maMh;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getSoDonViHocTrinh() {
        return soDonViHocTrinh;
    }

    public void setSoDonViHocTrinh(int soDonViHocTrinh) {
        this.soDonViHocTrinh = soDonViHocTrinh;
    }

    public String getLoaiMon() {
        return loaiMon;
    }

    public void setLoaiMon(String loaiMon) {
        this.loaiMon = loaiMon;
    }


    public String toString(){
        return "\nMã môn học: " +maMh+
                "\nTên môn: " +tenMon+
                "\nSố đơn vị học trình: " +soDonViHocTrinh+
                "\nLoại môn: " +loaiMon;
    }
}