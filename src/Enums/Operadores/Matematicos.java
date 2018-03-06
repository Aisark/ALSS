/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums.Operadores;

/**
 *
 * @author dark_
 */
public enum Matematicos {
    
    SUMA("+"),
    RESTA("-"),
    MULTI("*"),
    DIV("/"),
    RESID("%");
    
    private final String operador;
    private Matematicos(String operador){
        this.operador = operador;
    }
}
