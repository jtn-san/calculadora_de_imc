package imc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Imc extends JFrame {

	private JPanel contentPane;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Imc frame = new Imc();
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
	public Imc() {
		setAutoRequestFocus(false);
		setResizable(false);
		setTitle("C\u00E1lculo do IMC");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Imc.class.getResource("/icones/calc4.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sua altura:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(22, 64, 87, 20);
		contentPane.add(lblNewLabel);
		
		txtAltura = new JTextField();
		txtAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAltura.setBounds(119, 66, 136, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Seu peso:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(22, 100, 87, 20);
		contentPane.add(lblNewLabel_1);
		
		txtPeso = new JTextField();
		txtPeso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPeso.setBounds(119, 102, 136, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Resultado:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(60, 134, 99, 25);
		contentPane.add(lblNewLabel_2);
		
		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtResultado.setEditable(false);
		txtResultado.setBounds(154, 133, 126, 25);
		contentPane.add(txtResultado);
		txtResultado.setColumns(10);
		
		JButton btnCalculo = new JButton("New button");
		btnCalculo.setIcon(new ImageIcon(Imc.class.getResource("/icones/calc128px.png")));
		btnCalculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DecimalFormat formatador = new DecimalFormat("#0.00");
				double altura, peso, resultado;
				altura = Double.parseDouble(txtAltura.getText().replace(",", "."));
				peso = Double.parseDouble(txtPeso.getText().replace(",", "."));
				resultado = peso / (altura*altura);
				txtResultado.setText("" + formatador.format(resultado));
				if (resultado < 18.5) {
					JOptionPane.showMessageDialog(null, "ABAIXO DO PESO", "STATUS", JOptionPane.INFORMATION_MESSAGE);
				} else if (resultado >= 18.5 && resultado < 24.9) {
					JOptionPane.showMessageDialog(null, "PESO NORMAL", "STATUS", JOptionPane.INFORMATION_MESSAGE);
				} else if (resultado >= 24.9 && resultado < 29.9) {
					JOptionPane.showMessageDialog(null, "ACIMA DO PESO", "STATUS", JOptionPane.INFORMATION_MESSAGE);
				} else if (resultado >= 29.9 && resultado < 39.9) {
					JOptionPane.showMessageDialog(null, "OBESIDADE", "STATUS", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "OBESIDADE GRAVE", "STATUS", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCalculo.setBounds(42, 169, 128, 128);
		contentPane.add(btnCalculo);
		
		JButton btnLimpar = new JButton("New button");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAltura.setText(null);
				txtPeso.setText(null);
				txtResultado.setText(null);
			}
		});
		btnLimpar.setIcon(new ImageIcon(Imc.class.getResource("/icones/apagar_128px.png")));
		btnLimpar.setBounds(267, 169, 128, 128);
		contentPane.add(btnLimpar);
		
		JButton btnNewButton_2 = new JButton("Sobre");
		btnNewButton_2.setToolTipText("Sobre o aplicativo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Calculadora do IMC ver. 1.0\nAutor: Jonathan", "Sobre", JOptionPane.DEFAULT_OPTION);
			}
		});
		btnNewButton_2.setBounds(305, 81, 106, 25);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ajudando voc\u00EA a descobrir seu IMC");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_3.setBounds(130, 13, 202, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Imc.class.getResource("/icones/imc.png")));
		lblNewLabel_4.setBounds(0, 3, 64, 48);
		contentPane.add(lblNewLabel_4);
	}
}
