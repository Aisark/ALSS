/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import Enums.Estructuras.Control;
/**
 *
 * @author dark_
 */
public class ClassEstrucControl implements InterfaceSentencias{

    @Override
    public boolean equals(String word) {        
        for(Control control: Control.values()){
            if(control.toString().equals(word))return true;
        }        
        return false;
    }
    
}
