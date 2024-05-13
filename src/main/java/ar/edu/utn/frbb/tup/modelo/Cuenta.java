package ar.edu.utn.frbb.tup.modelo;

import java.time.LocalDate;

public class Cuenta {
    private static int generadorId = 0;  // Variable estática para generar números de cuenta únicos
    private int id;
    private TipoCuenta tipo;
    private double saldo;
    private LocalDate fechaApertura;
    private Cliente cliente;

    public Cuenta(TipoCuenta tipo, double saldo, LocalDate fechaApertura, Cliente cliente) {
        this.id = ++generadorId;
        this.tipo = tipo;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public TipoCuenta getTipo() {
        return tipo;
    }

    public void setTipo(TipoCuenta tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void depositar(double monto) {
        this.saldo += monto;
    }

    public void retirar(double monto) {
        if (this.saldo - monto < 0) {
            System.out.println("Saldo insuficiente");
        } else {
            this.saldo -= monto;
            System.out.println("Se retiraron: $" + monto);
        }
    }
}