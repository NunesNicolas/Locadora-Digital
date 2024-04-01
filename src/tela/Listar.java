package tela;
import java.util.Scanner;

import data.ItemLocaDAO;
import data.JogoDAO;
import data.UsuarioDAO;
import entidades.ItemLocacao;
import entidades.Jogo;
import entidades.Locacao;

public class Listar {

/*JOGOS*/
static Scanner scanner = new Scanner(System.in);

    public static void listarJogos(int id, Locacao carrinho){
        
        
        System.out.println("\n".repeat(50));
        System.out.println("==========/Jogos-mais-recentes/==========");
        System.out.println(JogoDAO.listarGeral()+"\n");
        System.out.println("digite:" +"\n 1 - Menu principal" + "\n 2 - Buscar jogo");
        int opcao = scanner.nextInt();
        options(opcao, id, carrinho);
}

    public static void listarJogosDis(int id, Locacao carrinho){
        ItemLocaDAO.ListarDis();

        System.out.println("digite:" +"\n 1 - Menu principal" + "\n 2 - Buscar jogo");
        int opcao = scanner.nextInt();
        options(opcao, id, carrinho);
}


/*USUARIO*/
    public static void listarUser(){
        System.out.println("\n".repeat(50));
        System.out.println("==========/Usuarios-Cadastrados/==========");
        System.out.println(UsuarioDAO.listar()+"\n");
    }

/*GERAL*/
    public static void options(int opcao, int id, Locacao carrinho){
        switch (opcao) {
            case 1: 
                break;
            
            case 2: //Ver mais informações do jogo escolhido
            try {        
                 System.out.println("Digite o nome do jogo que deseja buscar: ");
                        scanner.nextLine();
                        String tituloJogo = scanner.nextLine();
                        Jogo j = JogoDAO.buscarJogoPeloTitulo(tituloJogo.toLowerCase());
                        System.out.println(j);
                        Alugar.adicionaraoCarrinho(id, carrinho, j);
                        
    
            } catch (Exception erro) {
                System.out.println(erro.getMessage());
            }
            break;
    }
    }

    public static void mostrarCarrinho(Locacao carrinho){
        System.out.println("=====Seu_Carrinho=====");
        for(ItemLocacao item : carrinho.getItensLocacao()){
            System.out.println(JogoDAO.buscarJogoPeloID(item.getJogo().getId()));
        }
        System.out.println("/n"+"=====VALOR TOTAL:"+carrinho.getValor()+"=====");
    }
}

