
package Controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import Modelo.Ingreso;
import Conexion.Conexion;
import Modelo.Funcion;
import Vista.Registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import Modelo.Ingreso;
public class Controlador implements ActionListener {
    private Registro registro;
    public Controlador(){}
    public Controlador(Registro registro){
    this.registro=registro;
    actionListener(this);
    }
     private void actionListener(ActionListener Controlador) {
  registro.btnAgregar.addActionListener(Controlador);
  registro.btnLimpiar.addActionListener(Controlador);
  registro.btnReiniciar.addActionListener(Controlador);
  registro.btnTotalizar.addActionListener(Controlador);
 }

    public void actionPerformed(ActionEvent ev) {
        
        try{
            
            if(ev.getActionCommand().equals("Agregar")){
    String tipo = registro.tipocombo.getSelectedItem().toString();
    String placa = registro.txtPlaca.getText();
    String modelo = registro.txtModelo.getText();
    
    Ingreso ingreso = new Ingreso(Integer.parseInt(tipo),placa,Integer.parseInt(modelo));
    Ingreso i = new Ingreso();
    i.setPlaca(placa);
   
    Controlador controlador = new Controlador();
    controlador.guardar(i);
            }
      else if(ev.getActionCommand().equals("Limpiar")){
     registro.txtModelo.setText("");
     registro.txtPlaca.setText("");
       
       }
            
       
    }
        catch(Exception e){}
        
        
     try{
     if(ev.getActionCommand().equals("Totalizar")){
     
         
         
         
     }
     }
    }
    
    public static void guardar(Ingreso i){
    try{
    
    Connection conexion = Conexion.obtener();
    PreparedStatement consulta;
    consulta=conexion.prepareStatement("INSERT INTO registro(placa,modelo,tipo,valor)" + "VALUES(?,?,?,?)");
    consulta.setString(1, i.getPlaca());
    consulta.setInt(2, i.getModelo());
    consulta.setInt(3, i.getTipo());
    consulta.setInt(4, i.getValor());
    }   catch (SQLException ex) {
         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Boolean ExistePlaca(String placa){
    try{
    
    Connection conexion = Conexion.obtener();
    PreparedStatement consulta;
    consulta = conexion.prepareStatement("SELECT * FROM registro WHERE placa = ?");
    consulta.setString(1, placa);
    
    ResultSet rs = consulta.executeQuery();
    if(rs.next()){
    return true;
    
    }
    return false;
    }   catch (SQLException ex) {  
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }  
    
    return false;
    
    }
    
    public static String Totalizar(){
    
    try{
    Connection conexion = Conexion.obtener();
    PreparedStatement consulta;
    consulta = conexion.prepareStatement("select"+"sum(valor)as total, count(placa) as cantidad,tipo"
                                                 +"from registro group by tipo");
    
    
    ResultSet rs = consulta.executeQuery();
    String total = "";
    if(rs.next()){
    total = total +"El total de carros es:"+rs.getInt("cantidad") + "con un valor de:" +rs.getInt("valor")+"";
    
    }
    if(rs.next()){
    
    total = total +"El total de motos es:"+rs.getInt("cantidad") + "con un valor de:" +rs.getInt("valor")+"";
    }
    return total;
    
    }   catch (SQLException ex) {
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    return "Error al totalizar";
    }
    public static void eliminar(){
    
    try{
    Connection conexion = Conexion.obtener();
    PreparedStatement consulta;
    consulta = conexion.prepareStatement("DELETE FROM registro");
    consulta.executeUpdate();
    }   catch (SQLException ex) {
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }


   

   
}
