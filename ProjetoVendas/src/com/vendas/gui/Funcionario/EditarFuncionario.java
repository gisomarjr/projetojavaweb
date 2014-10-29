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

import com.vendas.basicas.Departamento;
import com.vendas.basicas.Endereco;
import com.vendas.basicas.Fornecedor;
import com.vendas.basicas.Funcionario;
import com.vendas.fachada.FDepartamento;
import com.vendas.fachada.FEndereco;
import com.vendas.fachada.FFuncionario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class EditarFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textMatricula;
	ImageIcon loading = new ImageIcon("loading.gif");
	JLabel lblCarregando = new JLabel("Validando Funcionário... ", loading, JLabel.CENTER);
	JProgressBar progressBar = new JProgressBar();
	final JButton btnSalvar = new JButton("Salvar");
	final JFormattedTextField cpf = new JFormattedTextField();
	String status;
	MaskFormatter cpf_format;
	List<Departamento> lista_departamento;
	Departamento departamento;
	Funcionario funcionario_editar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarFuncionario frame = new EditarFuncionario();
					frame.setVisible(true);
					//desabilitando o botáo maximizar
					frame.setResizable(false);
					frame.setTitle("Cadastro de Funcionário");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 
	 final JLabel label = new JLabel("Validando Funcionário... ", loading, JLabel.CENTER);
	 private JTextField textUsuario;
	 
	 private JTextField textEmail;
	 private JTextField textLogradouro;
	 private JTextField textCidade;
	 private JTextField textNumero;
	/**
	 * Create the frame.
	 */
	public EditarFuncionario(){}
	public EditarFuncionario(Funcionario funcionario) {
		this.funcionario_editar = funcionario;
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 558, 515);
		contentPane = new JPanel();
		
		//Tela centralizada
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		  setLocation((tela.width-this.getSize().width)/2,   
                  (tela.height-this.getSize().height)/2);
		   
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeFuncionario = new JLabel("Cadastro de Funcionário");
		lblCadastroDeFuncionario.setBounds(144, 11, 280, 29);
		contentPane.add(lblCadastroDeFuncionario);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 45, 109, 23);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(129, 45, 307, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(10, 90, 81, 29);
		contentPane.add(lblMatricula);
		
		textMatricula = new JTextField();
		textMatricula.setBounds(129, 88, 86, 20);
		contentPane.add(textMatricula);
		textMatricula.setColumns(10);
		
		JLabel lblcpf = new JLabel("CPF:");
		lblcpf.setBounds(225, 84, 34, 29);   
		contentPane.add(lblcpf);
		
		
		cpf.setBounds(269, 88, 109, 20);
		try {
			cpf_format = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}  
        cpf.setFormatterFactory(new DefaultFormatterFactory(cpf_format));
		contentPane.add(cpf);
		
		
		
		btnSalvar.setBounds(347, 431, 130, 29);
		contentPane.add(btnSalvar);
		
		
		lblCarregando.setBounds(99, 379, 378, 16);
		contentPane.add(lblCarregando);
		
		
		progressBar.setBounds(223, 406, 148, 14);
		progressBar.setIndeterminate(true);
		progressBar.setVisible(false);
		contentPane.add(progressBar);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(10, 185, 81, 14);
		contentPane.add(lblUsurio);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(129, 175, 117, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(256, 178, 51, 21);
		contentPane.add(lblSenha);
		
		
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(5, 224, 114, 14);
		contentPane.add(lblDepartamento);
		
		//Carregando o departamento
		FDepartamento fachada_departamento = new FDepartamento();
		lista_departamento = new ArrayList<Departamento>(fachada_departamento.listar());
		ArrayList<String> lista = new ArrayList<String>();
		 for (Departamento departamento : lista_departamento) { 
			 this.departamento = departamento;
			 lista.add(departamento.getNome());
		 }
		
		JComboBox comboBoxDepartamento = new JComboBox(lista.toArray());
		comboBoxDepartamento.setBounds(129, 221, 113, 20);
		contentPane.add(comboBoxDepartamento);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 140, 86, 14);
		contentPane.add(lblTelefone);
		
		final JFormattedTextField telefone = new JFormattedTextField();
		telefone.setBounds(129, 131, 86, 20);
		contentPane.add(telefone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(223, 133, 46, 14);
		contentPane.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(267, 130, 167, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 386, 232, -104);
		contentPane.add(separator);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setBounds(10, 264, 109, 14);
		contentPane.add(lblLogradouro);
		
		textLogradouro = new JTextField();
		textLogradouro.setBounds(129, 262, 307, 20);
		contentPane.add(textLogradouro);
		textLogradouro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 305, 95, 14);
		contentPane.add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setBounds(127, 303, 86, 20);
		contentPane.add(textCidade);
		textCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(223, 306, 72, 14);
		contentPane.add(lblEstado);
		
		String listaEstado [] = {"PE", "SP"}; 
		final JComboBox comboBoxEstado = new JComboBox(listaEstado);
	
		
		
		comboBoxEstado.setBounds(311, 302, 95, 20);
		contentPane.add(comboBoxEstado);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(18, 350, 46, 14);
		contentPane.add(lblCep);
		
		final JFormattedTextField cep = new JFormattedTextField();
		cep.setBounds(127, 340, 86, 20);
		contentPane.add(cep);
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setBounds(223, 343, 86, 17);
		contentPane.add(lblNmero);
		
		textNumero = new JTextField();
		textNumero.setBounds(318, 334, 46, 20);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		lblCarregando.setVisible(false);
		
		
		
		/*
		 * Adicionando os valores no Formulario
		 */
		cpf.setText(funcionario.getCpf());
		textMatricula.setText(funcionario.getMatricula());
		textNome.setText(funcionario.getNome());
		textEmail.setText(funcionario.getEmail());
		telefone.setText(funcionario.getTelefone());
		textUsuario.setText(funcionario.getUsuario());
		departamento = funcionario.getDepartamento();
		cep.setText(funcionario.getEndereco().getCep());
		textCidade.setText(funcionario.getEndereco().getCidade());
		comboBoxEstado.setSelectedItem(funcionario.getEndereco().getEstado());
		textLogradouro.setText(funcionario.getEndereco().getLogradouro());
		textNumero.setText(funcionario.getEndereco().getNumero().toString());
		
		//Fim Adicionar
		
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				new Thread(){
					@Override
					public void run() {
						lblCarregando.setVisible(true);
						progressBar.setVisible(true);
						btnSalvar.setEnabled(false);
						Funcionario funcionario = new Funcionario();
						Endereco 	endereco	= new Endereco();
						funcionario.setCpf(cpf.getText());
						funcionario.setMatricula(textMatricula.getText());
						funcionario.setNome(textNome.getText());
						funcionario.setEmail(textEmail.getText());
						funcionario.setTelefone(telefone.getText());
						funcionario.setUsuario(textUsuario.getText());
						//funcionario.setSenha(passwordField.getText());
						funcionario.setDepartamento(departamento);
						
						endereco.setCep(cep.getText());
						endereco.setCidade(textCidade.getText());
						endereco.setEstado(comboBoxEstado.getSelectedItem().toString());
						endereco.setLogradouro(textLogradouro.getText());
						endereco.setNumero(Integer.parseInt(textNumero.getText()));
						endereco.setFuncionario(funcionario);
						
						
						FFuncionario fachada_Funcionario = new FFuncionario();
						FEndereco    fachada_endereco    = new FEndereco();
						try {
							status = fachada_Funcionario.validaCampo(funcionario);
							
							if(status == ""){
								 //Cadastrar Funcionário
							 fachada_Funcionario.editar(funcionario);
							 fachada_endereco.editar(endereco);
					         cpf.setText("");
							 textMatricula.setText("");
							 textNome.setText("");
							 //Cadastrar Endereço
							
							
							 status = "Funcionario Cadastrado com Sucesso!";
					         JOptionPane.showMessageDialog(null,status);
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
