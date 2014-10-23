package com.vendas.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import com.vendas.basicas.Fornecedor;
import com.vendas.fachada.FFornecedor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField textRazaoSocial;
	private JTextField textNomeFantasia;
	ImageIcon loading = new ImageIcon("loading.gif");
	JLabel lblNewLabel = new JLabel("Loading... ", loading, JLabel.CENTER);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarFornecedor frame = new CadastrarFornecedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 
	 final JLabel label = new JLabel("Loading... ", loading, JLabel.CENTER);
	/**
	 * Create the frame.
	 */
	public CadastrarFornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeFornecedor = new JLabel("Cadastro de Fornecedor");
		lblCadastroDeFornecedor.setBounds(144, 11, 280, 29);
		contentPane.add(lblCadastroDeFornecedor);
		
		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social:");
		lblRazoSocial.setBounds(17, 45, 78, 23);
		contentPane.add(lblRazoSocial);
		
		textRazaoSocial = new JTextField();
		textRazaoSocial.setBounds(105, 46, 319, 20);
		contentPane.add(textRazaoSocial);
		textRazaoSocial.setColumns(10);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		lblNomeFantasia.setBounds(10, 90, 85, 29);
		contentPane.add(lblNomeFantasia);
		
		textNomeFantasia = new JTextField();
		textNomeFantasia.setBounds(105, 94, 319, 20);
		contentPane.add(textNomeFantasia);
		textNomeFantasia.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(61, 132, 34, 29);
		contentPane.add(lblCnpj);
		
		final JFormattedTextField cnpj = new JFormattedTextField();
		cnpj.setBounds(105, 136, 124, 20);
		contentPane.add(cnpj);
		
		JButton btnSalvar = new JButton("Salvar");
		
		btnSalvar.setBounds(294, 222, 130, 29);
		contentPane.add(btnSalvar);
		
		
		lblNewLabel.setBounds(71, 173, 55, 16);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		btnSalvar.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				new Thread(){
					@Override
					public void run() {
						lblNewLabel.setVisible(true);
						Fornecedor fornecedor = new Fornecedor();
						fornecedor.setCnpj(cnpj.getText());
						fornecedor.setNomeFantasia(textNomeFantasia.getText());
						fornecedor.setRazaoSocial(textRazaoSocial.getText());
						
						FFornecedor fachada_fornecedor = new FFornecedor();
						try {
							
							fachada_fornecedor.cadastrar(fornecedor);
							
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						
					}
				}.start();
				
				
				
			}
			
			
		});
		
		lblNewLabel.setVisible(false);
		
	}
}
