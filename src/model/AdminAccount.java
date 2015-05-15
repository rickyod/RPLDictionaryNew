/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Kelas yang merepresentasikan akun untuk admin.
 * @author Devi
 */
public class AdminAccount {
    /*
     * Atribut ID akun
     */
    private String ID;
    /*
     * Atribut password untuk akun
     */
    private String password;

    /**
     * Constructor untuk membuat sebuah akun admin.
     * @param ID ID akun
     * @param password password akun
     */
    public AdminAccount(String ID, String password) {
        this.ID = ID;
        this.password = password;
    }

    /**
     * Method untuk mendapatkan ID dari sebuah akun
     * @return ID akun
     */
    public String getID() {
        return ID;
    }

    /**
     * Method untuk mendapatkan password dari sebuah akun.
     * @return password akun
     */
    public String getPassword() {
        return password;
    }
    
}
