/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import java.awt.Font;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;

/**
 *
 * @author nestor2502
 */
public class IniciarSesion extends javax.swing.JFrame {
    Base base;
     String llave;
     int cont=0;
     Activacion m;
     boolean activacion= false;
    /**
     * Creates new form IniciarSesion
     */
    public IniciarSesion() {
        initComponents();
        //this.setAlwaysOnTop(true); 
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(false);
        this.setTitle("Proyecto 3");
        this.setResizable(false);
        
        inicio.setContentAreaFilled(false);
        regresar.setContentAreaFilled(false);
        
        TextPrompt placeholder = new TextPrompt("Correo electronico", correo);
         placeholder.changeAlpha(0.75f);
         placeholder.changeStyle(Font.ITALIC);
         
         TextPrompt placeholder1= new TextPrompt("Contraseña", contraseña);
         placeholder1.changeAlpha(0.75f);
         placeholder1.changeStyle(Font.ITALIC);
         
        
         try{
         ObjectInputStream recuperando_fichero= new ObjectInputStream(new FileInputStream("Test2"));
                 base =(Base)recuperando_fichero.readObject();
                recuperando_fichero.close();}
          catch(IOException e){
                	System.out.println(e.getMessage());
                }
                catch(ClassNotFoundException e){
                    System.out.println(e.getMessage());
                	
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

        correo = new javax.swing.JTextField();
        inicio = new javax.swing.JButton();
        contraseña = new javax.swing.JPasswordField();
        regresar = new javax.swing.JButton();
        fondo3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 360, 60));

        inicio.setBackground(new java.awt.Color(90, 90, 78));
        inicio.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        inicio.setForeground(new java.awt.Color(240, 240, 240));
        inicio.setText("Iniciar sesion");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        getContentPane().add(inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 190, 50));
        getContentPane().add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 360, 60));

        regresar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        regresar.setForeground(new java.awt.Color(254, 254, 254));
        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        getContentPane().add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        fondo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto3/1080x720-00001.jpg"))); // NOI18N
        getContentPane().add(fondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        Historial his;
        int correcto1 =0;
        int correcto2 =0;
        boolean continuar = false;
        String correo2= correo.getText().trim();
        String contraseña2 = contraseña.getText().trim();
         llave = correo2.concat(contraseña2);
         //System.out.println(llave);
         //se verifican los espacios
         String email = correo2;
         //se verifican espacios vacios
         if(correo2.equals("")||contraseña2.equals("")){
             JOptionPane.showMessageDialog(null, "No dejes campos vacios");
         }
         //se verifica el correo
        if(!email.equals("")||!email.equals(" ")){
         for(int i = 0 ; i<email.length(); i++){

             	  if(email.charAt(i)=='@')

             	  	  correcto1 ++;
                  if(email.charAt(i)=='.')

             	  	  correcto2 ++;
             }

             if(correcto1 == 0 || correcto2==0){

             	 //System.out.println("Incorrecto");
             	 JOptionPane.showMessageDialog(null, "Correo incorrecto");
             }
            
             if(correcto1 >0  && correcto2 > 0){
                 //System.out.println("se realizo");
                 continuar = true;}
        }
        //se lee la base
         
       
        try{             
                ObjectInputStream recuperando_fichero= new ObjectInputStream(new FileInputStream("Test2"));
                 base =(Base)recuperando_fichero.readObject();
                recuperando_fichero.close();
                

                }
                 catch(IOException e){
                	//System.out.println(e.getMessage());
                }
                catch(ClassNotFoundException e){
                    //System.out.println(e.getMessage());
                	
             } 
        
        if(base== null){
             JOptionPane.showMessageDialog(null, "usuario no registrado");
        }
        //se avanza en la app y se veriica que exista el usuario  
        else if(continuar == true){
             if(base.existeUsuario(llave)){ 
                  this.setVisible(false);
                  cont++;
                  //activacion =true;
                  this.dispose();
                  //his= new Historial(base,llave);}
             }
                  else
                 JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto"); 
        
        }
        
    }//GEN-LAST:event_inicioActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(cont>0){
        Historial his= new Historial(base,llave);}
        /**
        else if(cont ==0){
         m = new Activacion(false);
       try{//escribiendo archivo
                ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("Inicio"));
                escribiendo_fichero.writeObject(m);
                escribiendo_fichero.close();
               
                }
                catch(Exception e){
                System.out.println(" 3 hay un error");
                }}*/
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JTextField correo;
    private javax.swing.JLabel fondo3;
    private javax.swing.JButton inicio;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
