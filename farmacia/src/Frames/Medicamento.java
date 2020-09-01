/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Toolkit;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import seguridad.Conexion;
import seguridad.Usuario;

/**
 *
 * @author GuillePC
 */
public class Medicamento extends javax.swing.JFrame {
        private static Usuario user;//variable global del usuario logeado

    /**
     * Creates new form Medicamento
     */
    public Medicamento(Usuario user) {
        this.user=user;//Se asigna el usuaario que hizo login
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/índice.png")).getImage());
         
        initComponents();      
        this.setLocationRelativeTo(null);
        
         mostrardatos("");  
         btnNuevoMe.setVisible(true);
         btnCancelar.setVisible(false);
        
         jmenuHabi.setVisible(false);
        radHabili.setSelected(true);
        
        jtxtNombre.setEnabled(false);
        jtxtPrincAct.setEnabled(false);
        jtxtIndicUso.setEnabled(false);
        jtxtDosis.setEnabled(false);
        jtxtPresentacion.setEnabled(false);
        
        jtxtPrecioInt.setEnabled(false);
        jtxtPrecioExt.setEnabled(false);
        btnInsertar.setEnabled(false);
        btnInsertar.setVisible(false);
        btnModificar.setVisible(false);
        

    
    }
    
    
      private int Validar()
    {
       
        if ( jtxtNombre.getText().length()==0) 
        {
          JOptionPane.showMessageDialog(null, "Llenar Todos Los campos", "Error", JOptionPane.ERROR_MESSAGE);
          return 1;
        }
        else if (jtxtPrincAct.getText().length()==0) 
        {
          JOptionPane.showMessageDialog(null, "Llenar Todos Los campos", "Error", JOptionPane.ERROR_MESSAGE);
          return 1;
        }
        else if (jtxtIndicUso.getText().length()==0) 
        {
          JOptionPane.showMessageDialog(null, "Llenar Todos Los campos", "Error", JOptionPane.ERROR_MESSAGE);
           return 1;
        }  
        else if (jtxtDosis.getText().length()==0) 
        {
          JOptionPane.showMessageDialog(null, "Llenar Todos Los campos", "Error", JOptionPane.ERROR_MESSAGE);
           return 1;
        }  
        else if (jtxtPresentacion.getText().length()==0) 
        {
          JOptionPane.showMessageDialog(null, "Llenar Todos Los campos", "Error", JOptionPane.ERROR_MESSAGE);
           return 1;
        }  
        else if (jtxtPrecioInt.getText().length()==0) 
        {
          JOptionPane.showMessageDialog(null, "Llenar Todos Los campos", "Error", JOptionPane.ERROR_MESSAGE);
           return 1;
        }  
        else if (jtxtPrecioExt.getText().length()==0) 
        {
          JOptionPane.showMessageDialog(null, "Llenar Todos Los campos", "Error", JOptionPane.ERROR_MESSAGE);
           return 1;

        }  
        else
        {
            return 0;
        }
    }
    
    
 private  void mostrardatos(String valor)
 {
        try{
            Connection cn=Conexion.conectar();
            
            DefaultTableModel modelo=new DefaultTableModel()
            {
                @Override
                public boolean isCellEditable(int fil, int col) {
                    return col==9;
                }
            
            };
            
            modelo.addColumn("ID Medicamento");
            modelo.addColumn("Nombre");
            modelo.addColumn("Principio Activo");
            modelo.addColumn("Indicacion De Uso");
            modelo.addColumn("Dosis");
            modelo.addColumn("Presentacion");
            modelo.addColumn("Precio Interior Q.");
            modelo.addColumn("Precio Exterior Q.");
            
            
            jTable1.setModel(modelo);
            String sql="";
            
            if (valor.equals(""))
            {
                sql="select * from Medicamento where medicamento.Habilitado = 1";
            }
            else if (valor.equals("Des"))
            {
                sql="select * from Medicamento where medicamento.Habilitado = 0";
            }
            
            else
            {
                sql="SELECT * FROM Medicamento WHERE (idMedicamento='"+valor+"'  OR Nombre='"+valor+"' OR PrincipioActivo='"+valor+"' )";
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
                    datos[7]=rs.getString(8);                    
                                        
                    modelo.addRow(datos);
                }
                           
              
           
        }catch(SQLException ex){
           
          JOptionPane.showMessageDialog(null, "Error" +ex);
        }
    }
           
