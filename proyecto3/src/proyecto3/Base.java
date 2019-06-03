package proyecto3;
import java.util.*;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
*Clase que se almacenará en el disco duro con todos los usuario
*/
public class Base implements  Serializable{
     Lista <String> usuarios = new Lista<String>();
     Lista <String> correos = new Lista<String>();
     TablaDeDispersion <String, Usuario> tabla = new TablaDeDispersion <String,Usuario>((x) -> Dispersiones.dispersionDJB(x.getBytes()));
     //TablaDeDispersion <String, Usuario> tabla = new TablaDeDispersion <String,Usuario>();
    public Base(){
    	
    	tabla = new TablaDeDispersion <String,Usuario>(x -> Dispersiones.dispersionDJB(x.getBytes())); 
    }
    
    /**
    *Metodo que retorna si el nombre de usuario ya está registrado
    *@param obj usuariuo a checar
    *@return contiene 
    */
    public boolean existeUsuario(Usuario obj){
    	 boolean contiene = false;
    	 String usuario = obj.getUsuario();
    	 String contraseña = obj.getContraseña();
         String correo = obj.getCorreo();
    	 String llave = correo.concat(contraseña);
    	 if(tabla.contieneLlave(llave)){
    	 	 contiene = true;
    	 }
         return contiene;
    }
    
    public Usuario getUsuario(String llave){
         Usuario us = null;
         us = tabla .getValor(llave);
         return us;
    }
    /**
     * 
     * @param llave
     * @return contiene
     */
    public boolean existeUsuario(String llave){
               
         return tabla.contieneLlave(llave);
    }
     
     /**
     *Metodo que nos dice si ya está un correo registrado
     */
    public boolean existeNombreUsuario(Usuario obj){
    	 boolean contiene = false;
    	 if(usuarios.contiene(obj.getUsuario())){
    	 	  contiene = true;
    	 }
          return contiene;
    }
    public boolean existeCorreo(Usuario obj){
    	 boolean contiene = false;
    	 if(correos.contiene(obj.getCorreo())){
    	 	  contiene = true;
    	 }
          return contiene;
    }
    

    public void agrega(Usuario obj){
    	 String usuario = obj.getUsuario();
    	 String contraseña = obj.getContraseña();
    	 String correo = obj.getCorreo();
    	 String llave = correo.concat(contraseña);
    	 usuarios.agregaFinal(usuario);
    	 correos.agregaFinal(correo);
         tabla.agrega(llave, obj);
    }

    public void getAdvertencias(Usuario obj){
    	 String advertencia ="";
    	 String usuario = obj.getUsuario();
    	 String contraseña = obj.getContraseña();
    	 String correo = obj.getCorreo();
    	 String llave = correo.concat(contraseña);
    	 int cont=0;
    	 if(existeNombreUsuario(obj)){
             advertencia+="Este nombre de usuario ya esta en uso";
    	     cont++;
    	 }
    	 if(existeCorreo(obj)){
    	 	 advertencia+="\nEste correo ya está registrado";
             cont++;
    	 }
         if(cont>0)
         JOptionPane.showMessageDialog(null, advertencia);
    	
    }

	
}