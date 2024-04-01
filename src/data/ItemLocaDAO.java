package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import config.Conexao;
import entidades.ItemLocacao;
import entidades.Jogo;
import entidades.Locacao;

public class ItemLocaDAO {

    public static boolean criar(ItemLocacao itemlocacao){
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO itemlocacao(id, valor, Jogo_id, Locacao_id)"
                +"VALUES (?,?,?,?)";
             PreparedStatement ps = conexao.prepareStatement(sql);
             Locacao locacao = new Locacao();
             itemlocacao.setLocacao(locacao);
             itemlocacao.getLocacao().setId(0);
            ps.setInt(1, itemlocacao.getId());
            ps.setDouble(2, itemlocacao.getValor());
            ps.setInt(3, itemlocacao.getJogo().getId());
            ps.setInt(4, itemlocacao.getLocacao().getId());
            int resultado = ps.executeUpdate();
            ps.close();

            return resultado > 0;

            
        } catch (Exception e) {
              System.out.println(e);
            return false;
        }
    }


    public static void ListarDis(){
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM itemlocacao";
            Statement st = conexao.createStatement();
            ResultSet res = st.executeQuery(sql);
            
            while (res.next()) {
                ItemLocacao il = new ItemLocacao();
                il.setId(res.getInt("id"));
                il.setValor(res.getDouble("valor"));
                Jogo j = new Jogo();
                    il.setJogo(j);
                    il.getJogo().setId(res.getInt("jogo_id"));
                Locacao lo = new Locacao();
                    il.setLocacao(lo);
                    il.getLocacao().setId(res.getInt("locacao_id"));
                if (il.getLocacao().getId()== 0) {
                System.out.println(JogoDAO.buscarJogoPeloID(il.getJogo().getId()));
                }
            }
            res.close();
            st.close();
        } 
        catch (Exception e) {
            System.out.println("Não foi possível apresentar os jogos disponíveis");
            System.out.println(e);
        }
    }
}
        
