package proyecto3;
import java.util.*;
import java.io.*;
/**
*Clase de pruebas
*@version 1.0
*/


public class Test {
    
    public Test(){
    Torneo1 test = new Torneo1();}
     
     public static void main(String[] args) {
         /**
     	  System.out.println("Pruebas a base de datos");
     	  Base base = new Base();
     	  Usuario us = new Usuario("Nestor", "nestor2502", "correo", "1086");
     	  Usuario usa = new Usuario("Nestor Semer", "nestor250", "correo", "1086");
     	  System.out.println();
     	  System.out.println();
     	  System.out.println("Existe el nombre nestor: "+base.existeNombreUsuario(us));
     	  System.out.println("Existe el correo: "+base.existeCorreo(us));
     	  System.out.println("Existe el Usuario: "+base.existeUsuario(us));
          System.out.println("");
     	  base.agrega(us);
          System.out.println("Existe el nombre nestor: "+base.existeNombreUsuario(usa));
     	  System.out.println("Existe el correo: "+base.existeCorreo(usa));
     	  System.out.println("Existe el Usuario: "+base.existeUsuario(usa));
          System.out.println("");
          System.out.println("");
     	  //if(base.existeNombreUsuario(us)||base.existeCorreo(us))
     	  //	   base.getAdvertencias(usa);
     	  //else
     	  //base.agrega(usa);
           /**   
     	  System.out.println();
     	  System.out.println();
     	  System.out.println("Existe el nombre nestor: "+base.existeNombreUsuario(us));
     	  System.out.println("Existe el correo: "+base.existeCorreo(us));
     	  System.out.println("Existe el Usuario: "+base.existeUsuario(us));*/
          //prueba de serializacion con listas
          /**
          Lista<String> prueba1 = new Lista<String>();
          TablaDeDispersion <String, String> prueba2 = new TablaDeDispersion <String, String>((x) -> Dispersiones.dispersionDJB(x.getBytes()));
     	  Usuario prueba3 = new Usuario("Nestor", "nestor2502", "correo", "1086");
          Base prueba4 = new Base();
//Base [] base2 = {base};
     	  //int [] test = {4,4,5,6,4,8,5,7};
     	   Base personal_recuperado=null;
                //leyendOo archivo
                try{
                ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("Base_De_Datos"));
                escribiendo_fichero.writeObject(base);
                escribiendo_fichero.close();
                
                ObjectInputStream recuperando_fichero= new ObjectInputStream(new FileInputStream("Base_De_Datos"));
                 personal_recuperado =(Base )recuperando_fichero.readObject();
                recuperando_fichero.close();/*
                ByteArrayOutputStream bs= new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream (bs);
                os.writeObject(base);  // this es de tipo DatoUdp
                os.close();
               byte[] bytes =  bs.toByteArray(); // devuelve byte[]
                System.out.println("Existe el nombre nestor: "+personal_recuperado.existeNombreUsuario(us));
     	  System.out.println("Existe el correo: "+personal_recuperado.existeCorreo(us));
     	  System.out.println("Existe el Usuario: "+personal_recuperado.existeUsuario(us));*/
          /**
                }
                 catch(IOException e){
                	System.out.println(e.getMessage());
                }
                catch(ClassNotFoundException e){
                	System.out.println(e.getMessage());
                }
                
                
             ///Prueba de lectura
             
             
           */  
          
           
        Torneo1 test = new Torneo1();/**
        try{
        test.iniciar();
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }*/

     }
}
