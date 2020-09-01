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
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;

import seguridad.Conexion;
import seguridad.Usuario;

/**
 *
 * @author GuillePC
 */
public class Historial extends javax.swing.JFrame {
    private static Usuario user;//variable global del usuario logeado

    /**
     * Creates new form Lotes
     */
    
   
     public Historial(Usuario user) {
        this.user=user;//Se asigna el usuaario que hizo login
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/índice.png")).getImage());
         
        initComponents();
        GrupoBotones.add(Compras);
        GrupoBotones.add(Ventas);
        GrupoBotones2.add(NoAnulado);
        GrupoBotones2.add(Anulado);
        NoAnulado.setEnabled(false);
        Anulado.setEnabled(false);
        this.setLocationRelativeTo(null);
        
        
        /*LlenarCmbMedi();
        LlenarcmbProve(); 

        jtxtCosto.setEnabled(false);
       jtxtExistencia.setEnabled(false);*/
        FechaFin.setEnabled(true);
      
 /*       btnInsertar.setVisible(false);
        btnTerminarCom.setVisible(false);
        btnCancelarCo.setVisible(false);
        btnModificar.setVisible(false);
        
      cmbMedicamentoID.setEnabled(false); */
        
    
    }
    
//    public NuevaCompra() {
//        initComponents();
//       
//        this.setLocationRelativeTo(null);
//        LlenarCmbMedi();
//        LlenarcmbProve(); 
//        //ObtenerDate();
//             
//       
//        jtxtCosto.setEnabled(false);
//        jtxtExistencia.setEnabled(false);
//        jDateFechaCadu.setEnabled(false);
//        btnInsertar.setEnabled(false);
//        btnModificar.setVisible(false);
//        cmbMedicamentoID.setEnabled(false);
//        
//    
//    }
  
     
    private java.sql.Date ObtenerDate(String FechaString) 
    { 
         
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy"); // Se Crea El formato
            java.util.Date fechaD = new java.util.Date(); // Variable De tipo Date
   
            fechaD = formatoFecha.parse(FechaString); // Se le asigna el valor STRING a la variable de tipo Date
            java.sql.Date sqlDate = new java.sql.Date(fechaD.getTime()); // Conversion Explicita a sqlDate
            //System.out.println(sqlDate);
            return sqlDate;
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);

        }
        return null;

            
    }
    
   /*  private int Validar()
    {
       
        if ( jtxtCosto.getText().length()==0) 
        {
          JOptionPane.showMessageDialog(null, "Llenar Todos Los campos", "Error", JOptionPane.ERROR_MESSAGE);
          return 1;
        }
        else if (jtxtExistencia.getText().length()==0) 
        {
          JOptionPane.showMessageDialog(null, "Llenar Todos Los campos", "Error", JOptionPane.ERROR_MESSAGE);
          return 1;

        }
        else if (jDateFechaCadu.getDate()==null) {
            return 1;
        }
        else
        {
            return 0;
        }
    }

   private void LlenarcmbProve()
    {
        try{
            Connection cn=Conexion.conectar();
            String sql="";
            
            
            sql="select * from proveedor ";
            
            String []datos=new String [4];
        
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                while(rs.next())
                {
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);                    
                    
                    cmbProveedor.addItem(datos[0]+".  "+datos[1]);
                    
                }

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error"+ex);
        }

    }
   
   
   private void LlenarCmbMedi()
    {
        try{
            Connection cn=Conexion.conectar();
            
            String sql="";         
            
            sql="select * from Medicamento where medicamento.Habilitado = 1";
            
            String []datos=new String [4];
           
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                while(rs.next())
                {
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    
                    cmbMedicamentoID.addItem(datos[0]+".  "+datos[1]);
                }
                
        }
        
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "Error"+ex);
        }

    }
    
   */
     void mostrardatos1(String valor)
    {
        try{
            Connection cn=Conexion.conectar(); 
            //java.sql.Date datei = new java.sql.Date(fechai.getTime());
            //java.sql.Date datef = new java.sql.Date(fechaf.getTime());
            DefaultTableModel modelo=new DefaultTableModel()
            {
                @Override
                public boolean isCellEditable(int fil, int col) {
                    return col==7;
                }
            
            };
            
            modelo.addColumn("ID Compra");
            modelo.addColumn("Usuario");
            modelo.addColumn("Fecha");
            modelo.addColumn("Proveedor");
            modelo.addColumn("Teléfono");
            modelo.addColumn("Dirección");

            
            java.sql.Date Datei = new java.sql.Date(FechaIni.getDate().getTime());
            java.sql.Date Datef= new java.sql.Date(FechaFin.getDate().getTime());
            String sql = "";
            jTable1.setModel(modelo);
            if (valor.equals(""))
            {
                sql = "Select comp.idCompra, us.Nombre, comp.Fecha, prov.Nombre, prov.Telefono, prov.Direccion from lote lot inner join compra comp on lot.Compra_idCompra = comp.idCompra inner join usuario us on us.idUsuario = comp.Usuario_idUsuario inner join proveedor prov on lot.Proveedor_idproveedor = prov.idproveedor " + "where comp.Fecha between '" + Datei + "' and '" + Datef +"';";
                //PreparedStatement ps = cn.prepareStatement(sql);
                //ps.setDate(1, new java.sql.Date(FechaIni.getDate().getTime()));
                //ps.setDate(2, new java.sql.Date(FechaFin.getDate().getTime()));                
                //ResultSet rs= ps.executeQuery();
            }
            /*else
            {
              //sql="Select lot.IdLotes, med.Nombre, lot.Existencia, lot.Costo, lot.FechaCaducidad, lot.FechaIngreso, pro.Nombre from lote lot inner join medicamento med on lot.Medicamento_idMedicamento = med.idMedicamento left join proveedor pro on lot.Proveedor_idproveedor = pro.idproveedor where (lot.Compra_idCompra ='"+valor+"')";
  
            }*/
            
            
            String []datos=new String [7];
          
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
                    
                    
                    modelo.addRow(datos);
                    
                }
                
                jTable1.setModel(modelo);
           
        }
        
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "Error "+ex);
        }
    }
     
     void mostrardatos2(String valor)
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
            
            modelo.addColumn("ID Venta");
            modelo.addColumn("Usuario");
            modelo.addColumn("Fecha");
            modelo.addColumn("Nombre Cliente");
            modelo.addColumn("Apellido Cliente");
            modelo.addColumn("NIT Cliente");
            modelo.addColumn("Dirección Cliente");
            modelo.addColumn("Total");

                                
            jTable1.setModel(modelo);
            String sql="";
            java.sql.Date Datei = new java.sql.Date(FechaIni.getDate().getTime());
            java.sql.Date Datef= new java.sql.Date(FechaFin.getDate().getTime());
            if (valor.equals(""))
            {
                sql="SELECT vent.idVenta, us.Nombre, vent.Fecha, cli.Nombre,cli.Apellido, cli.NIT, cli.Direccion, vent.Total from usuario us inner join venta vent on us.idUsuario = vent.Usuario_idUsuario inner join cliente cli on cli.idCliente = vent.Cliente_idCliente WHERE vent.Anulado = 0 and vent.Fecha between '" + Datei + "' and '" + Datef +"';";
            }
            else if(valor.equals("2"))
            {
              sql="SELECT vent.idVenta, us.Nombre, vent.Fecha, cli.Nombre,cli.Apellido, cli.NIT, cli.Direccion, vent.Total from usuario us inner join venta vent on us.idUsuario = vent.Usuario_idUsuario inner join cliente cli on cli.idCliente = vent.Cliente_idCliente WHERE vent.Anulado = 1 and vent.Fecha between '" + Datei + "' and '" + Datef +"';";
  
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
                
                jTable1.setModel(modelo);
           
        }
        
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "Error "+ex);
        }
    }
    
     
     
 private void insertarCompra()
 {
        try {
            Connection cn=Conexion.conectar();
            java.util.Date d = new java.util.Date(); 
            java.sql.Date date = new java.sql.Date(d.getTime());
            PreparedStatement pst=cn.prepareStatement("INSERT INTO Compra(Usuario_idUsuario,Fecha) VALUES(?,?)");
                  
                      pst.setInt(1,user.getUserId());
                      pst.setDate(2,date);

                      int a=pst.executeUpdate();
                      if(a>0)
                      {
                         // JOptionPane.showMessageDialog(null,"Compra Generada");
                        
                      }

                      else
                      {
                          JOptionPane.showMessageDialog(null,"Error al Generar Compra");
                      }
           

           
       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" +ex);
           
        }
 
 }
       
 private int obtenerUltimaCom()
 {
     try{
            Connection cn=Conexion.conectar();
            
                String sql="Select * from compra";
                
                String idCo="";  
                int iD;
                Statement st=cn.createStatement();
                ResultSet rs=st.executeQuery(sql);
                
                
                while(rs.next())
                {
                    idCo=rs.getString(1);             
                  
                }
                iD=Integer.parseInt(idCo);
                return iD;
     }
        catch(SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "Error "+ex);
          return 0;
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
        jMenuComprar = new javax.swing.JMenuItem();
        jmenuModificar = new javax.swing.JMenuItem();
        jmenuEliminar = new javax.swing.JMenuItem();
        GrupoBotones = new javax.swing.ButtonGroup();
        GrupoBotones2 = new javax.swing.ButtonGroup();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnMenu = new javax.swing.JButton();
        jLabelMenu = new javax.swing.JLabel();
        FechaFin = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        FechaIni = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        Compras = new javax.swing.JRadioButton();
        Ventas = new javax.swing.JRadioButton();
        Anulado = new javax.swing.JRadioButton();
        NoAnulado = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jMenuComprar.setText("Comprar");
        jMenuComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuComprarActionPerformed(evt);
            }
        });
        jpopOpciones.add(jMenuComprar);

        jmenuModificar.setText("Modificar");
        jmenuModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuModificarActionPerformed(evt);
            }
        });
        jpopOpciones.add(jmenuModificar);

        jmenuEliminar.setText("Eliminar");
        jmenuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuEliminarActionPerformed(evt);
            }
        });
        jpopOpciones.add(jmenuEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HISTORIAL");
        setMinimumSize(new java.awt.Dimension(1150, 690));
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
        btnBuscar.setBounds(1070, 360, 50, 40);

        jTable1.setBackground(new java.awt.Color(240, 240, 240));
        jTable1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setComponentPopupMenu(jpopOpciones);
        jTable1.setFocusable(false);
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(60, 68, 790, 550);

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
        btnMenu.setBounds(1050, 570, 60, 50);

        jLabelMenu.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabelMenu.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMenu.setText("Menú");
        getContentPane().add(jLabelMenu);
        jLabelMenu.setBounds(1050, 620, 60, 17);

        FechaFin.setDateFormatString("yyyy/MM/dd");
        getContentPane().add(FechaFin);
        FechaFin.setBounds(880, 160, 160, 30);

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Buscar");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(1080, 400, 40, 15);

        FechaIni.setDateFormatString("yyyy/MM/dd");
        getContentPane().add(FechaIni);
        FechaIni.setBounds(880, 90, 160, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Íconos/rectangulo.png"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(880, 320, 130, 100);

        Compras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Compras.setForeground(new java.awt.Color(255, 255, 255));
        Compras.setText("Compras");
        Compras.setContentAreaFilled(false);
        Compras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprasActionPerformed(evt);
            }
        });
        getContentPane().add(Compras);
        Compras.setBounds(890, 380, 107, 23);

        Ventas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Ventas.setForeground(new java.awt.Color(255, 255, 255));
        Ventas.setText("Ventas");
        Ventas.setContentAreaFilled(false);
        Ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentasActionPerformed(evt);
            }
        });
        getContentPane().add(Ventas);
        Ventas.setBounds(890, 360, 107, 23);

        Anulado.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        Anulado.setForeground(new java.awt.Color(255, 255, 255));
        Anulado.setText("Anulado");
        Anulado.setContentAreaFilled(false);
        Anulado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnuladoActionPerformed(evt);
            }
        });
        getContentPane().add(Anulado);
        Anulado.setBounds(890, 240, 107, 23);

        NoAnulado.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        NoAnulado.setForeground(new java.awt.Color(255, 255, 255));
        NoAnulado.setText("No Anulado");
        NoAnulado.setContentAreaFilled(false);
        NoAnulado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoAnuladoActionPerformed(evt);
            }
        });
        getContentPane().add(NoAnulado);
        NoAnulado.setBounds(890, 260, 107, 23);

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Estado");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(920, 220, 50, 18);

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tipo");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(930, 340, 28, 18);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Íconos/rectangulo.png"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(880, 200, 130, 100);

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Fecha Final ");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(880, 140, 130, 18);

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fecha Inicial");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(880, 70, 130, 18);

        jLabel1.setBackground(new java.awt.Color(38, 76, 114));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1150, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void jMenuComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuComprarActionPerformed
