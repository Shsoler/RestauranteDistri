package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jms.CriaProduto;
import objetos.Pedido;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;
import java.awt.event.ActionEvent;

public class TelaPedido {

	private JFrame frame;
	private JTextField txtPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPedido window = new TelaPedido();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox<String> cmbLanche = new JComboBox<String>();
		cmbLanche.setBounds(23, 34, 145, 24);
		frame.getContentPane().add(cmbLanche);
		
		JComboBox<String> cmbBebida = new JComboBox<String>();
		cmbBebida.setBounds(23, 101, 150, 24);
		frame.getContentPane().add(cmbBebida);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 39, 208, 153);
		frame.getContentPane().add(scrollPane);
		
		JTextArea txtObs = new JTextArea();
		scrollPane.setViewportView(txtObs);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(23, 169, 150, 24);
		frame.getContentPane().add(txtPreco);
		txtPreco.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				if(txtPreco.getText().equals("") ){
					JOptionPane.showMessageDialog(frame, "Adicionar Valor");
				}else{
					Pedido ped = new Pedido(cmbLanche.getSelectedItem().toString(),cmbBebida.getSelectedItem().toString(),txtObs.getText()
							,Double.valueOf(txtPreco.getText()),gerarData());
					CriaProduto pp = new CriaProduto();
					pp.Enviar(ped);
				}
				}catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(frame,"Preço é valor numérico somente");
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnEnviar.setBounds(34, 238, 117, 25);
		frame.getContentPane().add(btnEnviar);
		
		JLabel lblLanche = new JLabel("Lanche");
		lblLanche.setBounds(12, 12, 70, 15);
		frame.getContentPane().add(lblLanche);
		
		JLabel lblBebida = new JLabel("Bebida");
		lblBebida.setBounds(12, 74, 70, 15);
		frame.getContentPane().add(lblBebida);
		
		JLabel lblPreo = new JLabel("Preço");
		lblPreo.setBounds(12, 142, 70, 15);
		frame.getContentPane().add(lblPreo);
		
		JLabel lblObs = new JLabel("Obs");
		lblObs.setBounds(227, 12, 70, 15);
		frame.getContentPane().add(lblObs);
		
		PopulaCmb(cmbLanche,cmbBebida);
	}

	protected Date gerarData() {
		Date data = new Date();
		try {
			Socket cliente = new Socket("127.0.0.1",5555);
			ObjectInputStream doServer = new ObjectInputStream(cliente.getInputStream());
			data = (Date) doServer.readObject();
			cliente.close();
			return data;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	private void PopulaCmb(JComboBox<String> cmbLanche, JComboBox<String> cmbBebida) {
		String[] lanches = {"Cachorro Quente","CheeseBurguer","CheeseBacon","CheeseSalada","Bauru"};
		String[] bebidas = {"Coca-Cola lata","Coca-Cola 2L","Pepsi Lata","Pepsi 2L","Suco de Laranja","Suco de abacaxi"};
		
		for (String string : lanches) {
			cmbLanche.addItem(string);
		}
		for (String string : bebidas) {
			cmbBebida.addItem(string);
		}
		
	}
}
