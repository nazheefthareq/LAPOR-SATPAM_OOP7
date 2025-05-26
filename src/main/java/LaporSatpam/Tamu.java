package LaporSatpam;

import java.time.LocalDateTime;

public class Tamu {
    private final String nama;
    private final String nopol;
    private final String tujuan;
    private final LocalDateTime waktuMasuk;
    private final int durasiMenetap; // dalam menit
    private final LocalDateTime waktuKeluar;

    public Tamu(String nama, String nopol, String tujuan, int durasiMenetap) {
        this.nama = nama;
        this.nopol = nopol;
        this.tujuan = tujuan;
        this.durasiMenetap = durasiMenetap;
        this.waktuMasuk = LocalDateTime.now();
        this.waktuKeluar = waktuMasuk.plusMinutes(durasiMenetap);
    }

    public String getNama() { return nama; }
    public String getNopol() { return nopol; }
    public String getTujuan() { return tujuan; }
    public LocalDateTime getWaktuMasuk() { return waktuMasuk; }
    public int getDurasiMenetap() { return durasiMenetap; }
    public LocalDateTime getWaktuKeluar() { return waktuKeluar; }
}
