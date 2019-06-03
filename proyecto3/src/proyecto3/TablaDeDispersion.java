package proyecto3;
import java.util.Iterator;
import java.util.*;
import java.io.Serializable;

/**
 * Clase que define tablas de dispersión.
 */
public class TablaDeDispersion<K, V> implements Serializable {

    private class Entrada implements  Serializable{

	public K llave;
	public V valor;

	public Entrada(K llave, V valor){
	     this.llave = llave;
         this.valor = valor;
	}
    
    @Override
    public boolean equals(Object t){
        boolean ig = false;
        if(t instanceof TablaDeDispersion.Entrada){
         Entrada g = (Entrada)t;
        if(llave.equals(g.llave) && valor.equals(g.valor))
             ig = true; }

         return ig;   
    }
    }

    private Lista<Entrada>[] tabla;
    private Dispersor<K> dispersor;
    private int elementos;
    public static final int CAPACIDAD_MINIMA = 64;
    private static final double CARGA_MAXIMA = 0.75;


    private Lista<Entrada>[] nuevoArreglo(int tamano){
	@SuppressWarnings("unchecked")
	Lista<Entrada>[] arreglo = (Lista<Entrada>[]) new Lista[tamano];
	return arreglo;
    }
     /**
     *Constructor vacio
     */
     public TablaDeDispersion(){
	     tabla = nuevoArreglo(64*2);
         //dispersor = k.hashCode();
         elementos=0;
     }

     /**
     *Constructor que recibe ua capacidad
     *@param capacidad
     */
    public TablaDeDispersion(int capacidad){
         int capacidadInicial;
         if(capacidad>=64){
             capacidadInicial = capacidad*2;
             double m = Math.log(capacidadInicial)/Math.log(2);
             int tamano =(int) Math.pow(2,(int)Math.ceil(m));
             tabla = nuevoArreglo(tamano);
             //dispersor = K.hashCode();
             dispersor = null;
             elementos=0;}
         else{
             System.out.println("La capacidad minima aceptada es 64");
         }
    }
     /**
     *Constructor que recibe un dispersor
     *@param dispersor
     */
    public TablaDeDispersion(Dispersor<K> dispersor){
             //se modifico esta parte
	     tabla = nuevoArreglo(CAPACIDAD_MINIMA);
         this.dispersor = dispersor;
         elementos=0;
    }
    
    /**
    *Constructor que recibe una capacidad y el tipo de dispersor
    *@param capacidad esta debe superar el tamaño 64
    *@param dispersor 
    */
    public TablaDeDispersion(int capacidad, Dispersor<K> dispersor){
	      int capacidadInicial;
         if(capacidad>=64){
             capacidadInicial = capacidad*2;
             double m = Math.log(capacidadInicial)/Math.log(2);
             int tamano =(int) Math.pow(2,(int)Math.ceil(m));
             tabla = nuevoArreglo(tamano);
             this.dispersor = dispersor;
             elementos=0;}
         else{
             System.out.println("La capacidad minima aceptada es 64");
         }

    }
    

    /**
    *Metodo que recibe un int y le asigna un espacio en la tabla
    *@param int
    *@return espacio
    */
    public int asignaLugar(K llave){
         int posicion =0;
         int hash=0;
         if(dispersor==null){
             //si no hay un dispersor se utilita el propio de Object
             hash = llave.hashCode();
             posicion = hash &(tabla.length -1 );}
         else{
              hash = dispersor.dispersa(llave);
             posicion = hash &(tabla.length -1 );}
        return posicion;
    }
    /**
    *Metodo que agrega en un espacio de la tabla segun la llave
    *@param llave
    *@param valor
    */
    public void agrega(K llave, V valor){ 
         //primero se busca el espacio donde estara
         int posicion = asignaLugar(llave);
         Lista<Entrada> l1;
         //si esta libre creamos la listao
         if(tabla[posicion]==null){
             l1 = new Lista <Entrada>();
             l1.agregaFinal(new Entrada(llave, valor));
             tabla[posicion]= l1;
             elementos++;
         }
         //si ya hay una lista agregamoes el nuevo elemento al final
         else if(tabla[posicion]!=null){
             l1 = tabla[posicion];
              Entrada e1 = new Entrada(llave, valor);
              //si se encuentra la llave se ssustituye
             if(contieneLlave(llave)==true){
                 V v =   elimina(llave);
                 System.out.println("se elimino el repetido");
                 agrega (llave, valor);
              }
             //si no se encuentra la llave entonces se agrega
             if(l1.contiene(e1)==false){
                 l1.agregaFinal(e1);
                 elementos++;}
            
             }

          if(getCarga()>CARGA_MAXIMA){
             
              Lista<Entrada>[] temp = nuevoArreglo(tabla.length*2);
              for(int i = 0; i< tabla.length;i++){
                   if(tabla[i]!= null){
                    Lista<Entrada> l5 = tabla[i];
                    Iterator<Entrada> it = l5.iterator();
                    while(it.hasNext()){
                        Entrada temp2 = it.next();
                        K llave1= temp2.llave;
                        V valor1= temp2.valor;
                        agrega(llave1,valor1);
                    }

                   }
              }
          }

         }
    
