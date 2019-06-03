/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author isayd
 */
public class Torneo1 extends javax.swing.JFrame implements ActionListener{
public Equipos [] arr;
Wapuesta1 apuesta1= null;
Wapuesta1 apuesta2= null;
Wapuesta1 apuesta3= null;
Wapuesta1 apuesta4= null;
Wapuesta1 apuesta5= null;
Wapuesta1 apuesta6= null;
Wapuesta1 apuesta7= null;

//Ganadores por cada ronda
Equipos cuartos []= new Equipos[4];
Equipos semi []= new Equipos[2];
Equipos last []= new Equipos[1];
    //Inici
public Equipos A;
public Equipos B;
public Equipos C;
public Equipos D;
public Equipos E;
public Equipos F;
public Equipos G;
public Equipos H;

//Semifinal
public Equipos semi1;
public Equipos semi2;
public Equipos semi3;
public Equipos semi4;

//Final
public Equipos last1;
public Equipos last2;

//Ganador
public Equipos winner;
//objeto a serializar 
public TotalObtenido total;
//contador para accion de ventana
int contador=0;
//total acumulado por el jugador
double acumulado=0;
//informacion obtenida cada vez que se 
Apuesta personal_recuperado;
//
String historial = "";
//temporizador

Timer t = null; 
Base base;
        String llave;
    /**
     * Creates new form Torneo
     */
    public Torneo1() {
        
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("Proyecto 3");
        this.setResizable(false);
        regresar.setContentAreaFilled(false);
        Equipos Seoul = new Equipos("Seoul Dynasty", 200, "Seoul.png");
        Equipos Houston = new Equipos("Houston Outlaws", 180, "Houston.png");
        Equipos LAG = new Equipos("LA Gladiator", 210, "LosAngeles.png");
        Equipos NY = new Equipos("New York Excelsior", 240, "New York.png");
        Equipos Phily = new Equipos("Philadelphia Fusion", 230, "Philadelphia.png");
        Equipos Shangai = new Equipos("Shangai Dragons", 190, "Shangai.png");
        Equipos Vanc = new Equipos("Vancouver Titans", 215,"Vancouver.png");
        Equipos Atl = new Equipos("Atlanta Reign", 224, "Atlanta.png");
        Equipos[] arr1 = {Seoul,Houston,LAG,NY,Phily,Shangai,Vanc,Atl};
        
        this.arr = arr1;
        
        Apostar5.setVisible(false);
       
        Apostar6.setVisible(false);
       
        Apostar7.setVisible(false);
        
        ImageIcon imagen = new ImageIcon(getClass().getResource("/proyecto3/Fondo2.jpg"));
        Icon fondo = new ImageIcon(imagen.getImage().getScaledInstance(Fondo.getWidth(),Fondo.getHeight(),Image.SCALE_DEFAULT));
        Fondo.setIcon(fondo);
        
        acomodarEquipos();
        
        /**
        Apostar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 if(e.getSource() == t){ 
     dispose(); }
            }
        });*/
        total = new TotalObtenido();
        t = new Timer(10000, this); 
        t.start(); 
        
    }
    public Torneo1(double saldo, String historial, Base b, String v) {
        
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setTitle("Proyecto 3");
        this.setResizable(false);
        this.base = b;
        this.llave = v;
        regresar.setContentAreaFilled(false);
        Equipos Seoul = new Equipos("Seoul Dynasty", 200, "Seoul.png");
        Equipos Houston = new Equipos("Houston Outlaws", 180, "Houston.png");
        Equipos LAG = new Equipos("LA Gladiator", 210, "LosAngeles.png");
        Equipos NY = new Equipos("New York Excelsior", 240, "New York.png");
        Equipos Phily = new Equipos("Philadelphia Fusion", 230, "Philadelphia.png");
        Equipos Shangai = new Equipos("Shangai Dragons", 190, "Shangai.png");
        Equipos Vanc = new Equipos("Vancouver Titans", 215,"Vancouver.png");
        Equipos Atl = new Equipos("Atlanta Reign", 224, "Atlanta.png");
        Equipos[] arr1 = {Seoul,Houston,LAG,NY,Phily,Shangai,Vanc,Atl};
        acumulado =00;//saldo;
        this.historial = historial;
        this.arr = arr1;
        
        Apostar5.setVisible(false);
       
        Apostar6.setVisible(false);
       
        Apostar7.setVisible(false);
        
        ImageIcon imagen = new ImageIcon(getClass().getResource("/proyecto3/Fondo2.jpg"));
        Icon fondo = new ImageIcon(imagen.getImage().getScaledInstance(Fondo.getWidth(),Fondo.getHeight(),Image.SCALE_DEFAULT));
        Fondo.setIcon(fondo);
        
        acomodarEquipos();
        
        /**
        Apostar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 if(e.getSource() == t){ 
     dispose(); }
            }
        });*/
        total = new TotalObtenido();
        t = new Timer(10000, this); 
        t.start(); 
        
    }
    
