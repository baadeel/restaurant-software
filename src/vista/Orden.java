/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import controlador.ControladorVentanaMenu;
import controlador.ControladorVentanaOrden;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.base_de_datos.HistorialOrdenesDAO;
import modelo.base_de_datos.LineaTiquetDAO;
import modelo.base_de_datos.ProductoDAO;
import modelo.entidades.HistorialOrdenes;

/**
 *
 * @author Badal
 */
public class Orden extends javax.swing.JPanel {

  /**
   * Creates new form Orden
   */
  
  LineaTiquetDAO ltDAO = new LineaTiquetDAO();
  ProductoDAO prDAO = new ProductoDAO();
  String empleadoOrden;
  String empleadoSistema;
  int idLinea;
  ControladorVentanaOrden cvo;
  VentanaPrincipal ventanaPrincipal;
  HistorialOrdenesDAO hoDAO = new HistorialOrdenesDAO();
  
  public Orden() {
    initComponents();
  }
  
  public Orden(VentanaPrincipal vp, int numeroMesa){
    initComponents();
    JComboBox cbEmpleadoSistema = vp.getCBNombreEmpleado();
    empleadoSistema = cbEmpleadoSistema.getSelectedItem().toString();
    empleadoOrden = ltDAO.obtenerNombre(numeroMesa);
    lNombreCamarer.setText(empleadoOrden);
    lNumeroMesa.setText(numeroMesa+"");
    
    ventanaPrincipal = vp;
    
    
    
    cvo = new ControladorVentanaOrden(this, ltDAO, prDAO, hoDAO);
    cvo.setDisponibilidad();
    cvo.actualizarTablaOrden();
    cvo.actualizarTablaMenu();
    cvo.setTotal();
    
    
    
    
    
    

    
    
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    pMenu = new javax.swing.JPanel();
    spMenu = new javax.swing.JScrollPane();
    tMenu = new javax.swing.JTable();
    bAñadir = new javax.swing.JButton();
    bCerrarOrden = new javax.swing.JButton();
    lMenu2 = new javax.swing.JLabel();
    bAtras = new javax.swing.JButton();
    pOrden = new javax.swing.JPanel();
    lMesa = new javax.swing.JLabel();
    lLibre = new javax.swing.JLabel();
    lOcupada = new javax.swing.JLabel();
    spOrden = new javax.swing.JScrollPane();
    tOrden = new javax.swing.JTable();
    lTotal = new javax.swing.JLabel();
    lNumeroMesa = new javax.swing.JLabel();
    lNombreCamarer = new javax.swing.JLabel();
    lCamarer = new javax.swing.JLabel();
    bEliminar = new javax.swing.JButton();
    lTotalValor = new javax.swing.JLabel();

    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    pMenu.setBackground(new java.awt.Color(225, 218, 206));
    pMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    pMenu.setPreferredSize(new java.awt.Dimension(605, 530));
    pMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    tMenu.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Id", "Nombre", "Tipo", "Precio"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    spMenu.setViewportView(tMenu);
    if (tMenu.getColumnModel().getColumnCount() > 0) {
      tMenu.getColumnModel().getColumn(0).setMinWidth(40);
      tMenu.getColumnModel().getColumn(1).setMinWidth(400);
    }

    pMenu.add(spMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 570, 410));

