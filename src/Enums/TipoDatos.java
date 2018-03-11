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
public enum TipoDatos {
    ent("Entero"),
    dec("Decena"),
    cad("Cadena"),
    log("Logico"),
    car("Caracter");
    private final String tipo;
    
    private TipoDatos(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return this.tipo;
    }
}
