package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import model.*;

/**
 * Kelas yang merepresentasikan controller dari aplikasi.
 * 
 * @author Devina Emily
 */
public class DictionaryController {

    /*
     * Atribut kamus
     */
    Dictionary dict;
    /*
     * Atribut list akun admin
     */
    AdminAccountList adminAccountList;
    /*
     * Atribut admin yang sedang login (jika tidak null)
     */
    AdminAccount admin;
    
    /**
     * Constructor untuk membuat objek controller dari kamus.
     */
    public DictionaryController() {
        dict = new Dictionary();
        adminAccountList = new AdminAccountList();
    }

    /**
     * Method untuk login
     * @param id id
     * @param password password
     * @return true jika berhasil
     */
    public boolean login(String id, char[] password) {
        AdminAccount x = adminAccountList.search(id, password);
        if (x != null) {
            admin = x;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Method untuk logout dari aplikasi.
     */
    public void logout() {
        if (admin == null) {
        } else {
            admin = null;
        }
    }

    /**
     * Method untuk menambah istilah baru
     * @param termName nama istilah
     * @param definitions definisi
     */
    public void add(String termName, ArrayList<String> definitions) {
        dict.add(termName, definitions);
    }

    /**
     * Method untuk mengecek apakah sebuah istilah ada di dalam kamus atau tidak.
     * @param termName nama istilah
     * @return true jika ada
     */
    public boolean isExist(String termName) {
        if (this.search(termName) == null) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Method untuk melakukan perubahan pada sebuah istilah
     * @param termName nama istilah
     * @param newTermName nama istilah yang baru (mungkin tidak berubah)
     * @param newDefinition definisi yang baru
     * @return true jika berhasil
     */
    public boolean edit(String termName, String newTermName, ArrayList<String> newDefinition) {
        if (dict.search(termName) != null) {
            dict.edit(termName, newTermName, newDefinition);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Method untuk menghapus sebuah istilah
     * @param termName nama istilah
     * @return true jika istilah ditemukan dan dihapus
     */
    public boolean remove(String termName) {
        if (dict.search(termName) != null) {
            dict.remove(termName);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method untuk mencari definisi dari sebuah istilah.
     * @param termName nama istilah
     * @return definisi dari istilah yang ingin dicari
     */
    public List<String> search(String termName) {
        Term searchedTerm;
        searchedTerm = dict.search(termName);
        if(searchedTerm!=null){
            return searchedTerm.getDefinitions();
        } else {
            return null;
        }
    }
    
    /**
     * Method untuk menyimpan terms yang ada ke file.
     */
    public void saveTerms() {
        dict.save();
    }
}
