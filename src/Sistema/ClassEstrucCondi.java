/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import Enums.Estructuras.Condicion;
/**
 *
 * @author dark_
 */
public class ClassEstrucCondi implements InterfaceSentencias{
    
    @Override
    public boolean equals(String word){
        for(Condicion condi: Condicion.values()){
            if(condi.toString().equals(word))return true;
        }
        return false;
    }
    
}
