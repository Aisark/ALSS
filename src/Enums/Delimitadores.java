/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author dark_
 */
public enum Delimitadores {
    inicio("inicio#"),
    fin("fin#"),
    abrir("{"),
    cerrar("}");
    private final String delimitador;
    private Delimitadores(String delimitador){
        this.delimitador = delimitador;
    }
    public String getChar(){
        return delimitador;
    }
    
    @Override
    public String toString(){
        return delimitador;
    }
}
