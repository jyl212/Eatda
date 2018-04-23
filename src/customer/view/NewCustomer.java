package customer.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout.Group;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import customer.listener.NewCustomerListener;
import login.view.MainFrame;

import javax.swing.border.BevelBorder;

public class NewCustomer extends JPanel {
	public JPanel contentPane;
	public JTextField txtCustomerId;
	public JTextField txt_BirthMM;
	public JTextField txt_PhoneMid;
	public JTextField txt_BirthDD;
	public JTextField txt_BirthYY;
	public JTextField txt_PhonePos;
	public JTextField txt_EmailPr;
	public JPasswordField passwordFieldFr;
	public JPasswordField passwordFieldRe;
	public JButton btnCheckDupel;
	public JButton btnCancel;
	public JButton btnSignUpCommit;
	public MainFrame frame;
	public JTextField txt_Phonefr;
	public JTextField txtcustomername;
	public JRadioButton rdo_GenderM;
	public JRadioButton rdo_GenderW;
	public JCheckBox chck_Email_agree;
	public JComboBox comboBox_local;
	ButtonGroup group1 = new ButtonGroup();
	String[] addr = {"°­¿ø","°æ±â","°æ³²","°æºÏ","±¤ÁÖ","´ë±¸","´ëÀü","ºÎ»ê","¼­¿ï","¿ï»ê","ÀÎÃµ","Àü³²","ÀüºÏ","Á¦ÁÖ","Ãæ³²","ÃæºÏ"};
	public NewCustomer() {
		setSize(1008, 652);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		setBackground(Color.WHITE);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setFont(new Font("ÈÞ¸Õ¿¾Ã¼", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(244, 29, 120, 34);
		add(lblNewLabel);
		
		JLabel label = new JLabel("* \uB294 \uD544\uC218\uC785\uB825\uC785\uB2C8\uB2E4.");
		label.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label.setForeground(Color.RED);
		label.setBounds(659, 48, 135, 15);
		add(label);
		
		JLabel lblNewLabel_1 = new JLabel("\uACE0\uAC1D ID");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(196, 100, 76, 28);
		add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_1.setBounds(196, 138, 89, 28);
		add(label_1);
		
		JLabel label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_2.setBounds(196, 195, 130, 28);
		add(label_2);
		
		JLabel label_3 = new JLabel("\uC131 \uBCC4");
		label_3.setLabelFor(lblNewLabel);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_3.setBounds(196, 273, 58, 28);
		add(label_3);
		
		JLabel label_4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_4.setBounds(196, 311, 89, 28);
		add(label_4);
		
		JLabel label_5 = new JLabel("\uD734\uB300\uC804\uD654");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_5.setBounds(196, 352, 89, 28);
		add(label_5);
		
		JLabel label_6 = new JLabel("\uC774\uBA54\uC77C");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_6.setBounds(196, 397, 71, 28);
		add(label_6);
		
		JLabel label_7 = new JLabel("\uC774\uBA54\uC77C \uC218\uC2E0\uC5EC\uBD80");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_7.setBounds(196, 436, 150, 28);
		add(label_7);
		
		JLabel label_8 = new JLabel("\uC9C0 \uC5ED");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_8.setBounds(196, 477, 58, 28);
		add(label_8);
		
		JLabel label_9 = new JLabel("*");
		label_9.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_9.setForeground(Color.RED);
		label_9.setBounds(275, 103, 10, 28);
		add(label_9);
		
		JLabel label_10 = new JLabel("*");
		label_10.setForeground(Color.RED);
		label_10.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_10.setBounds(286, 141, 10, 28);
		add(label_10);
		
		JLabel label_11 = new JLabel("*");
		label_11.setForeground(Color.RED);
		label_11.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_11.setBounds(317, 197, 10, 28);
		add(label_11);
		
		JLabel label_12 = new JLabel("*");
		label_12.setForeground(Color.RED);
		label_12.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_12.setBounds(244, 275, 10, 28);
		add(label_12);
		
		JLabel label_13 = new JLabel("*");
		label_13.setForeground(Color.RED);
		label_13.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_13.setBounds(275, 313, 10, 28);
		add(label_13);
		
		JLabel label_14 = new JLabel("*");
		label_14.setForeground(Color.RED);
		label_14.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_14.setBounds(275, 354, 10, 28);
		add(label_14);
		
		JLabel label_15 = new JLabel("*");
		label_15.setForeground(Color.RED);
		label_15.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_15.setBounds(256, 399, 10, 28);
		add(label_15);
		
		JLabel label_17 = new JLabel("*");
		label_17.setForeground(Color.RED);
		label_17.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_17.setBounds(244, 480, 10, 28);
		add(label_17);
		
		txtCustomerId = new JTextField();
		txtCustomerId.setBounds(338, 100, 261, 28);
		add(txtCustomerId);
		txtCustomerId.setColumns(10);
		
		btnCheckDupel = new JButton("\uC911\uBCF5\uCCB4\uD06C");
		btnCheckDupel.setBounds(611, 100, 92, 28);
		add(btnCheckDupel);
		
		JLabel lblNewLabel_2 = new JLabel("\uC601\uBB38 \uB300\uC18C\uBB38\uC790/\uC22B\uC790/\uD2B9\uC218\uBB38\uC790 \uC911 2\uAC00\uC9C0 \uC774\uC0C1 \uC870\uD569, 10~16\uC790 \uC774\uB0B4");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 10));
		lblNewLabel_2.setBounds(338, 168, 304, 15);
		add(lblNewLabel_2);
		
		rdo_GenderM = new JRadioButton("\uB0A8\uC790");
		rdo_GenderM.setBackground(Color.WHITE);
		rdo_GenderM.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		rdo_GenderM.setBounds(338, 267, 71, 33);
		group1.add(rdo_GenderM);
		add(rdo_GenderM);
		
		rdo_GenderW = new JRadioButton("\uC5EC\uC790");
		rdo_GenderW.setBackground(Color.WHITE);
		rdo_GenderW.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		rdo_GenderW.setBounds(431, 268, 71, 33);
		group1.add(rdo_GenderW);
		add(rdo_GenderW);
		
		JLabel label_18 = new JLabel("\uB144");
		label_18.setForeground(Color.BLACK);
		label_18.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		label_18.setBounds(431, 311, 26, 28);
		add(label_18);
		
		txt_BirthMM = new JTextField();
		txt_BirthMM.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		txt_BirthMM.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_BirthMM.setColumns(10);
		txt_BirthMM.setBounds(461, 311, 42, 28);
		add(txt_BirthMM);
		
		JLabel label_19 = new JLabel("\uC6D4");
		label_19.setForeground(Color.BLACK);
		label_19.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		label_19.setBounds(508, 311, 26, 28);
		add(label_19);
		
		JLabel label_20 = new JLabel("\uC77C");
		label_20.setForeground(Color.BLACK);
		label_20.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		label_20.setBounds(586, 311, 26, 28);
		add(label_20);
		
		JLabel label_21 = new JLabel("-");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setForeground(Color.BLACK);
		label_21.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		label_21.setBounds(387, 352, 26, 28);
		add(label_21);
		
		txt_PhoneMid = new JTextField();
		txt_PhoneMid.setHorizontalAlignment(SwingConstants.CENTER);
		txt_PhoneMid.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		txt_PhoneMid.setColumns(10);
		txt_PhoneMid.setBounds(411, 355, 54, 28);
		add(txt_PhoneMid);
		
		txt_BirthDD = new JTextField();
		txt_BirthDD.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_BirthDD.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		txt_BirthDD.setColumns(10);
		txt_BirthDD.setBounds(542, 311, 42, 28);
		add(txt_BirthDD);
		
		txt_BirthYY = new JTextField();
		txt_BirthYY.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_BirthYY.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		txt_BirthYY.setColumns(10);
		txt_BirthYY.setBounds(338, 311, 89, 28);
		add(txt_BirthYY);
		
		txt_PhonePos = new JTextField();
		txt_PhonePos.setHorizontalAlignment(SwingConstants.CENTER);
		txt_PhonePos.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		txt_PhonePos.setColumns(10);
		txt_PhonePos.setBounds(492, 355, 48, 28);
		add(txt_PhonePos);
		
		JLabel label_22 = new JLabel("-");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setForeground(Color.BLACK);
		label_22.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		label_22.setBounds(464, 352, 26, 28);
		add(label_22);
		
		txt_EmailPr = new JTextField();
		txt_EmailPr.setHorizontalAlignment(SwingConstants.LEFT);
		txt_EmailPr.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		txt_EmailPr.setColumns(10);
		txt_EmailPr.setBounds(338, 397, 261, 31);
		add(txt_EmailPr);
		
		chck_Email_agree = new JCheckBox("\uB3D9\uC758\uD568");
		chck_Email_agree.setBackground(Color.WHITE);
		chck_Email_agree.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		chck_Email_agree.setHorizontalAlignment(SwingConstants.CENTER);
		chck_Email_agree.setBounds(338, 439, 76, 28);
		add(chck_Email_agree);
		
		JLabel lblNewLabel_3 = new JLabel("\uBCF8 \uC0AC\uC774\uD2B8\uC5D0\uC11C \uC81C\uACF5\uD558\uB294 \uC720\uC775\uD55C \uC774\uBCA4\uD2B8 \uC18C\uC2DD\uC744 \uC774\uBA54\uC77C\uB85C \uBC1B\uC73C\uC2E4 \uC218 \uC788\uC2B5\uB2C8\uB2E4.");
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 10));
		lblNewLabel_3.setBounds(417, 448, 390, 15);
		add(lblNewLabel_3);
		
		comboBox_local = new JComboBox(addr);
		comboBox_local.setBackground(Color.WHITE);
		comboBox_local.setBounds(338, 480, 54, 28);
		add(comboBox_local);
		
		btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.setToolTipText("");
		btnCancel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		btnCancel.setBounds(552, 575, 89, 42);
		add(btnCancel);
		
		btnSignUpCommit = new JButton("\uAC00\uC785\uD558\uAE30");
		btnSignUpCommit.setToolTipText("");
		btnSignUpCommit.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		btnSignUpCommit.setBounds(387, 575, 109, 42);
		add(btnSignUpCommit);
		
		passwordFieldFr = new JPasswordField();
		passwordFieldFr.setHorizontalAlignment(SwingConstants.LEFT);
		passwordFieldFr.setBounds(338, 137, 261, 29);
		add(passwordFieldFr);
		
		passwordFieldRe = new JPasswordField();
		passwordFieldRe.setHorizontalAlignment(SwingConstants.LEFT);
		passwordFieldRe.setBounds(338, 195, 261, 29);
		add(passwordFieldRe);
		
		txt_Phonefr = new JTextField();
		txt_Phonefr.setHorizontalAlignment(SwingConstants.CENTER);
		txt_Phonefr.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		txt_Phonefr.setColumns(10);
		txt_Phonefr.setBounds(338, 356, 54, 28);
		add(txt_Phonefr);
		
		JLabel label_16 = new JLabel("");
		label_16.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_16.setVerticalAlignment(SwingConstants.TOP);
		label_16.setOpaque(true);
		label_16.setBackground(Color.LIGHT_GRAY);
		label_16.setBounds(0, 0, 179, 652);
		add(label_16);
		
		JLabel label_24 = new JLabel("");
		label_24.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_24.setVerticalAlignment(SwingConstants.TOP);
		label_24.setOpaque(true);
		label_24.setBackground(Color.LIGHT_GRAY);
		label_24.setBounds(845, 0, 163, 652);
		add(label_24);
		
		JLabel label_25 = new JLabel("\uC774 \uB984");
		label_25.setForeground(Color.BLACK);
		label_25.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_25.setBounds(196, 233, 58, 28);
		add(label_25);
		
		JLabel label_26 = new JLabel("*");
		label_26.setForeground(Color.RED);
		label_26.setFont(new Font("Dialog", Font.BOLD, 18));
		label_26.setBounds(244, 235, 10, 28);
		add(label_26);
		
		txtcustomername = new JTextField();
		txtcustomername.setColumns(10);
		txtcustomername.setBounds(338, 233, 100, 28);
		add(txtcustomername);
		
		JLabel lblNewLabel_4 = new JLabel("\uC2DC/\uB3C4");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(392, 480, 42, 28);
		add(lblNewLabel_4);
		
		startEvent();
	}
	private void startEvent() {
		NewCustomerListener listener = new NewCustomerListener(this);
		btnCancel.addActionListener(listener);
		btnSignUpCommit.addActionListener(listener);
		btnCheckDupel.addActionListener(listener);
		
	}
	public NewCustomer(MainFrame mainFrame) {
		this();
		frame = mainFrame;
	}
}
