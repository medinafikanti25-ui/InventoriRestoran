/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    private static Connection koneksi;

    public static Connection getConnection() {

        try {

            String url = "jdbc:mysql://localhost:3306/db_bookstore";
            String user = "root";
            String password = "";

            koneksi = DriverManager.getConnection(
                    url,
                    user,
                    password
            );

            System.out.println("Koneksi Berhasil");

        } catch (SQLException e) {

            System.out.println(
                    "Koneksi Gagal : " + e.getMessage()
            );

        }

        return koneksi;
    }
}
