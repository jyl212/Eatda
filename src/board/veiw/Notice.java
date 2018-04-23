package board.veiw;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Notice extends JPanel {
	private JTextField textField;
	public JTable table;

	/**
	 * Create the panel.
	 */
	public Notice() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1000, 640);
		setLayout(null);
		
		JPanel NoticeSearch = new JPanel();
		NoticeSearch.setBackground(Color.WHITE);
		NoticeSearch.setLayout(null);
		NoticeSearch.setBounds(12, 10, 1000, 640);
		add(NoticeSearch);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC81C\uBAA9", "\uB0B4\uC6A9", "\uC544\uC774\uB514"}));
		comboBox.setToolTipText("\u3139\u3147\u3147");
		comboBox.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		comboBox.setBorder(new LineBorder(Color.RED));
		comboBox.setBounds(32, 548, 125, 30);
		comboBox.setBackground(Color.RED);
		NoticeSearch.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.BLACK));
		textField.setBounds(174, 548, 250, 30);
		NoticeSearch.add(textField);
		
		JButton button = new JButton("Search");
		button.setForeground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBackground(Color.RED);
		button.setBorder(new LineBorder(Color.RED));
		button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		button.setBounds(436, 548, 125, 30);
		NoticeSearch.add(button);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.WHITE));
		panel.setBounds(12, 10, 946, 528);
		NoticeSearch.add(panel);
		panel.setLayout(null);
		
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
		table = new JTable(data,columnNames);
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
		table.setRowHeight(45);
		//		table.setBounds(12, 10, 1025, 556);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 10, 922, 508);
		panel.add(scrollPane);
		
//		panel.add(table);
		


	}
}
