/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class Ketnoi {

    public Connection ketnoi() {

        try {
            String url = "jdbc:mysql://localhost:/ontap2";
            String user = "root";
            String pass = "";
            Connection conn = DriverManager.getConnection(url, user, pass);
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(Ketnoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
        Ketnoi kn = new Ketnoi();
        System.out.println(kn.ketnoi());
    }
}
