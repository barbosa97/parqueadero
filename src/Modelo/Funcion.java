/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author andre
 */
public class Funcion {
    public static Integer Tipo(String tipo){
    if(tipo.equals("carro"))
    {return 1;
    }
    else{
    return 2;
    }
    }
    public static boolean ValidarAuto(Ingreso i){
    if(i.getPlaca().length()==6 && i.getTipo()==1){
    return true;
    
    }
    else if(i.getPlaca().length()==5 && i.getTipo()==2){
    
    return true;
    
    }
    return false;
    }
}
