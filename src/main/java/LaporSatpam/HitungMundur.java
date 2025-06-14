package LaporSatpam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class HitungMundur {
    public static void mulaiCountdown(String namaTamu, String nopol, int durasiMenit) {
        int durasiDetik = durasiMenit * 60;

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int detikSisa = durasiDetik;

            @Override
            public void run() {
                if (detikSisa > 0) {
                    int menit = detikSisa / 60;
                    int detik = detikSisa % 60;
                    System.out.println("Tamu " + namaTamu + " [" + nopol + "] - Sisa waktu: "
                            + menit + "m " + detik + "d");
                    detikSisa--;
                } else {
                    timer.cancel();
                    System.out.println("Waktu habis, akan muncul popup reminder!");
                    
                    updateStatusSelesai(namaTamu, nopol);
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(null,
                                "Waktu menetap tamu " + namaTamu + " [" + nopol + "] telah habis!",
                                "Pengingat",
                                JOptionPane.WARNING_MESSAGE);
                    });
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }
    
    private static void updateStatusSelesai(String namaTamu, String nopol) {
        Connection conn = ConnectionDB.DatabaseConn.connectDB();
        String updateQuery = "UPDATE tamu SET status='selesai' WHERE nama = ? AND nopol = ? AND status='menunggu'";
        try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
            pstmt.setString(1, namaTamu);
            pstmt.setString(2, nopol);
            int rows = pstmt.executeUpdate();
            System.out.println("Update status selesai, baris terpengaruh: " + rows);
        } catch (SQLException e) {
            System.err.println("Gagal update status selesai: " + e.getMessage());
        }
    }
}