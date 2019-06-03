package proyecto3;

import java.io.Serializable;

public class Equipos implements Serializable {
    
    private String nombre;
    private int habilidad;
    private String imagen;
    
    
    public Equipos(){
        this.nombre = "";
        this.habilidad = 0;
        this.imagen = "";
        
    }
    
    public Equipos(String nombre, int habilidad,String imagen){
        this.nombre = nombre;
        this.habilidad = habilidad;
        this.imagen = imagen;
        
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setHabilidad(int habilidad){
        this.habilidad = habilidad;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getHabilidad(){
        return this.habilidad;
    }
    
    public String getImagen(){
        return this.imagen;
    }
    
    public void setImagen(String imagen){
        this.imagen = imagen;
    }
    
    @Override
    public boolean equals(Object o){
    boolean igual = false;
    Equipos temp;
    if(o instanceof Equipos){
        temp = (Equipos)o;
        if(this.nombre.equals(temp.getNombre()))
            return true;
    }
    return igual;
    }
    @Override
    public String toString(){
    
    return this.nombre;}
    
    
}
           