    bAñadir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    bAñadir.setForeground(new java.awt.Color(51, 204, 0));
    bAñadir.setText("AÑADIR");
    bAñadir.setOpaque(true);
    bAñadir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bAñadirActionPerformed(evt);
      }
    });
    pMenu.add(bAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 111, -1));

    bCerrarOrden.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    bCerrarOrden.setText("CERRAR ORDEN");
    bCerrarOrden.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bCerrarOrdenActionPerformed(evt);
      }
    });
    pMenu.add(bCerrarOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 170, 30));

    lMenu2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lMenu2.setForeground(new java.awt.Color(0, 0, 0));
    lMenu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lMenu2.setText("MENÚ");
    pMenu.add(lMenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 30));

    bAtras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    bAtras.setText("ATRÁS");
    bAtras.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bAtrasActionPerformed(evt);
      }
    });
    pMenu.add(bAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, 100, 30));

    add(pMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 0, 600, 530));

    pOrden.setBackground(new java.awt.Color(225, 218, 206));
    pOrden.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    pOrden.setMinimumSize(new java.awt.Dimension(605, 522));
    pOrden.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    lMesa.setBackground(new java.awt.Color(153, 153, 153));
    lMesa.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lMesa.setForeground(new java.awt.Color(0, 0, 0));
    lMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lMesa.setText("MESA: ");
    pOrden.add(lMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 29, -1, -1));

    lLibre.setBackground(new java.awt.Color(0, 0, 0));
    lLibre.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lLibre.setForeground(new java.awt.Color(153, 255, 153));
    lLibre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lLibre.setText("LIBRE");
    lLibre.setOpaque(true);
    pOrden.add(lLibre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

    lOcupada.setBackground(new java.awt.Color(0, 0, 0));
    lOcupada.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lOcupada.setForeground(new java.awt.Color(255, 102, 102));
    lOcupada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lOcupada.setText("OCUPADA");
    lOcupada.setOpaque(true);
    pOrden.add(lOcupada, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

    tOrden.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "UDS", "Nombre", "PVP", "Importe"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    spOrden.setViewportView(tOrden);
    if (tOrden.getColumnModel().getColumnCount() > 0) {
      tOrden.getColumnModel().getColumn(0).setMinWidth(40);
      tOrden.getColumnModel().getColumn(1).setMinWidth(400);
    }

    pOrden.add(spOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 580, 412));

    lTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lTotal.setForeground(new java.awt.Color(0, 0, 0));
    lTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lTotal.setText("TOTAL: ");
    pOrden.add(lTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 140, -1));

    lNumeroMesa.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lNumeroMesa.setForeground(new java.awt.Color(0, 0, 0));
    lNumeroMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lNumeroMesa.setText("14");
    pOrden.add(lNumeroMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 50, -1));

    lNombreCamarer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lNombreCamarer.setForeground(new java.awt.Color(0, 0, 0));
    lNombreCamarer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lNombreCamarer.setText("Juanita");
    pOrden.add(lNombreCamarer, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, -1, -1));

    lCamarer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lCamarer.setForeground(new java.awt.Color(0, 0, 0));
    lCamarer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lCamarer.setText("Camarer@:");
    pOrden.add(lCamarer, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, -1, -1));

    bEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    bEliminar.setForeground(new java.awt.Color(255, 102, 102));
    bEliminar.setText("ELIMINAR");
    bEliminar.setOpaque(true);
    bEliminar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bEliminarActionPerformed(evt);
      }
    });
    pOrden.add(bEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 111, -1));

    lTotalValor.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lTotalValor.setForeground(new java.awt.Color(0, 102, 0));
    lTotalValor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lTotalValor.setText("32 $");
    pOrden.add(lTotalValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 250, -1));

    add(pOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 530));
  }// </editor-fold>//GEN-END:initComponents

  private void bAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAñadirActionPerformed
    // TODO add your handling code here:
    cvo.añadir();
  }//GEN-LAST:event_bAñadirActionPerformed

  private void bCerrarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarOrdenActionPerformed
    cvo.cerrarOrden();
  }//GEN-LAST:event_bCerrarOrdenActionPerformed

  private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
    cvo.eliminarProducto();
  }//GEN-LAST:event_bEliminarActionPerformed

  private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_bAtrasActionPerformed

 
  
  public JTable getTablaOrden(){
    return tOrden;
  }
  
  public JTable getTablaMenu(){
    return tMenu;
  }
  
  public JLabel getLibre(){
    return lLibre;
  }
  
  public JLabel getOcupada(){
    return lOcupada;
  }
  
  public int getNumeroMesa(){
    return Integer.parseInt(lNumeroMesa.getText());
  }
  
  public JLabel getTotal(){
    return lTotalValor;
  }
  
   public String getEmpleadoSistema(){
    return ventanaPrincipal.getCBEmpleados().getSelectedItem().toString();
  }
  
  public String getEmpleadoOrden(){
    return lNombreCamarer.getText();
  }
  
  public JLabel getlNombreCamarer(){
    return lNombreCamarer;
  }
  
  public JButton getCerrarOrdenBoton(){
    return bCerrarOrden;
  }
  
  
 
        

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bAtras;
  private javax.swing.JButton bAñadir;
  private javax.swing.JButton bCerrarOrden;
  private javax.swing.JButton bEliminar;
  private javax.swing.JLabel lCamarer;
  private javax.swing.JLabel lLibre;
  private javax.swing.JLabel lMenu2;
  private javax.swing.JLabel lMesa;
  private javax.swing.JLabel lNombreCamarer;
  private javax.swing.JLabel lNumeroMesa;
  private javax.swing.JLabel lOcupada;
  private javax.swing.JLabel lTotal;
  private javax.swing.JLabel lTotalValor;
  private javax.swing.JPanel pMenu;
  private javax.swing.JPanel pOrden;
  private javax.swing.JScrollPane spMenu;
  private javax.swing.JScrollPane spOrden;
  private javax.swing.JTable tMenu;
  private javax.swing.JTable tOrden;
  // End of variables declaration//GEN-END:variables
}