/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.abstracto.VentaDAO;
import DAO.implementacion.VentaDAOImpl;
import java.sql.SQLException;
import modelo.CabeceraVenta;
import modelo.DetalleVenta;

/**
 *
 * @author Ville
 */
public class Ctrl_Venta {

    private static Ctrl_Venta instancia;
    private final VentaDAO ventaDAO;

    public Ctrl_Venta() throws SQLException {
        ventaDAO = new VentaDAOImpl();
    }
    
    public static Ctrl_Venta getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new Ctrl_Venta();
        }
        return instancia;
    }
    
    
    public boolean guardar(CabeceraVenta objeto){
        return ventaDAO.guardar(objeto);
    }
    
    public boolean guardarDetalle(DetalleVenta objeto){
        return ventaDAO.guardarDetalle(objeto);
    }
    

}
