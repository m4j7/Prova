package View;

import Controller.BibliotecaController;
import Controller.GeneroController;
import Model.Biblioteca;
import Model.Genero;

import java.util.Locale;
import java.util.Scanner;

public class BibliotecaView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

    public void criaTabela() {

        BibliotecaController bc = new BibliotecaController ();
        bc.criaTabela();
    }

    public void cadastraBiblioteca() {

        System.out.println("Cadastre o nome da sua biblioteca: ");
        String nome = leitor.next();

        Biblioteca biblioteca = new Biblioteca(nome);

        BibliotecaController bibliotecaController = new BibliotecaController();
        BibliotecaController.cadastraBiblioteca(biblioteca);
    }

    public Biblioteca retornaById(){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        Biblioteca biblioteca = new Biblioteca();
        BibliotecaController bc = new BibliotecaController();

        System.out.println("Qual o biblioteca que voce deseja acessar:");

        biblioteca = bc.seleionaById(entrada.nextInt());

        System.out.println("O biblioteca selecionado foi:");
        System.out.println(biblioteca);

        return biblioteca;
    }
}
