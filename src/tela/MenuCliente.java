package tela;

import java.util.Scanner;

import data.ItemLocaDAO;
import data.JogoDAO;

public class MenuCliente {
public static void menuCliente(int id) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Menu Cliente ===");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Listar todos os jogos");
            System.out.println("2 - Buscar jogos");
            System.out.println("3 - Listar jogos disponíveis");
            System.out.println("4 - Listar jogos alugados");
            System.out.println("5 - Carrinho");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Listar.listarJogos();                    
                    break;
                case 2:
                try {        
                    System.out.println("Digite o nome do jogo que deseja buscar: ");
                    scanner.nextLine();
                    String tituloJogo = scanner.nextLine();
                    JogoDAO.buscarJogoPeloTitulo(tituloJogo.toLowerCase());

                } catch (Exception erro) {
                    System.out.println(erro.getMessage());
                }
                    break;
                case 3:
                    Listar.listarJogosDis();
                    break;
                case 4:
                    // Implementação da listagem de jogos alugados pelo cliente
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
