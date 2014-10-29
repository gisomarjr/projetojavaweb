package com.vendas.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JProgressBar;

import com.vendas.basicas.Funcionario;
import com.vendas.gui.Fornecedor.CadastrarFornecedor;
import com.vendas.gui.Fornecedor.ConsultarFornecedor;
import com.vendas.gui.Funcionario.CadastrarFuncionario;
import com.vendas.gui.Funcionario.ConsultarFuncionario;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;

public class Interno extends JFrame {

	private JPanel contentPane;
	JProgressBar progressBar = new JProgressBar();
	JButton btnConsultarFornecedor = new JButton("Consultar Fornecedor");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interno frame = new Interno();
					frame.setVisible(true);
					//desabilitando o botÔøΩo maximizar
					frame.setResizable(false);
					frame.setTitle("¡rea Interna");
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interno() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 411, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//Tela centralizada
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		  setLocation((tela.width-this.getSize().width)/2,   
                  (tela.height-this.getSize().height)/2);
		setContentPane(contentPane);
		
		JButton btnCadastrarFornecedor = new JButton("Cadastrar Fornecedor");
		btnCadastrarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarFornecedor cadastrar_fornecedor = new CadastrarFornecedor();
				cadastrar_fornecedor.setVisible(true);
			}
		});
		
		progressBar.setIndeterminate(true);
		progressBar.setVisible(false);
		
		
		
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		
		
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio");
		lblFuncionrio.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		
		JButton btnCadastrarFuncionrio = new JButton("Cadastrar Funcion\u00E1rio");
		btnCadastrarFuncionrio.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				CadastrarFuncionario cadastrar_funcionario = new CadastrarFuncionario();
				cadastrar_funcionario.setVisible(true);
				
				
			}
		});
		
		JButton btnConsultarFuncionrio = new JButton("Consultar Funcion\u00E1rio");
		btnConsultarFuncionrio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ConsultarFuncionario consultar_funcionario = new ConsultarFuncionario();
				consultar_funcionario.setVisible(true);
				
			}
		});
		
		JButton btnCadastrarLoja = new JButton("Cadastrar Loja");
		
		JButton btnConsultarLoja = new JButton("Consultar Loja");
		
		JLabel lblLoja = new JLabel("Loja");
		lblLoja.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		
		JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
		
		JButton btnConsultarProduto = new JButton("Consultar Produto");
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				String messageExit = "Deseja realmente sair?";
				String title = "Confirmação";
				//Exibe caixa de dialogo solicitando confirmação ou não. 
				//Se o usuário clicar em "Sim" retorna 0 pra variavel reply, se informado não retorna 1
				int reply = JOptionPane.showConfirmDialog(null, messageExit, title, JOptionPane.YES_NO_OPTION);
				  if (reply == JOptionPane.YES_OPTION)
				  {
					  dispose();
						Login login = new Login();
						login.setVisible(true);
				  }
				
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnCadastrarFuncionrio, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(btnConsultarFornecedor, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(btnCadastrarFornecedor, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 153, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblFuncionrio))
								.addComponent(btnConsultarFuncionrio, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblFornecedor)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(125)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblLoja, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblProduto, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(86)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnConsultarLoja, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnCadastrarProduto, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnConsultarProduto, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnCadastrarLoja, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(btnSair, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(104)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addComponent(lblMenu, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(176, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblMenu, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFornecedor)
						.addComponent(lblLoja))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCadastrarFornecedor, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConsultarFornecedor, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblFuncionrio))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCadastrarLoja, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConsultarLoja, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblProduto)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCadastrarFuncionrio, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConsultarFuncionrio, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCadastrarProduto, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConsultarProduto, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addComponent(btnSair))
		);
		contentPane.setLayout(gl_contentPane);
		btnConsultarFornecedor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Thread(){
					@Override
					public void run() {
						btnConsultarFornecedor.setEnabled(false);
						progressBar.setVisible(true);
						ConsultarFornecedor consultar_fornecedor = new ConsultarFornecedor();
						updateProgress();
						consultar_fornecedor.setVisible(true);
					}
				}.start();
				
			}
		});
		
		
		
		
		
	}
	
	private void updateProgress() {
		  SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		      // Here, we can safely update the GUI
		      // because we'll be called from the
		      // event dispatch thread
		    	
		    	progressBar.setVisible(false);
		    	btnConsultarFornecedor.setEnabled(true);
		    	
		    	
				
		    }
		  });
}
}