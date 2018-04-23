package board.veiw;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NoticeContent extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public NoticeContent() {

		setBounds(0, 0, 1000, 640);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 10, 950, 588);
		add(panel);
			
		
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(84, 137, 793, 382);
		panel.add(scrollPane_1);
		
		btnNewButton = new JButton("\uBAA9\uB85D");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBorder(new LineBorder(Color.RED));
		btnNewButton.setBounds(94, 529, 142, 49);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("   Subject");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 21, 119, 29);
		panel.add(lblNewLabel);
		
		JLabel lblId = new JLabel("   ID");
		lblId.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		lblId.setBounds(12, 60, 119, 29);
		panel.add(lblId);
		
		JLabel label_1 = new JLabel("   \uB0A0\uC9DC");
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		label_1.setBounds(12, 99, 119, 29);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(84, 21, 793, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(84, 60, 793, 29);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(84, 99, 793, 29);
		panel.add(textField_2);
		
//		panel.add(table);
		

	}
}
