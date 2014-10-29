package com.vendas.gui.Funcionario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
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
import java.text.ParseException;

import javax.swing.JProgressBar;

public class EditarFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textRazaoSocial;
	private JTextField textNomeFantasia;
	ImageIcon loading = new ImageIcon("loading.gif");
	JLabel lblCarregando = new JLabel("Validando Fornecedor... ", loading, JLabel.CENTER);
	JProgressBar progressBar = new JProgressBar();
	final JButton btnSalvar = new JButton("Atualizar");
	final JFormattedTextField cnpj = new JFormattedTextField();
	String status;
	MaskFormatter cnpj_format;
	FFornecedor fachada_fornecedor = new FFornecedor();
	Fornecedor fornecedor_editar;
	static EditarFuncionario frame ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new EditarFuncionario();
					
					frame.setVisible(true);
					
					//desabilitando o bot�o maximizar
					frame.setResizable(false);
					frame.setTitle("Editar Fornecedor");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 
	 final JLabel label = new JLabel("Atualizando Fornecedor... ", loading, JLabel.CENTER);
	/**
	 * Create the frame.
	 */
	 public EditarFuncionario(){}

	public EditarFuncionario(Fornecedor fornecedor) {
		
		
		this.fornecedor_editar = fornecedor;
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		//Tela centralizada
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		  setLocation((tela.width-this.getSize().width)/2,   
                  (tela.height-this.getSize().height)/2);
		   
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeFornecedor = new JLabel("Atualizar Fornecedor");
		lblCadastroDeFornecedor.setBounds(144, 11, 280, 29);
		contentPane.add(lblCadastroDeFornecedor);
		
		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social:");
		lblRazoSocial.setBounds(10, 45, 109, 23);
		contentPane.add(lblRazoSocial);
		
		textRazaoSocial = new JTextField();
		textRazaoSocial.setBounds(117, 46, 307, 20);
		contentPane.add(textRazaoSocial);
		textRazaoSocial.setColumns(10);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia");
		lblNomeFantasia.setBounds(10, 90, 109, 29);
		contentPane.add(lblNomeFantasia);
		
		textNomeFantasia = new JTextField();
		textNomeFantasia.setBounds(117, 94, 307, 20);
		contentPane.add(textNomeFantasia);
		textNomeFantasia.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(46, 131, 75, 29);   
		contentPane.add(lblCnpj);
		
		
		cnpj.setBounds(111, 136, 140, 20);
		try {
			cnpj_format = new MaskFormatter("##.###.###/####-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}  
        cnpj.setFormatterFactory(new DefaultFormatterFactory(cnpj_format));
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
			
		cnpj.setText(fornecedor_editar.getCnpj());
		textNomeFantasia.setText(fornecedor_editar.getNomeFantasia());
		textRazaoSocial.setText(fornecedor_editar.getRazaoSocial());
		
		
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				/*
				new Thread(){
					@Override
					public void run() {
						lblCarregando.setVisible(true);
						progressBar.setVisible(true);
						btnSalvar.setEnabled(false);
						*/
						try {
							Fornecedor formulario_editar = new Fornecedor();
							formulario_editar.setCnpj(cnpj.getText());
							formulario_editar.setNomeFantasia(textNomeFantasia.getText());
							formulario_editar.setRazaoSocial(textRazaoSocial.getText());
							formulario_editar.setId(fornecedor_editar.getId());
							status = fachada_fornecedor.validaCampo(formulario_editar);
							
							if(status == ""){
					        							
							fachada_fornecedor.atualizar(formulario_editar);
					         status = "Fornecedor Atualizado com Sucesso!";
					         JOptionPane.showMessageDialog(null,status);
							
							
							}else{
								JOptionPane.showMessageDialog(null,status);
								
							}
							updateProgress();
							
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,e.getMessage());
							
						}
					/*
					}
				}.start();
				
			}*/
			}
		}
	);
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
				dispose();
				ConsultarFuncionario c = new ConsultarFuncionario();
				c.setVisible(true);
				
				
		    }
		  });
		  
		}
	
	
}