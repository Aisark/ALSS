/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import Enums.TipoDatos;

/**
 *
 * @author dark_
 */
public class ClassTipoDatos implements InterfaceSentencias{

    @Override
    public boolean equals(String word) {
        for(TipoDatos tipo: TipoDatos.values()){
            if(tipo.toString().equals(word))return true;
        }
        return false;
    }
    
}
