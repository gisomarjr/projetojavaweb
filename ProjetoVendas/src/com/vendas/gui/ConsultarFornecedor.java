package com.vendas.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;

import com.vendas.basicas.Fornecedor;
import com.vendas.fachada.FFornecedor;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class ConsultarFornecedor extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarFornecedor frame = new ConsultarFornecedor();
					frame.setVisible(true);
					//desabilitando o botão maximizar
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
							
				
				FFornecedor fachada_fornecedor = new FFornecedor();
				ArrayList<Fornecedor> lista_fornecedor = new ArrayList<Fornecedor>(fachada_fornecedor.listar());
				
				 DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new Object[]{"ID", "Razão", "Nome Fantasia", "CNPJ" });   
				 
				    
                 for (Fornecedor fornecedor : lista_fornecedor) {    
                     model.addRow(new String[]{fornecedor.getId().toString(), 
                    		      			   fornecedor.getRazaoSocial(),
                    		      			   fornecedor.getNomeFantasia(),
                    		      			   fornecedor.getCnpj()
                    		 		});    
                 }
               
                 
				table = new JTable(model);
				table.setBounds(10, 71, 688, 296);
				
				contentPane.add(table);
				
				//Barra de Rolagem
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(10, 95, 688, 348);
				contentPane.add(scrollPane);
				
				JButton btnEditar = new JButton("Editar");
				btnEditar.setBounds(498, 53, 89, 23);
				contentPane.add(btnEditar);
				
				JButton btnExcluir = new JButton("Excluir");
				btnExcluir.setBounds(597, 53, 89, 23);
				contentPane.add(btnExcluir);
				
				JLabel lblPesquisarCnpj = new JLabel("Pesquisar  - CNPJ:");
				lblPesquisarCnpj.setBounds(10, 57, 108, 14);
				contentPane.add(lblPesquisarCnpj);
				
				JFormattedTextField formattedTextField = new JFormattedTextField();
				formattedTextField.setBounds(128, 54, 154, 20);
				contentPane.add(formattedTextField);
				
				JButton btnPesquisar = new JButton("Pesquisar");
				btnPesquisar.setBounds(292, 53, 108, 23);
				contentPane.add(btnPesquisar);
				
	}
}
