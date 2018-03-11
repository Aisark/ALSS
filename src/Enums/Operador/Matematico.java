/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums.Operador;

/**
 *
 * @author dark_
 */
public enum Matematico {
    
    SUMA("+"),
    RESTA("-"),
    MULTI("*"),
    DIV("/"),
    RESID("%");
    
    private final String operador;
    private Matematico(String operador){
        this.operador = operador;
    }
    public String getChar(){
        return operador;
    }
    @Override
    public String toString(){
        return operador;
    }
}
