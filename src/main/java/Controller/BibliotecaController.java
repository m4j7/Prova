package Controller;

import Dao.BibliotecaDao;
import Dao.GeneroDao;
import Model.Biblioteca;
import Model.Genero;

public class BibliotecaController {

    public static void criaTabela(){

        BibliotecaDao bd = new BibliotecaDao();
        bd.criaTabela();

    }

    public static void cadastraBiblioteca(Biblioteca biblioteca){
        BibliotecaDao bd = new BibliotecaDao();
        bd.gravaNoBanco(biblioteca);
    }

    public Biblioteca seleionaById(int id){

        BibliotecaDao bd = new BibliotecaDao();
        return bd.SelecionaId(id);
    }



}
