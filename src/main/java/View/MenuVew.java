package View;

import java.util.Scanner;

public class MenuVew {

    public void Menu(){


        Scanner leitor = new Scanner(System.in).useDelimiter("\n");
        LivroView lv = new LivroView();
        GeneroView gv = new GeneroView();
        BibliotecaView bv = new BibliotecaView();

        System.out.println("Escolha uma opção:");

        System.out.println("  1 - Cadastrar biblioteca            ");
        System.out.println("  2 - Cadastrar genero                ");
        System.out.println("  3 - Editar genero                   ");
        System.out.println("  4 - Cadastrar livro                 ");
        System.out.println("  5 - Encontrar livro pelo id         ");
        System.out.println("  6 - Lista de livros por biblioteca  ");
        System.out.println("  7 - Lista de livros por genero      ");


        switch (leitor.nextInt()) {
            case 1:
                bv.criaTabela();
                bv.cadastraBiblioteca();
                this.Menu();
                break;
            case 2:
                gv.criaTabela();
                gv.cadastraGenero();
                this.Menu();
                break;
            case 3:
                gv.editarGenero(gv.retornaById());
                this.Menu();
                break;
            case 4:
                lv.cadastraLivro();
                this.Menu();
                break;
            case 5:
                lv.retornaId();
                this.Menu();
                break;
            case 6 :
                lv.retornaIdBiblioteca();
                this.Menu();
                break;
            case 7:
                lv.retornaIdGenero();;
                this.Menu();
                break;
            default:
                System.out.println("Opção invalida");
        }

    }

}
