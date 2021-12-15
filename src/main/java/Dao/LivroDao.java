package Dao;

import Factory.ConectionFactory;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDao {

    private Connection connection;

    public LivroDao() {
        this.connection = new ConectionFactory().getConnection();
    }

    public void criaTabela() {


        String sql = "CREATE TABLE IF NOT EXISTS livros (" +
                "idLivro INT PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(50) NOT NULL," +
                "idGeneroFK INT," +
                "idBibliotecaFK INT," +
                "FOREIGN KEY (idGeneroFK) REFERENCES generos(idGenero)," +
                "FOREIGN KEY (idBibliotecaFK) REFERENCES bibliotecas(idBiblioteca)" +
                ");";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela livros criada com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void gravaNoBanco(Livro livro) {

        String sql = "INSERT INTO livros" +
                " (nome,idGeneroFK,idBibliotecaFK ) " +
                "VALUES (?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, livro.getNomeDoLivro());
            stmt.setInt(2, livro.getGeneroDoLivro().getIdDoGenero());
            stmt.setInt(3, livro.getBibliotecaDoLivro().getIdDaBiblioteca());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                livro.setIdDoLivro(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> SelecionaTipoGenero(int id) {

        String sql = "SELECT * FROM livros WHERE idGeneroFK = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            List<Livro> list = new ArrayList<>();

            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setIdDoLivro(resultSet.getInt("idLivro"));
                livro.setNomeDoLivro(resultSet.getString("nome"));

                GeneroDao gd = new GeneroDao();
                Genero genero = new Genero();
                genero = gd.SelecionaId(resultSet.getInt("idGeneroFK"));
                livro.setGeneroDoLivro(genero);

                BibliotecaDao bd = new BibliotecaDao();
                Biblioteca biblioteca = new Biblioteca();
                biblioteca = bd.SelecionaId(resultSet.getInt("idBibliotecaFK"));
                livro.setBibliotecaDoLivro(biblioteca);

                list.add(livro);
            }

            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


        public List<Livro> SelecionaTipoBiblioteca ( int id){

            String sql = "SELECT * FROM livros WHERE idBibliotecaFK = ?";

            try {

                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, id);

                ResultSet resultSet = stmt.executeQuery();

                List<Livro> list = new ArrayList<>();

                while (resultSet.next()) {
                    Livro livro = new Livro();
                    livro.setIdDoLivro(resultSet.getInt("idLivro"));
                    livro.setNomeDoLivro(resultSet.getString("nome"));

                    BibliotecaDao bd = new BibliotecaDao();
                    Biblioteca biblioteca = new Biblioteca();
                    biblioteca = bd.SelecionaId(resultSet.getInt("idBibliotecaFK"));
                    livro.setBibliotecaDoLivro(biblioteca);

                    GeneroDao gd = new GeneroDao();
                    Genero genero = new Genero();
                    genero = gd.SelecionaId(resultSet.getInt("idGeneroFK"));
                    livro.setGeneroDoLivro(genero);

                    list.add(livro);
                }

                return list;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    public List<Livro> SelecionaTipo ( int id){

        String sql = "SELECT * FROM livros WHERE idLivro = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            List<Livro> list = new ArrayList<>();

            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setIdDoLivro(resultSet.getInt("idLivro"));
                livro.setNomeDoLivro(resultSet.getString("nome"));

                BibliotecaDao bd = new BibliotecaDao();
                Biblioteca biblioteca = new Biblioteca();
                biblioteca = bd.SelecionaId(resultSet.getInt("idBibliotecaFK"));
                livro.setBibliotecaDoLivro(biblioteca);

                GeneroDao gd = new GeneroDao();
                Genero genero = new Genero();
                genero = gd.SelecionaId(resultSet.getInt("idGeneroFK"));
                livro.setGeneroDoLivro(genero);

                list.add(livro);

            }

            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




    }

