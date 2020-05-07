/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;



/**
 *
 * @author andre
 */
public class Ingreso {
    private Integer tipo;
    private String placa;
    private Integer modelo; 
    private Integer valor;
    public Ingreso() {
    }

    public Ingreso(Integer tipo, String placa, Integer modelo,Integer valor) {
        this.tipo = tipo;
        this.placa = placa;
        this.modelo = modelo;
        this.valor=valor;
    }

    public Ingreso(int parseInt, String placa, int parseInt0) {
      
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public Integer getValor() {
        if(this.modelo<2012){
        
        if(this.tipo==1){
        valor=2000;
        }
        else{
        valor=1000;
        }
        }
        else{
        
        if(this.tipo==1){
        valor=2500;
        if(this.modelo==2020){
        valor = new Integer((int)(valor*1.2));
        }
        }
        else{
        valor=1200;
        if(this.modelo==2020){
        valor = new Integer((int)(valor*1.1));
        }
        
        }
        }

     return valor;
    }

   public void setValor(Integer valor) {
        this.valor = valor;
    }
}


    

