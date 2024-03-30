package data;

import config.Conexao;
import entidades.Jogo;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class JogoDAO {
    public static boolean criar(Jogo jogo){
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO jogo(id, titulo, preco, descricao, numeroDias, plataforma, duracao, memoria)"
                +"VALUES (?,?,?,?,?,?,?,?)";
                
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, jogo.getId());
            ps.setString(2, jogo.getTitulo());
            ps.setDouble(3, jogo.getPreco());
            ps.setString(4, jogo.getDescricao());
            ps.setInt(5, jogo.getNumdias());
            ps.setString(6, jogo.getPlataforma());
            ps.setInt(7, jogo.getDuracao());
            ps.setInt(8, jogo.getMemoria());
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
            String sql = "UPDATE jogo SET titulo = ?, preco = ?, descricao = ?, numeroDias = ?, plataforma = ?, duracao = ?, memoria = ? WHERE id = ?";  

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, jogo.getTitulo());
            ps.setDouble(2, jogo.getPreco());
            ps.setString(3, jogo.getDescricao());
            ps.setInt(4, jogo.getNumdias());
            ps.setString(5, jogo.getPlataforma());
            ps.setInt(6, jogo.getDuracao());
            ps.setInt(7, jogo.getMemoria());
            ps.setInt(8, jogo.getId());
            int resultado = ps.executeUpdate();
            System.out.println("receba");
            ps.close();

            return resultado > 0;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
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

    public static ArrayList<Jogo> listar(){
        ArrayList<Jogo> listaJogos = new ArrayList<>();
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM jogo";
            Statement st = conexao.createStatement();
            ResultSet res = st.executeQuery(sql);

            while (res.next()) {
                // Categoria c = new Categoria();
                // c.setNome(res.getString("categoria"));

                Jogo j = new Jogo();// Associa a categoria ao jogo
                j.setId(res.getInt("id"));
                j.setTitulo(res.getString("titulo"));
                j.setPreco(res.getDouble("preco"));
                j.setDescricao(res.getString("descricao"));
                j.setNumdias(res.getInt("numeroDias"));
                j.setPlataforma(res.getString("plataforma"));
                j.setMemoria(res.getInt("memoria"));
                j.setDuracao(res.getInt("duracao"));
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
