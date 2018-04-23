package login.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import login.listener.FindPassWordListener;

public class FindPassWord extends JPanel {
	public JTextField txtname;
	public JTextField txtemail;
	public JTextField txttel1;
	public JTextField txttel2;
	public JTextField txtid;
	public MainFrame frame;
	public JButton btnCancle;
	public JTextField txttel0;
	public JComboBox comType;
	public JButton btnFind;
	public JButton btnOk;
	public JLabel label_1;
	public JLabel label_2;
	public JTextField txtNewPWcf;
	public JTextField txtNewPW;
	public JPanel pEditPW;

	/**
	 * Create the panel.
	 */
	public FindPassWord() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1008, 653);
		
		JLabel lbltype = new JLabel("Type");
		lbltype.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lbltype.setBounds(266, 225, 120, 40);
		add(lbltype);
		
		comType = new JComboBox();
		comType.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		comType.setModel(new DefaultComboBoxModel(new String[] {"\uAC1C\uC778\uD68C\uC6D0", "\uC5C5\uCCB4\uD68C\uC6D0"}));
		comType.setBounds(524, 226, 200, 40);
		comType.setBackground(Color.WHITE);
		add(comType);
		
		JLabel lblname = new JLabel("\uC774\uB984");
		lblname.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lblname.setBounds(266, 330, 120, 40);
		add(lblname);
		
		JLabel lblemail = new JLabel("E-Mail");
		lblemail.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lblemail.setBounds(266, 380, 120, 40);
		add(lblemail);
		
		JLabel lbltel = new JLabel("\uC804\uD654\uBC88\uD638");
		lbltel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lbltel.setBounds(266, 430, 120, 40);
		add(lbltel);
		
		txtname = new JTextField();
		txtname.setBounds(524, 323, 200, 40);
		add(txtname);
		txtname.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(524, 377, 200, 40);
		add(txtemail);
		
		txttel1 = new JTextField();
		txttel1.setColumns(10);
		txttel1.setBounds(513, 430, 90, 40);
		add(txttel1);
		
		txttel2 = new JTextField();
		txttel2.setColumns(10);
		txttel2.setBounds(634, 430, 90, 40);
		add(txttel2);
		
		JLabel lbl1 = new JLabel(" -");
		lbl1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		lbl1.setBounds(602, 430, 20, 40);
		add(lbl1);
		
		btnCancle = new JButton("Cancle");
		btnCancle.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnCancle.setBackground(new Color(255, 255, 255));
		btnCancle.setBounds(589, 492, 135, 50);
		add(btnCancle);
		
		JLabel lblid = new JLabel("ID");
		lblid.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lblid.setBounds(266, 280, 120, 40);
		add(lblid);
		
		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(524, 276, 200, 40);
		add(txtid);
		
		txttel0 = new JTextField();
		txttel0.setColumns(10);
		txttel0.setBounds(392, 430, 90, 40);
		add(txttel0);
		
		JLabel label = new JLabel(" -");
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		label.setBounds(481, 430, 20, 40);
		add(label);
		
		btnFind = new JButton("Find");
		btnFind.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnFind.setBackground(Color.WHITE);
		btnFind.setBounds(442, 492, 135, 50);
		add(btnFind);
		
		pEditPW = new JPanel();
		pEditPW.setBounds(226, 40, 546, 185);
		add(pEditPW);
		pEditPW.setLayout(null);
		
		label_1 = new JLabel("\uC0C8 \uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_1.setBounds(38, 135, 182, 40);
		pEditPW.add(label_1);
		
		label_2 = new JLabel("\uC0C8 \uBE44\uBC00\uBC88\uD638");
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_2.setBounds(38, 87, 182, 40);
		pEditPW.add(label_2);
		
		txtNewPWcf = new JTextField();
		txtNewPWcf.setColumns(10);
		txtNewPWcf.setBounds(298, 135, 200, 40);
		pEditPW.add(txtNewPWcf);
		
		txtNewPW = new JTextField();
		txtNewPW.setColumns(10);
		txtNewPW.setBounds(298, 87, 200, 40);
		pEditPW.add(txtNewPW);
		
		pEditPW.setOpaque(false);
		pEditPW.setVisible(false);
		
		btnOk = new JButton("Ok");
		btnOk.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		btnOk.setBackground(Color.WHITE);
		btnOk.setBounds(295, 492, 135, 50);
		add(btnOk);
		btnOk.setVisible(false);
		
		startEvent();

	}

	private void startEvent() {
		FindPassWordListener listener = new FindPassWordListener(this);
		btnCancle.addActionListener(listener);
		btnFind.addActionListener(listener);
		btnOk.addActionListener(listener);
		
	}

	public FindPassWord(MainFrame mainFrame) {
		this();
		frame = mainFrame;
	}
}
