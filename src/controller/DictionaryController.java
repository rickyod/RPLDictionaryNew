package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import model.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Devina Emily
 */
public class DictionaryController {

    Dictionary dict;
    AdminAccountList accountList;
    AdminAccount admin;
    HashMap<String, Term> termsMap;

    public DictionaryController() {
        dict = new Dictionary();
        accountList = new AdminAccountList();
    }

    public boolean login(String id, char[] password) {
        AdminAccount x = accountList.search(id, password);
        if (x != null) {
            admin = x;
            return true;
        } else {
            return false;
        }
    }

    public boolean logout() {
        if (admin == null) {
            return false;
        } else {
            admin = null;
            return true;
        }
    }

    public boolean add(String term, ArrayList<String> definition) {
        dict.add(term, definition);
        return true;
    }

    public boolean isExist(String term) {
        if (this.search(term) == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean edit(String termName, String newTermName, ArrayList<String> newDefinition) {
        if (dict.search(termName) != null) {
            dict.edit(termName, newTermName, newDefinition);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(String term) {
        if (dict.search(term) != null) {
            dict.remove(term);
            return true;
        } else {
            return false;
        }
    }

    public List<String> search(String term) {
        List<String> res = new LinkedList<String>();
        Term term1 = new Term(term, res);
        term1 = dict.search(term);
        if(term1!=null){
            res = term1.getDefinitions();
        }
        else{
            res = null;
        }
        return res;
    }
    
    public void saveTerms() {
        dict.save();
    }
}
