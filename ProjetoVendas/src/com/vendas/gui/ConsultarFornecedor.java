package com.vendas.gui;

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

import com.vendas.basicas.Fornecedor;
import com.vendas.fachada.FFornecedor;

import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.xml.bind.ParseConversionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JProgressBar;

public class ConsultarFornecedor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Fornecedor fornecedor = new Fornecedor();
	final FFornecedor fachada_fornecedor = new FFornecedor();
	int linha = 0;
	String valor_string = null;
	Object valor = null;
	int erro_null = 0;
	final JButton btnEditar = new JButton("Editar");
	final JProgressBar progressBar = new JProgressBar();
	JProgressBar progressBarPesquisar = new JProgressBar();
	 DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new Object[]{"ID", "Razão", "Nome Fantasia", "CNPJ" });   
	 static ConsultarFornecedor consultar;
	 MaskFormatter cnpj_format;
	 List<Fornecedor> lista_fornecedor;
	 JButton btnPesquisar = new JButton("Pesquisar");
	/**
	 * Launch the application.
	 */
	
	 
	 
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarFornecedor frame = new ConsultarFornecedor();
					frame.setVisible(true);
					consultar = frame;
					//desabilitando o bot�o maximizar
					frame.setResizable(false);
					frame.setTitle("Consultar Fornecedor");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public ConsultarFornecedor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 724, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//Tela centralizada
				Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				  setLocation((tela.width-this.getSize().width)/2,   
		                  (tela.height-this.getSize().height)/2);
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblConsultarFornecedores = new JLabel("Consultar Fornecedores");
				lblConsultarFornecedores.setBounds(293, 11, 267, 14);
				contentPane.add(lblConsultarFornecedores);
							
				 lista_fornecedor = new ArrayList<Fornecedor>(fachada_fornecedor.listar());
				 for (Fornecedor fornecedor : lista_fornecedor) {    
					 this.fornecedor = fornecedor;
		             model.addRow(new String[]{fornecedor.getId().toString(), 
		            		      			   fornecedor.getRazaoSocial(),
		            		      			   fornecedor.getNomeFantasia(),
		            		      			   fornecedor.getCnpj()
		            		 		});    
		         }
			
                 
				table = new JTable(model);
				table.setBounds(10, 71, 688, 296);
				
				contentPane.add(table);
				
				
				progressBar.setBounds(498, 37, 89, 14);
				contentPane.add(progressBar);
				
				//Barra de Rolagem
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(10, 95, 688, 348);
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
									fornecedor = fachada_fornecedor.consultarID(Integer.parseInt(valor_string));
									 btnEditar.setEnabled(false);
									 progressBar.setVisible(true);
								
									 EditarFornecedor editar_fornecedor = new EditarFornecedor(fornecedor);
									 editar_fornecedor.setVisible(true);
									 updateProgress();
									
									}
								}.start();
								
													 
							
							 
						}catch(Exception erro){
							JOptionPane.showMessageDialog(null,"Atenção é necessário selecionar um Fornecedor!");
							 erro_null = 1;
						}
						
						
						
					}
				});
				btnEditar.setBounds(498, 53, 89, 23);
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
					JOptionPane.showMessageDialog(null,"Atenção é necessário selecionar um Fornecedor!");
					 erro_null = 1;
				}
				
				try{
					if(erro_null != 1){
					fachada_fornecedor.excluir(Integer.parseInt(valor_string));
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.removeRow(linha);
					table.revalidate();
					
					JOptionPane.showMessageDialog(null,"Fornecedor Excluído com Sucesso!");
					}
				}catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
					}
				});
				
				
				
				btnExcluir.setBounds(597, 53, 89, 23);
				contentPane.add(btnExcluir);
				
				JLabel lblPesquisarCnpj = new JLabel("Pesquisar  - CNPJ:");
				lblPesquisarCnpj.setBounds(10, 57, 125, 14);
				contentPane.add(lblPesquisarCnpj);
				
				final JFormattedTextField cnpj = new JFormattedTextField();
				
				try {
					cnpj_format = new MaskFormatter("##.###.###/####-##");
				} catch (ParseException e1) {
					e1.printStackTrace();
				}  
		        cnpj.setFormatterFactory(new DefaultFormatterFactory(cnpj_format));
				
				cnpj.setBounds(142, 55, 154, 20);
				contentPane.add(cnpj);
				
				
				btnPesquisar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					
						new Thread(){
							@Override
							public void run() {
						
								progressBarPesquisar.setVisible(true);
						
					//removendo linhas
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						 for (int i = 0; i < model.getRowCount(); i++) {
							model.removeRow(i);
						}
					//listando	
					 lista_fornecedor = new ArrayList<Fornecedor>(fachada_fornecedor.consultarCNPJ(cnpj.getText()));
					
					 for (Fornecedor fornecedor : lista_fornecedor) {    
						
			             model.addRow(new String[]{fornecedor.getId().toString(), 
			            		      			   fornecedor.getRazaoSocial(),
			            		      			   fornecedor.getNomeFantasia(),
			            		      			   fornecedor.getCnpj()
			            		 		});    
			         }
					 
					 	if(model.getRowCount() <= 0){
					 		JOptionPane.showMessageDialog(null,"Nenhum Fornecedor Encontrado!");
					 	}
					 		table.setModel(model);
							updateProgressPesquisar();
					
							
							}
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
