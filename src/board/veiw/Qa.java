package board.veiw;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Qa extends JPanel {
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Qa() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1000, 640);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 1000, 640);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		add(panel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC81C\uBAA9", "\uB0B4\uC6A9", "\uC544\uC774\uB514"}));
		comboBox.setToolTipText("\u3139\u3147\u3147");
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		comboBox.setBorder(new LineBorder(Color.RED));
		comboBox.setBackground(Color.RED);
		comboBox.setBounds(32, 548, 125, 30);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.BLACK));
		textField.setBounds(174, 548, 250, 30);
		panel.add(textField);
		
		JButton button = new JButton("Search");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		button.setBorder(new LineBorder(Color.RED));
		button.setBackground(Color.RED);
		button.setBounds(436, 548, 125, 30);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(Color.WHITE));
		panel_1.setBounds(12, 10, 946, 528);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		String columnNames[] = {
				"No", "Á¦¸ñ", "ID", "³¯Â¥", "Á¶È¸¼ö"
		};
		
		Object data[][] = {
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null},
				{null,null,null,null,null}
		};
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"No", "\uC81C\uBAA9", "ID", "\uB0A0\uC9DC", "\uC870\uD68C\uC218"
			}
		));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"No", "\uC81C\uBAA9", "ID", "\uB0A0\uC9DC", "\uC870\uD68C\uC218"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMinWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(450);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setMinWidth(10);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setMinWidth(10);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 922, 508);
		panel_1.add(scrollPane);
		table.setRowHeight(45);
		
		//table.setBounds(12, 10, 922, 508);
		//panel_1.add(table);
		

	}
}
