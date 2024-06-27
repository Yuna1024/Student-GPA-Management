import java.util.Scanner;

public class SinhVien {
    Scanner sc = new Scanner(System.in);
    private static int nextId = 10000;
    private int maSv;
    private String hoTen;
    private  String diaChi;
    private int SDT;
    private String lop;


    public SinhVien(String hoTen, String diaChi, int SDT, String lop){
        this.maSv = nextId++;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.lop = lop;
    }

    public int getMaSv() {
        return maSv;
    }

    public void setMaSv(int maSv) {
        this.maSv = maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    @Override
    public String toString(){
        return "\nMã sinh viên: " +maSv+
                "\nHọ tên: " +hoTen+
                "\nĐia chỉ: " +diaChi+
                "\nSDT: " +SDT+
                "\nLớp: " +lop;
    }
}
