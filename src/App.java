import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    private static final int SENHA_ADMIN = 123321;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem-vindo ao sistema de locadora digital!");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastrar");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    login();
                    break;
                case 2:
                    cadastrar();
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

    public static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Login ===");
        System.out.println("Digite seu login: ");
        String login = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        int senha = scanner.nextInt();

        try (Connection conexao = Conexao.getConexao()) {
            String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, login);
            ps.setInt(2, senha);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int tipoUsuario = rs.getInt("id");
                if (tipoUsuario == 1) {
                    menuAdmin();
                } else {
                    menuCliente();
                }

            } else {
                System.out.println("Login ou senha incorretos. Tente novamente.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fazer login: " + e.getMessage());
        }
    }

    public static void cadastrar() {
        // Implementação do cadastro de usuário
    }

    public static void menuAdmin() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Menu Administrador ===");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar categoria");
            System.out.println("2 - Listar categorias");
            System.out.println("3 - Excluir categoria");
            System.out.println("4 - Atualizar categoria");
            System.out.println("5 - Criar jogo");
            System.out.println("6 - Listar jogos");
            System.out.println("7 - Excluir jogo");
            System.out.println("8 - Atualizar jogo");
            System.out.println("9 - Listar clientes");
            System.out.println("10 - Excluir cliente");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Implementação da criação de categoria
                    break;
                case 2:
                    // Implementação da listagem de categorias
                    break;
                case 3:
                    // Implementação da exclusão de categoria
                    break;
                case 4:
                    // Implementação da atualização de categoria
                    break;
                case 5:
                    // Implementação da criação de jogo
                    break;
                case 6:
                    // Implementação da listagem de jogos
                    break;
                case 7:
                    // Implementação da exclusão de jogo
                    break;
                case 8:
                    // Implementação da atualização de jogo
                    break;
                case 9:
                    // Implementação da listagem de clientes
                    break;
                case 10:
                    // Implementação da exclusão de cliente
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

    public static void menuCliente() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Menu Cliente ===");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Listar todos os jogos");
            System.out.println("2 - Buscar jogos");
            System.out.println("3 - Listar jogos disponíveis");
            System.out.println("4 - Listar jogos alugados");
            System.out.println("5 - Alugar jogos");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Implementação da listagem de todos os jogos
                    break;
                case 2:
                    // Implementação da busca de jogos
                    break;
                case 3:
                    // Implementação da listagem de jogos disponíveis
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


    
