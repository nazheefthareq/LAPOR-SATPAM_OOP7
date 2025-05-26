package LaporSatpam.utils;

import LaporSatpam.Tamu;
import javax.swing.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerReminder {

    public static void mulaiHitungMundur(Tamu tamu) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Duration sisa = Duration.between(LocalDateTime.now(), tamu.getWaktuKeluar());

                if (sisa.toMinutes() <= 5 && sisa.toMinutes() > 0) {
                    JOptionPane.showMessageDialog(null, 
                        "Tamu " + tamu.getNama() + " akan habis durasi menetap dalam " + sisa.toMinutes() + " menit!");
                } else if (sisa.toMinutes() <= 0) {
                    JOptionPane.showMessageDialog(null, 
                        "Tamu " + tamu.getNama() + " telah melewati durasi menetap!");
                    timer.cancel();
                }
            }
        }, 0, 60 * 1000); // periksa setiap 1 menit
    }
}
