package Dao;

import Factory.ConectionFactory;
import Model.Biblioteca;
import Model.Genero;

import java.sql.*;

public class BibliotecaDao {

        private Connection connection;

        public BibliotecaDao() {
            this.connection = new ConectionFactory().getConnection();
        }

        public void criaTabela(){

            String sql = "CREATE TABLE IF NOT EXISTS bibliotecas ("+
                    "idBiblioteca INT PRIMARY KEY AUTO_INCREMENT," +
                    "nome VARCHAR(50) NOT NULL" +
                    ");";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.execute();
                stmt.close();

                System.out.println("Tabela biblioteca criada com sucesso!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        public void gravaNoBanco(Biblioteca biblioteca){

            String sql = "INSERT INTO bibliotecas" +
                    " (nome) " +
                    "VALUES (?)";

            try {
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                stmt.setString(1, biblioteca.getNomeDaBiblioteca());

                stmt.execute();

                ResultSet resultSet = stmt.getGeneratedKeys();

                while (resultSet.next()) {
                    biblioteca.setIdDaBiblioteca(resultSet.getInt(1));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    public Biblioteca SelecionaId (int id){

        String sql = "SELECT * FROM bibliotecas WHERE  idBiblioteca = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setIdDaBiblioteca(resultSet.getInt("idBiblioteca"));
                biblioteca.setNomeDaBiblioteca(resultSet.getString("nome"));

                return biblioteca;
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return null;
    }


}
