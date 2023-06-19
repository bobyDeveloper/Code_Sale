/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.implementacion.UsuarioDAOImpl;
import DAO.abstracto.UsuarioDAO;
import java.sql.SQLException;
import modelo.Usuario;

/**
 *
 * @author BobyDev
 */
public class Ctrl_Usuario {

    private static Ctrl_Usuario instancia;
    private final UsuarioDAO usuarioDAO;

    public Ctrl_Usuario() throws SQLException {
        usuarioDAO = new UsuarioDAOImpl();
    }

    public static Ctrl_Usuario getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new Ctrl_Usuario();
        }
        return instancia;
    }

    public boolean guardar(Usuario objUsuario) {
        return usuarioDAO.guardar(objUsuario);
    }

    public boolean existeUsuario(String usuario) {
        return usuarioDAO.existeUsuario(usuario);
    }

    public boolean loginUser(Usuario objUsuario) {
        return usuarioDAO.loginUser(objUsuario);
    }

    public boolean actualizar(Usuario usuario, int idUsuario) {
        return usuarioDAO.actualizar(usuario, idUsuario);
    }

    public boolean eliminar(int idUsuario) {
        return usuarioDAO.eliminar(idUsuario);
    }

}
