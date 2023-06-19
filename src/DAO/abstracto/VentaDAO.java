/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.abstracto;

import modelo.CabeceraVenta;
import modelo.DetalleVenta;

/**
 *
 * @author Ville
 */
public interface VentaDAO {

    public boolean guardar(CabeceraVenta objeto);

    public boolean guardarDetalle(DetalleVenta objeto);

}
