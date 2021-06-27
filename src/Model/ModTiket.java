/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author USER
 */
public class ModTiket {
    private int no;
    private String nama;
    private int no_id;
    private String kode_pesawat;
    private String jenis_pesawat;
    private int harga;
    private int jumlah_tiket;
    private int total;

    public String getKode_pesawat() {
        return kode_pesawat;
    }

    public void setKode_pesawat(String kode_pesawat) {
        this.kode_pesawat = kode_pesawat;
    }

    public String getJenis_pesawat() {
        return jenis_pesawat;
    }

    public void setJenis_pesawat(String jenis_pesawat) {
        this.jenis_pesawat = jenis_pesawat;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getJumlah_tiket() {
        return jumlah_tiket;
    }

    public void setJumlah_tiket(int jumlah_tiket) {
        this.jumlah_tiket = jumlah_tiket;
    }
    

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNo_id() {
        return no_id;
    }

    public void setNo_id(int no_id) {
        this.no_id = no_id;
    }
    
    
}
