package View;

import Controller.LivroController;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class LivroView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
    GeneroView gv = new GeneroView();
    BibliotecaView bv = new BibliotecaView();

    public void criaTabela() {

       LivroController lc = new LivroController ();
       lc.criatabela();

    }

    public void cadastraLivro() {


        System.out.println("Digite o nome do livro que deseja cadastrar");
        String nome = leitor.next();

        Genero genero = gv.retornaById();
        Biblioteca biblioteca = bv.retornaById();


        Livro livro = new Livro(genero, biblioteca, nome);

        LivroController lv = new LivroController ();
        lv.cadastraLivro(livro);

    }

    public List<Livro> retornaIdBiblioteca() {

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        List<Livro> list = new ArrayList<>();
        Livro livro = new Livro();

        LivroController lc = new LivroController();

        System.out.println("Qual a biblioteca você deseja visualizar:");
        list = lc.seleionaByIdBiblioteca(entrada.nextInt());

        System.out.println("A biblioteca selecionada foi:");

        System.out.println(list);

        return list;
    }

    public List<Livro> retornaIdGenero() {

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        List<Livro> list = new ArrayList<>();
        Livro livro = new Livro();

        LivroController lc = new LivroController();

        System.out.println("Qual o genero você deseja visualizar:");
        list = lc.seleionaByIdGenero(entrada.nextInt());

        System.out.println("o genero selecionada foi:");

        System.out.println(list);

        return list;
    }

}