    /**
    *Metodo que recupera un elemento segun su llave
    *@param llave
    *@return valor
    */
    public V getValor(K llave){
         V valor = null;
	     if(contieneLlave(llave)==false)
             return null;
         else{
             //for(int i =0;i<tabla.length;i++){
                 Lista <Entrada> l2 = tabla[asignaLugar(llave)];
                 //Iterator <String []> iterator = doc_transformado.iterator();
                 Iterator<Entrada> it = l2.iterator();
                 while(it.hasNext()){
                     Entrada temp = it.next();
                     //si las llaves coinciden se devuelve el valor
                     if(temp.llave.equals(llave)){
                         return temp.valor;
                     }
                 }

             //}
         }
         return null;
    }

    public boolean contieneLlave(K llave){
         
	     if(tabla[asignaLugar(llave)]!=null){
             Lista <Entrada> l2 = tabla[asignaLugar(llave)];
             Iterator<Entrada> it = l2.iterator();
             while(it.hasNext()){
                     Entrada temp = it.next();
                     //si las llaves coinciden se devuelve el valor
                     if(temp.llave.equals(llave)){
                         return true;
                     }
                 }}
         
        return false;

    }

    public boolean contieneValor(V valor){
	     for (int i =0; i< tabla.length;i++){
             if(tabla[i]!= null){
             Lista <Entrada> l2 = tabla[i];
             Iterator<Entrada> it = l2.iterator();
             while(it.hasNext()){
                     Entrada temp = it.next();
                     //si las llaves coinciden se devuelve el valor
                     if(temp.valor.equals(valor)){
                         return true;
                     }
                 }
         }}
        return false;
    }

    public boolean esVacia(){
	     
         if(elementos==0)
             return true;
         else
             return false;
    }

    public V elimina(K llave){
	     V temp =null;
         if(contieneLlave(llave)==true){
             Lista <Entrada> l3 =tabla[asignaLugar(llave)];
             temp=getValor(llave); 
             Entrada tem = new Entrada(llave,temp);
             l3.elimina(tem); 
            // System.out.println("Se encuentra en la lista? "+l3.contiene(tem));
             //System.out.println(l3.elimina(tem) );
             if(l3.getLongitud()==0)
                tabla[asignaLugar(llave)]= null;
             
         }
         return temp;
    }

    public int getElementos(){
	     return elementos;
    }

    public Lista<K> getLlaves(){
	     Lista<K> llaves = new Lista<K>();
         for (int i =0; i< tabla.length;i++){
             if(tabla[i]!= null){
             Lista <Entrada> l2 = tabla[i];
             Iterator<Entrada> it = l2.iterator();
             while(it.hasNext()){
                     Entrada temp = it.next();
                     llaves.agregaFinal(temp.llave);
                 }}
         }
         return llaves;

    }

    public Lista<V> getValores(){
        Lista<V> valores = new Lista<V>();
         for (int i =0; i< tabla.length;i++){
             if(tabla[i]!= null){
             Lista <Entrada> l2 = tabla[i];
             Iterator<Entrada> it = l2.iterator();
             while(it.hasNext()){
                     Entrada temp = it.next();
                     valores.agregaFinal(temp.valor);
                 }}
         }
         return valores;
	
    }
    
    /**
    *Metodo que devuelve el factor de carga de una tabla
    *@return carga
    */
    public double getCarga(){
         double carga = (double) getElementos()/tabla.length;
         return carga;
    }
    
    
    /**
    *Metodo de pruebas
    *me retorna la posicion d3onde se almacena una llave
    */
    public int posicion(K llave){
        return asignaLugar(llave);

    }
}
