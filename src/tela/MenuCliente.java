package tela;

import java.util.ArrayList;
import java.util.Scanner;
import data.JogoDAO;
import entidades.ItemLocacao;
import entidades.Jogo;
import entidades.Locacao;

public class MenuCliente {
public static void menuCliente(int id, Locacao carrinho) {
    ItemLocacao item;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("=== Menu Cliente ===");
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Listar todos os jogos");
                System.out.println("2 - Buscar jogos");
                System.out.println("3 - Listar jogos disponíveis");
                System.out.println("4 - Visualizar Carrinho");
                System.out.println("5 - Carrinho");
                System.out.println("0 - Sair");

                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        Listar.listarJogos(id, carrinho);                  
                        break;
                    case 2:
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
                    case 3:
                        Listar.listarJogosDis(id, carrinho);
                        break;
                    case 4:
                        Listar.mostrarCarrinho(carrinho,id);
                        break;
                    case 5:
                        // Implementação do aluguel de jogos
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }
}
