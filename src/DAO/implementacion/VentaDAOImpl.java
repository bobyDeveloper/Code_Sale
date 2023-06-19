/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.implementacion;

import DAO.abstracto.VentaDAO;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.CabeceraVenta;
import modelo.DetalleVenta;

/**
 *
 * @author Ville
 */
public class VentaDAOImpl implements VentaDAO {

    private Connection cn = null;

    public VentaDAOImpl() throws SQLException {
        cn = Conexion.getInstancia().getConexion();
    }

    //ultimo id de la cabecera
    public static int idCabeceraRegistrada;
    java.math.BigDecimal iDColVar;

    @Override
    public boolean guardar(CabeceraVenta objeto) {
        boolean respuesta = false;
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_cabecera_venta values(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, 0);//id
            consulta.setDouble(2, objeto.getValorPagar());
            consulta.setString(3, objeto.getFechaVenta());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            ResultSet rs = consulta.getGeneratedKeys();
            while (rs.next()) {
                iDColVar = rs.getBigDecimal(1);
                idCabeceraRegistrada = iDColVar.intValue();
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar cabecera de venta: " + e);
        }
        return respuesta;
    }

    @Override
    public boolean guardarDetalle(DetalleVenta objeto) {
        boolean respuesta = false;
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_detalle_venta values(?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setInt(2, idCabeceraRegistrada);
            consulta.setInt(3, objeto.getIdProducto());
            consulta.setInt(4, objeto.getCantidad());
            consulta.setDouble(5, objeto.getPrecioUnitario());
            consulta.setDouble(6, objeto.getSubTotal());
            consulta.setDouble(7, objeto.getDescuento());
            consulta.setDouble(8, objeto.getIva());
            consulta.setDouble(9, objeto.getTotalPagar());
            consulta.setInt(10, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar detalle de venta: " + e);
        }
        return respuesta;
    }

   
}
