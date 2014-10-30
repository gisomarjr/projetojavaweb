package com.vendas.gui.Loja;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import com.vendas.basicas.Departamento;
import com.vendas.basicas.Fornecedor;
import com.vendas.basicas.Loja;
import com.vendas.fachada.FDepartamento;
import com.vendas.fachada.FLoja;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.JTable;

public class CadastrarLoja extends JFrame {

	private JPanel contentPane;
	private JTextField textRazaoSocial;
	private JTextField textNomeFantasia;
	ImageIcon loading = new ImageIcon("loading.gif");
	JLabel lblCarregando = new JLabel("Validando Loja... ", loading, JLabel.CENTER);
	JProgressBar progressBar = new JProgressBar();
	final JButton btnSalvar = new JButton("Salvar");
	final JFormattedTextField cnpj = new JFormattedTextField();
	String status;
	MaskFormatter cnpj_format;
	Collection<Departamento> lista_departamento = new ArrayList<Departamento>();
//	List<Loja> lista_loja_departamento;
	Loja loja_public = new Loja();
	 DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new Object[]{"ID", "Nome" });
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarLoja frame = new CadastrarLoja();
					frame.setVisible(true);
					//desabilitando o bot�o maximizar
					frame.setResizable(false);
					frame.setTitle("Cadastro de Loja");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 
	 final JLabel label = new JLabel("Validando Loja... ", loading, JLabel.CENTER);
	 private JTextField textEmail;
	 private JTable table;
	 private JTextField textCadastroNomeDepartamento;
	/**
	 * Create the frame.
	 */
	public CadastrarLoja() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 498, 647);
		contentPane = new JPanel();
		
		//Tela centralizada
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		  setLocation((tela.width-this.getSize().width)/2,   
                  (tela.height-this.getSize().height)/2);
		   
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblCadastroDeLoja = new JLabel("Cadastro de Loja");
		lblCadastroDeLoja.setBounds(173, 11, 245, 29);
		contentPane.add(lblCadastroDeLoja);
		
		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social:");
		lblRazoSocial.setBounds(10, 45, 109, 23);
		contentPane.add(lblRazoSocial);
		
		textRazaoSocial = new JTextField();
		textRazaoSocial.setBounds(129, 47, 307, 20);
		contentPane.add(textRazaoSocial);
		textRazaoSocial.setColumns(10);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		lblNomeFantasia.setBounds(10, 90, 109, 29);
		contentPane.add(lblNomeFantasia);
		
		textNomeFantasia = new JTextField();
		textNomeFantasia.setBounds(129, 95, 307, 20);
		contentPane.add(textNomeFantasia);
		textNomeFantasia.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(72, 131, 75, 29);   
		contentPane.add(lblCnpj);
		
		
		cnpj.setBounds(129, 136, 140, 20);
		try {
			cnpj_format = new MaskFormatter("##.###.###/####-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}  
        cnpj.setFormatterFactory(new DefaultFormatterFactory(cnpj_format));
		contentPane.add(cnpj);
		
		
		
		btnSalvar.setBounds(322, 565, 130, 29);
		contentPane.add(btnSalvar);
		
		
		lblCarregando.setBounds(60, 512, 378, 16);
		contentPane.add(lblCarregando);
		
		
		progressBar.setBounds(182, 539, 148, 14);
		progressBar.setIndeterminate(true);
		progressBar.setVisible(false);
		contentPane.add(progressBar);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(65, 179, 46, 14);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(129, 177, 307, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(46, 218, 73, 16);
		contentPane.add(lblTelefone);
		
		final JFormattedTextField telefone = new JFormattedTextField();
		telefone.setBounds(129, 218, 109, 20);
		contentPane.add(telefone);
		
		final FDepartamento fachada_departamento = new FDepartamento();
		
		/*
		lista_loja_departamento = new ArrayList<Loja>(fachada_loja.listar());
		try{
		 for (Loja loja : fachada_loja.listar()) {    
			this.loja_public = loja;
			 loja.getId();
			 loja.getDepartamentos();
			 
			 lista_loja_departamento.add(loja);
			 
          
         }
		 
		 lista_loja_departamento = new ArrayList<Loja>(fachada_loja.listar());
		 for (Departamento departamento : loja_public.getDepartamentos()) {    
			
			 
			 lista_departamento.add(departamento);
			 model.addRow(new String[]{departamento.getId().toString(), 
	 				   				   departamento.getNome()
	 		});
			 
          
         }
		}catch(java.lang.NullPointerException nulo){
			
		}
*/
		
		
		
		JLabel lblDepartamentos = new JLabel("Departamentos:");
		lblDepartamentos.setBounds(10, 273, 123, 16);
		contentPane.add(lblDepartamentos);
		

		textCadastroNomeDepartamento = new JTextField();
		textCadastroNomeDepartamento.setBounds(185, 334, 114, 19);
		contentPane.add(textCadastroNomeDepartamento);
		textCadastroNomeDepartamento.setColumns(10);
		
		final JLabel lblNomeDoDepartamento = new JLabel("Nome do departamento");
		lblNomeDoDepartamento.setBounds(10, 336, 187, 15);
		contentPane.add(lblNomeDoDepartamento);
		lblNomeDoDepartamento.setVisible(false);
		textCadastroNomeDepartamento.setVisible(false);
		
		/**
		 * Cadastrar Departamento
		 */
		final JButton btnOkCadastrarDepartamento = new JButton("OK");
		btnOkCadastrarDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblNomeDoDepartamento.setVisible(false);
				textCadastroNomeDepartamento.setVisible(false);
				btnOkCadastrarDepartamento.setVisible(false);
				
				Departamento departamento = new Departamento();
				
				departamento.setNome(textCadastroNomeDepartamento.getText());
				
				try {
					
					 lista_departamento.add(departamento);
					 fachada_departamento.cadastrar(departamento);
					 
					 model.addRow(new String[]{departamento.getId().toString(), 
			 				   				   departamento.getNome()
			 		});
					
					 
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		table = new JTable(model);
		table.setBounds(111, 295, 109, -46);
		contentPane.add(table);
		
		//Barra de Rolagem
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(129, 244, 170, 78);
		contentPane.add(scrollPane);
		
		btnOkCadastrarDepartamento.setBounds(308, 335, 60, 20);
		contentPane.add(btnOkCadastrarDepartamento);
		btnOkCadastrarDepartamento.setVisible(false);
		
		/**
		 * * Habilitar o botão de cadastrar departamento e o
		 * textbox do departametno
		 */
		JButton btnChamarCadastroDepartamento = new JButton("Cadastrar");
		btnChamarCadastroDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblNomeDoDepartamento.setVisible(true);
				textCadastroNomeDepartamento.setVisible(true);
				btnOkCadastrarDepartamento.setVisible(true);
				
			}
		});
		btnChamarCadastroDepartamento.setBounds(308, 244, 110, 23);
		contentPane.add(btnChamarCadastroDepartamento);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(309, 270, 110, 23);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(309, 300, 109, 23);
		contentPane.add(btnExcluir);
		
		
		
		
		
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
						Loja loja = new Loja();
						loja.setCnpj(cnpj.getText());
						loja.setRazao_social(textRazaoSocial.getText());
						loja.setDepartamentos(lista_departamento);
						loja.setEmail(textEmail.getText());
						loja.setNome(textNomeFantasia.getText());
						loja.setTelefone_comercial(telefone.getText());
						
						
						FLoja fachada_loja = new FLoja();
						try {
							status = fachada_loja.validaCampo(loja);
							
							if(status == ""){
					         fachada_loja.cadastrar(loja);
					         status = "Loja Cadastrado com Sucesso!";
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
