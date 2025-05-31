/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author PC WILDAN
 */
public class DatabaseConn {
    public static Connection conn = null;

    public static Connection connectDB() {
        if (conn == null) {
            String url = "jdbc:mysql://localhost:3306/lapor_satpam";
            String user = "root";
            String password = "";

            try {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi ke database berhasil.");
            } catch (SQLException e) {
                System.err.println("Koneksi gagal: " + e.getMessage());
            }
        }
        return conn;
    }
    
    public static Connection getConnection() {
        return connectDB(); // Pastikan selalu mengembalikan koneksi aktif
    }
}
