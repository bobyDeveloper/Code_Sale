/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.abstracto;

import modelo.Categoria;

/**
 *
 * @author Ville
 */
public interface CategoriaDAO {

    public boolean guardar(Categoria objeto);

    public boolean existeCategoria(String categoria);

    public boolean actualizar(Categoria objeto, int idCategoria);

    public boolean eliminar(int idCategoria);
    
    public boolean tieneProductos(int idCategoria);

}
