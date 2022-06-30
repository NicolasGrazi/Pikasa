package IU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfazinicio extends JFrame {

	private JPanel contentPane;
	private JTextField txtBienvenido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazinicio frame = new interfazinicio();
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
	public interfazinicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtBienvenido = new JTextField();
		txtBienvenido.setBounds(28, 11, 350, 34);
		txtBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		txtBienvenido.setText("Bienvenido ");
		contentPane.add(txtBienvenido);
		txtBienvenido.setColumns(10);
		
		JButton btnNewButton = new JButton("Conteiner");
		btnNewButton.setBounds(28, 121, 146, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Almacen");
		btnNewButton_1.setBounds(211, 114, 167, 62);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_1);
	}

}
