package board.veiw;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Write extends JPanel {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	public JButton btnOk;
	public JButton btnCancle;

	/**
	 * Create the panel.
	 */
	public Write() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBounds(0, 0, 1000, 640);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setBounds(17, 67, 100, 25);
		add(lblSubject);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(135, 67, 200, 25);
		add(textField_1);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(17, 102, 100, 25);
		add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(135, 102, 200, 25);
		add(textField_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setBorder(new LineBorder(Color.BLACK));
		textArea.setBounds(17, 137, 971, 418);
		add(textArea);
		
		JLabel labPass = new JLabel("Password");
		labPass.setHorizontalAlignment(SwingConstants.RIGHT);
		labPass.setBounds(17, 570, 100, 25);
		add(labPass);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(135, 570, 200, 25);
		add(textField);
		
		JLabel lblSecret = new JLabel("Secret");
		lblSecret.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSecret.setBounds(343, 570, 100, 25);
		add(lblSecret);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uACF5\uAC1C");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(459, 571, 121, 23);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uBE44\uACF5\uAC1C");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setBounds(585, 571, 121, 23);
		add(rdbtnNewRadioButton_1);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setBackground(Color.RED);
		btnOk.setBorder(new LineBorder(Color.red));
		btnOk.setForeground(Color.WHITE);
		btnOk.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btnOk.setBounds(713, 565, 125, 30);
		add(btnOk);
		
		btnCancle = new JButton("Cancel");
		btnCancle.setBackground(Color.RED);
		btnCancle.setForeground(Color.WHITE);
		btnCancle.setBorder(new LineBorder(Color.red));
		btnCancle.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btnCancle.setBounds(863, 565, 125, 30);
		add(btnCancle);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Notice\uAC8C\uC2DC\uD310", "Qa \uAC8C\uC2DC\uD310"}));
		comboBox.setToolTipText("\u3139\u3147\u3147");
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(17, 27, 151, 30);
		add(comboBox);
	}
}