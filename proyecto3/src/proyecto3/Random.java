package proyecto3;

public class Random {
   //Arreglo con los equipos

    //Tienes que cambiar el tipo de dato
    Equipos [] arr;


    /**
    *Constructor con todos los equipos
    */
	public Random(Equipos [] arreglo){
            
		//Este constructor llena el arreglo con todos los equipos
        
		this.arr = arreglo;
	}

    /**
    *Este metodo te regresa un arreglo con el nombre de los equipos de manera aleatoria
    *@return Equipos ordenados de manera aleatoria
    */
	public Equipos [] revuelve(){
		 //arreglo con los numeros del 0 al 7 los cuales se ordenan de manera aleatoria
		 int [] revuelto = new int[8];
		 //arreglo con los eqipos ordenados de manera aleatoria
		 Equipos [] fina = new Equipos[8];
		 //primer contador
		 int i=0;
		 //Se generan numeros aleatorios
		 while(i<8){
		     int numero = (int) (Math.random() * 8)+1;
		     //si el numero no está en el arreglo revuelto se agrega a este
		     if(!contiene(numero,revuelto)){
             revuelto[i]=numero;
             i++;}
	     }
         //se llena el arreglo con los equipos ordenanos de manera aleatoria
	     for(int j =0; j<fina.length;j++){
	     	 fina[j]= arr[revuelto[j]-1];
	     }
	     //se reglresa el arreglo con los equipos ordenados de manera aleatoria
	    return fina;
	}
     
     /**
     *Metodo auxiliar que te dice si un numero esta en el arreglo o no
     *@param num numero a consultar
     *@param arr arreglo donde se buscará el numero
     *@return se encuentra o no
     */
	 public boolean contiene(int num, int[] arr){
		 for(int i =0; i< arr.length;i++){
			 if(num==arr[i])
			 	 return true;
		 }
		 return false;
	}
/**
*    //esto no es necesario solo es para que lo pruebes XDD
*	public static void main(String[] args) {
*		 //se crea objeto
*		 Random obj = new Random(); 
*		 //se obtiene arreglo con los equipos ordenados de manera aleatoria 
*		 Equipos [] temp = obj.revuelve();
*        //se imprime el arreglo con los equipos 
*		 for(int i =0; i<obj.arr.length;i++){
*
*		 	  System.out.println(obj.arr[i].getNombre());
*		 }		 
*	 }
**/
}