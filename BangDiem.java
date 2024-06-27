public class BangDiem {
    private  SinhVien sinhVien;
    private MonHoc monHoc;
    private  float  soDiem;

    public BangDiem(SinhVien sinhVien,MonHoc monHoc,float soDiem) throws IllegalAccessException {
        if (soDiem < 0 || soDiem > 10) {
            throw  new IllegalArgumentException("Số điểm bạn nhập không đúng yêu cầu vui lòng nhập lại (0 < Số điểm < 10)!!!");
        }
        this.sinhVien = sinhVien;
        this.monHoc = monHoc;
        this.soDiem = soDiem;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public float getSoDiem() {
        return soDiem;
    }

    @Override
    public String toString(){
        return "\nTên sinh viên: "+getSinhVien().getHoTen()+
                "\nMôn học: " +getMonHoc().getTenMon()+
                "\nĐiểm: "+soDiem;
    }
}
