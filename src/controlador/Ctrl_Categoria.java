/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.abstracto.CategoriaDAO;
import DAO.implementacion.CategoriaDAOImpl;
import java.sql.SQLException;
import modelo.Categoria;

/**
 *
 * @author Ville
 */
public class Ctrl_Categoria {

    private static Ctrl_Categoria instancia;
    private final CategoriaDAO categoriaDAO;

    public Ctrl_Categoria() throws SQLException {
        categoriaDAO = new CategoriaDAOImpl();
    }

    public static Ctrl_Categoria getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new Ctrl_Categoria();
        }
        return instancia;
    }

    public boolean guardar(Categoria objeto) {
        return categoriaDAO.guardar(objeto);
    }

    public boolean existeCategoria(String categoria) {
        return categoriaDAO.existeCategoria(categoria);
    }

    public boolean actualizar(Categoria objeto, int idCategoria) {
        return categoriaDAO.actualizar(objeto, idCategoria);
    }

    public boolean eliminar(int idCategoria) {
        return categoriaDAO.eliminar(idCategoria);
    }

    public boolean tieneProductos(int idCategoria) {
        return categoriaDAO.tieneProductos(idCategoria);

    }

}
