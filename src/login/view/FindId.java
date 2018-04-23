package login.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import login.listener.FindIdListener;
import javax.swing.SwingConstants;

public class FindId extends JPanel {
	public JTextField txtname;
	public JTextField txtemail;
	public JTextField txttel1;
	public JTextField txttel2;
	public MainFrame frame;
	public JButton btnok;
	public JLabel lblFindResult;
	public JButton btnFind;
	public JComboBox comType;
	public JTextField txttel0;

	/**
	 * Create the panel.
	 */
	public FindId() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1008, 653);
		
		JLabel lbltype = new JLabel("Type");
		lbltype.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lbltype.setBounds(238, 284, 120, 40);
		add(lbltype);
		
		comType = new JComboBox();
		comType.setForeground(Color.BLACK);
		comType.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		comType.setModel(new DefaultComboBoxModel(new String[] {"\uAC1C\uC778\uD68C\uC6D0", "\uC5C5\uCCB4\uD68C\uC6D0"}));
		comType.setBounds(496, 285, 200, 40);
		add(comType);
		
		JLabel lblname = new JLabel("\uC774\uB984");
		lblname.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lblname.setBounds(238, 342, 120, 40);
		add(lblname);
		
		JLabel lblemail = new JLabel("E-Mail");
		lblemail.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lblemail.setBounds(238, 392, 120, 40);
		add(lblemail);
		
		JLabel lbltel = new JLabel("\uC804\uD654\uBC88\uD638");
		lbltel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lbltel.setBounds(238, 442, 120, 40);
		add(lbltel);
		
		txtname = new JTextField();
		txtname.setBounds(496, 335, 200, 40);
		add(txtname);
		txtname.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(496, 389, 200, 40);
		add(txtemail);
		
		txttel1 = new JTextField();
		txttel1.setColumns(10);
		txttel1.setBounds(485, 442, 90, 40);
		add(txttel1);
		
		txttel2 = new JTextField();
		txttel2.setColumns(10);
		txttel2.setBounds(606, 442, 90, 40);
		add(txttel2);
		
		JLabel lbl1 = new JLabel(" -");
		lbl1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		lbl1.setBounds(574, 442, 20, 40);
		add(lbl1);
		
		btnok = new JButton("Ok");
		btnok.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnok.setBounds(561, 504, 135, 50);
		add(btnok);
		
		btnFind = new JButton("Find");
		btnFind.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnFind.setBounds(386, 504, 135, 50);
		add(btnFind);
		
		lblFindResult = new JLabel("");
		lblFindResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblFindResult.setBounds(237, 156, 459, 69);
		lblFindResult.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		add(lblFindResult);
		
		txttel0 = new JTextField();
		txttel0.setColumns(10);
		txttel0.setBounds(364, 442, 90, 40);
		add(txttel0);
		
		JLabel label = new JLabel(" -");
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		label.setBounds(453, 442, 20, 40);
		add(label);
		
		startEvent();

	}

	private void startEvent() {
		FindIdListener listener = new FindIdListener(this);
		btnok.addActionListener(listener);
		btnFind.addActionListener(listener);
		
	}

	public FindId(MainFrame mainFrame) {
		this();
		frame = mainFrame;
	}
}
