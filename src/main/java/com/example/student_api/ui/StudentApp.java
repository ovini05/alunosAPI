package com.example.student_api.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class StudentApp {

	// Definindo os componentes da interface
	private JFrame frame;
	private JTextField cpfField, rgField, nomeField, idadeField, maeField, paiField, enderecoField;
	private JTextArea resultArea;

	public StudentApp() {
		initUI();
	}

	private void initUI() {
		frame = new JFrame("Gerenciamento de Alunos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setLayout(new BorderLayout(10, 10));

		// Painel principal de campos de entrada e botões
		JPanel inputPanel = new JPanel(new GridLayout(7, 2, 10, 10));
		inputPanel.setBorder(BorderFactory.createTitledBorder("Informações do Aluno"));

		// Campos de entrada
		cpfField = new JTextField(20);
		rgField = new JTextField(20);
		nomeField = new JTextField(20);
		idadeField = new JTextField(20);
		maeField = new JTextField(20);
		paiField = new JTextField(20);
		enderecoField = new JTextField(20);

		// Adiciona os campos e rótulos no painel
		inputPanel.add(new JLabel("CPF:"));
		inputPanel.add(cpfField);
		inputPanel.add(new JLabel("RG:"));
		inputPanel.add(rgField);
		inputPanel.add(new JLabel("Nome:"));
		inputPanel.add(nomeField);
		inputPanel.add(new JLabel("Idade:"));
		inputPanel.add(idadeField);
		inputPanel.add(new JLabel("Nome da Mãe:"));
		inputPanel.add(maeField);
		inputPanel.add(new JLabel("Nome do Pai:"));
		inputPanel.add(paiField);
		inputPanel.add(new JLabel("Endereço:"));
		inputPanel.add(enderecoField);

		// Painel de botões
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JButton cadastrarButton = new JButton("Cadastrar");
		JButton deletarButton = new JButton("Deletar");
		JButton buscarButton = new JButton("Buscar");

		buttonPanel.add(cadastrarButton);
		buttonPanel.add(deletarButton);
		buttonPanel.add(buscarButton);

		// Área de exibição dos resultados
		resultArea = new JTextArea(5, 40);
		resultArea.setEditable(false);
		resultArea.setBorder(BorderFactory.createTitledBorder("Resultado da Busca"));

		// Adiciona os painéis à janela principal
		frame.add(inputPanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.add(resultArea, BorderLayout.NORTH);

		// Ações dos botões
		cadastrarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrarAluno();
			}
		});

		deletarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deletarAluno();
			}
		});

		buscarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buscarAluno();
			}
		});

		frame.setVisible(true);
	}

	private void cadastrarAluno() {
		// Código de registro do aluno usando os dados dos campos
		String cpf = cpfField.getText();
		String rg = rgField.getText();
		String nome = nomeField.getText();
		String idade = idadeField.getText();
		String mae = maeField.getText();
		String pai = paiField.getText();
		String endereco = enderecoField.getText();

		// Salvar aluno no banco de dados
		resultArea.setText("Aluno cadastrado: " + nome);
	}

	private void deletarAluno() {
		// Código para deletar o aluno pelo CPF
		String cpf = cpfField.getText();
		resultArea.setText("Aluno deletado com CPF: " + cpf);
	}

	private void buscarAluno() {
		// Código de busca do aluno pelo CPF e exibir os dados no resultArea
		String cpf = cpfField.getText();
		resultArea.setText("Dados do aluno encontrado: \nCPF: " + cpf
				+ "\nRG: \nNome: \nIdade: \nNome da Mãe: \nNome do Pai: \nEndereço:");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new StudentApp());
	}
}
