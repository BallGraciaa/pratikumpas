/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lib;

import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Administrator
 */
public class koneksi {
    static Connection konek;
    static ResultSet rs;
    static Statement st;

    
    public koneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            konek = DriverManager.getConnection("jdbc:mysql://localhost:3306/pratikumspp","root","");      
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    } 
    
    public ResultSet ambilData(String sql){
        try {
            st = konek.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
     public boolean rubahData(String sql){
            try {
                st = konek.createStatement();
                st.executeUpdate(sql);
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                return false;
            }
        }
}
