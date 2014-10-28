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

import com.vendas.gui.Fornecedor.CadastrarFornecedor;
import com.vendas.gui.Fornecedor.ConsultarFornecedor;

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
					//desabilitando o botï¿½o maximizar
					frame.setResizable(false);
					frame.setTitle("Área Interna");
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
		setBounds(100, 100, 554, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//Tela centralizada
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		  setLocation((tela.width-this.getSize().width)/2,   
                  (tela.height-this.getSize().height)/2);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Cadastrar Fornecedor");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarFornecedor cadastrar_fornecedor = new CadastrarFornecedor();
				cadastrar_fornecedor.setVisible(true);
			}
		});
		button.setBounds(50, 61, 190, 70);
		contentPane.add(button);
		
		progressBar.setIndeterminate(true);
		progressBar.setVisible(false);
		progressBar.setBounds(332, 43, 190, 14);
		contentPane.add(progressBar);
		btnConsultarFornecedor.setBounds(332, 61, 190, 70);
		contentPane.add(btnConsultarFornecedor);
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
