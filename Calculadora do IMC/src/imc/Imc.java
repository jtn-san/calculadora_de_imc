package imc;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
//import javax.swing.SwingConstants;

public class Imc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAltura;
	private JTextField txtPeso;
	private JTextField txtResultado;
	private JLabel lblStatus;

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
		setBounds(100, 100, 465, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sua altura:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 66, 87, 20);
		contentPane.add(lblNewLabel);
		
		txtAltura = new JTextField();
		txtAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAltura.setBounds(107, 66, 64, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Seu peso:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 97, 87, 20);
		contentPane.add(lblNewLabel_1);
		
		txtPeso = new JTextField();
		txtPeso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPeso.setBounds(107, 97, 64, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Resultado:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(31, 134, 99, 25);
		contentPane.add(lblNewLabel_2);
		
		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtResultado.setEditable(false);
		txtResultado.setBounds(140, 133, 126, 25);
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
				if (resultado < 17) {
					lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imc1.png")));
					//JOptionPane.showMessageDialog(null, "MUITO ABAIXO DO PESO", "STATUS", JOptionPane.INFORMATION_MESSAGE);
				} else if (resultado >= 17 && resultado <= 18.49) {
					lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imc2.png")));
					//JOptionPane.showMessageDialog(null, "ABAIXO DO PESO", "STATUS", JOptionPane.INFORMATION_MESSAGE);
				} else if (resultado >= 18.5 && resultado <= 24.99) {
					lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imc3.png")));
					//JOptionPane.showMessageDialog(null, "PESO NORMAL", "STATUS", JOptionPane.INFORMATION_MESSAGE);
				} else if (resultado >= 25 && resultado < 29.99) {
					lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imc4.png")));
					//JOptionPane.showMessageDialog(null, "ACIMA DO PESO", "STATUS", JOptionPane.INFORMATION_MESSAGE);
				} else if (resultado >= 30 && resultado < 34.99) {
					lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imc5.png")));
					//JOptionPane.showMessageDialog(null, "OBESIDADE I", "STATUS", JOptionPane.INFORMATION_MESSAGE);
				} else if (resultado >= 35 && resultado < 39.99) {
					lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imc6.png")));
					//JOptionPane.showMessageDialog(null, "OBESIDADE II", "STATUS", JOptionPane.INFORMATION_MESSAGE);
				} else {
					lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imc7.png")));
					//JOptionPane.showMessageDialog(null, "OBESIDADE GRAVE", "STATUS", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnCalculo.setBounds(10, 170, 128, 128);
		contentPane.add(btnCalculo);
		
		JButton btnLimpar = new JButton("New button");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAltura.setText(null);
				txtPeso.setText(null);
				txtResultado.setText(null);
				lblStatus.setIcon(new ImageIcon(Imc.class.getResource("/icones/imc0.png")));
			}
		});
		btnLimpar.setIcon(new ImageIcon(Imc.class.getResource("/icones/apagar_128px.png")));
		btnLimpar.setBounds(154, 170, 138, 128);
		contentPane.add(btnLimpar);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.setToolTipText("Sobre o aplicativo");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Calculadora do IMC ver. 2.0\nAutor: Jonathan", "Sobre", JOptionPane.DEFAULT_OPTION);
			}
		});
		btnSobre.setBounds(95, 309, 82, 25);
		contentPane.add(btnSobre);
		
		JLabel lblNewLabel_3 = new JLabel("Ajudando voc\u00EA a descobrir seu IMC");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_3.setBounds(85, 13, 202, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Imc.class.getResource("/icones/imc.png")));
		lblNewLabel_4.setBounds(0, 3, 64, 48);
		contentPane.add(lblNewLabel_4);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Imc.class.getResource("/icones/imc0.png")));
		lblStatus.setBounds(302, 34, 150, 300);
		contentPane.add(lblStatus);
	}
}