/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JTextArea;

/**
 *
 * @author dark_
 */
public class LexicoSettings {
    private ArrayList<String> words = new ArrayList<>();
    private boolean reciveString  = false;
    private String stringword = "";
    //--------------------------------------------------------------------------
    //                   Publics Methods
    //--------------------------------------------------------------------------
    public void setWords(JTextArea txtEditor){
        stringword="";
        reciveString=false;
        words.clear();
        if (txtEditor.getText().length() > 0) {
            String wordeditor = txtEditor.getText();
            String[] wordsarray = wordeditor.split("[\\n\\s\\t]");
            for(String word: wordsarray){
                if(!word.equals(""))setWord(word);
            }
        }
    }
    public ArrayList<String> getListWords(){
        return words;
    }
    
    
    
    
    //--------------------------------------------------------------------------
    //                   Privates Methods
    //--------------------------------------------------------------------------
    private void setWord(String word){
        if(word.contains(";") && !reciveString && !word.startsWith("\"")){
            setDeclaritionWord(word);
        }if(word.startsWith("\"")||reciveString){
            setStringWord(word);
        }
        else if(!word.contains(";")){
            words.add(word);
        }
    }
    
    private void setDeclaritionWord(String word){
        String newword = word.replaceAll(";","; ");
        String[] sentenArray = newword.split(" ");
        if(sentenArray.length>0){
            for(String sent: sentenArray){
                if(!sent.equals(""))words.add(sent);
            }
        }else{
            words.add(word);
        }
        
    }
    
    private void setStringWord(String word){
        if(word.contains("\"")){
            if(word.startsWith("\"")){
                if(word.endsWith("\"")||word.endsWith("\";")){
                    outSetStringWord(word);
                }else{
                    stringword = word+" ";
                    reciveString=true;
                }

            }else if(word.endsWith("\"")||word.endsWith("\";")){                
                int occur = (word.endsWith("\";"))?
                        (word.lastIndexOf("\";")-word.indexOf("\";")):
                        (word.lastIndexOf("\"")-word.indexOf("\""));
                if(occur==0){
                    stringword += word;
                    outSetStringWord(stringword);
                }else{
                    preOutSetStringWord(word);
                }                
            }else{
                preOutSetStringWord(word);
            }
        }else{
            stringword += word+" ";
        }
        
    }    
    private void outSetStringWord(String word){
        words.add(word);
        stringword="";
        reciveString=false;
    }
    private void preOutSetStringWord(String word){
        String newword = (word.contains("\";"))? word.replaceAll("\";","\"; "):word.replaceAll("\"","\" ");
        String[] nwwords = newword.split(" ");
        for(String nww: nwwords){
            setWord(nww);
        }
    }
    
}
