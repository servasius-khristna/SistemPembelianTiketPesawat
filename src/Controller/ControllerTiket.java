/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOTiket;
import DAO.ImplementTiket;
import Model.ModTblTiket;
import Model.ModTiket;
import View.FormTiket;
import View.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import koneksi.KoneksiDT;

/**
 *
 * @author USER
 */
public class ControllerTiket {
    FormTiket frame;
    ImplementTiket implTiket;
    List<ModTiket> lmt;

    public ControllerTiket(FormTiket frame) {
        this.frame = frame;
        implTiket = new DAOTiket();
        lmt = implTiket.getAll();
    } 

//    public ControllerTiket() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    
    public void reset(){
        frame.getTf_nomor().setText("");
        frame.getTf_nama().setText("");
        frame.getTf_id().setText("");
        frame.getCombo_kode().setSelectedItem("--Pilih--");
        frame.getTf_jenis().setText("");
        frame.getTf_harga().setText("");
        frame.getTf_jumlah().setText("");
        frame.getTf_total().setText("");
        frame.getTf_bayar().setText("");
        frame.getTf_kembali().setText("");
        
    }
    
    public void isiTable(){
        lmt = implTiket.getAll();
        ModTblTiket mtt = new ModTblTiket(lmt);
        frame.getTabel().setModel(mtt);
    }
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null; 

    public String sql,no,nama,no_id,kode_pesawat,jenis_pesawat,harga,jumlah_tiket,total;
    public void save() throws SQLException{
        con = koneksi.getKoneksi();
        sql = "INSERT INTO tiket(no,nama,no_id,kode_pesawat,jenis_pesawat,harga,jumlah_tiket,total)VALUE(?,?,?,?,?,?,?,?)";
        ps = con.prepareStatement(sql);
        ps.setString(1, no);
        ps.setString(2, nama);
        ps.setString(3, no_id);
        ps.setString(4, kode_pesawat);
        ps.setString(5, jenis_pesawat);
        ps.setString(6, harga);
        ps.setString(7, jumlah_tiket);
        ps.setString(8, total);
        ps.execute();
        ps.close();
    }
    public void isiField(int row){
        frame.getTf_nomor().setText(String.valueOf(lmt.get(row).getNo()));
        frame.getTf_nama().setText(lmt.get(row).getNama());
        frame.getTf_id().setText(String.valueOf(lmt.get(row).getNo_id()));
        frame.getCombo_kode().setSelectedItem(String.valueOf(lmt.get(row).getKode_pesawat()));
        frame.getTf_jenis().setText(String.valueOf(lmt.get(row).getJenis_pesawat()));
        frame.getTf_harga().setText(String.valueOf(lmt.get(row).getHarga()));
        frame.getTf_jumlah().setText(String.valueOf(lmt.get(row).getJumlah_tiket()));
        frame.getTf_total().setText(String.valueOf(lmt.get(row).getTotal()));
    }
    
    public void insert(){
//        if(!frame.getTf_nama().getText().trim().isEmpty() & !frame.getTf_nama().getText().trim().isEmpty()){
//            ModTiket mt =new ModTiket();
//            
//            mt.setNama(frame.getTf_nama().getText());
//            mt.setNo_id(Integer.valueOf(frame.getTf_id().getText()));
//            //mt.setKode_pesawat(String.valueOf(frame.getCombo_kode().getSelectedItem()));
//            //mt.setJenis_pesawat(String.valueOf(frame.getTf_jenis().getText()));
//            //mt.setHarga(Double.valueOf(frame.getTf_harga().getText()));
//            mt.setJumlah_tiket(Integer.valueOf(frame.getTf_jumlah().getText()));
//            //mt.setTotal(Integer.valueOf(frame.getTf_total().getText()));
//            
//            implTiket.insert(mt);
//            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
//        }else{
//            JOptionPane.showMessageDialog(null, "Data tidak berhasil disimpan");
//        }
//            Connection con = null;
//            PreparedStatement ps = null;
//            ResultSet rs = null;
//
//
//            nama = tf_nama.getText();
//            id.alamat = alamatPembeli.getText();
//            id.noHp = nohpPembeli.getText();
//            id.kodeBarang = kodeBrg.getText();
//            id.smartphone = (String) combPhone.getSelectedItem();
//            id.type = (String) combType.getSelectedItem();
//            id.harga = textHarga.getText();
//
//            try{
//                id.save();
//                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
//                reset();
//            }catch(SQLException e){
//                JOptionPane.showMessageDialog(null, "Data Masih Kosong!");
//                reset();
//            }
    }
    
    public void delete(){
        if(!frame.getTf_nomor().getText().trim().isEmpty()){
            int no = Integer.parseInt(frame.getTf_nomor().getText());
            
            implTiket.delete(no);
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
        }else{
            JOptionPane.showMessageDialog(null, "Data tidak berhasil di hapus");
        
            
        }
    }
    
    public void update(){
        if(!frame.getTf_nomor().getText().trim().isEmpty()){
            
            ModTiket mt = new ModTiket();
            
            mt.setNama(frame.getTf_nama().getText());
            mt.setNo_id(Integer.valueOf(frame.getTf_id().getText()));
            mt.setKode_pesawat(String.valueOf(frame.getCombo_kode().getSelectedItem()));
            mt.setJenis_pesawat(String.valueOf(frame.getTf_jenis().getText()));
            mt.setHarga(Integer.valueOf(frame.getTf_harga().getText()));
            mt.setJumlah_tiket(Integer.valueOf(frame.getTf_jumlah().getText()));
            mt.setTotal(Integer.valueOf(frame.getTf_total().getText()));
            mt.setNo(Integer.valueOf(frame.getTf_nomor().getText()));
            
            implTiket.update(mt);
            JOptionPane.showMessageDialog(null, "Data berhasil di update");
        }else{
            JOptionPane.showMessageDialog(null, "Data tidak berhasil di update");
            
        }
    }
    
    public void isiTableCariNama(){
        lmt = implTiket.getCariNama(frame.getTf_cari().getText());
        ModTblTiket mtt = new ModTblTiket(lmt);
        frame.getTabel().setModel(mtt);
    }
    
    public void cariNama(){
        if(!frame.getTf_cari().getText().trim().isEmpty()){
            implTiket.getCariNama(frame.getTf_cari().getText());
            isiTableCariNama();
            
        }else{
            JOptionPane.showMessageDialog(null, "Silahkan Masukan Nama");
        }
    }
}
