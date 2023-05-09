/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.implementacion;

import DAO.abstracto.CategoriaDAO;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Categoria;

/**
 *
 * @author Ville
 */
public class CategoriaDAOImpl implements CategoriaDAO {

    private Connection cn = null;

    public CategoriaDAOImpl() throws SQLException {
        cn = Conexion.getInstancia().getConexion();
    }

    @Override
    public boolean guardar(Categoria objeto) {
        boolean respuesta = false;
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_categoria values(?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar cartegoria: " + e);
        }

        return respuesta;
    }

    @Override
    public boolean existeCategoria(String categoria) {
        boolean respuesta = false;
        String sql = "select descripcion from tb_categoria where descripcion = '" + categoria + "';";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar cartegoria: " + e);
        }
        return respuesta;
    }

    @Override
    public boolean actualizar(Categoria objeto, int idCategoria) {
        boolean respuesta = false;
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_categoria set descripcion=? where idCategoria ='" + idCategoria + "'");
            consulta.setString(1, objeto.getDescripcion());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar cartegoria: " + e);
        }

        return respuesta;

    }

    @Override
    public boolean eliminar(int idCategoria) {
        boolean respuesta = false;
        try {

            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_categoria where idCategoria ='" + idCategoria + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar cartegoria: " + e);
        }

        return respuesta;

    }

}
