package LaporSatpam;

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
}