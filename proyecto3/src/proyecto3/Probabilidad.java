
package proyecto3;

import java.text.DecimalFormat;

public class Probabilidad {
    DecimalFormat formato = new DecimalFormat();
    private Equipos A;
    private Equipos B;
    private Equipos Winner;
    private double ProbaA;
    private double ProbaB;
    private double Apostado;
    private double regreso;
    
    	public Probabilidad(){
            this.A = null;
            this.B = null;
            this.ProbaA = 0;
            this.ProbaB = 0;
            this.Apostado = 0;
            this.regreso = 0;
        }
    
	public Probabilidad(Equipos A, Equipos B){
		this.A = A;
		this.B = B;
		setProbabilidad();
	}

	public Equipos ganador(){// throws InterruptedException{
		double aux = Math.random();
                
               // Thread.sleep(1000);
		if(ProbaA <= ProbaB) {
			if(ProbaA <= aux){
                                this.Winner = A;
				return A;
                        }else{ 
                               this.Winner = B;     
				return B;
			}
                }else{
			if(ProbaB <= aux){
                                this.Winner = B;
				return B;
                                }else{ 
                                this.Winner = A;
				return A;
                                }
			}
                }  
                
	
        
        public double aRegresar(Equipos propio) throws InterruptedException{
            double temporal = 0;
            double temporal1 = 0;
            //Si entras aqui, significa que si aposto por el equipo correcto
            if(propio == Winner){
                double aux0 = 1/(ProbaA);
                temporal = Decimal(aux0);
                temporal1 = temporal * Apostado;
                return temporal1;
            }
         
         //No aposto por el equipo correcto
            return 0;
        }
        
        
        public double Decimal(double Decimal){
            String aux1 = formato.format(Decimal);
        double aux = Double.parseDouble(aux1);
        return aux;
        }
	
	public void setProbabilidad() {
		//Sacamos la probabilidad de cada uno y los guardamos en probaA y B
		ProbaA = (double) A.getHabilidad() / (A.getHabilidad() + B.getHabilidad());
		ProbaB = (double) B.getHabilidad() / (A.getHabilidad() + B.getHabilidad());
	}
	
        
//------------------------------------------------------------------------	
	public void setProbaA(double probabilidad) {
		this.ProbaA = probabilidad;
	}	
	public double getProbaA() {
		return ProbaA;
	}
	public void setProbaB(double probabilidad) {
		this.ProbaB = probabilidad;
	}	
	public double getProbaB() {
		return ProbaB;
	}
//------------------------------------------------------------------------
	public void setEquiposA(Equipos A) {
		this.A = A;
	}
	public void setEquiposB(Equipos B) {
		this.B = B;
	}	
	public Equipos getEquiposA() {
		return A;
	}
	public Equipos getEquiposB() {
		return B;
	}
        
        public void setApostado(double apostado){
        String aux1 = formato.format(apostado);
        double aux = Double.parseDouble(aux1);
        this.Apostado = aux;
        }

        public double getApostado(){
        return this.Apostado;
        }
        
        public void setWinner(Equipos ganador){
            this.Winner = ganador;
        }
        
        public Equipos getWinner(){
            return this.Winner;
        }
//------------------------------------------------------------------------
}
