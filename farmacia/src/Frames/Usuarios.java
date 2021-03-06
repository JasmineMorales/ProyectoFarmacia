/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import seguridad.Acceso;
import seguridad.ManejoUsuarios;
import seguridad.Usuario;

public class Usuarios extends javax.swing.JFrame {
    private ManejoUsuarios manejador = new ManejoUsuarios();
    DefaultTableModel modeloTabla;
    ArrayList<Usuario> usuarios;
    ArrayList<Acceso> accesos;

    public Usuarios() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/índice.png")).getImage());
        usuarios = manejador.getUsuarios();
        modeloTabla =  (DefaultTableModel) jTable2.getModel();
        for (Iterator<Usuario> iterator = usuarios.iterator(); iterator.hasNext();) {
            Usuario next = iterator.next();
            modeloTabla.addRow(new String[]{next.getUserId()+"", next.getUserName(), next.getNivelAcceso()==1?"Administrador":"usuario"});
        } 
        //BuscarInventario.setVisible(false);
        accesos = manejador.getAcceso();
        for (Acceso acceso : accesos) {
            jComboBox1.addItem(acceso.toString());
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabelMenu = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_nombrecomercial = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        Btnadd1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_nombrecomercial2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_nombrecomercial3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_nombrecomercial4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("USUARIOS");
        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(1150, 690));
        setResizable(false);
        setSize(new java.awt.Dimension(1150, 690));
        getContentPane().setLayout(null);

        jTable2.setBackground(new java.awt.Color(240, 240, 240));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Acceso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(480, 60, 600, 440);

        jLabelMenu.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabelMenu.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenu.setText("Menú");
        getContentPane().add(jLabelMenu);
        jLabelMenu.setBounds(1030, 570, 60, 17);

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cerrar Sesion.png"))); // NOI18N
        btnMenu.setBorderPainted(false);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/CerrarSesionNegro.png"))); // NOI18N
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu);
        btnMenu.setBounds(1020, 510, 73, 49);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Íconos/buscar_usuario.png"))); // NOI18N
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Íconos/buscar_usuario_sl.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(400, 70, 40, 40);

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("INFORMACIÓN USUARIO");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(170, 40, 230, 41);

        txt_id.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txt_id.setEnabled(false);
        getContentPane().add(txt_id);
        txt_id.setBounds(150, 90, 230, 30);

        txt_nombrecomercial.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txt_nombrecomercial.setEnabled(false);
        getContentPane().add(txt_nombrecomercial);
        txt_nombrecomercial.setBounds(150, 130, 230, 30);

        jComboBox1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(150, 290, 230, 30);

        jPasswordField1.setBackground(new java.awt.Color(240, 240, 240));
        jPasswordField1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(150, 340, 230, 30);

        jCheckBox1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("CAMBIAR CLAVE");
        jCheckBox1.setOpaque(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(230, 390, 157, 29);

        jPasswordField2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jPasswordField2.setEnabled(false);
        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField2);
        jPasswordField2.setBounds(150, 430, 230, 30);

        jPasswordField3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jPasswordField3.setEnabled(false);
        jPasswordField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField3);
        jPasswordField3.setBounds(150, 470, 230, 30);

        Btnadd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Íconos/guardar-disco.png"))); // NOI18N
        Btnadd1.setBorderPainted(false);
        Btnadd1.setContentAreaFilled(false);
        Btnadd1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Íconos/guardar_disco_sl.png"))); // NOI18N
        Btnadd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btnadd1ActionPerformed(evt);
            }
        });
        getContentPane().add(Btnadd1);
        Btnadd1.setBounds(220, 520, 60, 60);

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(80, 90, 20, 18);

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Guardar");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(230, 570, 50, 18);

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Puesto");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(80, 290, 60, 18);

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Repetir Contraseña");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 460, 130, 40);

        txt_nombrecomercial2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txt_nombrecomercial2.setEnabled(false);
        getContentPane().add(txt_nombrecomercial2);
        txt_nombrecomercial2.setBounds(150, 170, 230, 30);

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Dirección");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(80, 170, 60, 14);

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Salario");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(80, 210, 60, 20);

        txt_nombrecomercial3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txt_nombrecomercial3.setEnabled(false);
        getContentPane().add(txt_nombrecomercial3);
        txt_nombrecomercial3.setBounds(150, 210, 230, 30);

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Prestaciones");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(50, 250, 90, 14);

        txt_nombrecomercial4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txt_nombrecomercial4.setEnabled(false);
        getContentPane().add(txt_nombrecomercial4);
        txt_nombrecomercial4.setBounds(150, 250, 230, 30);

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nombre");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(80, 130, 60, 18);

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Contraseña Actual");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(20, 340, 130, 40);

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Contraseña Nueva");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(20, 420, 130, 40);

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Buscar");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(400, 100, 40, 18);

        jLabel1.setBackground(new java.awt.Color(38, 76, 114));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1150, 690);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        Menu otro = new Menu();
        otro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (jTable2.getSelectedRow() != -1) {
            int fila =jTable2.getSelectedRow();
            Usuario user = usuarios.get(fila);
            txt_id.setText(user.getUserId()+"");
            txt_nombrecomercial.setText(user.getUserName());
            txt_nombrecomercial2.setText(user.getDireccion());
            txt_nombrecomercial3.setText(user.getSalario() + "");
            txt_nombrecomercial4.setText(user.getPrestaciones() + "");
            
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            jPasswordField2.setEnabled(true);
            jPasswordField3.setEnabled(true);
        }else{
            jPasswordField2.setEnabled(false);
            jPasswordField3.setEnabled(false);

        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private void jPasswordField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField3ActionPerformed

    private void Btnadd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btnadd1ActionPerformed
        if (jTable2.getSelectedRow() != -1) {
            int fila =jTable2.getSelectedRow();
            if (jCheckBox1.isSelected()) {
                if(jPasswordField2.getText().equals(jPasswordField3.getText())){
                    boolean resutl = manejador.cambiarConstraseña(usuarios.get(fila), jPasswordField1.getText(), jPasswordField2.getText());
                    if (!resutl) {
                        JOptionPane.showMessageDialog(this, "Error no se pudo actualizar contraseñas,  ¿Ingreso una contraseña antigua valida?","ERROR",JOptionPane.ERROR_MESSAGE);//se informa que el usuario no existe
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Las conraseñas no coinciden","ERROR",JOptionPane.ERROR_MESSAGE);//se informa que el usuario no existe
                }
            }
            int combo = jComboBox1.getSelectedIndex();
            boolean acc =manejador.modificarAcceso(usuarios.get(fila), accesos.get(combo).getId());
            if (!acc) {
                JOptionPane.showMessageDialog(this, "Error no se pudo actualizar acceso","ERROR",JOptionPane.ERROR_MESSAGE);//se informa que el usuario no existe
            }
            JOptionPane.showMessageDialog(this, "Informacion Actualizada","INFORMACION",JOptionPane.INFORMATION_MESSAGE);//se informa que el usuario no existe
        }
    }//GEN-LAST:event_Btnadd1ActionPerformed

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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btnadd1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMenu;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombrecomercial;
    private javax.swing.JTextField txt_nombrecomercial2;
    private javax.swing.JTextField txt_nombrecomercial3;
    private javax.swing.JTextField txt_nombrecomercial4;
    // End of variables declaration//GEN-END:variables
}
