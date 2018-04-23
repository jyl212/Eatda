package pos.veiw;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import login.view.MainFrame;
import pos.listener.SalesViewListener;

public class SalesView extends JPanel {
	public JTable calctable;
	public MainFrame frame;
	public JButton btnSelect;
	public JButton calc_close;
	public JTextField tfCash;
	public JTextField tfCard;
	public JTextField tfTotal;
	public JRadioButton man;
	public JRadioButton woman;
	public JRadioButton all;
	public Vector<String> colName;
	public JPanel panel;
	public JDateChooser dtcStart;
	public JDateChooser dtcEnd;
	public JComboBox calroot;

	/**
	 * Create the panel.
	 */
	public SalesView() {
		setBackground(Color.WHITE);
		setSize(1008,653);
		Color co=new Color(243,50,11);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("~");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(276, 39, 51, 15);
		add(lblNewLabel_1);
		
		ButtonGroup group1=new ButtonGroup();
		man = new JRadioButton("  \uB0A8\uC790");
		man.setFont(new Font("±¼¸²", Font.BOLD, 17));
		man.setBackground(Color.WHITE);
		man.setBounds(168, 85, 84, 23);
		add(man);
		
		woman = new JRadioButton("  \uC5EC\uC790");
		woman.setFont(new Font("±¼¸²", Font.BOLD, 17));
		woman.setBackground(Color.WHITE);
		woman.setBounds(260, 85, 84, 23);
		add(woman);
		
		all = new JRadioButton("  \uC804\uCCB4");
		all.setFont(new Font("±¼¸²", Font.BOLD, 17));
		all.setBackground(Color.WHITE);
		all.setBounds(70, 85, 84, 23);
		all.setSelected(true);
		add(all);
		group1.add(man);
		group1.add(woman);
		group1.add(all);
		
		btnSelect = new JButton();
		btnSelect.setText("\uC870\uD68C");
		btnSelect.setForeground(Color.WHITE);
		btnSelect.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnSelect.setFocusPainted(false);
		btnSelect.setBackground(new Color(243, 50, 11));
		btnSelect.setBounds(580, 35, 102, 27);
		add(btnSelect);
		
		panel = new JPanel();
		panel.setBounds(29, 137, 434, 481);
		add(panel);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 128));
		panel_1.setBounds(485, 137, 486, 414);
		add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
		);
		
		calctable = new JTable();
		calctable.setShowHorizontalLines(false);
		colName=new Vector<String>();
		colName.add("¸Þ´º");
		colName.add("°¡°Ý");
		colName.add("°Å·¡ÀÏ½Ã");
		colName.add("°áÁ¦¹æ¹ý");
		colName.add("¼ºº°");
		colName.add("¿¹¾àÀÚ");
		scrollPane.setViewportView(calctable);
		panel_1.setLayout(gl_panel_1);
		
		SalesViewListener listener = new SalesViewListener(this);
		
		calc_close = new JButton();
		calc_close.setText("\uC885 \uB8CC");
		calc_close.setForeground(Color.WHITE);
		calc_close.setFont(new Font("±¼¸²", Font.BOLD, 17));
		calc_close.setFocusPainted(false);
		calc_close.setBackground(new Color(243, 50, 11));
		calc_close.setBounds(702, 35, 102, 27);
		calc_close.addActionListener(listener);
		add(calc_close);
		
		calroot = new JComboBox();
		calroot.setModel(new DefaultComboBoxModel(new String[] {"\uACB0\uC7AC\uBC29\uBC95", "\uD604\uAE08", "\uCE74\uB4DC"}));
		calroot.setBounds(393, 87, 118, 21);
		add(calroot);
		
		dtcStart = new JDateChooser();
		dtcStart.setBounds(70, 35, 206, 27);
		add(dtcStart);
		
		dtcEnd = new JDateChooser();
		dtcEnd.setBounds(329, 35, 206, 27);
		add(dtcEnd);
		
		JLabel lblCash = new JLabel("\uD604\uAE08");
		lblCash.setHorizontalAlignment(SwingConstants.CENTER);
		lblCash.setFont(new Font("±¼¸²", Font.BOLD, 14));
		lblCash.setBounds(485, 573, 41, 33);
		lblCash.setOpaque(true);
		lblCash.setBackground(co);
		lblCash.setForeground(Color.white);
		add(lblCash);
		
		tfCash = new JTextField();
		tfCash.setBounds(538, 573, 102, 33);
		add(tfCash);
		tfCash.setColumns(10);
		
		JLabel lblCredit = new JLabel("\uCE74\uB4DC");
		lblCredit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCredit.setFont(new Font("±¼¸²", Font.BOLD, 14));
		lblCredit.setOpaque(true);
		lblCredit.setForeground(Color.WHITE);
		lblCredit.setBackground(new Color(243, 50, 11));
		lblCredit.setBounds(649, 573, 41, 33);
		add(lblCredit);
		
		tfCard = new JTextField();
		tfCard.setColumns(10);
		tfCard.setBounds(702, 573, 102, 33);
		add(tfCard);
		
		JLabel lblTotal = new JLabel("\uCD1D\uD569");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("±¼¸²", Font.BOLD, 14));
		lblTotal.setOpaque(true);
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setBackground(new Color(243, 50, 11));
		lblTotal.setBounds(816, 573, 41, 33);
		add(lblTotal);
		
		tfTotal = new JTextField();
		tfTotal.setColumns(10);
		tfTotal.setBounds(869, 573, 102, 33);
		add(tfTotal);
		StartEvent();
	}
	public void StartEvent(){
		SalesViewListener listener=new SalesViewListener(this);
		btnSelect.addActionListener(listener);
		calroot.addActionListener(listener);
		all.addItemListener(listener);
		man.addItemListener(listener);
		woman.addItemListener(listener);
		
	}

	public SalesView(MainFrame mainFrame) {
		this();
		frame = mainFrame;
	}
	
}