    public void setHistorialT(){
    historial+="ganaste :)\n";
    }
    public void setHistorialF(){
    historial+="perdiste :(\n";
    }
    public void setSaldo(){
        Apuesta apuesta= null;/**
        try{
                ObjectInputStream recuperando_fichero= new ObjectInputStream(new FileInputStream("ApuestaTemp"));
                 apuesta =(Apuesta)recuperando_fichero.readObject();
                recuperando_fichero.close();
                }
        catch(IOException | ClassNotFoundException e){
                    System.out.println("ooops");
                }
        if(apuesta != null){
        acumulado+= apuesta.getApuesta();
        saldoTemp.setText(String.valueOf(acumulado));
        }*/
         if(personal_recuperado!= null){
              acumulado+= personal_recuperado.getApuesta();
              saldoTemp.setText(String.valueOf(acumulado));
         }
    }
    public double getSaldo(){
    return acumulado;
    }
    //saldo += }
    
    @Override 
     public void actionPerformed(ActionEvent e) { 
     if(e.getSource() == t){ 
         if(apuesta1!= null)
             apuesta1.dispose(); 
         if(apuesta2!= null)
             apuesta2.dispose();
         if(apuesta3!= null)
             apuesta3.dispose();
         if(apuesta4!= null)
             apuesta4.dispose();
         if(apuesta5!= null)
             apuesta5.dispose();
         if(apuesta6!= null)
             apuesta6.dispose();
         if(apuesta7!= null)
             apuesta7.dispose();
     }
} 
        
        public Equipos batalla(Equipos alpha, Equipos beta){ //throws InterruptedException{
            Probabilidad batalla = new Probabilidad(alpha, beta);
            return batalla.ganador();
        }
    
        public void acomodarEquipos(){
        Random obj = new Random(arr);
        Equipos [] temp = obj.revuelve();
            A = temp[0];
            B = temp[1];
            C = temp[2];
            D = temp[3];
            E = temp[4];
            F = temp[5];
            G = temp[6];
            H = temp[7];
            
            semi1 = null;
            semi2 = null;
            semi3 = null;
            semi4 = null;
            
            last1 = null;
            last2 = null;
            
            winner = null;
        ImageIcon imagen2 = new ImageIcon(getClass().getResource(A.getImagen()));
        Icon fondo1 = new ImageIcon(imagen2.getImage().getScaledInstance(Cua1.getWidth(),Cua1.getHeight(),Image.SCALE_DEFAULT));
        Cua1.setIcon(fondo1);
        
        ImageIcon imagen3 = new ImageIcon(getClass().getResource(B.getImagen()));
        Icon fondo2 = new ImageIcon(imagen3.getImage().getScaledInstance(Cua2.getWidth(),Cua2.getHeight(),Image.SCALE_DEFAULT));
        Cua2.setIcon(fondo2);
        
        ImageIcon imagen4 = new ImageIcon(getClass().getResource(C.getImagen()));
        Icon fondo3 = new ImageIcon(imagen4.getImage().getScaledInstance(Cua3.getWidth(),Cua3.getHeight(),Image.SCALE_DEFAULT));
        Cua3.setIcon(fondo3);
        
        ImageIcon imagen5 = new ImageIcon(getClass().getResource(D.getImagen()));
        Icon fondo4 = new ImageIcon(imagen5.getImage().getScaledInstance(Cua4.getWidth(),Cua4.getHeight(),Image.SCALE_DEFAULT));
        Cua4.setIcon(fondo4);
        
        ImageIcon imagen6 = new ImageIcon(getClass().getResource(E.getImagen()));
        Icon fondo5 = new ImageIcon(imagen6.getImage().getScaledInstance(Cua5.getWidth(),Cua5.getHeight(),Image.SCALE_DEFAULT));
        Cua5.setIcon(fondo5);
        
        ImageIcon imagen7 = new ImageIcon(getClass().getResource(F.getImagen()));
        Icon fondo6 = new ImageIcon(imagen7.getImage().getScaledInstance(Cua6.getWidth(),Cua6.getHeight(),Image.SCALE_DEFAULT));
        Cua6.setIcon(fondo6);
        
        ImageIcon imagen8 = new ImageIcon(getClass().getResource(G.getImagen()));
        Icon fondo7 = new ImageIcon(imagen8.getImage().getScaledInstance(Cua7.getWidth(),Cua7.getHeight(),Image.SCALE_DEFAULT));
        Cua7.setIcon(fondo7);
        
        ImageIcon imagen9 = new ImageIcon(getClass().getResource(H.getImagen()));
        Icon fondo8 = new ImageIcon(imagen9.getImage().getScaledInstance(Cua8.getWidth(),Cua8.getHeight(),Image.SCALE_DEFAULT));
        Cua8.setIcon(fondo8);
        
    }
    
