package config;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {
    private static final String LINK = "jdbc:mysql://localhost/locadora_digital";
    private static final String USUARIO = "mysql";
    private static final String SENHA = "3024";
   
    public static Connection getConexao() {
        try {
            Connection conexao = DriverManager.getConnection(LINK, USUARIO, SENHA);
            return conexao;
        } catch (SQLException erro) {
            System.out.println(erro.getMessage());
            return null;
        }
    }
}
