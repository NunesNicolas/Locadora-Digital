package config;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class  Frame extends JFrame {

    public Frame() {
        setTitle("Exemplo de JTable");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Dados da tabela (categorias e tipos)
        String[][] dados = {
            {"Comédia", "F"},
            {"Ação", "J"},
            {"Drama", "F"},
            {"Aventura", "J"},
            // Adicione mais linhas conforme necessário
        };

        // Nomes das colunas
        String[] colunas = {"Categoria", "Tipo"};

        // Criando o modelo de tabela
        DefaultTableModel modelo = new DefaultTableModel(dados, colunas);

        // Criando a tabela
        JTable tabela = new JTable(modelo);

        // Adicionando a tabela em um painel com barra de rolagem
        JScrollPane scrollPane = new JScrollPane(tabela);
        getContentPane().add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Frame());
    }
}