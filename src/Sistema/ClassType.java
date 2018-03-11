/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;
import Enums.Tipo;
import java.lang.reflect.Method;

/**
 *
 * @author dark_
 */
public class ClassType {

    
    public static <E extends Enum<E>> boolean isThisType(Class<E> enumData, String word){
        for(Enum<E> enumitem: enumData.getEnumConstants()){
            if(containMethod(enumData)){
                if(enumitem.toString().equalsIgnoreCase(word))return true;
            }else{
                if(enumitem.name().equalsIgnoreCase(word))return true;
            }
        }
        return false;
    }
    
    public static <E extends Enum<E>> Tipo getTipo(Class<E> enumData,String word){
        String nameclass = enumData.getName();
        for(Tipo tipo: Tipo.values()){
            
        }
        return Tipo.NOTIPO;
    }
    
    public static <E extends Enum<E>> boolean containMethod(Class<E> enumData){
        try{
            Method item = enumData.getMethod("getChar");
            return true;
        }catch(NoSuchMethodException e){
            return false;
        }
    }
    
    
}
