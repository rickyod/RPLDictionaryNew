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
 *
 * @author Adam Hafidz F
 */
public class Dictionary {
    
    private HashMap<String , Term> termsMap;
    
    public Dictionary()
    {
        DictionaryFileReader dfr = new DictionaryFileReader();
        List<Term> list = dfr.loadTerm("terms.txt");
        termsMap=new HashMap<>();
        int length = list.size();
        Term curTerm;
        for (int i = 0; i < length; i++) {
            curTerm = list.get(i);
            termsMap.put(curTerm.getIstilah().toLowerCase(), curTerm);
        }
    }
    
    public Term search(String term)
    {
        return termsMap.get(term.toLowerCase());
    }
    
    public void add(String term,ArrayList<String> definition)
    {
        Term temp=new Term(term, definition);
        termsMap.put(term.toLowerCase(), temp);
    }
    
    public void remove(String t)
    {
        termsMap.remove(t);
    }
    
    public boolean edit(String termName, String newTermName , ArrayList<String> newDefinition)
    {
        Term oldTerm = search(termName);
        if(oldTerm==null){
            return false;
        }
        termsMap.remove(termName);
        termsMap.put(termName.toLowerCase(), new Term(newTermName,newDefinition));
        return true;
    }

    public void save() {
        DictionaryFileWriter dfw = new DictionaryFileWriter();
        ArrayList<Term> listTerm = new ArrayList<>();
        for (Map.Entry<String, Term> entry : termsMap.entrySet())
        {
            listTerm.add(termsMap.get(entry.getKey()));
        }
        
        dfw.writeTermsToFile(listTerm, "terms.txt");
    }
}
