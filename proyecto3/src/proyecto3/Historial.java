/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nestor2502
 */
public class Historial extends javax.swing.JFrame {
     Base base;
     Usuario usuario;
     String llave;
     String historial1="";
     Torneo1 torn;
     int contador =0;
     Apuesta apuesta;
     Equipos cuartos []= new Equipos[4];
     Equipos semi []= new Equipos[4];
     Equipos last []= new Equipos[4];
    
     //Torneo1 torn = new Torneo1();
     
    /**
     * Creates new form Historial
     */
    public Historial() {
     
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Proyecto 3");
        this.setResizable(false);
        historial.setContentAreaFilled(false);
        comenzar.setContentAreaFilled(false);
        instrucciones.setContentAreaFilled(false);
        cerrar.setContentAreaFilled(false);
       
        
    }
    
    /**
     * Constructor que inicia con una base
     * @param base
     */
    public Historial(Base base, String llave){
        initComponents();
        this.base = base;
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Proyecto 3");
        this.setResizable(false);
       
        
        //historial.setOpaque (true);
        this.llave = llave;
        historial.setContentAreaFilled(false);
        comenzar.setContentAreaFilled(false);
        instrucciones.setContentAreaFilled(false);
        cerrar.setContentAreaFilled(false);
        usuario = base.getUsuario(llave);
        setNombre(usuario.getUsuario());
        historial1 = usuario.getHistorial();
        /**
        try{
       //torn.cuartos();
        torn.iniciar();
        }
        catch(InterruptedException e){}*/
         
         
    }
    
    /**
     * Metodo que asigna el nombre de usuario
     * @param nombre
     */
     public void setNombre(String nombre){
         this.nombre.setText("Bienvenido "+nombre);
     }
     
