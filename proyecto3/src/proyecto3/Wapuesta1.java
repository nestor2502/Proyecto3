/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import java.io.*;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

/**
 *
 * @author isayd
 */
public class Wapuesta1 extends javax.swing.JFrame { 
    Equipos seleccionado, alfa, beta;
    Equipos ganador= null;
    double apostado=0;
    int cont=0;   
    Timer t = null; 
    int cont2=0;
    
   
    /**
     * Creates new form Apuesta1
     */
    public Wapuesta1(Equipos A, Equipos B) {
        initComponents();
        alfa = A; 
        beta = B;
         //this.setUndecorated(true);
        ImageIcon imagen1 = new ImageIcon(getClass().getResource(A.getImagen())); 
        Icon fondo1 = new ImageIcon(imagen1.getImage().getScaledInstance(EquipoA.getWidth(), EquipoA.getHeight(), Image.SCALE_DEFAULT));
        EquipoA.setIcon(fondo1);
       
        ImageIcon imagen2 = new ImageIcon(getClass().getResource(B.getImagen()));
        Icon fondo2 = new ImageIcon(imagen2.getImage().getScaledInstance(EquipoB.getWidth(),EquipoB.getHeight(),Image.SCALE_DEFAULT));
        EquipoB.setIcon(fondo2);
        
        ImageIcon imagen3 = new ImageIcon(getClass().getResource("/proyecto3/Fondillo.jpg"));
        Icon fondo3 = new ImageIcon(imagen3.getImage().getScaledInstance(Fondo.getWidth(),Fondo.getHeight(),Image.SCALE_DEFAULT));
        Fondo.setIcon(fondo3);
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Proyecto 3");
        this.setResizable(false);
        
        
        EquipoA.setContentAreaFilled(false);
        EquipoB.setContentAreaFilled(false);
         TextPrompt placeholder = new TextPrompt("$0.00", Apostado);
         placeholder.changeAlpha(0.75f);
         placeholder.changeStyle(Font.ITALIC);
        regresar.setContentAreaFilled(false);
       
        
    }
    
    

        
    
    public boolean isNumeric(String cadena){
        try{
            Double.parseDouble(cadena);
            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        EquipoB = new javax.swing.JButton();
        EquipoA = new javax.swing.JButton();
        Apostado = new javax.swing.JTextField();
        regresar = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EquipoB.setText("jButton1");
        EquipoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EquipoBActionPerformed(evt);
            }
        });
        getContentPane().add(EquipoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 240, 260));

        EquipoA.setText("jButton1");
        EquipoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EquipoAActionPerformed(evt);
            }
        });
        getContentPane().add(EquipoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 240, 260));

        Apostado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApostadoActionPerformed(evt);
            }
        });
        getContentPane().add(Apostado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 240, 40));

        regresar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        regresar.setForeground(new java.awt.Color(254, 254, 254));
        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        getContentPane().add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 575, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ApostadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApostadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApostadoActionPerformed

    private void EquipoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EquipoAActionPerformed
        
        String dato="";
        
        if(Apostado.getText().trim()== ""){
        JOptionPane.showMessageDialog(null, "Tienes que apostar una cantidad"); 
        }
        else{
        
        dato = this.Apostado.getText().trim();
        if(isNumeric(dato) == true){
            //Guardamos en el de apuestas y esperamos
            apostado = Double.parseDouble(dato);
       
            ganador= alfa;
            cont2++;
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "No es un valor valido");
        }}
         
            
// TODO add your handling code here:
    }//GEN-LAST:event_EquipoAActionPerformed

    private void EquipoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EquipoBActionPerformed
         String dato="";
        if(Apostado.getText().trim()== ""){
        JOptionPane.showMessageDialog(null, "Tienes que apostar una cantidad"); 
        }
        else{  
        
        dato = this.Apostado.getText().trim();        
        if(isNumeric(dato) == true){
            //Guardamos en el de apuestas y esperamos
           //System.out.println(dato);
           
            apostado = Double.parseDouble(dato);
             ganador = beta;
             cont2++;
            
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "No es un valor valido");
        }}
        //this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_EquipoBActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Apuesta m= null ;
        //si no se ingresó un valor se crea el objeto null
        if(apostado==0 || ganador == null) {
             m =null; 
        }
        //si se selecciono a un jugador y se aposto una cantidad mayor a 0
        else if( ganador != null&& cont2>0){
        m = new Apuesta(apostado, ganador);}
       try{//escribiendo archivo
                ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("ApuestaTemp"));
                escribiendo_fichero.writeObject(m);
                escribiendo_fichero.close();
               
                }
                catch(Exception e){
                //System.out.println("hay un error");
                }
    }//GEN-LAST:event_formWindowClosed

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        
    }//GEN-LAST:event_formWindowDeactivated

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Apuesta personal_recuperado1= null;
        try{
                //leyendOo archivo
                ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("ApuestaTemp"));
                escribiendo_fichero.writeObject(personal_recuperado1);
                escribiendo_fichero.close();
                }
                catch(Exception e){
               // System.out.println("hay un error");
                }
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Equipos Atl = new Equipos("Atlanta Reign", 200, "Atlanta.png");
        Equipos Seoul = new Equipos("Seoul Dynasty", 210, "Seoul.png");
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
            java.util.logging.Logger.getLogger(Wapuesta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Wapuesta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Wapuesta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Wapuesta1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wapuesta1(Atl, Seoul).setVisible(true);
            }
        });
    }

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apostado;
    private javax.swing.JButton EquipoA;
    private javax.swing.JButton EquipoB;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
