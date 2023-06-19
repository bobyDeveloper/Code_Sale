/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Decorator.PDFGenerator;
import Decorator.PDFQRDecorator;
import Decorator.VentaPDF;
import conexion.Conexion;
import controlador.Ctrl_Venta;
import java.awt.Dimension;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CabeceraVenta;
import modelo.DetalleVenta;

/**
 *
 * @author Ville
 */
public class Venta extends javax.swing.JInternalFrame {

    private Connection cn = null;

    //Modelo de los datos
    private DefaultTableModel modeloDatosProductos;
    //lista para el detalle de venta de los productos
    ArrayList<DetalleVenta> listaProductos = new ArrayList<>();
    private DetalleVenta producto;

    private int idProducto = 0;
    private String nombre = "";
    private int cantidadProductoBBDD = 0;
    private double precioUnitario = 0.0;
    private int porcentajeIva = 0;

    private int cantidad = 0;//cantidad de productos a comprar
    private double subtotal = 0.0;//cantidad por precio
    private double descuento = 0.0;
    private double iva = 0.0;
    private double totalPagar = 0.0;

    //variables para calculos globales
    private double subtotalGeneral = 0.0;
    private double descuentoGeneral = 0.0;
    private double ivaGeneral = 0.0;
    private double totalPagarGeneral = 0.0;
    //fin de variables de calculos globales

    private int auxIdDetalle = 1;//id del detalle de venta

    /**
     * Creates new form Venta
     */
    public Venta() {
        initComponents();
        cn = Conexion.getInstancia().getConexion();
        this.setSize(new Dimension(800, 600));
        this.setTitle("Nueva venta");
        ImageIcon fondo = new ImageIcon("src/Img/fondo3.jpg");
        Icon icono = new ImageIcon(fondo.getImage().getScaledInstance(800, 600, WIDTH));
        jFondo.setIcon(icono);
        this.repaint();
        //Cargar lo Clientes en la vista - cargar productos
        this.CargarComboProductos();

        this.inicializarTablaProducto();

        txtSubtotal.setText("0.0");
        txtIva.setText("0.0");
        txtDescuento.setText("0.0");
        txtTotal.setText("0.0");
    }

    //metodo para inicializar la tabla de los productos
    private void inicializarTablaProducto() {
        modeloDatosProductos = new DefaultTableModel();
        //añadir columnas
        modeloDatosProductos.addColumn("N");
        modeloDatosProductos.addColumn("Nombre");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("P. Unitario");
        modeloDatosProductos.addColumn("SubTotal");
        modeloDatosProductos.addColumn("Descuento");
        modeloDatosProductos.addColumn("Iva");
        modeloDatosProductos.addColumn("Total Pagar");
        modeloDatosProductos.addColumn("Accion");
        //agregar los datos del modelo a la tabla
        Venta.jTableVenta.setModel(modeloDatosProductos);
        jTableVenta.setEnabled(false);
        jTableVenta.getTableHeader().setReorderingAllowed(false);
    }

