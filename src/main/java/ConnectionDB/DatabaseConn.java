/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author PC WILDAN
 */
public class DatabaseConn {
     public static Connection conn = null;

    // Ubah nama method jadi connectDB
    public static void connectDB() {
        String url = "jdbc:mysql://localhost:3306/lapor_satpam";
        String user = "root";
        String password = "";

        try {
            conn = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Koneksi berhasil!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal: " + e.getMessage());
        }
    }
}
