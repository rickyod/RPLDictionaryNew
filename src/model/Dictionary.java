/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Kelas yang merepresentasikan kamus istilah.
 *
 * @author Adam Hafidz F
 */
public class Dictionary {
    /*
     * Atribut yang menyimpan term-term ke sebuah map 
     * agar insert,search,remove dapat dilakukan dengan cepat
     */

    private HashMap<String, Term> termsMap;

    /**
     * Constructor untuk membuat sebuah kamus istilah.
     */
    public Dictionary() {
        DictionaryFileReader dfr = new DictionaryFileReader();
        List<Term> list = dfr.loadTerm("terms.txt");
        termsMap = new HashMap<>();
        int length = list.size();
        Term curTerm;
        for (int i = 0; i < length; i++) {
            curTerm = list.get(i);
            termsMap.put(curTerm.getIstilah().toLowerCase(), curTerm);
        }
    }

    /**
     * Method untuk melakukan pencarian istilah dan definisinya yang ada di kamus 
     * tanpa membandingkan huruf besar dan kecilnya.
     * @param termName nama istilah yang ingin dicari
     * @return sebuah objek dari Term yang ditemukan, null jika tidak ditemukan
     */
    public Term search(String termName) {
        return termsMap.get(termName.toLowerCase());
    }

    /**
     * Method untuk menambah istilah baru ke kamus.
     * @param newTermName nama istilah baru
     * @param newDefinitions definisinya
     */
    public void add(String newTermName, ArrayList<String> newDefinitions) {
        termsMap.put(newTermName.toLowerCase(), new Term(newTermName, newDefinitions));
    }

    /**
     * Method untuk menghapus istilah dari kamus.
     * @param termName nama istilah yang ingin dihapus
     */
    public void remove(String termName) {
        termsMap.remove(termName);
    }

    /**
     * Method untuk melakukan perubahan pada istilah di kamus.
     * @param termName nama istilah awal
     * @param newTermName nama istilah baru (jika ada perubahan)
     * @param newDefinition definisi istilah
     * @return true jika berhasil di edit
     */
    public boolean edit(String termName, String newTermName, ArrayList<String> newDefinition) {
        Term oldTerm = search(termName);
        if (oldTerm == null) {
            return false;
        } else {
            termsMap.put(termName.toLowerCase(), new Term(newTermName, newDefinition));
            return true;
        }
    }

    /**
     * Method untuk menyimpan semua yang ada di kamus sekarang ini
     * ke sebuah file yang bernama "terms.txt".
     */
    public void save() {
        DictionaryFileWriter dfw = new DictionaryFileWriter();
        ArrayList<Term> listTerm = new ArrayList<>();
        for (Map.Entry<String, Term> entry : termsMap.entrySet()) {
            listTerm.add(termsMap.get(entry.getKey()));
        }

        dfw.writeTermsToFile(listTerm, "terms.txt");
    }
}
