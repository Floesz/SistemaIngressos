package application;

import entities.Ingresso;
import entities.Inteira;
import entities.Meia_Entrada;
import entities.VIP;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import com.formdev.flatlaf.FlatDarkLaf;

public class TelaIngresso extends JFrame {

    private JComboBox<String> comboTipo;
    private JTextField txtNome, txtData, txtPreco;
    private JTable tabela;
    private DefaultTableModel model;

    private java.util.List<Ingresso> listaIngressos = new ArrayList<>();

    public TelaIngresso() {
        setTitle("Ingressos");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/ticket_icon-icons.com_52351.png"));
        setIconImage(icon.getImage());


        JPanel painelEntrada = new JPanel(new GridLayout(5, 2, 5, 5));
        painelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        painelEntrada.add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>(new String[]{"Inteira", "VIP", "Meia"});
        painelEntrada.add(comboTipo);

        painelEntrada.add(new JLabel("Nome do Evento:"));
        txtNome = new JTextField();
        painelEntrada.add(txtNome);

        painelEntrada.add(new JLabel("Data:"));
        txtData = new JTextField();
        painelEntrada.add(txtData);

        painelEntrada.add(new JLabel("Preço base:"));
        txtPreco = new JTextField();
        painelEntrada.add(txtPreco);

        JButton btnGerar = new JButton("Gerar Ingresso");
        btnGerar.addActionListener(this::gerarIngresso);
        painelEntrada.add(btnGerar);

        JButton btnDetalhes = new JButton("Detalhes");
        btnDetalhes.addActionListener(this::mostrarDetalhes);
        painelEntrada.add(btnDetalhes);

        add(painelEntrada, BorderLayout.NORTH);

        // Tabela
        model = new DefaultTableModel(new String[]{"Tipo", "Evento", "Data", "Valor"}, 0);
        tabela = new JTable(model);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }

    private void mostrarDetalhes(ActionEvent e) {
        int linhaSelecionada = tabela.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um ingresso na tabela.");
            return;
        }

        Ingresso ingressoSelecionado = listaIngressos.get(linhaSelecionada);
        String detalhes = ingressoSelecionado.imprimirIngresso();

        JOptionPane.showMessageDialog(this, detalhes, "Detalhes do Ingresso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void gerarIngresso(ActionEvent e) {
        String tipo = (String) comboTipo.getSelectedItem();
        String nome = txtNome.getText();
        String data = txtData.getText();
        double preco;

        try {
            preco = Double.parseDouble(txtPreco.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Preço inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Ingresso ingresso = null;

        switch (tipo) {
            case "Inteira":
                ingresso = new Inteira(nome, data, preco);
                break;
            case "VIP":
                ingresso = new VIP(nome, data, preco, 50);
                break;
            case "Meia":
                ingresso = new Meia_Entrada(nome, data, preco);
                break;
        }

        if (ingresso != null) {
            listaIngressos.add(ingresso);
            model.addRow(new Object[]{
                    tipo,
                    nome,
                    data,
                    String.format("R$ %.2f", ingresso.calcularValor())
            });

            // Limpar campos
            txtNome.setText("");
            txtData.setText("");
            txtPreco.setText("");
        }


    }



    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() ->
                new TelaIngresso().setVisible(true));
    }
}

