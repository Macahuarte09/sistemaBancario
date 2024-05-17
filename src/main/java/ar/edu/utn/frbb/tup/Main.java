package ar.edu.utn.frbb.tup;
import ar.edu.utn.frbb.tup.Input.MenuInputProcessor;
import ar.edu.utn.frbb.tup.Model.Banco;
import ar.edu.utn.frbb.tup.Model.Cuenta;
import ar.edu.utn.frbb.tup.Model.Cliente;

import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        Banco banco = new Banco();

        MenuInputProcessor menuInputProcessor = new MenuInputProcessor();
        menuInputProcessor.renderMenu(banco);
    }
}