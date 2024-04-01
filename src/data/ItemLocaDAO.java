package data;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
