package ar.edu.utn.frbb.tup.usuario;

import ar.edu.utn.frbb.tup.banco.Cuenta;

import java.util.ArrayList;

public class Cliente extends Persona{
    //private int id;

    private long telefono;
    private ArrayList<Cuenta> cuentas;

    public Cliente(String nombre, String apellido, int dni, long telefono){
        super(nombre,apellido,dni);
        this.telefono=telefono;
        this.cuentas = new ArrayList<>();
    }

    public long getTelefono(){
        return telefono;
    }

    public void setTelefono(long telefono){
        this.telefono=telefono;
    }
    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
}
