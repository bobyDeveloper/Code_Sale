/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.abstracto;

import modelo.Usuario;

/**
 *
 * @author BobyDev
 */
public interface UsuarioDAO {

    public boolean guardar(Usuario objeto);

    public boolean existeUsuario(String usuario);

    public boolean loginUser(Usuario objeto);

    public boolean actualizar(Usuario objeto, int idUsuario);

    public boolean eliminar(int idUsuario);

}
