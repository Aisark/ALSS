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
    private int line = 0;
    private final ArrayList<String> words = new ArrayList<>();
    private final ArrayList<Object[]> listwords = new ArrayList<>();
    private boolean reciveString  = false;
    private String stringword = "";
    //--------------------------------------------------------------------------
    //                   Publics Methods
    //--------------------------------------------------------------------------
    
    public void splitLines(JTextArea txtEditor){
        line = 0;
        stringword="";
        reciveString=false;
        listwords.clear();
        if (txtEditor.getText().length() > 0) {
            String wordeditor = txtEditor.getText();
            String[] wordsarray = wordeditor.split("\n");
            for(int i=0;i< wordsarray.length;i++ ){
                if(!wordsarray[i].equals(""))setWords(wordsarray[i]);
                line = i+1;
            }
        }
    }
    
    private void setWords(String txtEditor){
        if (txtEditor.length() > 0) {
            String wordeditor = txtEditor;
            String[] wordsarray = wordeditor.split("[\\s\\t]");
            for(String word: wordsarray){
                if(!word.equals(""))setWord(word);
            }
        }
    }
    public ArrayList<Object[]> getListWords(){
        return listwords;
    }
      
    //--------------------------------------------------------------------------
    //                   Privates Methods
    //--------------------------------------------------------------------------
    private void addList(String word){
        listwords.add(new Object[]{word,line});
    }
    /**
     * Analiza una string y lo procesa para definir si es una sentencia
     * o si es un string
     * @param word 
     * @return void
     */
    private void setWord(String word){
        if(word.contains(";") && !reciveString && !word.startsWith("\"")){
            setDeclaritionWord(word);
        }if(word.startsWith("\"")||reciveString){
            setStringWord(word);
        }
        else if(!word.contains(";")){
            addList(word);
        }
    }
    /**
     * Agrega una palabra en la lista words si considera que es una declaracion
     * @param word 
     * @return void
     */
    private void setDeclaritionWord(String word){
        String newword = word.replaceAll(";","; ");
        String[] sentenArray = newword.split(" ");
        if(sentenArray.length>0){
            for(String sent: sentenArray){
                if(!sent.equals(""))addList(sent);
            }
        }else{
            addList(word);
        }
        
    }
    /**
     * Organiza una literal de tipo String
     * produce un error al ingresar esta secuencia  asd "asd "asd";AAS
     * @param word tipo String reprenseta una palabra a analizar
     * @return void 
     */
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
                int occur = (word.lastIndexOf("\"")-word.indexOf("\""));
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
    /**
     * Agrega una literal de tipo String en la lista word
     * @return void
     * @param word 
     */
    private void outSetStringWord(String word){
        addList(word);
        stringword="";
        reciveString=false;
    }
    /**
     * Agrega una literal String organizada y se prepara para organizar otra
     * @return void
     * @param word 
     */
    private void preOutSetStringWord(String word){
        String newword = word.replaceAll("\"","\" ").replaceAll(";", "; " );
        newword = newword.replaceAll("\" ;", "\";" );
        String[] nwwords = newword.split(" ");
        for(String nww: nwwords){
            setWord(nww);
        }
    }
    
}
