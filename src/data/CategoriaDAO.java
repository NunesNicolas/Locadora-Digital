package data;
import entidades.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

import config.Conexao;

public class CategoriaDAO {
    public static boolean criar(Categoria categoria) {
        try {

            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO categoria (nome, tipo) VALUES (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, categoria.getNome());
            comando.setString(2, String.valueOf(categoria.getTipo()));
            comando.execute();
            comando.close();

            return true;

        } catch (SQLException erro) {
            return false;
        }        
    }

    public static ArrayList<Categoria> listar() {
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        try {

            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM categoria";
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(sql);

            while(resultado.next()) {
                Categoria c = new Categoria();
                c.setId(resultado.getInt("id"));
                c.setNome(resultado.getString("nome"));
                c.setTipo(resultado.getString("tipo").charAt(0));
                categorias.add(c);
            }

            resultado.close();
            comando.close();
            
        } catch (SQLException erro) {
            System.out.println(erro.getMessage());
        }
            return categorias;
    }

    public static boolean atualizar(Categoria categoria) {
        try {

            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE categoria SET nome = ?, tipo = ? WHERE id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, categoria.getNome());
            comando.setString(2, String.valueOf(categoria.getTipo()));
            comando.setInt(3, categoria.getId());
            
            int numeroDeLinhas = comando.executeUpdate();
            
            comando.close();
            
            return numeroDeLinhas > 0;
        } catch (SQLException erro) {
            return false;
        }
    }

    public static boolean excluir(int id) {
        try {

            Connection conexao = Conexao.getConexao();
            String sql = "DELETE FROM categoria WHERE id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1, id);

            int numeroDeLinhas = comando.executeUpdate();
            
            comando.close();

            return numeroDeLinhas > 0;
        } catch(SQLException erro) {
            System.out.println(erro.getMessage());
            return false;
        }
    }
}
