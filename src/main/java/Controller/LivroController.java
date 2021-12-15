package Controller;

import Dao.LivroDao;
import Model.Livro;

import java.util.List;

public class LivroController {

    public void criatabela(){

        LivroDao ld = new LivroDao();
        ld.criaTabela();

    }

    public void cadastraLivro(Livro livro){

        LivroDao ld = new LivroDao();
        ld.gravaNoBanco(livro);

    }

    public List<Livro> seleionaByIdGenero(int id){
        LivroDao ld = new LivroDao();
        return ld.SelecionaTipoGenero(id);
    }

    public List<Livro> seleionaByIdBiblioteca(int id){
        LivroDao ld = new LivroDao();
        return ld.SelecionaTipoBiblioteca(id);
    }




}
