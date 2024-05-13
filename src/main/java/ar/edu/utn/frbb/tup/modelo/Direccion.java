package ar.edu.utn.frbb.tup.modelo;

public class Direccion
{
    private String calle;
    private int numero;
    private String ciudad;
    private String provincia;
    private int codigoPostal;


    public Direccion(String calle, int numero, String ciudad, String provincia, int codigoPostal) {
        this.calle = calle;
        this.numero = Integer.parseInt(String.valueOf(numero));
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.codigoPostal = Integer.parseInt(String.valueOf(codigoPostal));
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
