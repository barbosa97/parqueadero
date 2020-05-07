/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero;

import Vista.Registro;
import Controlador.Controlador;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 *
 * @author andre
 */
public class Parqueadero {

  
    public static void main(String[] args) {
    Registro r = new Registro();
    new Controlador(r);
   r.setLocationRelativeTo(r);
   r.setVisible(true);
   r.setDefaultCloseOperation(EXIT_ON_CLOSE);
   
    }
    
}
