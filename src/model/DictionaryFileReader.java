/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Devi
 */
public class DictionaryFileReader {
    
    /**
     * Method untuk membaca seluruh istilah beserta definisi-definisinya dari sebuah file dan
     * di-ubah formatnya menjadi list yang berisi Term-Term.
     * @param fileName nama file untuk membaca
     * @return list berisi Term(s)
     */
    public List loadTerm(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
            
            List<Term> list = new ArrayList<>();
            
            Term curTerm;
            String termName, definition;
            ArrayList<String> definitions;

            while (true) {
                definitions = new ArrayList<>();
                try {
                    termName = br.readLine();
                    if(termName.equals("*****")) { break; }
                    
                    while (true) {
                        definition = br.readLine();
                        if(definition.equals("*")) { break; }
                        definition = br.readLine();
                        
                        definitions.add(definition);
                    }
                    
                    curTerm = new Term(termName,definitions);
                    list.add(curTerm);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            
            return list;
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }    
    
    /**
     * Method untuk membaca seluruh username dan password admin dari sebuah file.
     * @param fileName nama file untuk membaca
     * @return list berisi AdminAccount
     */
    public List loadAdminAccountList(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
            
            List<AdminAccount> list = new ArrayList<>();
            String ID, password;

            while (true) {
                try {
                    ID = br.readLine();
                    if(ID==null) { break; }
                    password = br.readLine(); br.readLine();
                    list.add(new AdminAccount(ID, password));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            
            return list;
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
}

/* Format Term

TERM1
-
def1
-
def2
*
TERM2
-
def1
*
TERM3
-
def1
*
*****

*/



/*

Format admin:
NamaID
Password

NamaID
Password

NamaID
Password

*/