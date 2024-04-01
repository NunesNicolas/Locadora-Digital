import config.Conexao;
import data.UsuarioDAO;
import entidades.Usuario;
import tela.Listar;
import entidades.Jogo;
import data.JogoDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            //System.out.println("\n".repeat(50));
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
        menuAdmin();
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

    public static void cadastrar() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();

        System.out.print("\nNome: ");
        usuario.setNome(scanner.nextLine());

        System.out.print("Username/email: ");
        String login = scanner.nextLine();
        boolean existeEmail = UsuarioDAO.verificarEmailExistente(login);

        if (existeEmail == true) {
            System.out.println("Esse username/email ja está cadastrado! Tente novamente.\n");
            return;
        } else {
            usuario.setLogin(login);
    
            System.out.print("Senha: ");
            usuario.setSenha(scanner.nextLine());
    
            UsuarioDAO.cadastrarUsuario(usuario);
            login();
        }
    }

    public static void menuAdmin() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            //System.out.println("\n".repeat(50));
            System.out.println("=== Menu Administrador ===");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar jogo");
            System.out.println("2 - Buscar jogo");
            System.out.println("3 - Listar jogos");
            System.out.println("4 - Excluir jogo");
            System.out.println("5 - Atualizar jogo");
            System.out.println("6 - Listar clientes");
            System.out.println("7 - Excluir cliente");
            System.out.println("0 - Sair");
            //System.out.println("3 - Buscar cliente");
            //System.out.println("8 - Atualizar cliente");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("INFORME OS DADOS DO JOGO\n\n");

                    // System.out.println("Digite o ID: ");
                    // int id = scanner.nextInt();

                    System.out.println("Digite o TITULO: ");
                    scanner.nextLine();
                    String titulo = scanner.nextLine();

                    System.out.println("Digite a DESCRIÇÃO: ");
                    String descricao = scanner.nextLine();

                    System.out.println("Digite o NUMEDO DE DIAS que pode ser alugado: ");
                    int numdias = scanner.nextInt();

                    System.out.println("Digite o PREÇO: ");
                    double preco = scanner.nextDouble();

                    System.out.println("Digite a PLATAFORMA que pertence: ");
                    scanner.nextLine();
                    String plataforma = scanner.nextLine();

                    System.out.println("Digite quanto de MEMORIA: ");
                    int memoria = scanner.nextInt();

                    Jogo jogo = new Jogo(titulo.toLowerCase(), descricao, numdias, preco, plataforma, memoria);
                    JogoDAO.criar(jogo);
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
                    Listar.listarJogos();
                    System.in.read();
                    break;
                case 4:
                    // Implementação 
                    break;
                case 5:
                    System.out.println("Digite o nome do jogo que deseja atualizar: ");
                    String nomeJogo = scanner.nextLine();

                    try{
                        Connection conexao = Conexao.getConexao();
                        String sql = "SELECT * FROM jogo";
                        Statement st = conexao.createStatement();
                        ResultSet res = st.executeQuery(sql);

                        while (res.next()) {
                            if (nomeJogo.toLowerCase() == res.getString("titulo").toLowerCase()) {
                                Jogo j = new Jogo();// Associa a categoria ao jogo

                                j.setId(res.getInt("id"));

                                System.out.println("Digite o TITULO: ");
                                scanner.nextLine();
                                String titulo2 = scanner.nextLine();
                                j.setTitulo(titulo2.toLowerCase());

                                System.out.println("Digite o PREÇO: ");
                                double preco2 = scanner.nextDouble();
                                j.setPreco(preco2);

                                System.out.println("Digite a DESCRIÇÃO: ");
                                String descricao2 = scanner.nextLine();
                                j.setDescricao(descricao2);

                                System.out.println("Digite o NUMEDO DE DIAS que pode ser alugado: ");
                                int numdias2 = scanner.nextInt();
                                j.setNumdias(numdias2);
                                
                                System.out.println("Digite a PLATAFORMA que pertence: ");
                                scanner.nextLine();
                                String plataforma2 = scanner.nextLine();
                                j.setPlataforma(plataforma2);

                                System.out.println("Digite quanto de MEMORIA: ");
                                int memoria2 = scanner.nextInt();
                                j.setMemoria(memoria2);

                                JogoDAO.atualizar(j);

                                res.close();
                                st.close();
                            }
                            else{
                                System.out.println("Não existe jogo com esse nome");
                            }

                        }
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
        
                    break;
                case 6:
                    // Implementação da listagem de jogos
                    break;
                case 7:
                    // Implementação da exclusão de jogo
                    break;
                case 8:
                   
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


    
