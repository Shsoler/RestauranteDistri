package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import jms.listaPedido;
import objetos.Pedido;

import javax.jms.JMSException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Pedidos {

	private JFrame frame;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedidos window = new Pedidos();
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
	public Pedidos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		


		
		JButton btnFeito = new JButton("Feito");
		btnFeito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFeito.setEnabled(false);
				((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
				redefiniTabela();
			}
		});
		btnFeito.setEnabled(false);
		btnFeito.setBounds(148, 267, 117, 25);
		frame.getContentPane().add(btnFeito);
		try {
			listaPedido.Listar();
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table = new JTable();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){	
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnFeito.setEnabled(true);
				
			}
		});
		table.setBounds(12, 12, 416, 229);
		frame.getContentPane().add(table);
		popularTabela();
	}

	protected void redefiniTabela() {
		ArrayList<Pedido> novoPedidos = new ArrayList<Pedido>();
		for(int linha = 0; linha < table.getRowCount();linha++){
			Pedido ped = new Pedido(table.getValueAt(linha, 0).toString(),
					table.getValueAt(linha, 1).toString(),
					table.getValueAt(linha, 3).toString(),
					Double.valueOf(table.getValueAt(linha, 2).toString()));
			novoPedidos.add(ped);

		}
		listaPedido.pedidos.clear();
		listaPedido.pedidos = novoPedidos;
	}

	public static void popularTabela() {
		Object[][] matrizPedido = new Object[listaPedido.pedidos.size()][5];
		int counter = 0;
		for (Pedido ped : listaPedido.pedidos) {
			matrizPedido[counter][0] = ped.getLanche();
			matrizPedido[counter][1]= ped.getBebida();
			matrizPedido[counter][2]= ped.getPreco();
			matrizPedido[counter][3] = ped.getObs();
			counter++;
		}
		String[] indice = {"Lanche","Bebida","Preço","Obs"};
		
		table.setModel(new DefaultTableModel(matrizPedido,indice));
		

	}
	
}
