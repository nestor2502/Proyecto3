/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import java.io.Serializable;

/**
 *
 * @author nestor2502
 */
public class Apuesta implements Serializable{
     double cantidad;
     Equipos seleccionado;
    
    public Apuesta(double cantidad, Equipos seleccionado){
          this.cantidad = cantidad;
          this.seleccionado = seleccionado;
         
    }
    public double getApuesta(){
    return cantidad;
    }
    public Equipos getEquipoApostado(){
         return seleccionado;
    }
    
}
