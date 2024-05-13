package ar.edu.utn.frbb.tup.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cuentas {
    private List<Cuenta> cuentas = new ArrayList<>();

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuenta(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

}
