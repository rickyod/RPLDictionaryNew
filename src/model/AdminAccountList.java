/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Kelas yang merepresentasikan list dari akun admin.
 * @author Devi
 */
public class AdminAccountList {
    /*
     * Atribute yang menyimpan seluruh akun admin yang ada
     */
    private Map<String, String> adminAccounts;
    
    /**
     * Constructor untuk membuat list akun admin,
     * mengisi adminAccounts dengan membaca dari sebuah file yang bernama "adminlist.txt".
     */
    public AdminAccountList() {
        this.adminAccounts = new HashMap<>();
        DictionaryFileReader reader = new DictionaryFileReader();
        List<AdminAccount> list = reader.loadAdminAccountList("adminlist.txt");
        
        for (AdminAccount aa : list) {
            adminAccounts.put(aa.getID(), aa.getPassword());
        }
    }
    
    /**
     * Method untuk mendapatkan akun admin dari list.
     * @param ID ID akun yang dicari
     * @param password password akun yang ingin dicocokkan
     * @return objek dari kelas AdminAccount jika ID dan password yang cocok ditemukan, 
     * null jika ada salah satu (ID atau password) yang tidak cocok
     */
    public AdminAccount search(String ID, char[] password) {
        String actualPassword = adminAccounts.get(ID);
        if(actualPassword!=null) {
            char[] actPassChar = actualPassword.toCharArray();
            if(actualPassword!=null && Arrays.equals(actPassChar, password)) {
                return new AdminAccount(ID, actualPassword);
            }
        }
        return null;
    }
}
