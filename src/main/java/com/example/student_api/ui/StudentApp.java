package com.example.student_api.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class StudentApp extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField cpfField;
	private JTextField nomeField;
	private JTextField rgField;
	private JTextField idadeField;
	private JTextField nomeMaeField;
	private JTextField nomePaiField;
	private JTextField enderecoField;
	private JTextArea outputArea;

	public StudentApp() {
		setTitle("Gerenciamento de Alunos");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		// Campos de entrada
		cpfField = new JTextField(15);
		nomeField = new JTextField(15);
		rgField = new JTextField(15);
		idadeField = new JTextField(15);
		nomeMaeField = new JTextField(15);
		nomePaiField = new JTextField(15);
		enderecoField = new JTextField(15);

		// Botões
		JButton salvarButton = new JButton("Salvar");
		JButton buscarButton = new JButton("Buscar");
		JButton deletarButton = new JButton("Deletar");

		outputArea = new JTextArea(10, 30);
		outputArea.setEditable(false);

		// Adicionando os componentes
		add(new JLabel("CPF:"));
		add(cpfField);
		add(new JLabel("Nome:"));
		add(nomeField);
		add(new JLabel("RG:"));
		add(rgField);
		add(new JLabel("Idade:"));
		add(idadeField);
		add(new JLabel("Nome da Mãe:"));
		add(nomeMaeField);
		add(new JLabel("Nome do Pai:"));
		add(nomePaiField);
		add(new JLabel("Endereço:"));
		add(enderecoField);
		add(salvarButton);
		add(buscarButton);
		add(deletarButton);
		add(new JScrollPane(outputArea));

		// Adicionando ações dos botões
		salvarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Aqui você deve implementar a chamada à API para salvar o aluno
				outputArea.setText("Aluno salvo: " + nomeField.getText());
			}
		});

		buscarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Aqui você deve implementar a chamada à API para buscar o aluno
				outputArea.setText("Aluno buscado: " + cpfField.getText());
			}
		});

		deletarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Aqui você deve implementar a chamada à API para deletar o aluno
				outputArea.setText("Aluno deletado: " + cpfField.getText());
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			StudentApp app = new StudentApp();
			app.setVisible(true);
		});
	}
}