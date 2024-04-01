package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import config.Conexao;
import entidades.ItemLocacao;
import entidades.Locacao;

public class LocacaoDAO {

     public static boolean criar(Locacao locacao, int id){
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO locacao(id, data, valor, cliente_id, usuario_id)"
                +"VALUES (?,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, locacao.getId());
            ps.setDate(2, (Date) locacao.getData());
            ps.setDouble(3, locacao.getValor());
            ps.setInt(4, 0);
            ps.setInt(5, id);
            int resultado = ps.executeUpdate();
            ps.close();

            return resultado > 0;

            
        } catch (Exception e) {
              System.out.println(e);
            return false;
        }
    }
}
