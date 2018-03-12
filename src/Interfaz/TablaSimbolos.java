/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dark_
 */
public class TablaSimbolos {
    private static DefaultTableModel tabladata;
    
    
    
    public static void setDataTableSimbolo(ArrayList<Object[]> words, DefaultTableModel model){
        tabladata = model;
        removeAllRows(tabladata);
        int id = 1;
        for(Object[] word: words){
            tabladata.addRow(new Object[]{word[0],"tipo",word[1],id});
            id++;
        }
        
    }    
    public static DefaultTableModel model(){
        return tabladata;
    }
    
    
    private static void removeAllRows(DefaultTableModel mode){
       if(mode.getRowCount()>0){
            int columCount = mode.getColumnCount();
            do{
                mode.removeRow(columCount-1);
                columCount--;
            }while (columCount!=0);
       }
    }
    
}
