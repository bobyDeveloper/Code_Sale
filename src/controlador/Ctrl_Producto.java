/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.abstracto.ProductoDAO;
import DAO.implementacion.ProductoDAOImpl;
import java.sql.SQLException;
import modelo.Producto;

/**
 *
 * @author Ville
 */
public class Ctrl_Producto {

    private static Ctrl_Usuario instancia;
    private final ProductoDAO productoDAO;

    public Ctrl_Producto() throws SQLException {
        productoDAO = new ProductoDAOImpl();
    }

    public static Ctrl_Usuario getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new Ctrl_Usuario();
        }
        return instancia;
    }

    public boolean guardar(Producto objeto) {
        return productoDAO.guardar(objeto);
    }

    public boolean existeProducto(String producto) {
        return productoDAO.existeProducto(producto);
    }

    public boolean actualizar(Producto objeto, int idProducto) {
        return productoDAO.actualizar(objeto, idProducto);
    }

    public boolean eliminar(int idProducto) {
        return productoDAO.eliminar(idProducto);
    }

    public boolean actualizarStock(Producto object, int idProducto) {
        return productoDAO.actualizarStock(object, idProducto);
    }

}