/*        cmbMedicamentoID.setEnabled(true);
        btnInsertar.setVisible(true);
        btnInsertar.setEnabled(true);
        btnModificar.setVisible(false);

        jtxtCosto.setEnabled(true);
        jtxtExistencia.setEnabled(true);*/
        FechaFin.setEnabled(true);

  /*      btnInsertar.setEnabled(true);

        jtxtCosto.setText("");
        jtxtExistencia.setText("");*/
        FechaFin.setDate(new Date());

    }//GEN-LAST:event_jMenuComprarActionPerformed

    private void jmenuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuModificarActionPerformed
    //    btnInsertar.setVisible(false);
        
       
        int fila=jTable1.getSelectedRow();
        
        int k =  JOptionPane.showConfirmDialog(null, "Modificar compra ?", "Modificar", JOptionPane.YES_NO_OPTION);
               
       if(k==JOptionPane.YES_OPTION)
        {
                if (fila==-1) 
                {
                   JOptionPane.showMessageDialog(null, "Seleccione una casilla", "Error", JOptionPane.ERROR_MESSAGE);
                }
               else{
                    
                   /*jtxtExistencia.setEnabled(true);
                   jtxtCosto.setEnabled(true);
                   cmbMedicamentoID.setEnabled(true);
                   btnModificar.setVisible(true);
                   btnModificar.setEnabled(true);

                   //--------------------------------------------
                   cmbMedicamentoID.setSelectedItem(jTable1.getValueAt(fila,1));
                   jtxtExistencia.setText(jTable1.getValueAt(fila,2).toString());
                   jtxtCosto.setText(jTable1.getValueAt(fila,3).toString());*/
                   FechaFin.setDate(new Date());
                   //cmbMedicamentoID.setSelectedItem(jTable1.getValueAt(fila,3));

               }

       }// fin if si o no 
       
    }//GEN-LAST:event_jmenuModificarActionPerformed

    private void jmenuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuEliminarActionPerformed

       /* try{

            Connection cn=Conexion.conectar();
            int fila=jTable1.getSelectedRow();
            String cod="";
            
            int k =  JOptionPane.showConfirmDialog(null, "Eliminar compra?", "Eliminar", JOptionPane.YES_NO_OPTION);
               
             if(k==JOptionPane.YES_OPTION)
             {
                    if(fila==-1)
                    {
                        JOptionPane.showMessageDialog(null, "Seleccione una casilla", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        cod=jTable1.getValueAt(fila,0).toString();
                    }


                        PreparedStatement pst=cn.prepareStatement("DELETE FROM Lote WHERE idLotes='"+cod+"'");
                        pst.executeUpdate();
                        mostrardatos1(String.valueOf(cod));   

              }

        }
        catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null, "Eror"+ex, "Error", JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_jmenuEliminarActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        Menu otro = new Menu();
        otro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(Compras.isSelected())
       {
           mostrardatos1("");
       }
       else if(Ventas.isSelected() && Anulado.isSelected())
       {
           mostrardatos2("2");
       }
       else if(Ventas.isSelected() && NoAnulado.isSelected())
       {
           mostrardatos2("");
       }
       
        /*mostrardatos(jtxtBuscar.getText());

        if (jTable1.getValueAt(0, 3).toString().equals("0"))
        {
            JOptionPane.showMessageDialog(null, "No hay compras con este ID");
            mostrardatos("");
        }
        jtxtBuscar.setText("");*/
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void VentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentasActionPerformed
//        mostrardatos2("");
        NoAnulado.setEnabled(true);
        Anulado.setEnabled(true);
    }//GEN-LAST:event_VentasActionPerformed

    private void ComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprasActionPerformed
//        mostrardatos1("");
        GrupoBotones2.clearSelection();
        NoAnulado.setEnabled(false);
        Anulado.setEnabled(false);
        
        /*jmenuModifPrecio.setVisible(true);
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
        btnModificar.setVisible(false);*/
    }//GEN-LAST:event_ComprasActionPerformed

    private void AnuladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnuladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnuladoActionPerformed

    private void NoAnuladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoAnuladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoAnuladoActionPerformed

     
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Historial(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Anulado;
    private javax.swing.JRadioButton Compras;
    private com.toedter.calendar.JDateChooser FechaFin;
    private com.toedter.calendar.JDateChooser FechaIni;
    private javax.swing.ButtonGroup GrupoBotones;
    private javax.swing.ButtonGroup GrupoBotones2;
    private javax.swing.JRadioButton NoAnulado;
    private javax.swing.JRadioButton Ventas;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabelMenu;
    private javax.swing.JMenuItem jMenuComprar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem jmenuEliminar;
    private javax.swing.JMenuItem jmenuModificar;
    private javax.swing.JPopupMenu jpopOpciones;
    // End of variables declaration//GEN-END:variables
}
