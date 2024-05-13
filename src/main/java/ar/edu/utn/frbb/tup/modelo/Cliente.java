package ar.edu.utn.frbb.tup.modelo;

import java.time.LocalDate;
import java.util.Set;

public class Cliente extends Persona{
    private LocalDate fechaAlta;
    private Set<Cuenta> cuenta;
    private Segmento segmento;

    public Cliente(String nombre, String apellido, int dni, int telefono, String correo, Direccion direccion) {
        super(nombre, apellido, dni, telefono, correo, direccion);
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Set<Cuenta> getCuenta() {
        return cuenta;
    }

    public void setCuenta(Set<Cuenta> cuenta) {
        this.cuenta = cuenta;
    }

    public Segmento getSegmento() {
        return segmento;
    }

    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }
}
