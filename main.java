import java.awt.*;
import java.util.Scanner;

public class main {

    private static SinhVien[] sinhViens = new SinhVien[100];
    private static int soLuongSinhVien = 0;

    private static  MonHoc[] monHocs = new MonHoc[100];
    private  static int soLuongMonHoc = 0;

    private static BangDiem[] bangDiems = new BangDiem[100];
    private  static  int soLuongBangDiem = 0;

    public static void main(String[] args) throws IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        int choose;
        do{
            System.out.println("Student-GPA-Management");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Thêm môn học");
            System.out.println("4. Hiển thị danh sách môn học");
            System.out.println("5. Nhập điểm cho sinh viên");
            System.out.println("6. Hiển thị danh sách điểm sinh viên");
            System.out.println("7. Sắp xếp danh sách bảng điểm theo họ tên");
            System.out.println("8. Sắp xếp danh sách bảng điểm theo tên môn học");
            System.out.println("9. Tính điểm tổng kết");
            System.out.println("10. Lưu vào file");
            System.out.println("0. Thoát chương trình...");
            System.out.println("Lựa chọn của bạn");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose){
                case 1:
                    themSinhVien();
                    pause();
                    break;
                case 2:
                    hienThiDanhSachSinhVien();
                    pause();
                    break;
                case 3:
                    themMonHoc();
                    pause();
                    break;
                case 4:
                    hienThiDanhSachMonHoc();
                    pause();
                    break;
                case 5:
                    nhapDiemChoSinhVien();
                    pause();
                    break;
                case 6:
                    hienThiDanhSachDiem();
                    pause();
                    break;
                case 7:
                   sapXepTheoHoTen();
                   pause();
                   break;
                case 8:
                    sapXepTheoMonHoc();
                    pause();
                    break;
                case 9:
                    tinhDiemTongKet();
                    pause();
                    break;
//                case 10:
//                    luuVaoFile();
//                    pause();
//                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ vui lòng chọn lại.");
            }
        }while (choose !=0);
    }

    private static void themSinhVien(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Nhập số lượng sinh viên: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i=0;i<n;i++){
            System.out.println("Nhập thông tin sinh viên thứ : " + (i+1));
            System.out.println("Nhập họ tên: ");
            String hoTen = sc.nextLine();
            System.out.println("Nhập địa chỉ: ");
            String diaChi = sc.nextLine();
            System.out.println("Nhập SDT: ");
            int SDT = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhập lớp: ");
            String lop = sc.nextLine();

            SinhVien newSinhVien = new SinhVien(hoTen,diaChi,SDT,lop);
            sinhViens[soLuongSinhVien++] = newSinhVien;
        }
    }

    private static void themMonHoc(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng môn học: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i =0; i< n ;i++){
            System.out.println("Nhập thông tin môn học thứ : " + (i+1));
            System.out.println("Nhập tên môn học: ");
            String tenMon = sc.nextLine();
            System.out.println("Nhập số đơn vị học trình: ");
            int soDonViHocTrinh = sc.nextInt();
            sc.nextLine();
            System.out.println("Chọn loại môn học: \n1.Đại cương \n2.Cơ sở ngành \n3.Chuyên ngành");
            int check = sc.nextInt();
            sc.nextLine();
            String loaiMonHoc = "";
            switch (check){
                case 1:
                    loaiMonHoc = "Đại cương";
                    break;
                case 2:
                    loaiMonHoc = "Cơ Sở Ngành";
                    break;
                case 3:
                    loaiMonHoc = "Chuyên ngành";
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ");
                    break;
            }

            MonHoc newMonHoc = new MonHoc(tenMon,soDonViHocTrinh,loaiMonHoc);
            monHocs[soLuongMonHoc++]= newMonHoc;
        }
    }


    public static void hienThiDanhSachSinhVien(){
        System.out.println("Danh sách sinh viên");
        for (int i=0 ;i < soLuongSinhVien;i++){
            System.out.println(sinhViens[i]);
        }
    }

    public static void hienThiDanhSachMonHoc(){
        System.out.println("Danh sách môn học");
        for (int i=0;i<soLuongMonHoc;i++){
            System.out.println(monHocs[i]);
        }
    }

    private static void nhapDiemChoSinhVien() throws IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id Sinh viên (ID gồm 5 chữ số)");
        int idSV = sc.nextInt();
        sc.nextLine();
        SinhVien sinhVien = timKiemSinhVien(idSV);
        if(sinhVien == null){
            System.out.println("ID không hợp lệ");
            return;
        }

        System.out.println("Nhập id môn học (ID gồm 3 chữ số)");
        int idMH = sc.nextInt();
        sc.nextLine();
        MonHoc monHoc = timKiemMonHoc(idMH);
        if(monHoc == null){
            System.out.println("ID không hợp lệ");
            return;
        }

        System.out.println("Nhập điểm cho môn học: ");
        int soDiem = sc.nextInt();
        sc.nextLine();

        BangDiem newBangDiem = new BangDiem(sinhVien,monHoc,soDiem);
        bangDiems[soLuongBangDiem++]= newBangDiem;
    }


    public static  void hienThiDanhSachDiem(){
        System.out.println("Danh sách bảng điểm của sinh viên");
        for (int i=0;i<soLuongBangDiem;i++){
            System.out.println(bangDiems[i]);
        }
    }


    private static void sapXepTheoHoTen(){
        if (soLuongBangDiem <=1 ){
            System.out.println("Không đủ dữ liệu sắp xếp");
            return;
        }
        for (int i=0;i<soLuongBangDiem;i++){
            for (int j= i+1; j<soLuongBangDiem;j++){
                if(bangDiems[i].getSinhVien().getHoTen().compareTo(bangDiems[j].getSinhVien().getHoTen())>0){
                    BangDiem temp = bangDiems[i];
                    bangDiems[i] = bangDiems[j];
                    bangDiems[j] = temp;
                }
            }
            hienThiDanhSachDiem();
        }
    }

    private static void sapXepTheoMonHoc(){
        if (soLuongBangDiem <=1 ){
            System.out.println("Không đủ dữ liệu sắp xếp");
            return;
        }
        for (int i=0;i<soLuongBangDiem;i++){
            for (int j=i+1;j<soLuongBangDiem;j++){
                if(bangDiems[i].getMonHoc().getTenMon().compareTo(bangDiems[j].getMonHoc().getTenMon())>0){
                    BangDiem temp = bangDiems[i];
                    bangDiems[i] = bangDiems[j];
                    bangDiems[j] = temp;
                }
            }
        }
    }

    private static void tinhDiemTongKet(){
        System.out.println("Bảng điểm tổng kết");
        for (int i=0;i<soLuongSinhVien;i++){
            SinhVien SV = sinhViens[i];
            float total = 0;
            int tongDVHT = 0;
            for (int j=0 ;j < soLuongBangDiem;j++){
                if (bangDiems[j].getSinhVien() == SV){
                    total += bangDiems[j].getSoDiem() * bangDiems[j].getMonHoc().getSoDonViHocTrinh();
                    tongDVHT +=bangDiems[j].getMonHoc().getSoDonViHocTrinh();
                }
            }
            float diemTB = tongDVHT == 0 ? 0 : total / tongDVHT;
            System.out.println("Sinh viên:"+SV.getHoTen()+" -Điểm trung bình:"+diemTB);
        }
    }



    private static  SinhVien timKiemSinhVien(int idSV){
        for (int i=0;i<soLuongSinhVien;i++){
            if(sinhViens[i].getMaSv()== idSV){
                return sinhViens[i];
            }
        }return null;
    }

    private static MonHoc timKiemMonHoc(int idMH){
        for (int i=0;i<soLuongMonHoc;i++){
            if(monHocs[i].getMaMh()== idMH){
                return monHocs[i];
            }
        }return null;
    }


    public static void pause(){
        System.out.print("Nhấn enter để tiếp tục ...\n");
        try{
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