    //metodo para presentar la informacion de la tavla DetalleVenta
    private void listaTablaProductos() {
        this.modeloDatosProductos.setRowCount(listaProductos.size());
        for (int i = 0; i < listaProductos.size(); i++) {
            this.modeloDatosProductos.setValueAt(i + 1, i, 0);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getNombre(), i, 1);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getCantidad(), i, 2);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getPrecioUnitario(), i, 3);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getSubTotal(), i, 4);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getDescuento(), i, 5);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getIva(), i, 6);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getTotalPagar(), i, 7);
            this.modeloDatosProductos.setValueAt("Eliminar", i, 8);//aqui luego poner un boton de eliminar
        }
        //añadir al Jtable
        jTableVenta.setModel(modeloDatosProductos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxProducto = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        btnAñadir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVenta = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtEfectivo = new javax.swing.JTextField();
        txtCambio = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        btnVenta = new javax.swing.JButton();
        btnCalcularCambio = new javax.swing.JButton();
        txtCantidad1 = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nueva venta");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Producto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        jComboBoxProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:" }));
        getContentPane().add(jComboBoxProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 170, -1));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 120, -1));

        btnAñadir.setBackground(new java.awt.Color(0, 255, 255));
        btnAñadir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAñadir.setText("Añadir");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVenta);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 740, 190));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 760, 210));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Cambio:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Iva:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Total a pagar:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Efectivo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Subtotal:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Descuento:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtDescuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDescuento.setEnabled(false);
        txtDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentoActionPerformed(evt);
            }
        });
        jPanel1.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 120, -1));

        txtIva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIva.setEnabled(false);
        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });
        jPanel1.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 120, -1));

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotal.setEnabled(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 120, -1));

        txtEfectivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEfectivoActionPerformed(evt);
            }
        });
        txtEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyTyped(evt);
            }
        });
        jPanel1.add(txtEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 120, -1));

        txtCambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCambio.setEnabled(false);
        txtCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCambioActionPerformed(evt);
            }
        });
        jPanel1.add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 120, -1));

        txtSubtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSubtotal.setEnabled(false);
        txtSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalActionPerformed(evt);
            }
        });
        jPanel1.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 270, 210));

        btnVenta.setBackground(new java.awt.Color(0, 255, 255));
        btnVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVenta.setText("Resgitrar venta");
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 170, 110));

        btnCalcularCambio.setBackground(new java.awt.Color(0, 255, 255));
        btnCalcularCambio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcularCambio.setText("Calcular cambio");
        btnCalcularCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularCambioActionPerformed(evt);
            }
        });
        getContentPane().add(btnCalcularCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 170, 30));

        txtCantidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidad1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 70, -1));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));
        getContentPane().add(jFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoActionPerformed

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEfectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEfectivoActionPerformed

    private void txtCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCambioActionPerformed

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotalActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        try {
            CabeceraVenta cabeceraVenta = new CabeceraVenta();
            DetalleVenta detalleVenta = new DetalleVenta();
            Ctrl_Venta venta = new Ctrl_Venta();

            String fechaActual = "";
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);

            if (!listaProductos.isEmpty()) {

                //registrar cabecera
                cabeceraVenta.setIdCabeceraventa(0);
                cabeceraVenta.setValorPagar(Double.parseDouble(txtTotal.getText()));
                cabeceraVenta.setFechaVenta(fechaActual);

                if (venta.guardar(cabeceraVenta)) {
                    JOptionPane.showMessageDialog(null, "¡Venta Registrada!");

                    // GenerarFactura
                    String[] options = {"PDF sin QR", "PDF con QR"};
                    int choice = JOptionPane.showOptionDialog(
                            null,
                            "Seleccione el tipo de PDF",
                            "Generar Factura",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);

                    VentaPDF pdf;
                    if (choice == 0) {
                        //pdf = new VentaPDF();
                        // Generar PDF sin código QR
                        PDFGenerator ventaPDF = new VentaPDF();
                        ventaPDF.generarFacturaPDF();

                    } else if (choice == 1) {
                        //pdf = new VentaPDF();
                        // Generar PDF con código QR
                        PDFGenerator ventaPDFConQR = new PDFQRDecorator(new VentaPDF());
                        ventaPDFConQR.generarFacturaPDF();
                        

                    } else {
                        // El usuario cerró el diálogo o no seleccionó ninguna opción
                        // Puedes tomar alguna acción adicional si es necesario
                        return;
                    }

                    //pdf.generarFacturaPDF();

                    // guardar detalle
                    for (DetalleVenta elemento : listaProductos) {
                        detalleVenta.setIdDetalleVenta(0);
                        detalleVenta.setIdCabeceraVenta(0);
                        detalleVenta.setIdProducto(elemento.getIdProducto());
                        detalleVenta.setCantidad(elemento.getCantidad());
                        detalleVenta.setPrecioUnitario(elemento.getPrecioUnitario());
                        detalleVenta.setSubTotal(elemento.getSubTotal());
                        detalleVenta.setDescuento(elemento.getDescuento());
                        detalleVenta.setIva(elemento.getIva());
                        detalleVenta.setTotalPagar(elemento.getTotalPagar());
                        detalleVenta.setEstado(1);

                        if (venta.guardarDetalle(detalleVenta)) {
                            //System.out.println("Detalle de Venta Registrado");

                            txtSubtotal.setText("0.0");
                            txtIva.setText("0.0");
                            txtDescuento.setText("0.0");
                            txtTotal.setText("0.0");
                            txtEfectivo.setText("");
                            txtCambio.setText("0.0");
                            auxIdDetalle = 1;

                            this.RestarStockProductos(elemento.getIdProducto(), elemento.getCantidad());

                        } else {
                            JOptionPane.showMessageDialog(null, "¡Error al guardar detalle de venta!");
                        }
                    }
                    //vaciamos la lista
                    listaProductos.clear();
                    listaTablaProductos();

                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al guardar cabecera de venta!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Seleccione un producto!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        String combo = this.jComboBoxProducto.getSelectedItem().toString();

        // Validar que seleccione un producto
        if (combo.equalsIgnoreCase("Seleccione producto:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        } else {
            // Validar que ingrese una cantidad
            if (!txtCantidad1.getText().isEmpty()) {
                // Validar que el usuario no ingrese caracteres no numéricos
                boolean validacion = validar(txtCantidad1.getText());
                if (validacion) {
                    // Validar que la cantidad sea mayor a cero
                    int cantidad = Integer.parseInt(txtCantidad1.getText());
                    if (cantidad > 0) {
                        // Ejecutar método para obtener datos del producto
                        DatosDelProducto();

                        // Buscar si el producto ya está en la lista
                        DetalleVenta productoExistente = null;
                        for (DetalleVenta producto : listaProductos) {
                            if (producto.getIdProducto() == idProducto) {
                                productoExistente = producto;
                                break;
                            }
                        }

                        // Si el producto existe en la lista, se actualiza el stock
                        if (productoExistente != null) {
                            int nuevoStock = productoExistente.getCantidad() + cantidad;

                            // Validar si hay suficiente stock
                            if (nuevoStock <= cantidadProductoBBDD) {
                                // Validar que la cantidad sea mayor a cero
                                if (nuevoStock > 0) {
                                    productoExistente.setCantidad(nuevoStock);

                                    // Actualizar precios
                                    iva = iva * nuevoStock;
                                    double subtotal = precioUnitario * nuevoStock;
                                    double totalPagar = subtotal + iva + descuento;
                                    subtotal = (double) Math.round(subtotal * 100) / 100;
                                    iva = (double) Math.round(iva * 100) / 100;
                                    descuento = (double) Math.round(descuento * 100) / 100;
                                    totalPagar = (double) Math.round(totalPagar * 100) / 100;

                                    // Actualizar precios en el producto existente
                                    productoExistente.setSubTotal(subtotal);
                                    productoExistente.setTotalPagar(totalPagar);
                                    productoExistente.setIva(iva);

                                    JOptionPane.showMessageDialog(null, "Stock actualizado");
                                } else {
                                    JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero (0) ni negativa");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "La cantidad supera el Stock disponible");
                            }
                        } else {
                            // Validar si hay suficiente stock
                            if (cantidad <= cantidadProductoBBDD) {
                                // Calcular el subtotal, total a pagar y redondear decimales
                                iva = iva * cantidad;
                                double subtotal = precioUnitario * cantidad;
                                double totalPagar = subtotal + iva + descuento;
                                subtotal = (double) Math.round(subtotal * 100) / 100;
                                iva = (double) Math.round(iva * 100) / 100;
                                descuento = (double) Math.round(descuento * 100) / 100;
                                totalPagar = (double) Math.round(totalPagar * 100) / 100;

                                // Crear un nuevo producto
                                DetalleVenta productoNuevo = new DetalleVenta(auxIdDetalle,
                                        1,
                                        idProducto,
                                        nombre,
                                        cantidad,
                                        precioUnitario,
                                        subtotal,
                                        descuento,
                                        iva,
                                        totalPagar,
                                        1
                                );

                                // Añadir a la lista
                                listaProductos.add(productoNuevo);
                                JOptionPane.showMessageDialog(null, "Producto Agregado");
                                auxIdDetalle++;
                            } else {
                                JOptionPane.showMessageDialog(null, "La cantidad supera el Stock disponible");
                            }
                        }

                        // Limpiar el campo
                        txtCantidad1.setText("");

                        // Volver a cargar combo productos
                        CargarComboProductos();
                        CalcularTotalPagar();
                        txtEfectivo.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero (0) ni negativa");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "En la cantidad no se admiten caracteres no numéricos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingresa la cantidad de productos");
            }
        }

        // Llamar al método listaTablaProductos()
        listaTablaProductos();
    }//GEN-LAST:event_btnAñadirActionPerformed

    int idArrayList = 0;
    private void jTableVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVentaMouseClicked
        int fila_point = jTableVenta.rowAtPoint(evt.getPoint());
        int columna_point = 0;
        if (fila_point > -1) {
            idArrayList = (int) modeloDatosProductos.getValueAt(fila_point, columna_point);
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Eliminar Producto?");
        //opciones de confir dialog - (si = 0; no = 1; cancel = 2; close = -1)
        switch (opcion) {
            case 0: //presione si
                listaProductos.remove(idArrayList - 1);
                this.CalcularTotalPagar();
                this.listaTablaProductos();
                break;
            case 1: //presione no
                break;
            default://sea que presione cancel (2) o close (-1)
                break;
        }
    }//GEN-LAST:event_jTableVentaMouseClicked

    private void btnCalcularCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularCambioActionPerformed
        if (!txtEfectivo.getText().isEmpty()) {
            //validamos que el usuario no ingrese otros caracteres no numericos 
            boolean validacion = validarDouble(txtEfectivo.getText());
            if (validacion == true) {
                //validar que el efectivo sea mayor a cero
                double efc = Double.parseDouble(txtEfectivo.getText().trim());
                double top = Double.parseDouble(txtTotal.getText().trim());

                if (efc < top) {
                    JOptionPane.showMessageDialog(null, "El Dinero en efectivo no es suficiente");
                } else {
                    double cambio = (efc - top);
                    double cambi = (double) Math.round(cambio * 100d) / 100;
                    String camb = String.valueOf(cambi);
                    txtCambio.setText(camb);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No de admiten caracteres no numericos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese dinero en efectivo para calcular cambio");
        }
    }//GEN-LAST:event_btnCalcularCambioActionPerformed

    private void txtCantidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidad1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String productoBuscar = txtBuscar.getText().trim();
        String sql = "SELECT nombre FROM tb_producto WHERE nombre = '" + productoBuscar + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                jComboBoxProducto.setSelectedItem(rs.getString("nombre"));
            } else {
                jComboBoxProducto.setSelectedItem("Seleccione un producto:");
                JOptionPane.showMessageDialog(null, "¡Nombre del producto incorrecto o no encontrado!");
            }
            txtBuscar.setText("");
        } catch (SQLException e) {
            System.out.println("¡Error al buscar producto!, " + e);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtEfectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.' && !Character.isISOControl(c)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Solo se permiten valores numericos", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtEfectivoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcularCambio;
    private javax.swing.JButton btnVenta;
    private javax.swing.JComboBox<String> jComboBoxProducto;
    private javax.swing.JLabel jFondo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableVenta;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtCantidad1;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtEfectivo;
    public static javax.swing.JTextField txtIva;
    public static javax.swing.JTextField txtSubtotal;
    public static javax.swing.JTextField txtTotal;
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
            System.out.println("¡Error al cargar productos, !" + e);
        }
    }

    /*
        Metodo para validar que el usuario no ingrese caracteres no numericos
     */
    private boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
        Metodo para validar que el usuario no ingrese caracteres no numericos
     */
    private boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
        Metodo para mostrar los datos del producto seleccionado
     */
    private void DatosDelProducto() {
        try {
            String sql = "select * from tb_producto where nombre = '" + this.jComboBoxProducto.getSelectedItem() + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idProducto = rs.getInt("idProducto");
                nombre = rs.getString("nombre");
                cantidadProductoBBDD = rs.getInt("cantidad");
                precioUnitario = rs.getDouble("precio");
                porcentajeIva = rs.getInt("porcentajeIva");
                this.CalcularIva(precioUnitario, porcentajeIva);//calcula y retorna el iva
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto, " + e);
        }
    }

    private double CalcularIva(double precio, int porcentajeIva) {
        int p_iva = porcentajeIva;

        switch (p_iva) {
            case 0 ->
                iva = 0.0;
            case 16 ->
                iva = precio * 0.16;
            default -> {
            }
        }

        return iva;
    }

    /*
    Metodo para calcular el total a pagar de todos los productos agregados
     */
    private void CalcularTotalPagar() {
        subtotalGeneral = 0;
        descuentoGeneral = 0;
        ivaGeneral = 0;
        totalPagarGeneral = 0;

        for (DetalleVenta elemento : listaProductos) {
            subtotalGeneral += elemento.getSubTotal();
            descuentoGeneral += elemento.getDescuento();
            ivaGeneral += elemento.getIva();
            totalPagarGeneral += elemento.getTotalPagar();
        }
        //redondear decimales
        subtotalGeneral = (double) Math.round(subtotalGeneral * 100) / 100;
        ivaGeneral = (double) Math.round(ivaGeneral * 100) / 100;
        descuentoGeneral = (double) Math.round(descuentoGeneral * 100) / 100;
        totalPagarGeneral = (double) Math.round(totalPagarGeneral * 100) / 100;

        //enviar datos a la vista
        txtSubtotal.setText(String.valueOf(subtotalGeneral));
        txtIva.setText(String.valueOf(ivaGeneral));
        txtDescuento.setText(String.valueOf(descuentoGeneral));
        txtTotal.setText(String.valueOf(totalPagarGeneral));
    }

    private void RestarStockProductos(int idProducto, int cantidad) {
        int cantidadProductosBaseDeDatos = 0;
        try {
            String sql = "select idProducto, cantidad from tb_producto where idProducto = '" + idProducto + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cantidadProductosBaseDeDatos = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 1, " + e);
        }

        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_producto set cantidad=? where idProducto = '" + idProducto + "'");
            int cantidadNueva = cantidadProductosBaseDeDatos - cantidad;
            consulta.setInt(1, cantidadNueva);
            if (consulta.executeUpdate() > 0) {
                //System.out.println("Todo bien");
            }
        } catch (SQLException e) {
            System.out.println("Error al restar cantidad 2, " + e);
        }
    }

}
