package View;

import Controller.BibliotecaController;
import Controller.GeneroController;
import Model.Biblioteca;
import Model.Genero;

import java.util.Locale;
import java.util.Scanner;

public class GeneroView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

    public void criaTabela() {

        GeneroController gc = new  GeneroController();
        gc.criaTabela();
    }

    public void cadastraGenero() {

        System.out.println("Cadastre o nome do genero: ");
        String nome = leitor.next();

        Genero genero = new Genero(nome);

        GeneroController generoController = new GeneroController();
        GeneroController.cadastraGenero(genero);
    }

    public Genero retornaById(){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        Genero gen = new Genero();
        GeneroController gc = new GeneroController();

        System.out.println("Qual o genero que voce deseja acessar:");

        gen = gc.seleionaById(entrada.nextInt());

        System.out.println("O genero selecionado foi:");
        System.out.println(gen);

        return gen;
    }


    public void editarGenero(Genero gen){

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        GeneroController pc = new GeneroController();

        System.out.println("Digite o novo nome do seu genero");

        gen.setNomeDoGenero(entrada.next());
        pc.editarGenero(gen);

        System.out.println("Genero Editado!");
        System.out.println("Deseja renomear novamente ?");
        System.out.println("1-Sim;2-Não;");

        switch (entrada.nextInt()){
            case 1:
                this.editarGenero(gen);
                break;
            case 2:
                System.out.println("Retornando ao Menu");
                break;
            default:
                System.out.println("Opção invalida");
        }
    }




}
