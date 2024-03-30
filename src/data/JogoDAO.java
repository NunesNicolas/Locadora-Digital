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
    public static boolean inserir(Jogo jogo){
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO jogo(id, titulo, preco, descricao, numeroDias, memoria)"
                +"VALUES (?,?,?,?,?,?)";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, jogo.getId());
            ps.setString(2, jogo.getTitulo());
            ps.setDouble(3, jogo.getPreco());
            ps.setString(4, jogo.getDescricao());
            ps.setInt(5, jogo.getNumdias());
            ps.setInt(6, jogo.getDuracao());

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
