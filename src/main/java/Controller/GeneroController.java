package Controller;

import Dao.BibliotecaDao;
import Dao.GeneroDao;
import Model.Biblioteca;
import Model.Genero;

public class GeneroController {

    public static void criaTabela(){

        GeneroDao gd = new GeneroDao();
        gd.criaTabela();

    }
    public static void cadastraGenero(Genero genero){

        GeneroDao gb = new GeneroDao();
        gb.gravaNoBanco(genero);
    }

    public Genero seleionaById(int id){

        GeneroDao gd = new GeneroDao();
        return gd.SelecionaId(id);
    }

    public void editarGenero(Genero gen){
        GeneroDao gd = new GeneroDao();
        gd.editarGeneroDoBanco(gen);
    }




}
