package tela;
import data.JogoDAO;
import data.UsuarioDAO;
import entidades.Jogo;
public class Listar {

    public static void listarJogos(){
        System.out.println("\n".repeat(50));
        System.out.println("==========/Jogos-mais-recentes/==========");
        System.out.println(JogoDAO.listar()+"\n");

    }

    public static void listarUser(){
        System.out.println("\n".repeat(50));
        System.out.println("==========/Usuarios-Cadastrados/==========");
        System.out.println(UsuarioDAO.listar()+"\n");
    }
}
