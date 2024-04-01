package tela;
import java.util.Scanner;

import data.ItemLocaDAO;
import data.JogoDAO;
import data.UsuarioDAO;
import entidades.Jogo;

public class Listar {

/*JOGOS*/
static Scanner scanner = new Scanner(System.in);

    public static void listarJogos(){
        
        
        System.out.println("\n".repeat(50));
        System.out.println("==========/Jogos-mais-recentes/==========");
        System.out.println(JogoDAO.listarGeral()+"\n");
        System.out.println("digite:" +"\n 1 - Menu principal" + "\n 2 - Buscar jogo");
        int opcao = scanner.nextInt();
        options(opcao);
}

    public static void listarJogosDis(){
        ItemLocaDAO.ListarDis();

        System.out.println("digite:" +"\n 1 - Menu principal" + "\n 2 - Buscar jogo");
        int opcao = scanner.nextInt();
        options(opcao);
}


/*USUARIO*/
    public static void listarUser(){
        System.out.println("\n".repeat(50));
        System.out.println("==========/Usuarios-Cadastrados/==========");
        System.out.println(UsuarioDAO.listar()+"\n");
    }

/*GERAL*/
    public static void options(int opcao){
        switch (opcao) {
            case 1: 
                break;
            
            case 2: //Ver mais informações do jogo escolhido
            try {        
                System.out.println("Digite o nome do jogo que deseja buscar: ");
                scanner.nextLine();
                String tituloJogo = scanner.nextLine();
                JogoDAO.buscarJogoPeloTitulo(tituloJogo.toLowerCase());
    
            } catch (Exception erro) {
                System.out.println(erro.getMessage());
            }
            break;
    }
    }
}

