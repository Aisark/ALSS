/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import Enums.TipoDatos;
import java.lang.reflect.Method;

/**
 *
 * @author dark_
 */
public class ClassTipoDatos {

    
    public static <E extends Enum<E>> void enumValues(Class<E> enumData){
        for(Enum<E> enumitem: enumData.getEnumConstants()){
            try{
                
                Method item = enumitem.getDeclaringClass().getMethod("getChar");
                System.out.println(enumitem.toString());
            }catch(NoSuchMethodException e){
                System.out.println(enumitem.name());
            }
        }
    }
}
