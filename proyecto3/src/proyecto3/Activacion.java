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
public class Activacion implements Serializable{
    public boolean activacion = false;
    
    public Activacion(boolean activacion){
        this.activacion = activacion;
    }
    
    public boolean getActivacion(){
    return activacion;}
    
}