        public void cuartos()throws InterruptedException{
        semi1 = batalla(A,B);
        
        semi2 = batalla(C,D);
        
        semi3 = batalla(E,F);
        
        semi4 = batalla(G,H);
        //se llena el arreglo con los ganadores
        cuartos[0]=semi1;
        cuartos[1]=semi2;
        cuartos[2]=semi3;
        cuartos[3]=semi4;
    }
        public Equipos [] getWinnerCuartos(){
        return cuartos;
        }
        public Equipos [] getWinnerSemi(){
        
        return semi;
        }
        public Equipos [] getWinnerLast(){
        
        return last;
        }
        
        public void mostrarCuartos(){
        ImageIcon imagen10 = new ImageIcon(getClass().getResource(semi1.getImagen())); 
        Icon fondo9 = new ImageIcon(imagen10.getImage().getScaledInstance(Semi1.getWidth(), Semi1.getHeight(), Image.SCALE_DEFAULT));
        Semi1.setIcon(fondo9);
        
        ImageIcon imagen11 = new ImageIcon(getClass().getResource(semi2.getImagen())); 
        Icon fondo10 = new ImageIcon(imagen11.getImage().getScaledInstance(Semi2.getWidth(), Semi2.getHeight(), Image.SCALE_DEFAULT));
        Semi2.setIcon(fondo10);
        
        ImageIcon imagen12 = new ImageIcon(getClass().getResource(semi3.getImagen())); 
        Icon fondo11 = new ImageIcon(imagen12.getImage().getScaledInstance(Semi3.getWidth(), Semi3.getHeight(), Image.SCALE_DEFAULT));
        Semi3.setIcon(fondo11);
        
        ImageIcon imagen13 = new ImageIcon(getClass().getResource(semi4.getImagen())); 
        Icon fondo12 = new ImageIcon(imagen13.getImage().getScaledInstance(Semi4.getWidth(), Semi4.getHeight(), Image.SCALE_DEFAULT));
        Semi4.setIcon(fondo12);
        
            Apostar1.setVisible(false);
            Apostar2.setVisible(false);
            Apostar3.setVisible(false);
            Apostar4.setVisible(false);
            Apostar5.setVisible(true);
            Apostar6.setVisible(true);
        }
        
        public void mostrarSemifinal(){
        ImageIcon imagen14 = new ImageIcon(getClass().getResource(last1.getImagen())); 
        Icon fondo13 = new ImageIcon(imagen14.getImage().getScaledInstance(Last1.getWidth(), Last1.getHeight(), Image.SCALE_DEFAULT));
        Last1.setIcon(fondo13);
        
        ImageIcon imagen15 = new ImageIcon(getClass().getResource(last2.getImagen())); 
        Icon fondo14 = new ImageIcon(imagen15.getImage().getScaledInstance(Last2.getWidth(), Last2.getHeight(), Image.SCALE_DEFAULT));
        Last2.setIcon(fondo14);
        
            Apostar5.setVisible(false);
            Apostar6.setVisible(false);
            Apostar7.setVisible(true);
        }
    
    public void semifinal()throws InterruptedException{
        last1 = batalla(semi1, semi2);
        last2 = batalla(semi3,semi4);
        
        semi[0]= last1;
        semi[1]= last2;
        
    }
    
    public void mostrarLast(){
        ImageIcon imagen16 = new ImageIcon(getClass().getResource(winner.getImagen())); 
        Icon fondo15 = new ImageIcon(imagen16.getImage().getScaledInstance(Winner.getWidth(), Winner.getHeight(), Image.SCALE_DEFAULT));
        Winner.setIcon(fondo15);
        
       Apostar7.setVisible(false);
    }
    
