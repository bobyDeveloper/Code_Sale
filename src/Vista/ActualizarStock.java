/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import conexion.Conexion;
import controlador.Ctrl_Producto;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Producto;

/**
 *
 * @author Ville
 */
public class ActualizarStock extends javax.swing.JInternalFrame {

    private Connection cn = null;

    int idProducto = 0;
    int cantidad = 0;

    /**
     * Creates new form ActualizarStock
     */
    public ActualizarStock() {
        cn = Conexion.getInstancia().getConexion();
        initComponents();
        this.setTitle("Actulizar stock");
        this.setSize(new Dimension(400, 300));
        this.CargarComboProductos();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtStockNuevo = new javax.swing.JTextField();
        txtStockActual = new javax.swing.JTextField();
        jComboBoxProducto = new javax.swing.JComboBox<>();
        btnAcualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Actualizar stock");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Stock actual:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Stock nuevo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 100, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Producto:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 90, -1));

        txtStockNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtStockNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(txtStockNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 170, -1));

        txtStockActual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtStockActual.setEnabled(false);
        txtStockActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActualActionPerformed(evt);
            }
        });
        getContentPane().add(txtStockActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 170, -1));

        jComboBoxProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:" }));
        jComboBoxProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 170, -1));

        btnAcualizar.setBackground(new java.awt.Color(0, 255, 255));
        btnAcualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAcualizar.setText("Actualizar");
        btnAcualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAcualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 170, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtStockNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockNuevoActionPerformed

    private void txtStockActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActualActionPerformed

    private void btnAcualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcualizarActionPerformed
        //validamos seleccion del producto
        if (!jComboBoxProducto.getSelectedItem().equals("Seleccione producto:")) {
            //Validamos campos vacios
            if (!txtStockNuevo.getText().isEmpty()) {
                //validamos que el usuario no ingrese otros caracteres no numericos
                boolean validacion = validar(txtStockNuevo.getText().trim());
                if (validacion == true) {
                    //validar que la cantidad sea mayor cero (0)
                    if (Integer.parseInt(txtStockNuevo.getText()) > 0) {

                        try {
                            modelo.Producto producto = new modelo.Producto();
                            Ctrl_Producto controlProducto = new Ctrl_Producto();
                            int stockActual = Integer.parseInt(txtStockActual.getText().trim());
                            int stockNuevo = Integer.parseInt(txtStockNuevo.getText().trim());
                            
                            stockNuevo = stockActual + stockNuevo;
                            producto.setCantidad(stockNuevo);
                            if (controlProducto.actualizarStock(producto, idProducto)) {
                                JOptionPane.showMessageDialog(null, "Stock Actualizado");
                                jComboBoxProducto.setSelectedItem("Seleccione producto:");
                                txtStockActual.setText("");
                                txtStockNuevo.setText("");
                                this.CargarComboProductos();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al Actualizar Stock");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(ActualizarStock.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero ni negativa");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "En la cantidad no se admiten caracteres no numericos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una nueva cantidad para sumar el stock del producto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        }
    }//GEN-LAST:event_btnAcualizarActionPerformed

    private void jComboBoxProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProductoActionPerformed
        this.MostrarStock();
    }//GEN-LAST:event_jComboBoxProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcualizar;
    private javax.swing.JComboBox<String> jComboBoxProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtStockActual;
    private javax.swing.JTextField txtStockNuevo;
    // End of variables declaration//GEN-END:variables

    private void CargarComboProductos() {
        String sql = "select * from tb_producto";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBoxProducto.removeAllItems();
            jComboBoxProducto.addItem("Seleccione producto:");
            while (rs.next()) {
                jComboBoxProducto.addItem(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar los productos en: " + e);
        }

    }

    private void MostrarStock() {
        try {
            String sql = "select * from tb_producto where nombre = '" + this.jComboBoxProducto.getSelectedItem() + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                idProducto = rs.getInt("idProducto");
                cantidad = rs.getInt("cantidad");
                txtStockActual.setText(String.valueOf(cantidad));
            } else {
                txtStockActual.setText("");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener stock del producto en: " + e);
        }
    }

    private boolean validar(String valor) {
        int num;
        try {
            num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
