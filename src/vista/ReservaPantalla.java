package vista;

import controlador.ControladorVentanaReservas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.Timer;
import modelo.base_de_datos.ReservaDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Badal
 */
public class ReservaPantalla extends javax.swing.JPanel {

  /**
   * Creates new form Reservas
   */
  
  Timer timer;
  ReservaDAO rsDAO = new ReservaDAO();
  ControladorVentanaReservas cvr;
  public ReservaPantalla() {
    initComponents();
    
    cvr = new ControladorVentanaReservas(this,rsDAO);
    cvr.actualizarTabla();
    
    
    
    //Fecha y hora actuales
    ActionListener actionListener = new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        Date date = new Date();
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormat.format(date);
        lHoraReal.setText(time);
        
        Date date2 = new Date();
        DateFormat timeFormat2 = new SimpleDateFormat("yyyy/MM/dd");
        String time2 = timeFormat2.format(date2);
        lFechaReal.setText(time2);
        
        
      }  
    };
    timer = new Timer(1000, actionListener);
    timer.setInitialDelay(0);
    timer.start();
  }

  public ReservaPantalla(String nombre, int personas, String comentarios, Date fecha, Date hora, int numeroMesa) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  public ReservaPantalla(int i, String string, int i0, String string0, Date date, Date date0, int i1) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    timePicker = new com.raven.swing.TimePicker();
    date = new com.raven.datechooser.DateChooser();
    pFondo = new javax.swing.JPanel();
    lReservas = new javax.swing.JLabel();
    lAñadir = new javax.swing.JLabel();
    bEliminar = new javax.swing.JButton();
    spReservas = new javax.swing.JScrollPane();
    tReservas = new javax.swing.JTable();
    pAñadirReserva = new javax.swing.JPanel();
    lNombre1 = new javax.swing.JLabel();
    lPersonas = new javax.swing.JLabel();
    lHora = new javax.swing.JLabel();
    tfNombre = new javax.swing.JTextField();
    tfPersonas = new javax.swing.JTextField();
    bAñadir = new javax.swing.JButton();
    lFecha = new javax.swing.JLabel();
    lComentarios = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    taComentarios = new javax.swing.JTextArea();
    tfHora = new javax.swing.JTextField();
    tfFecha = new javax.swing.JTextField();
    bFecha = new javax.swing.JButton();
    bHora = new javax.swing.JButton();
    lMesa = new javax.swing.JLabel();
    cbMesa = new javax.swing.JComboBox<>();
    pFechaYHoraActual = new javax.swing.JPanel();
    lFechaActual = new javax.swing.JLabel();
    lHoraActual = new javax.swing.JLabel();
    lFechaReal = new javax.swing.JLabel();
    lHoraReal = new javax.swing.JLabel();

    timePicker.setForeground(new java.awt.Color(204, 93, 93));
    timePicker.set24hourMode(true);
    timePicker.setDisplayText(tfHora);

    date.setDateFormat("yyyy-MM-dd");
    date.setTextRefernce(tfFecha);

    pFondo.setBackground(new java.awt.Color(225, 218, 206));
    pFondo.setPreferredSize(new java.awt.Dimension(1210, 530));

    lReservas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lReservas.setForeground(new java.awt.Color(0, 0, 0));
    lReservas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lReservas.setText("Reservas");

    lAñadir.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lAñadir.setForeground(new java.awt.Color(0, 0, 0));
    lAñadir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lAñadir.setText("AÑADIR RESERVA");

    bEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    bEliminar.setForeground(new java.awt.Color(255, 102, 102));
    bEliminar.setText("ELIMINAR");
    bEliminar.setOpaque(true);
    bEliminar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bEliminarActionPerformed(evt);
      }
    });

    tReservas.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Id", "Mesa", "Nombre", "Personas", "Fecha", "Hora", "Comentarios"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    spReservas.setViewportView(tReservas);
    if (tReservas.getColumnModel().getColumnCount() > 0) {
      tReservas.getColumnModel().getColumn(0).setMaxWidth(40);
      tReservas.getColumnModel().getColumn(1).setMaxWidth(40);
      tReservas.getColumnModel().getColumn(2).setMinWidth(150);
      tReservas.getColumnModel().getColumn(2).setMaxWidth(500);
      tReservas.getColumnModel().getColumn(3).setMaxWidth(70);
      tReservas.getColumnModel().getColumn(4).setMaxWidth(100);
      tReservas.getColumnModel().getColumn(5).setMaxWidth(100);
    }

    pAñadirReserva.setBackground(new java.awt.Color(255, 255, 255));
    pAñadirReserva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    lNombre1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lNombre1.setForeground(new java.awt.Color(0, 0, 0));
    lNombre1.setText("Nombre:");

    lPersonas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lPersonas.setForeground(new java.awt.Color(0, 0, 0));
    lPersonas.setText("Personas:");

    lHora.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lHora.setForeground(new java.awt.Color(0, 0, 0));
    lHora.setText("Hora:");

    tfNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    tfNombre.setMaximumSize(new java.awt.Dimension(5, 5));

    tfPersonas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

    bAñadir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
    bAñadir.setForeground(new java.awt.Color(0, 0, 0));
    bAñadir.setText("AÑADIR");
    bAñadir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bAñadirActionPerformed(evt);
      }
    });

    lFecha.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lFecha.setForeground(new java.awt.Color(0, 0, 0));
    lFecha.setText("Fecha:");

    lComentarios.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lComentarios.setForeground(new java.awt.Color(0, 0, 0));
    lComentarios.setText("Comentarios:");

    taComentarios.setColumns(20);
    taComentarios.setRows(5);
    jScrollPane1.setViewportView(taComentarios);

    tfHora.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    tfHora.setFocusable(false);
    tfHora.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tfHoraActionPerformed(evt);
      }
    });

    tfFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    tfFecha.setFocusable(false);

    bFecha.setText("jButton1");
    bFecha.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bFechaActionPerformed(evt);
      }
    });

    bHora.setText("jButton1");
    bHora.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bHoraActionPerformed(evt);
      }
    });

    lMesa.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lMesa.setForeground(new java.awt.Color(0, 0, 0));
    lMesa.setText("Mesa:");

    cbMesa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    cbMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18" }));

    javax.swing.GroupLayout pAñadirReservaLayout = new javax.swing.GroupLayout(pAñadirReserva);
    pAñadirReserva.setLayout(pAñadirReservaLayout);
    pAñadirReservaLayout.setHorizontalGroup(
      pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pAñadirReservaLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(pAñadirReservaLayout.createSequentialGroup()
            .addGroup(pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(lComentarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGroup(pAñadirReservaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(lHora)
                  .addComponent(lPersonas)
                  .addComponent(lNombre1)
                  .addComponent(lFecha)
                  .addComponent(lMesa))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(tfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
              .addComponent(tfPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(pAñadirReservaLayout.createSequentialGroup()
                .addGroup(pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                  .addComponent(tfHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                  .addComponent(tfFecha, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(bFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(bHora, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addComponent(jScrollPane1)
              .addComponent(cbMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(pAñadirReservaLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(bAñadir)))
        .addGap(23, 23, 23))
    );
    pAñadirReservaLayout.setVerticalGroup(
      pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pAñadirReservaLayout.createSequentialGroup()
        .addGap(19, 19, 19)
        .addGroup(pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lNombre1)
          .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lPersonas)
          .addComponent(tfPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(pAñadirReservaLayout.createSequentialGroup()
            .addGap(2, 2, 2)
            .addComponent(bFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(lFecha)
            .addComponent(tfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(bHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(tfHora)
            .addComponent(lHora)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lMesa)
          .addComponent(cbMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(pAñadirReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(lComentarios))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
        .addComponent(bAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(19, Short.MAX_VALUE))
    );

    pFechaYHoraActual.setBackground(new java.awt.Color(250, 239, 216));
    pFechaYHoraActual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    lFechaActual.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lFechaActual.setForeground(new java.awt.Color(0, 0, 0));
    lFechaActual.setText("Fecha actual:");

    lHoraActual.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lHoraActual.setForeground(new java.awt.Color(0, 0, 0));
    lHoraActual.setText("Hora actual:");

    lFechaReal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lFechaReal.setText("jLabel3");

    lHoraReal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
    lHoraReal.setText("jLabel3");

    javax.swing.GroupLayout pFechaYHoraActualLayout = new javax.swing.GroupLayout(pFechaYHoraActual);
    pFechaYHoraActual.setLayout(pFechaYHoraActualLayout);
    pFechaYHoraActualLayout.setHorizontalGroup(
      pFechaYHoraActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pFechaYHoraActualLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pFechaYHoraActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(lFechaActual)
          .addComponent(lHoraActual))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(pFechaYHoraActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lFechaReal)
          .addComponent(lHoraReal))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pFechaYHoraActualLayout.setVerticalGroup(
      pFechaYHoraActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pFechaYHoraActualLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pFechaYHoraActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lFechaActual)
          .addComponent(lFechaReal))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(pFechaYHoraActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(lHoraActual)
          .addComponent(lHoraReal))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
    pFondo.setLayout(pFondoLayout);
    pFondoLayout.setHorizontalGroup(
      pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pFondoLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(pFondoLayout.createSequentialGroup()
            .addComponent(lReservas)
            .addGap(457, 457, 457)
            .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(spReservas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(pFondoLayout.createSequentialGroup()
            .addComponent(pAñadirReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(79, Short.MAX_VALUE))
          .addGroup(pFondoLayout.createSequentialGroup()
            .addComponent(lAñadir)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pFechaYHoraActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(15, 15, 15))))
    );
    pFondoLayout.setVerticalGroup(
      pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(pFondoLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(pFondoLayout.createSequentialGroup()
            .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(pFondoLayout.createSequentialGroup()
                .addComponent(pFechaYHoraActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
              .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lAñadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(pAñadirReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(pFondoLayout.createSequentialGroup()
            .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(bEliminar)
              .addComponent(lReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(spReservas)))
        .addGap(34, 34, 34))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(pFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(pFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
    cvr.eliminar();
  }//GEN-LAST:event_bEliminarActionPerformed

  private void bAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAñadirActionPerformed
    try {
      cvr.añadirReserva();
    } catch (ParseException ex) {
      Logger.getLogger(ReservaPantalla.class.getName()).log(Level.SEVERE, null, ex);
    }

  }//GEN-LAST:event_bAñadirActionPerformed

  private void bFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFechaActionPerformed
    // TODO add your handling code here:
  date.showPopup();
  }//GEN-LAST:event_bFechaActionPerformed

  private void bHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHoraActionPerformed
    // TODO add your handling code here:
    timePicker.showPopup(this, 800, 150);
  }//GEN-LAST:event_bHoraActionPerformed

  private void tfHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHoraActionPerformed
    // TODO add your handling code here:
        timePicker.showPopup(this, 800, 150);
 
  }//GEN-LAST:event_tfHoraActionPerformed

  
  public JTable getTabla(){
    return tReservas;
  }
  
  public String getNombre(){
    return tfNombre.getText();
  }
  
  public String getPersonas(){
    return tfPersonas.getText();
  }
  
  public String getFecha(){
    return tfFecha.getText();
  }
  
  public String getHora(){
    return tfHora.getText();
  }
  
  public String getComentarios(){
    return taComentarios.getText();
  }
  
  public int getMesa(){
    return Integer.parseInt(cbMesa.getSelectedItem().toString());
  }
  
  public int[] getReservasAEliminar(){
    return tReservas.getSelectedRows();
  }
 

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bAñadir;
  private javax.swing.JButton bEliminar;
  private javax.swing.JButton bFecha;
  private javax.swing.JButton bHora;
  private javax.swing.JComboBox<String> cbMesa;
  private com.raven.datechooser.DateChooser date;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel lAñadir;
  private javax.swing.JLabel lComentarios;
  private javax.swing.JLabel lFecha;
  private javax.swing.JLabel lFechaActual;
  private javax.swing.JLabel lFechaReal;
  private javax.swing.JLabel lHora;
  private javax.swing.JLabel lHoraActual;
  private javax.swing.JLabel lHoraReal;
  private javax.swing.JLabel lMesa;
  private javax.swing.JLabel lNombre1;
  private javax.swing.JLabel lPersonas;
  private javax.swing.JLabel lReservas;
  private javax.swing.JPanel pAñadirReserva;
  private javax.swing.JPanel pFechaYHoraActual;
  private javax.swing.JPanel pFondo;
  private javax.swing.JScrollPane spReservas;
  private javax.swing.JTable tReservas;
  private javax.swing.JTextArea taComentarios;
  private javax.swing.JTextField tfFecha;
  private javax.swing.JTextField tfHora;
  private javax.swing.JTextField tfNombre;
  private javax.swing.JTextField tfPersonas;
  private com.raven.swing.TimePicker timePicker;
  // End of variables declaration//GEN-END:variables
}