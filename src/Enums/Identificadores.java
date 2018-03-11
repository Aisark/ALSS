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
public enum Identificadores {
    cadena("^\".*\"$"),
    literal("\"^[a-zA-Z]\\\\w*$\""),
    entero("^[0-9][0-9]*[0-9]$");
    private final String regex;
    private Identificadores(String regex){
        this.regex = regex;
    }
}
