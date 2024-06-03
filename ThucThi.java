/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau2;

import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nguye
 */
public class ThucThi {

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet rs = null;

    public ResultSet hienThi() {
        conn = (Connection) new Ketnoi().ketnoi();
        String sql = "SELECT * FROM `xuatban`";
        try {
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ThucThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean ktMa(String ma) {
        conn = (Connection) new Ketnoi().ketnoi();
        String sql = "SELECT * FROM `xuatban` WHERE `maXB`=?";
        boolean kt = false;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, ma);
            rs = statement.executeQuery();
            while (rs.next()) {
                kt = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThucThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kt;
    }

    public void ThemNxb(String ma, String ten, String diaChi, String sdt) {
        conn = (Connection) new Ketnoi().ketnoi();
        String sql = "INSERT INTO `xuatban` VALUES (?,?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, ma);
            statement.setString(2, ten);
            statement.setString(3, diaChi);
            statement.setString(4, sdt);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThucThi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Xoa(String ma) {
        conn = (Connection) new Ketnoi().ketnoi();
        String sql = "DELETE FROM `xuatban` WHERE `maXB`=?";

        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, ma);
            statement.execute();
        } catch (SQLException ex) {
//            Logger.getLogger(ThucThi.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Không được xóa");
        }
    }

    public int SoLuong(String ma) {
        conn = (Connection) new Ketnoi().ketnoi();
        int dem = 0;
        String sql = "SELECT COUNT(*) FROM `sach` WHERE `maXB`=?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, ma);
            rs = statement.executeQuery();
            if (rs.next()) {
                dem = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThucThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dem;
    }

    public void SuaNxb(String ma, String ten, String diaChi, String sdt) {
        conn = (Connection) new Ketnoi().ketnoi();
        String sql = "UPDATE `xuatban` SET `tenXB`=?,`diachi`=?,`sdt`=? WHERE `maXB`=?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(4, ma);
            statement.setString(1, ten);
            statement.setString(2, diaChi);
            statement.setString(3, sdt);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThucThi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//----------------------------------------------------------------------------

    public ResultSet HienThicbb() {
        conn = (Connection) new Ketnoi().ketnoi();
        String sql = "SELECT `maXB` FROM `xuatban` ";
        try {
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ThucThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet hienThiSach() {
        conn = (Connection) new Ketnoi().ketnoi();
        String sql = "SELECT * FROM `sach`";
        try {
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ThucThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //------------------------------------------------------------------------
    public boolean ktSach(String ma) {
        conn = (Connection) new Ketnoi().ketnoi();
        String sql = "SELECT * FROM `sach` WHERE `maSach`=?";
        boolean kt = false;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, ma);
            rs = statement.executeQuery();
            while (rs.next()) {
                kt = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThucThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kt;
    }

    public void ThemSach(String ma, String ten, String nxb) {
        conn = (Connection) new Ketnoi().ketnoi();
        String sql = "INSERT INTO `sach` VALUES (?,?,?)";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, ma);
            statement.setString(2, ten);
            statement.setString(3, nxb);
            statement.execute();
        } catch (SQLException ex) {
//            Logger.getLogger(ThucThi.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Mã đã tồn tại rồi bạn nhé");
        }
    }

    public void XoaSach(String ma) {
        conn = (Connection) new Ketnoi().ketnoi();
        String sql = "DELETE FROM `sach` WHERE `maSach`=?";

        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, ma);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThucThi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SuaSach(String ma, String ten, String nxb) {
        conn = (Connection) new Ketnoi().ketnoi();
        String sql = "UPDATE `sach` SET `tenSach`=?,`maXB`=? WHERE `maSach`=?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(3, ma);
            statement.setString(1, ten);
            statement.setString(2, nxb);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThucThi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet timKiemSach(String ma) {
        conn = (Connection) new Ketnoi().ketnoi();
        String sql = "SELECT * FROM `sach` WHERE `maXB`Like ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + ma + "%");
            rs = statement.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ThucThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
