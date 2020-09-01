/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import seguridad.Conexion;
import seguridad.Usuario;

/**
 *
 * @author GuillePC
 */
public class Compras extends javax.swing.JFrame {

private static Usuario user;//variable global del usuario logeado


    /**
     * Creates new form Lotes
     */


 public Compras(Usuario user) {//metodo constructor que recibe el usuario logeados
         this.user=user;//Se asigna el usuaario que hizo login       
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/índice.png")).getImage());
     
        initComponents();
        this.setLocationRelativeTo(null);
        
       
               
        mostrardatos("");
        jMenuTodCompr.setVisible(false);


        
    }


   
    
      void mostrarCompra(String valor)
    {
        try{
            Connection cn=Conexion.conectar();
            
            DefaultTableModel modelo=new DefaultTableModel()
            {
                @Override
                public boolean isCellEditable(int fil, int col) {
                    return col==7;
                }
            
            };
            
           
            
            modelo.addColumn("No. Compra");
            modelo.addColumn("Medicamentos");
            modelo.addColumn("Existencais");
            modelo.addColumn("Costo");
            modelo.addColumn("Fecha De Caducidad");
            modelo.addColumn("Fecha Ingreso");
            modelo.addColumn("Proveedor");
                                    
            
            jTable1.setModel(modelo);
            String sql="";
            
            if (valor.equals(""))
            {
             sql="select lot.Compra_idCompra, med.Nombre, lot.Existencia, lot.Costo, lot.FechaCaducidad, lot.FechaIngreso, pro.Nombre from lote lot inner join medicamento med on lot.Medicamento_idMedicamento = med.idMedicamento left join proveedor pro on lot.Proveedor_idproveedor = pro.idproveedor" ;
            }
            else
            {
              sql="select lot.Compra_idCompra, med.Nombre, lot.Existencia, lot.Costo, lot.FechaCaducidad, lot.FechaIngreso, pro.Nombre from lote lot inner join medicamento med on lot.Medicamento_idMedicamento = med.idMedicamento left join proveedor pro on lot.Proveedor_idproveedor = pro.idproveedor where (lot.Compra_idCompra ='"+valor+"')" ;
   
            }
            
            
            String []datos=new String [9];
          
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                
                while(rs.next())
                {
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    datos[4]=rs.getString(5);
                    datos[5]=rs.getString(6);
                    datos[6]=rs.getString(7);
                                     
                    modelo.addRow(datos);
                    
                }
                
                jTable1.setModel(modelo);
           
        }
        
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "Error "+ex);
        }
    }
    
    
     void mostrardatos(String valor)
    {
        try{
            Connection cn=Conexion.conectar();
            
            DefaultTableModel modelo=new DefaultTableModel()
            {
                @Override
                public boolean isCellEditable(int fil, int col) {
                    return col==6;
                }
            
            };
            
            modelo.addColumn("No. Compra");
            modelo.addColumn("Comprador");
            modelo.addColumn("Fecha");
            modelo.addColumn("Medicamentos");
            modelo.addColumn("Total Q.");
                        
            
            
            jTable1.setModel(modelo);
            String sql="";
            
            if (valor.equals(""))
            {
             sql="select lot.Compra_idCompra, us.Nombre, lot.FechaIngreso, count(lot.Medicamento_idMedicamento)as totalme, (lot.Existencia * lot.Costo) as costo from lote lot inner join medicamento med on lot.Medicamento_idMedicamento = med.idMedicamento left join compra com on lot.Compra_idCompra = com.idCompra right join usuario us on com.Usuario_idUsuario = us.idUsuario group by lot.Compra_idCompra" ;
            }
            else
            {
              sql="select lot.Compra_idCompra, us.Nombre, lot.FechaIngreso, count(lot.Medicamento_idMedicamento)as totalme, (lot.Existencia * lot.Costo) as costo from lote lot inner join medicamento med on lot.Medicamento_idMedicamento = med.idMedicamento left join compra com on lot.Compra_idCompra = com.idCompra right join usuario us on com.Usuario_idUsuario = us.idUsuario where (lot.Compra_idCompra='"+valor+"')" ;
   
            }
            
            
            String []datos=new String [6];
          
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                
                while(rs.next())
                {
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    datos[4]=rs.getString(5);

                                       
                    modelo.addRow(datos);
                    
                }
                
                jTable1.setModel(modelo);
           
        }
        
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "Error "+ex);
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

        jpopOpciones = new javax.swing.JPopupMenu();
        jMenuNueCompra = new javax.swing.JMenuItem();
        jMenuVerCompra = new javax.swing.JMenuItem();
        jMenuTodCompr = new javax.swing.JMenuItem();
        btnBuscar = new javax.swing.JButton();
        jtxtBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bntNuevaCompra = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        jLabelMenu = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jMenuNueCompra.setText("Nueva Compra");
        jMenuNueCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNueCompraActionPerformed(evt);
            }
        });
        jpopOpciones.add(jMenuNueCompra);

        jMenuVerCompra.setText("Ver Compra");
        jMenuVerCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVerCompraActionPerformed(evt);
            }
        });
        jpopOpciones.add(jMenuVerCompra);

        jMenuTodCompr.setText("Toda Las Compras");
        jMenuTodCompr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTodComprActionPerformed(evt);
            }
        });
        jpopOpciones.add(jMenuTodCompr);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COMPRAS");
        setMinimumSize(new java.awt.Dimension(1150, 690));
        setPreferredSize(new java.awt.Dimension(1150, 690));
        setResizable(false);
        getContentPane().setLayout(null);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BuscarBlanco.png"))); // NOI18N
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Buscar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(210, 20, 50, 40);

        jtxtBuscar.setBackground(new java.awt.Color(240, 240, 240));
        jtxtBuscar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        getContentPane().add(jtxtBuscar);
        jtxtBuscar.setBounds(70, 40, 120, 30);

        jTable1.setBackground(new java.awt.Color(240, 240, 240));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setComponentPopupMenu(jpopOpciones);
        jTable1.setFocusable(false);
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(70, 90, 940, 480);

        bntNuevaCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/NuevaCompraBlanco.png"))); // NOI18N
        bntNuevaCompra.setBorderPainted(false);
        bntNuevaCompra.setContentAreaFilled(false);
        bntNuevaCompra.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/NuevaCompraNegro.png"))); // NOI18N
        bntNuevaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevaCompraActionPerformed(evt);
            }
        });
        getContentPane().add(bntNuevaCompra);
        bntNuevaCompra.setBounds(1050, 30, 50, 50);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nueva Compra");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1040, 70, 80, 14);

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
        btnMenu.setBounds(1040, 570, 73, 49);

        jLabelMenu.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabelMenu.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenu.setText("Menú");
        getContentPane().add(jLabelMenu);
        jLabelMenu.setBounds(1050, 620, 60, 17);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("No. Compra");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 20, 80, 14);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Buscar");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(220, 60, 80, 14);

        jLabel1.setBackground(new java.awt.Color(38, 76, 114));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1150, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        mostrardatos(jtxtBuscar.getText());

        if (jTable1.getValueAt(0, 3).toString().equals("0")) 
        {
         JOptionPane.showMessageDialog(null, "No hay compras con este ID");
            mostrardatos("");
        }
        jtxtBuscar.setText("");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jMenuNueCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNueCompraActionPerformed
     NuevaCompra comprs = new NuevaCompra(user);
     this.setVisible(false);
     comprs.setVisible(true);

    }//GEN-LAST:event_jMenuNueCompraActionPerformed

    private void bntNuevaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNuevaCompraActionPerformed
     NuevaCompra comprs = new NuevaCompra(user);
     this.setVisible(false);
     comprs.setVisible(true);
    }//GEN-LAST:event_bntNuevaCompraActionPerformed

    private void jMenuVerCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVerCompraActionPerformed
        int fila = jTable1.getSelectedRow();
        String noCompra=jTable1.getValueAt(fila,0).toString();
        mostrarCompra(noCompra);
        jMenuVerCompra.setVisible(false);
        jMenuTodCompr.setVisible(true);
        
        jtxtBuscar.setEnabled(false);
        btnBuscar.setEnabled(false);
      
        
    }//GEN-LAST:event_jMenuVerCompraActionPerformed

    private void jMenuTodComprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTodComprActionPerformed
        mostrardatos("");
        jMenuVerCompra.setVisible(true);
        jMenuTodCompr.setVisible(false);
        
        jtxtBuscar.setEnabled(true);
        btnBuscar.setEnabled(true);
    }//GEN-LAST:event_jMenuTodComprActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        Menu otro = new Menu();
        otro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

     
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
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compras(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntNuevaCompra;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelMenu;
    private javax.swing.JMenuItem jMenuNueCompra;
    private javax.swing.JMenuItem jMenuTodCompr;
    private javax.swing.JMenuItem jMenuVerCompra;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPopupMenu jpopOpciones;
    private javax.swing.JTextField jtxtBuscar;
    // End of variables declaration//GEN-END:variables
}
