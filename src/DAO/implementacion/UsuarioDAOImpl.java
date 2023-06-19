/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.implementacion;

import DAO.abstracto.UsuarioDAO;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author BobyDev
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    private Connection cn = null;

    public UsuarioDAOImpl() throws SQLException {
        cn = Conexion.getInstancia().getConexion();
    }

    @Override
    public boolean guardar(Usuario objeto) {
        boolean respuesta = false;
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_usuario values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellidoPaterno());
            consulta.setString(4, objeto.getApellidoMaterno());
            consulta.setString(5, objeto.getUsuario());
            consulta.setString(6, objeto.getPassword());
            consulta.setString(7, objeto.getTelefono());
            consulta.setInt(8, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e);
        }
        return respuesta;
    }

    @Override
    public boolean existeUsuario(String usuario) {
        boolean respuesta = false;
        String sql = "select usuario from tb_usuario where usuario = '" + usuario + "';";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e);
        }
        return respuesta;
    }

    @Override
    public boolean loginUser(Usuario objeto) {
        boolean respuesta = false;
        String sql = "SELECT usuario, password FROM tb_usuario WHERE BINARY usuario = ? AND BINARY password = ?";
        try {
            PreparedStatement statement = cn.prepareStatement(sql);
            statement.setString(1, objeto.getUsuario());
            statement.setString(2, objeto.getPassword());

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al Iniciar Sesión");
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesión");
        }
        return respuesta;
    }

    @Override
    public boolean actualizar(Usuario objeto, int idUsuario) {
        boolean respuesta = false;
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_usuario set nombre=?, apellidoPaterno = ?, apellidoMaterno = ?, usuario = ?, password= ?, telefono = ?, estado = ? where idUsuario ='" + idUsuario + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellidoPaterno());
            consulta.setString(3, objeto.getApellidoMaterno());
            consulta.setString(4, objeto.getUsuario());
            consulta.setString(5, objeto.getPassword());
            consulta.setString(6, objeto.getTelefono());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            //no cerrar conexion
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e);
        }
        return respuesta;
    }

    @Override
    public boolean eliminar(int idUsuario) {
        boolean respuesta = false;
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_usuario where idUsuario ='" + idUsuario + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e);
        }
        return respuesta;
    }

    

}
