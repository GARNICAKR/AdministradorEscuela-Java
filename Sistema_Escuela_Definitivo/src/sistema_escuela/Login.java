/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_escuela;

import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import sistema_escuela.Interfaz;

/**
 *
 * @author User
 */
public class Login extends javax.swing.JFrame {
 File_Usuaros usuarios=new File_Usuaros();
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        login_txtusuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        login_txtcontraseña = new javax.swing.JTextField();
        login_btncancelar = new javax.swing.JButton();
        login_btnregistrarse = new javax.swing.JButton();
        login_btningresar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        login_btncancelar.setText("Cancelar");
        login_btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btncancelarActionPerformed(evt);
            }
        });

        login_btnregistrarse.setText("Registrarse");
        login_btnregistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnregistrarseActionPerformed(evt);
            }
        });

        login_btningresar.setText("Ingresar");
        login_btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btningresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(login_txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(login_txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(login_btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(login_btnregistrarse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(login_btningresar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(login_txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(login_txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(login_btnregistrarse)
                            .addComponent(login_btncancelar)
                            .addComponent(login_btningresar)))
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login_btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btningresarActionPerformed
        String usuario3 = login_txtusuario.getText();
        String contraseña = login_txtcontraseña.getText();
        String nombre2="";
           String id2="";
           String nombreusuario2="";
           String apellidopaterno2="";
           String apellidomaterno2="";
           String contraseña2="";
           String perfil2="";
           String texto3="";
           int aux=0;
              String texto=usuarios.Read();
              String texto2=usuarios.BuscarU(texto, usuario3);
              if(texto2=="no encontrado"){
                  JOptionPane.showMessageDialog(this, "No se encontro la id");
              }else{
              for(int i=0;i<texto2.length();i++){
                  if(texto2.charAt(i)=='°'){
                  aux++;
                  }
                  if(texto2.charAt(i)!='°'){
                  if(aux==0){
                  id2=id2+texto2.charAt(i);
                  }
                  if(aux==1){
                  nombre2=nombre2+texto2.charAt(i);
                  }
                  if(aux==2){
                  apellidopaterno2=apellidopaterno2+texto2.charAt(i);
                  }
                  if(aux==3){
                  apellidomaterno2=apellidomaterno2+texto2.charAt(i);
                  }
                  if(aux==4){
                  nombreusuario2=nombreusuario2+texto2.charAt(i);
                  }
                  if(aux==5){
                  contraseña2=contraseña2+texto2.charAt(i);
                  }
                  if(aux==6){
                  perfil2=perfil2+texto2.charAt(i);
                  }
                  }
              }
              if(contraseña.equals(contraseña2)){
                  if(perfil2.equals("Administrador")){
                      Interfaz Itz = new Interfaz();
        Itz.setVisible(true);
        Itz.pack();
        Itz.setLocationRelativeTo(null);
        Itz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        
        Itz.jTabbedPane1.setEnabledAt(0,true);
        Itz.jTabbedPane1.setEnabledAt(1,true);
        Itz.jTabbedPane1.setEnabledAt(2,true);
        Itz.jTabbedPane1.setEnabledAt(3,true);
        Itz.jTabbedPane1.setEnabledAt(4,true);
        Itz.jTabbedPane1.setEnabledAt(5,true);
        Itz.jTabbedPane1.setEnabledAt(6,true);
        Itz.jTabbedPane1.setEnabledAt(7,true);           
        this.dispose();
        
                  }
                  if(perfil2.equals("Coordinador")){
                  Interfaz Itz = new Interfaz();
        Itz.setVisible(true);
        Itz.pack();
        Itz.setLocationRelativeTo(null);
        Itz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        
        Itz.jTabbedPane1.setEnabledAt(0,false);
        Itz.jTabbedPane1.setEnabledAt(1,false);
        Itz.jTabbedPane1.setEnabledAt(2,false);
        Itz.jTabbedPane1.setEnabledAt(3,false);
        Itz.jTabbedPane1.setEnabledAt(4,false);
        Itz.jTabbedPane1.setEnabledAt(5,false);
        Itz.jTabbedPane1.setEnabledAt(6,true);
        Itz.jTabbedPane1.setEnabledAt(7,true);           
        this.dispose();
        
                  }
                  if(perfil2.equals("Alumno")){
                  Interfaz Itz = new Interfaz();
        Itz.setVisible(true);
        Itz.pack();
        Itz.setLocationRelativeTo(null);
        Itz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        
        Itz.jTabbedPane1.setEnabledAt(0,false);
        Itz.jTabbedPane1.setEnabledAt(1,false);
        Itz.jTabbedPane1.setEnabledAt(2,false);
        Itz.jTabbedPane1.setEnabledAt(3,false);
        Itz.jTabbedPane1.setEnabledAt(4,false);
        Itz.jTabbedPane1.setEnabledAt(5,false);
        Itz.jTabbedPane1.setEnabledAt(6,false);
        Itz.jTabbedPane1.setEnabledAt(7,true);           
        this.dispose();
        
                  }
              }
              
              }

    }//GEN-LAST:event_login_btningresarActionPerformed

    private void login_btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btncancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_login_btncancelarActionPerformed

    private void login_btnregistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnregistrarseActionPerformed
        Interfaz Itz = new Interfaz();
        Itz.setVisible(true);
        Itz.pack();
        Itz.setLocationRelativeTo(null);
        Itz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        
        Itz.jTabbedPane1.setEnabledAt(0,true);
        Itz.jTabbedPane1.setEnabledAt(1,false);
        Itz.jTabbedPane1.setEnabledAt(2,false);
        Itz.jTabbedPane1.setEnabledAt(3,false);
        Itz.jTabbedPane1.setEnabledAt(4,false);
        Itz.jTabbedPane1.setEnabledAt(5,false);
        Itz.jTabbedPane1.setEnabledAt(6,false);
        Itz.jTabbedPane1.setEnabledAt(7,false);           
        this.dispose();
        
    }//GEN-LAST:event_login_btnregistrarseActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton login_btncancelar;
    private javax.swing.JButton login_btningresar;
    private javax.swing.JButton login_btnregistrarse;
    private javax.swing.JTextField login_txtcontraseña;
    private javax.swing.JTextField login_txtusuario;
    // End of variables declaration//GEN-END:variables
}
