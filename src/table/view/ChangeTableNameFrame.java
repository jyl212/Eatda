package table.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import table.listener.ChangeTableNameFrameListener;

public class ChangeTableNameFrame extends JFrame {

	private JPanel contentPane;
	public JTable table;
	public TableInsert insertPanel;
	public TableEdit editPanel;
	public JButton btnOk;
	public JButton btnCancle;

	/**
	 * Create the frame.
	 */
	public ChangeTableNameFrame(TableInsert insertPanel,TableEdit editPanel) {
		this.insertPanel = insertPanel;
		this.editPanel = editPanel;
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ChangeTableModel model = null;
		if (insertPanel != null){
			model = new ChangeTableModel(insertPanel.panel.getTableNameAndComent());
		} else if (editPanel != null) {
			model = new ChangeTableModel(editPanel.panel.getTableNameAndComent());
		}
		
		if (model != null){
			table = new JTable(model);
		} else {
			table = new JTable();
		}
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 48, 466, 170);
		contentPane.add(scrollPane);
		resizeColumnWidth(table); 
		
		btnOk = new JButton("\uD655\uC778");
		btnOk.setBounds(272, 228, 97, 23);
		contentPane.add(btnOk);
		
		btnCancle = new JButton("\uCDE8\uC18C");
		btnCancle.setBounds(381, 228, 97, 23);
		contentPane.add(btnCancle);
		
		JLabel lblNewLabel = new JLabel("\uD14C\uC774\uBE14 \uC774\uB984, \uC124\uBA85 \uC218\uC815");
		lblNewLabel.setBounds(12, 10, 210, 28);
		contentPane.add(lblNewLabel);
		
		ChangeTableNameFrameListener listener = new ChangeTableNameFrameListener(this);
		btnCancle.addActionListener(listener);
		btnOk.addActionListener(listener);
	}


	private void resizeColumnWidth(JTable table) { 
		final TableColumnModel columnModel = table.getColumnModel(); 
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 50; // Min width 
			for (int row = 0; row < table.getRowCount(); row++) { 
				TableCellRenderer renderer = table.getCellRenderer(row, column); 
				Component comp = table.prepareRenderer(renderer, row, column); 
				width = Math.max(comp.getPreferredSize().width +1 , width); 
			} 
			columnModel.getColumn(column).setPreferredWidth(width); 
		} 
	}
}
