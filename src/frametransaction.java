import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JLabel;


public class frametransaction extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	JLabel label ;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frametransaction frame = new frametransaction();
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
	public frametransaction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 247, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton boton = new JButton("Transaction");
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					InsertDataDemo insert = new InsertDataDemo();
					label.setText("Succes!!!");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					label.setText("Error");
				}
				
				
			}
		});
		boton.setAction(action);
		boton.setBounds(34, 44, 160, 76);
		contentPane.add(boton);
		
		 label = new JLabel("-Estado-");
		label.setBounds(84, 11, 75, 22);
		contentPane.add(label);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
