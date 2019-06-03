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
public class TotalObtenido implements Serializable{
     double saldo_total=0;
     String historial="";
     
     public void setSaldo(double saldo){
          saldo_total = saldo;
     }
     
     public void setHistorial(String historial){
          this.historial = historial;      
     }
     
     public double getSaldo(){
     return saldo_total;
     
     }
     public String getHistorial(){
     return historial;
     }
    
}