     public boolean contiene(Equipos [] a, Equipos b){
         boolean es = false;
		 for(int i =0; i< a.length;i++){
			 if(a[i].equals(b))
			 	 es =  true;
		 }
		 return es;
	}
     public boolean ganaApuestaCuartos(){
         //System.out.println("paso 1");
         cuartos = torn.getWinnerCuartos();
         //System.out.println("paso2");
         boolean correcto = false;
     
        Equipos temp = null;
        Apuesta apuesta1= null;//new Apuesta(0,temp);
        contador++;
       
            //se lee objeto apuesta que es lo apostado en wapuesta1
       try{
                ObjectInputStream recuperando_fichero= new ObjectInputStream(new FileInputStream("ApuestaTemp"));
                 apuesta =(Apuesta)recuperando_fichero.readObject();
                recuperando_fichero.close();
                
                }
        catch(IOException | ClassNotFoundException e){
                    System.out.println("ooops   g");
                }
       try{
                //leyendOo archivo
                ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("ApuestaTemp"));
                escribiendo_fichero.writeObject(apuesta1);
                escribiendo_fichero.close();
                }
                catch(Exception e){
                System.out.println("hay un error");
                }
       if(apuesta!=null){
            if(contiene(cuartos, apuesta.getEquipoApostado())){
                //System.out.println("hecho");
                return true;
            }
      }
       
           
     return correcto;}
     
     /**
      * *
      * *
      * */
     
     public boolean ganaApuestaSemi(){
         semi = torn.getWinnerSemi();
         boolean correcto = false;
     
        Equipos temp = null;
        Apuesta apuesta1= null;//new Apuesta(0,temp);
        contador++;
       
            //se lee objeto apuesta que es lo apostado en wapuesta1
       try{
                ObjectInputStream recuperando_fichero= new ObjectInputStream(new FileInputStream("ApuestaTemp"));
                 apuesta =(Apuesta)recuperando_fichero.readObject();
                recuperando_fichero.close();
                }
        catch(IOException | ClassNotFoundException e){
                    System.out.println("ooops");
                }
       try{
                //leyendOo archivo
                ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("ApuestaTemp"));
                escribiendo_fichero.writeObject(apuesta1);
                escribiendo_fichero.close();
                }
                catch(Exception e){
                System.out.println("hay un error");
                }
       if(apuesta!=null){
            if(contiene(semi, apuesta.getEquipoApostado())){
                System.out.println("hecho");
                return true;
            }
       System.out.println("hechommm");}
       System.out.println("oops");
           
     return correcto;}
     
     public boolean ganaApuestaLast(){
         last = torn.getWinnerCuartos();
         boolean correcto = false;
     
        Equipos temp = null;
        Apuesta apuesta1= null;//new Apuesta(0,temp);
        contador++;
      
            //se lee objeto apuesta que es lo apostado en wapuesta1
       try{
                ObjectInputStream recuperando_fichero= new ObjectInputStream(new FileInputStream("ApuestaTemp"));
                 apuesta =(Apuesta)recuperando_fichero.readObject();
                recuperando_fichero.close();
                }
        catch(IOException | ClassNotFoundException e){
                    System.out.println("ooops");
                }
       try{
                //leyendOo archivo
                ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("ApuestaTemp"));
                escribiendo_fichero.writeObject(apuesta1);
                escribiendo_fichero.close();
                }
                catch(Exception e){
                System.out.println("hay un error");
                }
       if(apuesta!=null){
            if(contiene(last, apuesta.getEquipoApostado())){
                return true;
            }}
           
     return correcto;}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre = new javax.swing.JLabel();
        historial = new javax.swing.JButton();
        instrucciones = new javax.swing.JButton();
        comenzar = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre.setBackground(new java.awt.Color(197, 115, 33));
        nombre.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        nombre.setForeground(new java.awt.Color(254, 254, 254));
        nombre.setText("Bienvenido  Nestor vazquez");
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 360, 50));

        historial.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        historial.setForeground(new java.awt.Color(254, 254, 254));
        historial.setText("Datos de Usuario");
        historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialActionPerformed(evt);
            }
        });
        getContentPane().add(historial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 180, 40));

        instrucciones.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        instrucciones.setForeground(new java.awt.Color(254, 254, 254));
        instrucciones.setText("¿Cómo jugar ?");
        instrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instruccionesActionPerformed(evt);
            }
        });
        getContentPane().add(instrucciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 150, 40));

        comenzar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        comenzar.setForeground(new java.awt.Color(254, 254, 254));
        comenzar.setText("Comenzar");
        comenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comenzarActionPerformed(evt);
            }
        });
        getContentPane().add(comenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 150, 50));

        cerrar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        cerrar.setForeground(new java.awt.Color(254, 254, 254));
        cerrar.setText("Cerrar sesion");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        getContentPane().add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 150, 50));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto3/MMPmMEq2LHIac (1).gif"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
       base.agrega(usuario);
        this.setVisible(false);
       //System.exit(0);
       this.dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void historialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialActionPerformed
        TotalObtenido  g= null;
        try{
                ObjectInputStream recuperando_fichero= new ObjectInputStream(new FileInputStream("TotalObtenido"));
                g =(TotalObtenido)recuperando_fichero.readObject();
                recuperando_fichero.close();
             
                }
        catch(IOException | ClassNotFoundException e){
                    System.out.println("ooops");
                }
        if(g== null){
        JOptionPane.showMessageDialog(null, "Aun no hay datos");
        }
        else{
        historial1 += g.getHistorial();
        usuario.setHistorial(historial1);
        usuario.setSaldo(g.getSaldo());
        HistorialUsuario historiall = new HistorialUsuario(usuario);
        historiall.setVisible(true);}
        
    }//GEN-LAST:event_historialActionPerformed

    private void instruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instruccionesActionPerformed
        Instrucciones obj= new Instrucciones();
        obj.setVisible(true);
    }//GEN-LAST:event_instruccionesActionPerformed

    private void comenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comenzarActionPerformed
          torn = new Torneo1(usuario.getSaldo(), usuario.getHistorial(), base, llave);
         this.setVisible(false);
         torn.setVisible(true);
         Thread hilo1 = new Thread(){
             @Override
             public void run(){
                 try{
                     torn.cuartos(); 
                     torn.semifinal();
                     torn.last();
                     
                     ////////////////////////////////////////////////////////////
                     Thread.sleep(10000);
                     if(ganaApuestaCuartos()== true){
                     torn.setHistorialT();
                     torn.setSaldo();
                         //System.out.println("Ganaste"+ torn.getSaldo());
                     }
                     else{
                     torn.setHistorialF();
                     // System.out.println("Perdiste"+ torn.getSaldo());
                     }
                     torn.mostrarCuartos();
                     
                     /////////////////////////////////////////////////////////////
                     Thread.sleep(10000);
                     if(ganaApuestaSemi()== true){
                     torn.setHistorialT();
                     torn.setSaldo();
                     //System.out.println("Ganaste"+ torn.getSaldo());
                     }
                     else{
                     torn.setHistorialF();
                    // System.out.println("Perdiste"+ torn.getSaldo());
                     }
                     torn.mostrarSemifinal();
                     
                     //////////////////////////////////////////////////////
                     Thread.sleep(10000);
                     if(ganaApuestaLast()== true){
                     torn.setHistorialT();
                     torn.setSaldo();
                      //System.out.println("Ganaste"+ torn.getSaldo());
                     }
                     else{
                     torn.setHistorialF();
                     //System.out.println("Perdiste"+ torn.getSaldo());
                     }
                     torn.mostrarLast();
                     
                     ///////////////////////////////////////////////////////
                     
                 }catch(InterruptedException ex){
                     Logger.getLogger(Historial.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         };
         hilo1.start();
    }//GEN-LAST:event_comenzarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar;
    private javax.swing.JButton comenzar;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton historial;
    private javax.swing.JButton instrucciones;
    private javax.swing.JLabel nombre;
    // End of variables declaration//GEN-END:variables
}
