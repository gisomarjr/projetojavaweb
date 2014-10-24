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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;

import com.vendas.basicas.Fornecedor;
import com.vendas.fachada.FFornecedor;

public class ConsultarFornecedor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modeloTable;

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
		setBounds(100, 100, 724, 440);
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
				
				String [] colunas = {"ID", "Razão Social", "Nome Fantasia", "CNPJ"};
				
				Object [][] dados = null;//{ {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com", "" }};
				//ArrayList<Fornecedor> lista_fornecedor = new ArrayList<Fornecedor>();
				
				//Object [][] dados = {{fornecedor.getId().toString() , fornecedor.getRazaoSocial(), fornecedor.getNomeFantasia(),fornecedor.getCnpj()}};
				//for (Fornecedor fornecedor : lista_fornecedor){
					//lista_fornecedor.add(fornecedor);
					//
					//dadoss = dados;
				//}
				
				
				FFornecedor fachada_fornecedor = new FFornecedor();
				
				
				for (Fornecedor fornecedor : fachada_fornecedor.listar()){
					
					Object [][] dado = {{fornecedor.getId(), 
										 fornecedor.getRazaoSocial(), 
										 fornecedor.getNomeFantasia(), 
										 fornecedor.getCnpj()}};
					dados = dado;
										
					//JOptionPane.showMessageDialog(null,fornecedor.getRazaoSocial());
				} 
				
				
				table = new JTable(dados, colunas);
				table.setBounds(10, 71, 688, 296);
				contentPane.add(table);

	}
}
