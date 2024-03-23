package config;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao {
    private static final String LINK = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10693762";
    private static final String USUARIO = "sql10693762";
    private static final String SENHA = "LlJZkzD2aM";

    public static Connection getConexao() {
        try {
            Connection conexao = DriverManager.getConnection(LINK, USUARIO, SENHA);
            return conexao;
        } catch (Exception erro) {
            return null;
        }
    }
}
