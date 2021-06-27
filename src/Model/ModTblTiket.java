/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class ModTblTiket extends AbstractTableModel{
    
    List<ModTiket> lmt;

    public ModTblTiket(List<ModTiket> lmt) {
        this.lmt = lmt;
    }
    
    
    
    @Override
    public int getRowCount() {
        return lmt.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return lmt.get(row).getNo();
            case 1:
                return lmt.get(row).getNama(); 
            case 2:
                return lmt.get(row).getNo_id();
            case 3:
                return lmt.get(row).getKode_pesawat(); 
            case 4:
                return lmt.get(row).getJenis_pesawat();  
            case 5:
                return lmt.get(row).getHarga(); 
            case 6:
                return lmt.get(row).getJumlah_tiket(); 
            case 7:
                return lmt.get(row).getTotal(); 
            default :
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
         switch (column){
            case 0:
                return "no";
            case 1:
                return "nama";
            case 2:
                return "no_id";
            case 3:
                return "kode_pesawat";
            case 4:
                return "jenis_pesawat";
            case 5:
                return "harga";
            case 6:
                return "jumlah_tiket";
            case 7:
                return "total";
            default :
                return null;       
         }
    }
}
