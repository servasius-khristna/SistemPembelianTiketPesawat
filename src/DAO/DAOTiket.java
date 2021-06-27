/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ModTiket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.KoneksiDT;

/**
 *
 * @author USER
 */
public class DAOTiket implements ImplementTiket {
    
    Connection connection;
    final String insert = "INSERT INTO tiket (no,nama, no_id, kode_pesawat, jenis_pesawat, harga, jumlah_tiket, total) VALUES (?,?, ?, ?, ?, ?, ?, ?)";
    final String delete = "DELETE FROM tiket WHERE no=?";
    final String update = "UPDATE  tiket set nama=?, no_id=?, kode_pesawat=?, jenis_pesawat=?, harga=?, jumlah_tiket=?, total=? WHERE no=?";
    final String select = "SELECT * FROM tiket";
    final String cariNama = "SELECT * FROM tiket WHERE nama like ?";

    public DAOTiket() {
        connection = KoneksiDT.connection();
    }
    
    
    

    @Override
    public void insert(ModTiket mt) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(insert);
            statement.setInt(1,mt.getNo());
            statement.setString(2,mt.getNama());
            statement.setInt(3,mt.getNo_id());
            statement.setString(4,mt.getKode_pesawat());
            statement.setString(5,mt.getJenis_pesawat());
            statement.setInt(6,mt.getHarga());
            statement.setInt(7,mt.getJumlah_tiket());
            statement.setInt(8,mt.getTotal());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()){
                mt.setNama(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int no) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, no);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(ModTiket mt) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1,mt.getNama());
            statement.setInt(2,mt.getNo_id());
            statement.setString(3,mt.getKode_pesawat());
            statement.setString(4,mt.getJenis_pesawat());
            statement.setDouble(5,mt.getHarga());
            statement.setInt(6,mt.getJumlah_tiket());
            statement.setInt(7,mt.getTotal());
            statement.setInt(8,mt.getNo());
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<ModTiket> getAll() {
        List<ModTiket> lmt=null;
        
        try {
            lmt = new ArrayList<ModTiket>();
            Statement st = connection.createStatement();
            
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                ModTiket mt = new ModTiket();
                mt.setNo(rs.getInt("no"));
                mt.setNama(rs.getString("nama"));
                mt.setNo_id(rs.getInt("no_id"));
                mt.setKode_pesawat(rs.getString("kode_pesawat"));
                mt.setJenis_pesawat(rs.getString("jenis_pesawat"));
                mt.setHarga(rs.getInt("harga"));
                mt.setJumlah_tiket(rs.getInt("jumlah_tiket"));
                mt.setTotal(rs.getInt("total"));
                lmt.add(mt);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lmt;
    }

    @Override
    public List<ModTiket> getCariNama(String nama) {
        List<ModTiket> lmt = null;
       
        try {
            lmt = new ArrayList<ModTiket>();
            PreparedStatement st = connection.prepareStatement(cariNama);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                ModTiket mt = new ModTiket();
                mt.setNo(rs.getInt("no"));
                mt.setNama(rs.getString("nama"));
                mt.setNo_id(rs.getInt("no_id"));
                mt.setKode_pesawat(rs.getString("kode_pesawat"));
                mt.setJenis_pesawat(rs.getString("jenis_pesawat"));
                mt.setHarga(rs.getInt("harga"));
                mt.setJumlah_tiket(rs.getInt("jumlah_tiket"));
                mt.setTotal(rs.getInt("total"));
                lmt.add(mt);
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lmt;
    }

 
   
    
}
