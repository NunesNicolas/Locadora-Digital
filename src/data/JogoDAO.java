package data;

import config.Conexao;
import entidades.Categoria;
import entidades.Jogo;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;;

public class JogoDAO {
    public static boolean criar(Jogo jogo){
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO jogo(id, titulo, preco, descricao, numeroDias, duracao, memoria, categoria)"
                +"VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, jogo.getId());
            ps.setString(2, jogo.getTitulo());
            ps.setDouble(3, jogo.getPreco());
            ps.setString(4, jogo.getDescricao());
            ps.setInt(5, jogo.getNumdias());
            ps.setInt(6, jogo.getDuracao());
            ps.setInt(7, jogo.getMemoria());
            ps.setString(8, jogo.getCategoria().getNome());

            int resultado = ps.executeUpdate();
            ps.close();

            return resultado > 0;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean atualizar(Jogo jogo){

        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE jogo SET"
                + "titulo=?, preco=?, descricao=?, numeroDias=?, memoria=?, duracao=?"
                +"categoria=?"
                +"WHERE id=?";  

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, jogo.getTitulo());
            ps.setDouble(2, jogo.getPreco());
            ps.setString(3, jogo.getDescricao());
            ps.setInt(4, jogo.getNumdias());
            ps.setInt(5, jogo.getDuracao());
            ps.setInt(6, jogo.getMemoria());
            ps.setString(7, jogo.getCategoria().getNome());
            ps.setInt(8, jogo.getId());
            int resultado = ps.executeUpdate();
            ps.close();

            return resultado > 0;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean excluir(int id){
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "DELETE FROM jogo WHERE id=?";


            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            ps.close();

            return resultado > 0;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static List<Jogo> listar(){
        List<Jogo> listaJogos = new ArrayList<>();
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM jogo";
            Statement st = conexao.createStatement();
            ResultSet res = st.executeQuery(sql);

            while (res.next()) {
                Categoria c = new Categoria();
                c.setNome(res.getString("categoria"));

                Jogo j = new Jogo(c);// Associa a categoria ao jogo
                j.setId(res.getInt("id"));
                j.setTitulo(res.getString("titulo"));
                j.setPreco(res.getDouble("preco"));
                j.setDescricao(res.getString("descricao"));
                j.setNumdias(res.getInt("numeroDias"));
                j.setDuracao(res.getInt("memoria"));

                listaJogos.add(j);
            }

            res.close();
            st.close();
        } 
        catch (Exception e) {
            System.out.println(e);
        }

        return listaJogos;
    }


}
