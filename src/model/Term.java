/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 * Kelas yang merepresentasikan sebuah istilah, 
 * yang memiliki atribut nama istilah dan definisi-definisinya.
 * 
 * @author Devi
 */
public class Term {
    
    /*
     * Atribut nama istilah
     */
    private String termName;
    /*
     * Atribute yang menyimpan definisi-definisi dari istilah
     */
    private List<String> definitions;

    /**
     * Constructor untuk membuat sebuah istilah baru.
     * @param termName nama istilah
     * @param definitions definisi-definisi istilah
     */
    public Term(String termName, List definitions) {
        this.termName = termName;
        this.definitions = definitions;
    }
    
    /**
     * Method untuk mendapatkan nama istilah.
     * @return nama istilah
     */
    public String getIstilah() {
        return termName;
    }

    /**
     * Method untuk mengubah nama istilah.
     * @param istilah 
     */
    public void setIstilah(String istilah) {
        this.termName = istilah;
    }

    /**
     * Method untuk mendapatkan definisi dari istilah.
     * @return definisi
     */
    public List<String> getDefinitions() {
        return definitions;
    }

    /**
     * Method untuk mengubah seluruh definisi yang dimiliki istilah.
     * @param newDefinitions definisi baru
     */
    public void setDefinitions(List<String> newDefinitions) {
        this.definitions = newDefinitions;
    }
    
    /**
     * Method untuk menambah satu definisi baru pada istilah ini.
     * @param newDefinition definisi baru
     */
    public void addDefinitions(String newDefinition) {
        this.definitions.add(newDefinition);
    }
}
