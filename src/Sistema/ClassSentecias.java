/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import Enums.Sentencias;
/**
 *
 * @author dark_
 */
public class ClassSentecias implements InterfaceSentencias{
    @Override
    public boolean equals(String word){
        for(Sentencias sen: Sentencias.values()){
            if(sen.toString().equals(word))return true;
        }
        return false;
    }
}
