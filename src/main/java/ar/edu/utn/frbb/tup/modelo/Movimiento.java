package ar.edu.utn.frbb.tup.modelo;

import java.time.LocalDate;

public class Movimiento {
    private static long idcounter = 0;
    private long id;
    private double monto;
    private String descripcion;
    private LocalDate fecha;
    private int idcuenta;
    private TipoMovimiento tipo;

    public Movimiento(double monto, String descripcion, int idcuenta, TipoMovimiento tipo) {
        this.id = ++idcounter;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = LocalDate.now();
        this.idcuenta = idcuenta;
        this.tipo = tipo;
    }

    public static long getIdcounter() {
        return idcounter;
    }

    public long getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "id=" + id +
                ", Monto=" + monto +
                ", Descripcion='" + descripcion + '\'' +
                ", Fecha=" + fecha +
                ", Id de cuenta=" + idcuenta +
                ", Tipo=" + tipo +
                '}';
    }
}
