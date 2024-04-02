package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Calendar;

import config.Conexao;
import entidades.ItemLocacao;
import entidades.Locacao;

public class LocacaoDAO {

    public static boolean criar(Locacao locacao, int id){
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO locacao(id, data, valor, usuario_id)"
                +"VALUES (?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, locacao.getId());
            ps.setDate(2, (Date) locacao.getData());
            ps.setDouble(3, locacao.getValor());
            ps.setInt(4, id);
            int resultado = ps.executeUpdate();
            ps.close();

            return resultado > 0;

            
        } catch (Exception e) {
              System.out.println(e);
            return false;
        }
    }


    public static int idcarrinho(int user_id) {
        int j = 0;
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM locacao WHERE usuario_id = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, user_id);
            ResultSet res = comando.executeQuery();
    
            // Verifique se há resultados antes de obter o valor
            if (res.next()) {
                j = res.getInt("id");
            } else {
                // Se não houver resultados, defina um valor padrão (por exemplo, -1)
                j = 0;
                System.out.println("deu erro menor");
            }
            res.close();
            comando.close();
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return j;
    }
    
}