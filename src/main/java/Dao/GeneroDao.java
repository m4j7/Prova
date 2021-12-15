package Dao;

import Factory.ConectionFactory;
import Model.Biblioteca;
import Model.Genero;
import Model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneroDao {

    private Connection connection;

    public GeneroDao() {
        this.connection = new ConectionFactory().getConnection();
    }

    public void criaTabela(){

        String sql = "CREATE TABLE IF NOT EXISTS generos ("+
                "idGenero INT PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(50) NOT NULL" +
                ");";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela genero criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void gravaNoBanco(Genero genero){

        String sql = "INSERT INTO generos" +
                " (nome) " +
                "VALUES (?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, genero.getNomeDoGenero());

            stmt.execute();

            ResultSet resultSet = stmt.getGeneratedKeys();

            while (resultSet.next()) {
                genero.setIdDoGenero(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Genero SelecionaId (int id){

        String sql = "SELECT * FROM generos WHERE idGenero = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Genero genero = new Genero();
                genero.setIdDoGenero(resultSet.getInt("idGenero"));
                genero.setNomeDoGenero(resultSet.getString("nome"));

                return genero;
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return null;
    }

    public void editarGeneroDoBanco(Genero genero){
        String sql = "UPDATE generos SET nome = ? WHERE idGenero = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, genero.getNomeDoGenero());
            stmt.setInt(2, genero.getIdDoGenero());

            stmt.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
