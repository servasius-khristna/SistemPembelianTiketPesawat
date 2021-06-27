/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ModTiket;
import java.util.List;

/**
 *
 * @author USER
 */
public interface ImplementTiket {
    public void insert(ModTiket mt);
    public void delete(int no);
    public void update(ModTiket mt);
    public List<ModTiket> getAll();
    public List<ModTiket> getCariNama(String nama);
}
