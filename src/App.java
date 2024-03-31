import config.Conexao;
import data.UsuarioDAO;
import entidades.Usuario;
import tela.Listar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n".repeat(50));
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

    public static void login() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Login ===");
        System.out.println("Digite seu login: ");
        String login = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();

        try (Connection conexao = Conexao.getConexao()) {
            String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
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
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();

        System.out.print("\nNome: ");
        usuario.setNome(scanner.nextLine());

        System.out.print("Username/email: ");
        String login = scanner.nextLine();
        boolean existeEmail = UsuarioDAO.verificarEmailExistente(login);

        if (existeEmail == true) {
            System.out.println("Esse username/email ja está cadastrado! Tente novamente.");
            cadastrar();
        } else {
            
            usuario.setLogin(login);
    
            System.out.print("Senha: ");
            usuario.setSenha(scanner.nextLine());
    
            UsuarioDAO.cadastrarUsuario(usuario);
        }

    }

    public static void menuAdmin() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n".repeat(50));
            System.out.println("=== Menu Administrador ===");
            System.out.println("Escolha uma opção:");
            System.out.println("5 - Criar jogo");
            System.out.println("2 - Buscar jogo");
            System.out.println("3 - Listar jogos");
            System.out.println("7 - Excluir jogo");
            System.out.println("8 - Atualizar jogo");
            System.out.println("9 - Listar clientes");
            System.out.println("10 - Excluir cliente");
            System.out.println("0 - Sair");
            //System.out.println("3 - Buscar cliente");
            //System.out.println("8 - Atualizar cliente");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Implementação da criação de categoria
                    break;
                case 2:
                    // Implementação da listagem de categorias
                    break;
                case 3:
                    Listar.listarJogos();
                    System.in.read();
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
                    Listar.listarUser();
                    System.in.read();      
                        
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
                    Listar.listarJogos();                    
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


    
