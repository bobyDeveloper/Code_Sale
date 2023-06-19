/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Ville
 */
public class CabeceraVenta {

    //Atributos
    private int idCabeceraventa;
    private double valorPagar;
    private String fechaVenta;

    //constructor
    public CabeceraVenta() {
        this.idCabeceraventa = 0;
        this.valorPagar = 0.0;
        this.fechaVenta = "";
    }

    //constructor sobrecargado
    public CabeceraVenta(int idCabeceraventa, double valorPagar, String fechaVenta) {
        this.idCabeceraventa = idCabeceraventa;
        this.valorPagar = valorPagar;
        this.fechaVenta = fechaVenta;
    }

    //get and set 
    public int getIdCabeceraventa() {
        return idCabeceraventa;
    }

    public void setIdCabeceraventa(int idCabeceraventa) {
        this.idCabeceraventa = idCabeceraventa;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    

    //toString 
    @Override
    public String toString() {
        return "CabeceraVenta{" + "idCabeceraventa=" + idCabeceraventa +  ", valorPagar=" + valorPagar + ", fechaVenta=" + fechaVenta +  '}';
    }

}
