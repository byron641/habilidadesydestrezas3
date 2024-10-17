/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.habilidadesydestrezas3.Model;

public class Reserva {
    private String cliente;
    private String fecha;
    private int asientos;

    public Reserva(String cliente, String fecha, int asientos) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.asientos = asientos;
    }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public int getAsientos() { return asientos; }
    public void setAsientos(int asientos) { this.asientos = asientos; }
}
