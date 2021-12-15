package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {

    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/tbprova", "MariaJulia", "M99905406");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

// 4.1 CADASTRAR BIBLIOTECA; Ok
//
//4.2 CADASTRAR GÊNERO;Ok
//
//4.3 EDITAR GÊNERO;OK
//
//4.4 CADASTRAR LIVRO;
//
//4.5 ENCONTRAR LIVRO PELO SEU ID;
//
//4.6 LISTAR TODOS OS LIVROS DE 1 BIBLIOTECA ESPECÍFICA; livro recebe uma biblioteca
//
//4.7 LISTAR TODOS OS LIVROS DE DETERMINADO GÊNERO. um livro recebe um genero
