package com.vendas.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import com.vendas.basicas.Funcionario;
import com.vendas.fachada.FFuncionario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	static Login login;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					//desabilitando o bot�o maximizar
					frame.setResizable(false);
					frame.setTitle("Realizar Login");
				    login = frame;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 274);
		contentPane = new JPanel();
		//Tela centralizada
				Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				  setLocation((tela.width-this.getSize().width)/2,   
		                  (tela.height-this.getSize().height)/2);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRealizarLogin = new JLabel("Realizar Login - Sistema de Vendas");
		lblRealizarLogin.setBounds(135, 11, 258, 14);
		contentPane.add(lblRealizarLogin);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(57, 96, 74, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(57, 129, 74, 14);
		contentPane.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(135, 93, 232, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(135, 126, 115, 20);
		contentPane.add(txtSenha);
		
		JButton btnEfetuarLogin = new JButton("Efetuar Login");
		btnEfetuarLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				int cont  = 0;
				
				FFuncionario fachada_funcionario = new FFuncionario();
				for (Funcionario funcionario : fachada_funcionario.realizarLogin(txtUsuario.getText(), txtSenha.getText())) {
				String u = funcionario.getUsuario();
				String s = funcionario.getSenha();
				cont++;
				}
				if(cont >0){
				Interno interno = new Interno();
				interno.setVisible(true);
				dispose();
				}else{
					JOptionPane.showMessageDialog(null,"Usuário e Senha inválida!");
					txtUsuario.setText("");
					txtSenha.setText("");
				}
				
			}
		});
		btnEfetuarLogin.setBounds(168, 185, 132, 23);
		contentPane.add(btnEfetuarLogin);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnSair.setBounds(207, 205, 54, 29);
		contentPane.add(btnSair);
	}
}
