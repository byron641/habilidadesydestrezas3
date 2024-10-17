/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.habilidadesydestrezas3.Controller;

import com.example.habilidadesydestrezas3.Model.Reserva;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.DefaultListModel;

public class ReservaController {
    private Stack<Reserva> reservasConfirmadas;
    private Queue<Reserva> reservasEnEspera;
    private DefaultListModel<String> modeloConfirmadas;
    private DefaultListModel<String> modeloEspera;

    public ReservaController(DefaultListModel<String> modeloConfirmadas, DefaultListModel<String> modeloEspera) {
        this.reservasConfirmadas = new Stack<>();
        this.reservasEnEspera = new LinkedList<>();
        this.modeloConfirmadas = modeloConfirmadas;
        this.modeloEspera = modeloEspera;
    }

    public void agregarReserva(Reserva reserva) {
        if (reservasConfirmadas.size() < 5) {  // Limitar el número de reservas confirmadas
            reservasConfirmadas.push(reserva);
            modeloConfirmadas.addElement(reserva.getCliente() + " - " + reserva.getFecha() + " - " + reserva.getAsientos());
        } else {
            reservasEnEspera.add(reserva);
            modeloEspera.addElement(reserva.getCliente() + " - " + reserva.getFecha() + " - " + reserva.getAsientos());
        }
    }

    public void eliminarReservaConfirmada(int index) {
        if (index >= 0 && index < reservasConfirmadas.size()) {
            reservasConfirmadas.remove(index);
            modeloConfirmadas.remove(index);
            if (!reservasEnEspera.isEmpty()) {
                Reserva reserva = reservasEnEspera.poll();
                reservasConfirmadas.push(reserva);
                modeloEspera.remove(0);
                modeloConfirmadas.addElement(reserva.getCliente() + " - " + reserva.getFecha() + " - " + reserva.getAsientos());
            }
        }
    }

    public void eliminarReservaEspera(int index) {
        if (index >= 0 && index < reservasEnEspera.size()) {
            reservasEnEspera.remove();
            modeloEspera.remove(index);
        }
    }
}
