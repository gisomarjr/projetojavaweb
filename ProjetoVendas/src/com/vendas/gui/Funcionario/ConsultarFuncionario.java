package com.vendas.gui.Funcionario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JTable;

import com.vendas.basicas.Funcionario;
import com.vendas.fachada.FFuncionario;

import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.xml.bind.ParseConversionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JProgressBar;

public class ConsultarFuncionario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Funcionario funcionario = new Funcionario();
	final FFuncionario fachada_funcionario = new FFuncionario();
	int linha = 0;
	String valor_string = null;
	Object valor = null;
	int erro_null = 0;
	final JButton btnEditar = new JButton("Editar");
	final JProgressBar progressBar = new JProgressBar();
	JProgressBar progressBarPesquisar = new JProgressBar();
	 DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new Object[]{"ID", "CPF", "Nome", "Matricula","Email", "Telefone","Usuario","Departamento","Logradouro","Cidade","Numero","Estado" });   
	 static ConsultarFuncionario consultar;
	 MaskFormatter cpf_format;
	 List<Funcionario> lista_funcionario;
	 JButton btnPesquisar = new JButton("Pesquisar");
	/**
	 * Launch the application.
	 */
	
	 
	 
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarFuncionario frame = new ConsultarFuncionario();
					frame.setVisible(true);
					consultar = frame;
					//desabilitando o bot�o maximizar
					frame.setResizable(false);
					frame.setTitle("Consultar Funcionario");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public ConsultarFuncionario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1033, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//Tela centralizada
				Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				  setLocation((tela.width-this.getSize().width)/2,   
		                  (tela.height-this.getSize().height)/2);
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblConsultarFuncionarioes = new JLabel("Consultar Funcionarios");
				lblConsultarFuncionarioes.setBounds(452, 11, 267, 14);
				contentPane.add(lblConsultarFuncionarioes);
							
				 lista_funcionario = new ArrayList<Funcionario>(fachada_funcionario.listar());
				 for (Funcionario funcionario : lista_funcionario) {    
					 this.funcionario = funcionario;
		             model.addRow(new String[]{funcionario.getId().toString(), 
		            		      			   funcionario.getCpf(),
		            		      			   funcionario.getNome(),
		            		      			   funcionario.getMatricula(),
		            		      			   funcionario.getEmail(),
		            		      			   funcionario.getTelefone(),
		            		      			   funcionario.getUsuario(),
		            		      			   funcionario.getDepartamento().getNome(),
		            		      			   funcionario.getEndereco().getLogradouro(),
		            		      			   funcionario.getEndereco().getCidade(),
		            		      			   funcionario.getEndereco().getNumero().toString(),
		            		      			   funcionario.getEndereco().getEstado(),
		            		      			   
		            		 		});    
		         }
			                 
				table = new JTable(model);
				table.setBounds(10, 71, 688, 296);
				
				contentPane.add(table);
				
				
				progressBar.setBounds(805, 37, 89, 14);
				contentPane.add(progressBar);
				
				//Barra de Rolagem
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(10, 95, 1009, 402);
				contentPane.add(scrollPane);
				
				progressBar.setVisible(false);
				progressBarPesquisar.setVisible(false);
				progressBar.setIndeterminate(true);
				progressBarPesquisar.setIndeterminate(true);
				btnEditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try{		
							 linha =	table.getSelectedRow(); //retorna um inteiro  
							 valor = table.getValueAt(linha,0);   					
							 valor_string = (String)valor;
							
								new Thread(){
									@Override
									public void run() {
									funcionario = fachada_funcionario.consultarID(Integer.parseInt(valor_string));
									 btnEditar.setEnabled(false);
									 progressBar.setVisible(true);
								
									EditarFuncionario editar_funcionario = new EditarFuncionario(funcionario);
									editar_funcionario.setVisible(true);
									updateProgress();
									
									}
								}.start();
								
													 
							
							 
						}catch(Exception erro){
							JOptionPane.showMessageDialog(null,"Atenção é necessário selecionar um Funcionario!");
							 erro_null = 1;
						}
						
						
						
					}
				});
				btnEditar.setBounds(805, 53, 89, 23);
				contentPane.add(btnEditar);
				
				JButton btnExcluir = new JButton("Excluir");
				btnExcluir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					int linha = 0;
					String valor_string = null;
					Object valor = null;
					int erro_null = 0;
				try{		
					 linha =	table.getSelectedRow(); //retorna um inteiro  
					 valor = table.getValueAt(linha,0);   					
					 valor_string = (String)valor;
				}catch(Exception erro){
					JOptionPane.showMessageDialog(null,"Atenção é necessário selecionar um Funcionario!");
					 erro_null = 1;
				}
				
				try{
					if(erro_null != 1){
					//fachada_funcionario.excluir(Integer.parseInt(valor_string));
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.removeRow(linha);
					table.revalidate();
					
					JOptionPane.showMessageDialog(null,"Funcionario Excluído com Sucesso!");
					}
				}catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
					}
				});
				
				
				
				btnExcluir.setBounds(917, 53, 89, 23);
				contentPane.add(btnExcluir);
				
				JLabel lblPesquisarCnpj = new JLabel("Pesquisar  - CPF:");
				lblPesquisarCnpj.setBounds(10, 57, 125, 14);
				contentPane.add(lblPesquisarCnpj);
				
				final JFormattedTextField cpf = new JFormattedTextField();
				
				try {
					cpf_format = new MaskFormatter("###.###.###-##");
				} catch (ParseException e1) {
					e1.printStackTrace();
				}  
		        cpf.setFormatterFactory(new DefaultFormatterFactory(cpf_format));
				
				cpf.setBounds(142, 55, 108, 20);
				contentPane.add(cpf);
				
		
				btnPesquisar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
						new Thread(){
							@Override
							public void run() {
						
								progressBarPesquisar.setVisible(true);
					/*
					 * Verificando se o CNPJ est� vazio		
					 */
					if(cpf.getText().equals("   .   .   -  ")){
						
						//removendo linhas
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						//Lista todos os funcionarioes
						lista_funcionario = new ArrayList<Funcionario>(fachada_funcionario.listar());
						 for (Funcionario funcionario : lista_funcionario) {    
							
							 model.addRow(new String[]{funcionario.getId().toString(), 
          		      			   funcionario.getCpf(),
          		      			   funcionario.getNome(),
          		      			   funcionario.getMatricula(),
          		      			   funcionario.getEmail(),
          		      			   funcionario.getTelefone(),
          		      			   funcionario.getUsuario(),
          		      			   funcionario.getDepartamento().getNome(),
          		      			   funcionario.getEndereco().getLogradouro(),
          		      			   funcionario.getEndereco().getCidade(),
          		      			   funcionario.getEndereco().getNumero().toString(),
          		      			   funcionario.getEndereco().getEstado(),
          		      			   
          		 		});  
				         }
						 table.setModel(model);
						 updateProgressPesquisar();
					}else{
					//removendo linhas
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
				
					//listando	
					lista_funcionario = new ArrayList<Funcionario>(fachada_funcionario.consultarCPF(cpf.getText()));
					
					 for (Funcionario funcionario : lista_funcionario) {    
						
						 model.addRow(new String[]{funcionario.getId().toString(), 
      		      			   funcionario.getCpf(),
      		      			   funcionario.getNome(),
      		      			   funcionario.getMatricula(),
      		      			   funcionario.getEmail(),
      		      			   funcionario.getTelefone(),
      		      			   funcionario.getUsuario(),
      		      			   funcionario.getDepartamento().getNome(),
      		      			   funcionario.getEndereco().getLogradouro(),
      		      			   funcionario.getEndereco().getCidade(),
      		      			   funcionario.getEndereco().getNumero().toString(),
      		      			   funcionario.getEndereco().getEstado(),
      		      			   
      		 		});  
			       }
					 
					 	if(model.getRowCount() <= 0){
					 		JOptionPane.showMessageDialog(null,"Nenhum Funcionario Encontrado!");
					 	}
					 		table.setModel(model);
							updateProgressPesquisar();
							cpf.setText("");
							
							}
							}//fim do if	 
						}.start();
					
					}
				});
				
				
				
				btnPesquisar.setBounds(308, 53, 108, 23);
				contentPane.add(btnPesquisar);
				
				
				progressBarPesquisar.setBounds(308, 37, 108, 14);
				contentPane.add(progressBarPesquisar);
				
				
				
	}
	private void updateProgress() {
		  SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		      // Here, we can safely update the GUI
		      // because we'll be called from the
		      // event dispatch thread
		    	btnEditar.setEnabled(true);
				progressBar.setVisible(false);
				
		        dispose();
				
		    }
		  });
	}
	
	private void updateProgressPesquisar() {
		  SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		      // Here, we can safely update the GUI
		      // because we'll be called from the
		      // event dispatch thread
		    	btnPesquisar.setEnabled(true);
				progressBarPesquisar.setVisible(false);
				
				
		    }
		  });
	}
}