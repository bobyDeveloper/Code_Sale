/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.abstracto;

import modelo.Producto;

/**
 *
 * @author Ville
 */
public interface ProductoDAO {

    public boolean guardar(Producto objeto);

    public boolean existeProducto(String producto);

    public boolean actualizar(Producto objeto, int idProducto);

    public boolean eliminar(int idProducto);

    public boolean actualizarStock(Producto object, int idProducto);
}
