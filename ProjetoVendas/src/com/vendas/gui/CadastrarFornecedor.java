package com.vendas.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import com.vendas.basicas.Fornecedor;
import com.vendas.fachada.FFornecedor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JProgressBar;

public class CadastrarFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField textRazaoSocial;
	private JTextField textNomeFantasia;
	ImageIcon loading = new ImageIcon("loading.gif");
	JLabel lblCarregando = new JLabel("Validando Fornecedor... ", loading, JLabel.CENTER);
	JProgressBar progressBar = new JProgressBar();
	final JButton btnSalvar = new JButton("Salvar");
	final JFormattedTextField cnpj = new JFormattedTextField();
	String status;
	
	
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
	 
	 final JLabel label = new JLabel("Validando Fornecedor... ", loading, JLabel.CENTER);
	/**
	 * Create the frame.
	 */
	public CadastrarFornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		//Tela centralizada
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		  setLocation((tela.width-this.getSize().width)/2,   
                  (tela.height-this.getSize().height)/2);
		   
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
		
		
		cnpj.setBounds(105, 136, 124, 20);
		contentPane.add(cnpj);
		
		
		
		btnSalvar.setBounds(294, 222, 130, 29);
		contentPane.add(btnSalvar);
		
		
		lblCarregando.setBounds(32, 168, 378, 16);
		contentPane.add(lblCarregando);
		
		
		progressBar.setBounds(154, 196, 148, 14);
		progressBar.setIndeterminate(true);
		progressBar.setVisible(false);
		contentPane.add(progressBar);
		
		lblCarregando.setVisible(false);
		
		
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				new Thread(){
					@Override
					public void run() {
						lblCarregando.setVisible(true);
						progressBar.setVisible(true);
						btnSalvar.setEnabled(false);
						Fornecedor fornecedor = new Fornecedor();
						fornecedor.setCnpj(cnpj.getText());
						fornecedor.setNomeFantasia(textNomeFantasia.getText());
						fornecedor.setRazaoSocial(textRazaoSocial.getText());
						
						FFornecedor fachada_fornecedor = new FFornecedor();
						try {
							status = fachada_fornecedor.validaCampo(fornecedor);
							
							if(status == ""){
					         fachada_fornecedor.cadastrar(fornecedor);
					         status = "Fornecedor Cadastrado com Sucesso!";
					         JOptionPane.showMessageDialog(null,status);
					         cnpj.setText("");
							 textNomeFantasia.setText("");
							 textRazaoSocial.setText("");
							 
							}else{
								JOptionPane.showMessageDialog(null,status);
								
							}
							updateProgress();
							
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,e.getMessage());
						}
						
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
		    	lblCarregando.setVisible(false);
				progressBar.setVisible(false);
				btnSalvar.setEnabled(true);
				
				
		    }
		  });
		}
}