    public void last()throws InterruptedException{
        winner = batalla(last1,last2);
        last [0]= winner;
        //Thread.sleep(5000);
        
    }
    
    public void limpiar(){
     ImageIcon limpiar = new ImageIcon(getClass().getResource("/proyecto3/Limpio.png"));
     Icon limpio = new ImageIcon();
     Semi1.setIcon(limpio);
     Semi2.setIcon(limpio);
     Semi3.setIcon(limpio);
     Semi4.setIcon(limpio);
     Last1.setIcon(limpio);
     Last2.setIcon(limpio);
     Winner.setIcon(limpio);
     
     semi1 = null; 
     semi2 = null;
     semi3 = null;
     semi4 = null; 
     last1 = null;
     last2 = null;
     winner = null;
    }
    
    public void iniciar()throws InterruptedException{
        
        /**
        cuartos();
        semifinal();
        last();
        Thread.sleep(3000);
        mostrarCuartos();
        //Thread.sleep(5000);
        mostrarSemifinal();
        //Thread.sleep(5000);
        mostrarLast();*/    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cua1 = new javax.swing.JLabel();
        Cua2 = new javax.swing.JLabel();
        Cua3 = new javax.swing.JLabel();
        Cua4 = new javax.swing.JLabel();
        Cua5 = new javax.swing.JLabel();
        Cua6 = new javax.swing.JLabel();
        Cua7 = new javax.swing.JLabel();
        Cua8 = new javax.swing.JLabel();
        Semi1 = new javax.swing.JLabel();
        Semi2 = new javax.swing.JLabel();
        Semi3 = new javax.swing.JLabel();
        Semi4 = new javax.swing.JLabel();
        Last1 = new javax.swing.JLabel();
        Last2 = new javax.swing.JLabel();
        Winner = new javax.swing.JLabel();
        Apostar1 = new javax.swing.JButton();
        Apostar2 = new javax.swing.JButton();
        Apostar3 = new javax.swing.JButton();
        Apostar4 = new javax.swing.JButton();
        Apostar5 = new javax.swing.JButton();
        Apostar6 = new javax.swing.JButton();
        Apostar7 = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        saldoTemp = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Cua1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 14, 100, 80));
        getContentPane().add(Cua2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 100, 80));
        getContentPane().add(Cua3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 100, 80));
        getContentPane().add(Cua4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 100, 80));
        getContentPane().add(Cua5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, 100, 80));
        getContentPane().add(Cua6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 140, 100, 80));
        getContentPane().add(Cua7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 420, 100, 80));
        getContentPane().add(Cua8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 530, 100, 80));
        getContentPane().add(Semi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 100, 80));
        getContentPane().add(Semi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 100, 80));
        getContentPane().add(Semi3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 100, 80));
        getContentPane().add(Semi4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 500, 100, 80));
        getContentPane().add(Last1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 100, 80));
        getContentPane().add(Last2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 100, 80));
        getContentPane().add(Winner, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 100, 80));

        Apostar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Apostar1.setText("Apostar");
        Apostar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apostar1ActionPerformed(evt);
            }
        });
        getContentPane().add(Apostar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        Apostar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Apostar2.setText("Apostar");
        Apostar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apostar2ActionPerformed(evt);
            }
        });
        getContentPane().add(Apostar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, -1, -1));

        Apostar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Apostar3.setText("Apostar");
        Apostar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apostar3ActionPerformed(evt);
            }
        });
        getContentPane().add(Apostar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 100, -1, -1));

        Apostar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Apostar4.setText("Apostar");
        Apostar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apostar4ActionPerformed(evt);
            }
        });
        getContentPane().add(Apostar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 500, -1, -1));

        Apostar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Apostar5.setText("Apostar");
        Apostar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apostar5ActionPerformed(evt);
            }
        });
        getContentPane().add(Apostar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, -1));

        Apostar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Apostar6.setText("Apostar");
        Apostar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apostar6ActionPerformed(evt);
            }
        });
        getContentPane().add(Apostar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 320, -1, -1));

        Apostar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Apostar7.setText("Apostar");
        Apostar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apostar7ActionPerformed(evt);
            }
        });
        getContentPane().add(Apostar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, -1, -1));

        regresar.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        regresar.setForeground(new java.awt.Color(254, 254, 254));
        regresar.setText("regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        getContentPane().add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 580, 160, 50));

        saldoTemp.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        saldoTemp.setForeground(new java.awt.Color(254, 254, 254));
        saldoTemp.setText("$ 0.0");
        getContentPane().add(saldoTemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 110, 60));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto3/Fondo2.jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 1200, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Apostar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apostar3ActionPerformed
        apuesta3 = new Wapuesta1(E,F);
    }//GEN-LAST:event_Apostar3ActionPerformed

    private void Apostar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apostar4ActionPerformed
        apuesta4 = new Wapuesta1(G,H);
    }//GEN-LAST:event_Apostar4ActionPerformed

    private void Apostar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apostar6ActionPerformed
         apuesta6 = new Wapuesta1(semi3,semi4);
    }//GEN-LAST:event_Apostar6ActionPerformed

    private void Apostar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apostar2ActionPerformed
        apuesta2 = new Wapuesta1(C,D);
    }//GEN-LAST:event_Apostar2ActionPerformed

    private void Apostar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apostar1ActionPerformed
         apuesta1 = new Wapuesta1(A,B);
    }//GEN-LAST:event_Apostar1ActionPerformed

    private void Apostar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apostar5ActionPerformed
         apuesta5 = new Wapuesta1(semi1, semi2);
    }//GEN-LAST:event_Apostar5ActionPerformed

    private void Apostar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apostar7ActionPerformed
        apuesta7 = new Wapuesta1(last1 , last2 );
    }//GEN-LAST:event_Apostar7ActionPerformed

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
       this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        this.dispose();
        //this.setVisible(false);
        
    }//GEN-LAST:event_regresarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       //aqui
        // Apuest a = new Apuest(50);
        Equipos temp = null;
        Apuesta personal_recuperado1= null;//new Apuesta(0,temp);
        contador++;
        if(contador>1){
            //se lee objeto apuesta que es lo apostado en wapuesta1
       try{
                ObjectInputStream recuperando_fichero= new ObjectInputStream(new FileInputStream("ApuestaTemp"));
                 personal_recuperado =(Apuesta)recuperando_fichero.readObject();
                recuperando_fichero.close();
                //System.out.println("Cantidad apostada:  "+ personal_recuperado.getApuesta());
                }
        catch(IOException | ClassNotFoundException e){
                    //System.out.println("ooops");
                }
       /**
       try{
                //leyendOo archivo
                ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("ApuestaTemp"));
                escribiendo_fichero.writeObject(personal_recuperado1);
                escribiendo_fichero.close();
                }
                catch(Exception e){
                System.out.println("hay un error");
                }*/
       if(personal_recuperado!=null){
        //System.out.println(personal_recuperado.getApuesta());
         //System.out.println(personal_recuperado.getEquipoApostado().toString());
       }
           }
    }//GEN-LAST:event_formWindowActivated

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
      TotalObtenido m= new TotalObtenido();
      m.setSaldo(acumulado);
      m.setHistorial(historial);
        
        try{//escribiendo archivo
                ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("TotalObtenido"));
                escribiendo_fichero.writeObject(m);
                escribiendo_fichero.close();
               
                }
                catch(Exception e){
                //System.out.println("hay un error");
                }
        Historial his = new Historial(base, llave);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Torneo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Torneo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Torneo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Torneo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Torneo1().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Apostar1;
    private javax.swing.JButton Apostar2;
    private javax.swing.JButton Apostar3;
    private javax.swing.JButton Apostar4;
    private javax.swing.JButton Apostar5;
    private javax.swing.JButton Apostar6;
    private javax.swing.JButton Apostar7;
    private javax.swing.JLabel Cua1;
    private javax.swing.JLabel Cua2;
    private javax.swing.JLabel Cua3;
    private javax.swing.JLabel Cua4;
    private javax.swing.JLabel Cua5;
    private javax.swing.JLabel Cua6;
    private javax.swing.JLabel Cua7;
    private javax.swing.JLabel Cua8;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Last1;
    private javax.swing.JLabel Last2;
    private javax.swing.JLabel Semi1;
    private javax.swing.JLabel Semi2;
    private javax.swing.JLabel Semi3;
    private javax.swing.JLabel Semi4;
    private javax.swing.JLabel Winner;
    private javax.swing.JButton regresar;
    private javax.swing.JLabel saldoTemp;
    // End of variables declaration//GEN-END:variables


}
