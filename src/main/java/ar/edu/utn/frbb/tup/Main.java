package ar.edu.utn.frbb.tup;
import ar.edu.utn.frbb.tup.presentation.input.MenuInputProcessor;
import ar.edu.utn.frbb.tup.model.Banco;

public class Main {

    public static void main(String args[]) {
        Banco banco = new Banco();

        MenuInputProcessor menuInputProcessor = new MenuInputProcessor();
        menuInputProcessor.renderMenu(banco);
    }
}