 private int VerExist(String Id)
    {
        try{
            Connection cn=Conexion.conectar();
            String sql="";          
            
            sql="select lote.existencia from lote where (lote.Medicamento_idMedicamento ='"+Id+"' )";
            
            int existencia =0;
            
            try{
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                while(rs.next())
                {
                    existencia=Integer.parseInt(rs.getString(1));
                }
                
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Error" +ex);
            }
            return existencia;
        }
        
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error" +ex);
            return 100;
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
        jmenuDesha = new javax.swing.JMenuItem();
        jmenuModifPrecio = new javax.swing.JMenuItem();
        jMenuInsertar = new javax.swing.JMenuItem();
        jmenuHabi = new javax.swing.JMenuItem();
        buttonGroup = new javax.swing.ButtonGroup();
        btnInsertar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtIndicUso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtDosis = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxtPrincAct = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxtPrecioInt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxtPrecioExt = new javax.swing.JTextField();
        jtxtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtxtPresentacion = new javax.swing.JTextField();
        radHabili = new javax.swing.JRadioButton();
        radDeshabi = new javax.swing.JRadioButton();
        btnMenu = new javax.swing.JButton();
        jLabelMenu = new javax.swing.JLabel();
        btnNuevoMe = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelMenu1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jmenuDesha.setText("Deshabilitar");
        jmenuDesha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuDeshaActionPerformed(evt);
            }
        });
        jpopOpciones.add(jmenuDesha);

        jmenuModifPrecio.setText(" Modificar Precio");
        jmenuModifPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuModifPrecioActionPerformed(evt);
            }
        });
        jpopOpciones.add(jmenuModifPrecio);

        jMenuInsertar.setText("Insertar");
        jMenuInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuInsertarActionPerformed(evt);
            }
        });
        jpopOpciones.add(jMenuInsertar);

        jmenuHabi.setText("Habilitar");
        jmenuHabi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuHabiActionPerformed(evt);
            }
        });
        jpopOpciones.add(jmenuHabi);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MEDICAMENTO");
        setMinimumSize(new java.awt.Dimension(1150, 690));
        setName("Medicamento"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1150, 690));
        setResizable(false);
        getContentPane().setLayout(null);

        btnInsertar.setBackground(new java.awt.Color(255, 255, 255));
        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AñadirBlanco.png"))); // NOI18N
        btnInsertar.setBorderPainted(false);
        btnInsertar.setContentAreaFilled(false);
        btnInsertar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AñadirNegro.png"))); // NOI18N
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsertar);
        btnInsertar.setBounds(20, 440, 50, 40);

        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ActualizarBlanco.png"))); // NOI18N
        btnMostrar.setBorderPainted(false);
        btnMostrar.setContentAreaFilled(false);
        btnMostrar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ActualizarNegro.png"))); // NOI18N
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMostrar);
        btnMostrar.setBounds(210, 570, 50, 41);

        jTable1.setBackground(new java.awt.Color(240, 240, 240));
        jTable1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
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
        jScrollPane2.setBounds(187, 88, 730, 480);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modificar");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 500, 60, 30);

        jtxtNombre.setBackground(new java.awt.Color(240, 240, 240));
        jtxtNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        getContentPane().add(jtxtNombre);
        jtxtNombre.setBounds(21, 100, 140, 30);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Indicacion de Uso");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 180, 120, 18);

        jtxtIndicUso.setBackground(new java.awt.Color(240, 240, 240));
        jtxtIndicUso.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        getContentPane().add(jtxtIndicUso);
        jtxtIndicUso.setBounds(20, 200, 140, 30);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dosis");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 230, 40, 18);

        jtxtDosis.setBackground(new java.awt.Color(240, 240, 240));
        jtxtDosis.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        getContentPane().add(jtxtDosis);
        jtxtDosis.setBounds(20, 250, 140, 30);

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Principio Activo");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 130, 110, 18);

        jtxtPrincAct.setBackground(new java.awt.Color(240, 240, 240));
        jtxtPrincAct.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        getContentPane().add(jtxtPrincAct);
        jtxtPrincAct.setBounds(20, 150, 140, 30);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Precio Interior (Q.)");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 330, 130, 18);

        jtxtPrecioInt.setBackground(new java.awt.Color(240, 240, 240));
        jtxtPrecioInt.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        getContentPane().add(jtxtPrecioInt);
        jtxtPrecioInt.setBounds(20, 350, 140, 30);

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Precio Exterior (Q.)");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 380, 130, 18);

        jtxtPrecioExt.setBackground(new java.awt.Color(240, 240, 240));
        jtxtPrecioExt.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        getContentPane().add(jtxtPrecioExt);
        jtxtPrecioExt.setBounds(20, 400, 140, 30);

        jtxtBuscar.setBackground(new java.awt.Color(240, 240, 240));
        jtxtBuscar.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        getContentPane().add(jtxtBuscar);
        jtxtBuscar.setBounds(940, 90, 130, 30);

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
        btnBuscar.setBounds(1080, 80, 50, 40);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LapizBlanco.png"))); // NOI18N
        btnModificar.setBorderPainted(false);
        btnModificar.setContentAreaFilled(false);
        btnModificar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LapizNegro.png"))); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar);
        btnModificar.setBounds(100, 460, 50, 60);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Presentación");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 280, 110, 17);

        jtxtPresentacion.setBackground(new java.awt.Color(240, 240, 240));
        jtxtPresentacion.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        getContentPane().add(jtxtPresentacion);
        jtxtPresentacion.setBounds(20, 300, 140, 30);

        buttonGroup.add(radHabili);
        radHabili.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        radHabili.setForeground(new java.awt.Color(255, 255, 255));
        radHabili.setText("Habilitados");
        radHabili.setContentAreaFilled(false);
        radHabili.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radHabiliActionPerformed(evt);
            }
        });
        getContentPane().add(radHabili);
        radHabili.setBounds(950, 200, 107, 23);

        buttonGroup.add(radDeshabi);
        radDeshabi.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        radDeshabi.setForeground(new java.awt.Color(255, 255, 255));
        radDeshabi.setText("Deshabilitados");
        radDeshabi.setContentAreaFilled(false);
        radDeshabi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radDeshabiActionPerformed(evt);
            }
        });
        getContentPane().add(radDeshabi);
        radDeshabi.setBounds(950, 220, 120, 23);

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
        btnMenu.setBounds(1030, 560, 73, 49);

        jLabelMenu.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabelMenu.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenu.setText("Actualizar");
        getContentPane().add(jLabelMenu);
        jLabelMenu.setBounds(190, 610, 90, 17);

        btnNuevoMe.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoMe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AñadirBlanco.png"))); // NOI18N
        btnNuevoMe.setBorderPainted(false);
        btnNuevoMe.setContentAreaFilled(false);
        btnNuevoMe.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AñadirNegro.png"))); // NOI18N
        btnNuevoMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMeActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevoMe);
        btnNuevoMe.setBounds(140, 20, 40, 40);

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/XBlanca.png"))); // NOI18N
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/XNegra.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(20, 490, 50, 50);

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 80, 49, 18);

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Estado");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(980, 180, 50, 30);

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Añadir");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(30, 470, 40, 30);

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cancelar");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(20, 530, 50, 20);

        jLabelMenu1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabelMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenu1.setText("Menú");
        getContentPane().add(jLabelMenu1);
        jLabelMenu1.setBounds(1040, 610, 60, 17);

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nuevo");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(140, 50, 40, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Íconos/rectangulo.png"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(940, 170, 140, 100);

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Buscar");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(1090, 110, 40, 30);

        jLabel1.setBackground(new java.awt.Color(38, 76, 114));
        jLabel1.setMinimumSize(new java.awt.Dimension(1150, 690));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(1150, 690));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1150, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        

            try{ Connection cn=Conexion.conectar();
            {
                  if(Validar()==0)
                  {
                      PreparedStatement pst=cn.prepareStatement("INSERT INTO Medicamento(Nombre,PrincipioActivo,IndicacionUso,Dosis,Presentacion,PrecioInt,PrecioExt,Habilitado) VALUES(?,?,?,?,?,?,?,?)");
                
                      pst.setString(1,jtxtNombre.getText());
                      pst.setString(2,jtxtPrincAct.getText());
                      pst.setString(3,jtxtIndicUso.getText());
                      pst.setString(4,jtxtDosis.getText());
                      pst.setString(5,jtxtPresentacion.getText());
                      pst.setDouble(6,Double.parseDouble(jtxtPrecioInt.getText()));
                      pst.setDouble(7,Double.parseDouble(jtxtPrecioExt.getText()));
                      pst.setBoolean(8, true);




                      int a=pst.executeUpdate();
                      if(a>0)
                      {
                          JOptionPane.showMessageDialog(null,"Registro exitoso");
                          mostrardatos("");

                          jtxtNombre.setText(null);
                          jtxtPrincAct.setText(null);
                          jtxtIndicUso.setText(null);
                          jtxtPresentacion.setText(null);
                          jtxtDosis.setText(null);
                          jtxtPresentacion.setText(null);                     
                          jtxtPrecioInt.setText(null);
                          jtxtPrecioExt.setText(null);
                          btnCancelar.setVisible(false);


                      }

                      else
                      {
                          JOptionPane.showMessageDialog(null,"Error al agregar");
                      }
                  
                  } // fin del if validar
                   else
                       {
                             JOptionPane.showMessageDialog(null, "Llenar Todos Los Campos", "Error", JOptionPane.ERROR_MESSAGE);
                       }


             
                 } // fin del tray conexion
                  

            
            } // FIN DEL TRY 
            
            
            
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }









        
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        mostrardatos("");
        
        btnNuevoMe.setVisible(true);
        //radHabili.setSelected(true);
        btnInsertar.setVisible(false);     
        btnModificar.setVisible(false);
        jtxtNombre.setText("");
        jtxtPrincAct.setText("");
        jtxtIndicUso.setText("");
        jtxtDosis.setText("");
        jtxtPresentacion.setText("");
        jtxtPrecioInt.setText("");
        jtxtPrecioExt.setText("");
        jtxtBuscar.setText("");
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        mostrardatos(jtxtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jmenuDeshaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuDeshaActionPerformed
        
        
        try {
            Connection cn=Conexion.conectar();
            
            
            int fila=jTable1.getSelectedRow();
            
            jtxtNombre.setText(jTable1.getValueAt(fila,1).toString());
            jtxtPrincAct.setText(jTable1.getValueAt(fila,2).toString());
            jtxtIndicUso.setText(jTable1.getValueAt(fila,3).toString());
            jtxtDosis.setText(jTable1.getValueAt(fila,4).toString());
            jtxtPresentacion.setText(jTable1.getValueAt(fila,5).toString());
            
            jtxtPrecioInt.setText(jTable1.getValueAt(fila,6).toString());
            jtxtPrecioExt.setText(jTable1.getValueAt(fila,7).toString());
            
            String idm="";
            if(fila==-1)
            {
                JOptionPane.showMessageDialog(null, "Seleccione una casilla", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                idm=jTable1.getValueAt(fila,0).toString();
            }
            
            VerExist(idm); // Verificar las existencias            
            System.out.println(VerExist(idm));
            if(VerExist(idm)==0)
            {
            int k =  JOptionPane.showConfirmDialog(null, "Desea deshabilitar el medicamento", "Deshabilitar", JOptionPane.YES_NO_OPTION);
               
            if(k==JOptionPane.YES_OPTION)
                {
                 try{
                        
                        PreparedStatement pst=cn.prepareStatement("UPDATE Medicamento SET idMedicamento='"+idm+"',Nombre='"+jtxtNombre.getText()+"',PrincipioActivo='"+jtxtPrincAct.getText()+"',IndicacionUso='"+jtxtIndicUso.getText()+"',Dosis='"+jtxtDosis.getText()+"',Presentacion='"+jtxtPresentacion.getText()+"',PrecioInt='"+jtxtPrecioInt.getText()+"',PrecioExt='"+jtxtPrecioExt.getText()+"',Habilitado='"+"0"+ "' WHERE idMedicamento='"+idm+"' ");
                        pst.executeUpdate();
                        mostrardatos("");
                         
                    }
                    catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Error "+e, "Error", JOptionPane.ERROR_MESSAGE);
                        
                    }
                    
                } //  Fin Pregunta SI o NO deshabilitar medicamento
            } // fin IF, existencias = 0
            
            else // else por si el medicamento tiene existencias
            {
                JOptionPane.showMessageDialog(null, "El medicamento aun tiene existencias ", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            
        } catch (SQLException ex) { // TRY CATCH conexion
          JOptionPane.showMessageDialog(null, "Error" + ex);

        }
                              
        
    }//GEN-LAST:event_jmenuDeshaActionPerformed

    private void jmenuModifPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuModifPrecioActionPerformed
        btnInsertar.setVisible(false);
        btnNuevoMe.setVisible(false);
        btnCancelar.setVisible(true);
   
        
        int fila=jTable1.getSelectedRow();
        if (fila==-1) {
        JOptionPane.showMessageDialog(null, "Seleccione una casilla", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{

        jtxtPrecioInt.setEnabled(true);
        jtxtPrecioExt.setEnabled(true);
        btnModificar.setVisible(true);
            
 //--------------------------------------------           
            
             jtxtNombre.setText(jTable1.getValueAt(fila,1).toString());
             jtxtPrincAct.setText(jTable1.getValueAt(fila,2).toString());
             jtxtIndicUso.setText(jTable1.getValueAt(fila,3).toString());
             jtxtDosis.setText(jTable1.getValueAt(fila,4).toString());
             jtxtPresentacion.setText(jTable1.getValueAt(fila,5).toString());

             jtxtPrecioInt.setText(jTable1.getValueAt(fila,6).toString());
             jtxtPrecioExt.setText(jTable1.getValueAt(fila,7).toString());

             }
                   

    }//GEN-LAST:event_jmenuModifPrecioActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
             
        try{                                            
            Connection cn=Conexion.conectar();
            
            int fila=jTable1.getSelectedRow();
            String idm="";
            if(fila==-1)
            {
                JOptionPane.showMessageDialog(null, "Seleccione una casilla", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                idm=jTable1.getValueAt(fila,0).toString();
            }
            
            
            try{
                if (Validar()==0) 
                {
                        PreparedStatement pst=cn.prepareStatement("UPDATE Medicamento SET idMedicamento='"+idm+"',Nombre='"+jtxtNombre.getText()+"',PrincipioActivo='"+jtxtPrincAct.getText()+"',IndicacionUso='"+jtxtIndicUso.getText()+"',Dosis='"+jtxtDosis.getText()+"',Presentacion='"+jtxtPresentacion.getText()+"',PrecioInt='"+jtxtPrecioInt.getText()+"',PrecioExt='"+jtxtPrecioExt.getText()+"',Habilitado='"+"1"+ "' WHERE idMedicamento='"+idm+"' ");
                       pst.executeUpdate();

                       mostrardatos("");
                       jtxtNombre.setText(null);
                       jtxtPrincAct.setText(null);
                       jtxtIndicUso.setText(null);
                       jtxtDosis.setText(null);  
                       jtxtPresentacion.setText(null);     
                       jtxtPrecioInt.setText(null);
                       jtxtPrecioExt.setText(null);
                       jtxtPrecioExt.setText(null);
                       jtxtPrecioExt.setEnabled(false);
                       jtxtPrecioInt.setEnabled(false);
                       btnModificar.setVisible(false);
                       JOptionPane.showMessageDialog(null, "Registro Modificado Con Exito");
                } // FIn del if Validar
                
                else
                  {
                   JOptionPane.showMessageDialog(null, "Llenar Todos Los Campos", "Error", JOptionPane.ERROR_MESSAGE);
                  }
                
                
               
                
                
            } //TRY CATCH de actualizacion
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "Error"+e);
            }
            
        }
        catch(SQLException ex)
        {
         JOptionPane.showMessageDialog(null, "Error"+ex); // TRY CATCH conexion
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jMenuInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuInsertarActionPerformed
      
       btnCancelar.setVisible(true);
        btnNuevoMe.setVisible(false);
        btnInsertar.setVisible(true);
        btnInsertar.setEnabled(true);
        btnModificar.setVisible(false);
         
        jtxtNombre.setEnabled(true);
        jtxtPrincAct.setEnabled(true);
        jtxtIndicUso.setEnabled(true);
        jtxtDosis.setEnabled(true);
        jtxtPresentacion.setEnabled(true);

        jtxtPrecioInt.setEnabled(true);
        jtxtPrecioExt.setEnabled(true);
        btnInsertar.setEnabled(true);
        
        

        jtxtNombre.setText("");
        jtxtPrincAct.setText("");
        jtxtIndicUso.setText("");
        jtxtDosis.setText("");
        jtxtPresentacion.setText("");

        jtxtPrecioInt.setText("");
        jtxtPrecioExt.setText("");
       
    }//GEN-LAST:event_jMenuInsertarActionPerformed

    private void jmenuHabiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuHabiActionPerformed
      
              try {
            Connection cn=Conexion.conectar();
            
            
            int fila=jTable1.getSelectedRow();
            
            jtxtNombre.setText(jTable1.getValueAt(fila,1).toString());
            jtxtPrincAct.setText(jTable1.getValueAt(fila,2).toString());
            jtxtIndicUso.setText(jTable1.getValueAt(fila,3).toString());
            jtxtDosis.setText(jTable1.getValueAt(fila,4).toString());
            jtxtPresentacion.setText(jTable1.getValueAt(fila,5).toString());
            
            jtxtPrecioInt.setText(jTable1.getValueAt(fila,6).toString());
            jtxtPrecioExt.setText(jTable1.getValueAt(fila,7).toString());
            
            String idm="";
            if(fila==-1)
            {
                JOptionPane.showMessageDialog(null, "Seleccione una casilla", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                idm=jTable1.getValueAt(fila,0).toString();
            }
            
           
          
            int k =  JOptionPane.showConfirmDialog(null, "Desea Habilitar el medicamento", "Habilitar", JOptionPane.YES_NO_OPTION);
               
            if(k==JOptionPane.YES_OPTION)
                {
                 try{
                        
                        PreparedStatement pst=cn.prepareStatement("UPDATE Medicamento SET idMedicamento='"+idm+"',Nombre='"+jtxtNombre.getText()+"',PrincipioActivo='"+jtxtPrincAct.getText()+"',IndicacionUso='"+jtxtIndicUso.getText()+"',Dosis='"+jtxtDosis.getText()+"',Presentacion='"+jtxtPresentacion.getText()+"',PrecioInt='"+jtxtPrecioInt.getText()+"',PrecioExt='"+jtxtPrecioExt.getText()+"',Habilitado='"+"1"+ "' WHERE idMedicamento='"+idm+"' ");
                        pst.executeUpdate();
                        mostrardatos("");
                         
                    }
                    catch (Exception e){
                        JOptionPane.showMessageDialog(null, "Error "+e, "Error", JOptionPane.ERROR_MESSAGE);
                        
                    }
                    
                 radHabili.setSelected(true);
                jmenuModifPrecio.setVisible(true);
                jmenuDesha.setVisible(true);
                jMenuInsertar.setVisible(true);
                jmenuHabi.setVisible(false);
                 
                } //  Fin Pregunta SI o NO deshabilitar medicamento
          
            
                       
            
        } catch (SQLException ex) { // TRY CATCH conexion
          JOptionPane.showMessageDialog(null, "Error" + ex);

        }
                              
          
    }//GEN-LAST:event_jmenuHabiActionPerformed

    private void radHabiliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radHabiliActionPerformed
        mostrardatos("");

        jmenuModifPrecio.setVisible(true);
        jmenuDesha.setVisible(true);
        jMenuInsertar.setVisible(true);
        jmenuHabi.setVisible(false);

        
        
        jtxtNombre.setEnabled(false);
        jtxtPrincAct.setEnabled(false);
        jtxtIndicUso.setEnabled(false);
        jtxtDosis.setEnabled(false);
        jtxtPresentacion.setEnabled(false);
        jtxtPrecioInt.setEnabled(false);
        jtxtPrecioExt.setEnabled(false);
        
        btnInsertar.setVisible(false);
        btnModificar.setVisible(false);
       

        
        
    }//GEN-LAST:event_radHabiliActionPerformed

    private void radDeshabiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radDeshabiActionPerformed
        String Des="Des";
        mostrardatos(Des);
        
        jmenuHabi.setVisible(true);
        
        jmenuModifPrecio.setVisible(false);
        jmenuDesha.setVisible(false);
        jMenuInsertar.setVisible(false);

        
        jtxtNombre.setEnabled(false);
        jtxtPrincAct.setEnabled(false);
        jtxtIndicUso.setEnabled(false);
        jtxtDosis.setEnabled(false);
        jtxtPresentacion.setEnabled(false);
        jtxtPrecioInt.setEnabled(false);
        jtxtPrecioExt.setEnabled(false);
        
        btnInsertar.setVisible(false);
        btnModificar.setVisible(false);
       

        
    }//GEN-LAST:event_radDeshabiActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        Menu otro = new Menu();
        otro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnNuevoMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMeActionPerformed
        
        btnNuevoMe.setVisible(false);
        btnCancelar.setVisible(true);
        
        btnInsertar.setVisible(true);
        btnInsertar.setEnabled(true);
        btnModificar.setVisible(false);        
         
        jtxtNombre.setEnabled(true);
        jtxtPrincAct.setEnabled(true);
        jtxtIndicUso.setEnabled(true);
        jtxtDosis.setEnabled(true);
        jtxtPresentacion.setEnabled(true);

        jtxtPrecioInt.setEnabled(true);
        jtxtPrecioExt.setEnabled(true);
        btnInsertar.setEnabled(true);
        
        

        jtxtNombre.setText("");
        jtxtPrincAct.setText("");
        jtxtIndicUso.setText("");
        jtxtDosis.setText("");
        jtxtPresentacion.setText("");

        jtxtPrecioInt.setText("");
        jtxtPrecioExt.setText("");
        
        
    }//GEN-LAST:event_btnNuevoMeActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       
        btnNuevoMe.setVisible(true);
        btnCancelar.setVisible(false);
        
        btnInsertar.setVisible(false);
        btnModificar.setVisible(false);        
         
        jtxtNombre.setEnabled(false);
        jtxtPrincAct.setEnabled(false);
        jtxtIndicUso.setEnabled(false);
        jtxtDosis.setEnabled(false);
        jtxtPresentacion.setEnabled(false);

        jtxtPrecioInt.setEnabled(false);
        jtxtPrecioExt.setEnabled(false);
       
        

        jtxtNombre.setText("");
        jtxtPrincAct.setText("");
        jtxtIndicUso.setText("");
        jtxtDosis.setText("");
        jtxtPresentacion.setText("");

        jtxtPrecioInt.setText("");
        jtxtPrecioExt.setText("");
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    
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
            java.util.logging.Logger.getLogger(Medicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Medicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Medicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Medicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Medicamento(user).setVisible(true);
            }
        });
    }
    
     


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnNuevoMe;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMenu;
    private javax.swing.JLabel jLabelMenu1;
    private javax.swing.JMenuItem jMenuInsertar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem jmenuDesha;
    private javax.swing.JMenuItem jmenuHabi;
    private javax.swing.JMenuItem jmenuModifPrecio;
    private javax.swing.JPopupMenu jpopOpciones;
    private javax.swing.JTextField jtxtBuscar;
    private javax.swing.JTextField jtxtDosis;
    private javax.swing.JTextField jtxtIndicUso;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtPrecioExt;
    private javax.swing.JTextField jtxtPrecioInt;
    private javax.swing.JTextField jtxtPresentacion;
    private javax.swing.JTextField jtxtPrincAct;
    private javax.swing.JRadioButton radDeshabi;
    private javax.swing.JRadioButton radHabili;
    // End of variables declaration//GEN-END:variables
}
