package ar.edu.utn.frbb.tup.banco;

public class Cuenta {
    private String nombre;
    private long cbu;
    private long saldo;

    public Cuenta(String nombre, long cbu, long saldo){
        this.nombre=nombre;
        this.cbu=cbu;
        this.saldo=saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCbu() {
        return cbu;
    }

    public void setCbu(long cbu) {
        this.cbu = cbu;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }
}
