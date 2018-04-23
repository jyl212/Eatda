package customer.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import customer.listener.EditCustomerListener;
import customer.service.MemeberService;
import customer.service.MemeberServiceimpl;
import dto.MemberDTO;
import login.view.MainFrame;
import utill.JTextFieldLimit;

public class EditCustomer extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPanel contentPane;
	public JTextField txt_BirthMM;
	public JTextField txt_PhoneMid;
	public JTextField txt_BirthDD;
	public JTextField txt_BirthYY;
	public JTextField txt_PhoneBt;
	public JTextField txt_EmailPr;
	public JPasswordField passwordFieldFr;
	public JPasswordField passwordFieldRe;
	public MainFrame frame;
	public JTextField txt_phonefr;
	public JLabel lblNewLabel;
	public JButton btn_UpdateCommit;
	public JButton btn_Cancel;
	String[] addr = {"°­¿ø","°æ±â","°æ³²","°æºÏ","±¤ÁÖ","´ë±¸","´ëÀü","ºÎ»ê","¼­¿ï","¿ï»ê","ÀÎÃµ","Àü³²","ÀüºÏ","Á¦ÁÖ","Ãæ³²","ÃæºÏ"};
	public JTextField text_name;
	public JLabel lbl_customId;
	ButtonGroup group1 = new ButtonGroup();
	public JRadioButton rdo_GenderW;
	public JRadioButton rdo_GenderM;
	public JCheckBox chck_Email_agree;
	public JComboBox comboBox_local;
	public EditCustomer() {
	
		
		setSize(1008, 652);
		
		setBackground(Color.WHITE);
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLayout(null);
		
		JLabel lblMemberInfo = new JLabel("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		lblMemberInfo.setFont(new Font("ÈÞ¸Õ¿¾Ã¼", Font.BOLD, 26));
		lblMemberInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberInfo.setBounds(244, 24, 165, 34);
		
		add(lblMemberInfo);
		
		JLabel lblcustomerId = new JLabel("\uACE0\uAC1D ID");
		lblcustomerId.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lblcustomerId.setForeground(Color.BLACK);
		lblcustomerId.setBounds(213, 83, 76, 28);
		
		add(lblcustomerId);
		
		JLabel label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_1.setBounds(213, 121, 89, 28);
		
		add(label_1);
		
		JLabel label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_2.setBounds(213, 178, 128, 28);
		
		add(label_2);
		
		JLabel label_3 = new JLabel("\uC131 \uBCC4");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_3.setBounds(213, 257, 64, 28);
		
		add(label_3);
		
		JLabel label_4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_4.setBounds(213, 295, 89, 28);
		
		add(label_4);
		
		JLabel label_5 = new JLabel("\uD734\uB300\uC804\uD654");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_5.setBounds(213, 336, 89, 28);
		
		add(label_5);
		
		JLabel label_6 = new JLabel("\uC774\uBA54\uC77C");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_6.setBounds(213, 381, 64, 28);
		
		add(label_6);
		
		JLabel label_7 = new JLabel("\uC774\uBA54\uC77C \uC218\uC2E0\uC5EC\uBD80");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_7.setBounds(213, 420, 149, 28);
		
		add(label_7);
		
		JLabel label_8 = new JLabel("\uC9C0 \uC5ED");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_8.setBounds(213, 461, 76, 28);
		
		add(label_8);
		
		JLabel lblNewLabel_2 = new JLabel("\uC601\uBB38 \uB300\uC18C\uBB38\uC790/\uC22B\uC790/\uD2B9\uC218\uBB38\uC790 \uC911 2\uAC00\uC9C0 \uC774\uC0C1 \uC870\uD569, 10~16\uC790 \uC774\uB0B4");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 10));
		lblNewLabel_2.setBounds(355, 151, 319, 15);
		
		add(lblNewLabel_2);
		
		rdo_GenderM = new JRadioButton("\uB0A8\uC790");
		rdo_GenderM.setBackground(Color.WHITE);
		rdo_GenderM.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		rdo_GenderM.setBounds(355, 256, 71, 33);
		
		add(rdo_GenderM);
		
		rdo_GenderW = new JRadioButton("\uC5EC\uC790");
		rdo_GenderW.setBackground(Color.WHITE);
		rdo_GenderW.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		rdo_GenderW.setBounds(453, 255, 71, 33);
		
		add(rdo_GenderW);
		
		group1.add(rdo_GenderM);
		group1.add(rdo_GenderW);
		JLabel label_18 = new JLabel("\uB144");
		label_18.setForeground(Color.BLACK);
		label_18.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		label_18.setBounds(448, 295, 26, 28);
		
		add(label_18);
		
		txt_BirthMM = new JTextField();
		txt_BirthMM.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		txt_BirthMM.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_BirthMM.setColumns(10);
		txt_BirthMM.setBounds(478, 295, 42, 28);
		
		add(txt_BirthMM);
		
		JLabel label_19 = new JLabel("\uC6D4");
		label_19.setForeground(Color.BLACK);
		label_19.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		label_19.setBounds(525, 295, 26, 28);
		
		add(label_19);
		
		JLabel label_20 = new JLabel("\uC77C");
		label_20.setForeground(Color.BLACK);
		label_20.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		label_20.setBounds(603, 295, 26, 28);
		
		add(label_20);
		
		JLabel label_21 = new JLabel("-");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setForeground(Color.BLACK);
		label_21.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		label_21.setBounds(404, 336, 26, 28);
		
		add(label_21);
		
		txt_PhoneMid = new JTextField();
		txt_PhoneMid.setHorizontalAlignment(SwingConstants.CENTER);
		txt_PhoneMid.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		txt_PhoneMid.setColumns(10);
		txt_PhoneMid.setBounds(432, 336, 54, 28);
		
		add(txt_PhoneMid);
		
		txt_BirthDD = new JTextField();
		txt_BirthDD.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_BirthDD.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		txt_BirthDD.setColumns(10);
		txt_BirthDD.setBounds(559, 295, 42, 28);
		
		add(txt_BirthDD);
		
		txt_BirthYY = new JTextField();
		txt_BirthYY.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_BirthYY.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		txt_BirthYY.setColumns(10);
		txt_BirthYY.setBounds(355, 295, 89, 28);
		
		add(txt_BirthYY);
		
		txt_PhoneBt = new JTextField();
		txt_PhoneBt.setHorizontalAlignment(SwingConstants.CENTER);
		txt_PhoneBt.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		txt_PhoneBt.setColumns(10);
		txt_PhoneBt.setBounds(503, 336, 48, 28);
		
		add(txt_PhoneBt);
		
		JLabel label_22 = new JLabel("-");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setForeground(Color.BLACK);
		label_22.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		label_22.setBounds(481, 336, 26, 28);
		
		add(label_22);
		
		txt_EmailPr = new JTextField();
		txt_EmailPr.setHorizontalAlignment(SwingConstants.LEFT);
		txt_EmailPr.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		txt_EmailPr.setColumns(10);
		txt_EmailPr.setBounds(355, 381, 251, 31);
		
		add(txt_EmailPr);
		
		chck_Email_agree = new JCheckBox("\uB3D9\uC758\uD568");
		chck_Email_agree.setBackground(Color.WHITE);
		chck_Email_agree.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		chck_Email_agree.setHorizontalAlignment(SwingConstants.CENTER);
		chck_Email_agree.setBounds(355, 423, 76, 28);
		
		add(chck_Email_agree);
		
		JLabel lblNewLabel_3 = new JLabel("\uBCF8 \uC0AC\uC774\uD2B8\uC5D0\uC11C \uC81C\uACF5\uD558\uB294 \uC720\uC775\uD55C \uC774\uBCA4\uD2B8 \uC18C\uC2DD\uC744 \uC774\uBA54\uC77C\uB85C \uBC1B\uC73C\uC2E4 \uC218 \uC788\uC2B5\uB2C8\uB2E4.");
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 10));
		lblNewLabel_3.setBounds(434, 432, 390, 15);
		
		add(lblNewLabel_3);
		
		comboBox_local = new JComboBox(addr);
		comboBox_local.setBackground(Color.WHITE);
		comboBox_local.setBounds(355, 465, 89, 28);
		
		add(comboBox_local);
		
		btn_Cancel = new JButton("\uCDE8\uC18C");
		btn_Cancel.setToolTipText("");
		btn_Cancel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		btn_Cancel.setBounds(569, 567, 89, 42);
		
		add(btn_Cancel);
		
		btn_UpdateCommit = new JButton("\uC218\uC815\uC644\uB8CC");
		btn_UpdateCommit.setToolTipText("");
		btn_UpdateCommit.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		btn_UpdateCommit.setBounds(404, 567, 109, 42);
		
		add(btn_UpdateCommit);
		
		lbl_customId = new JLabel("id(\uC218\uC815\uBD88\uAC00)");
		lbl_customId.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		lbl_customId.setBounds(355, 83, 261, 28);
		
		add(lbl_customId);
		
		passwordFieldFr = new JPasswordField();
		passwordFieldFr.setHorizontalAlignment(SwingConstants.LEFT);
		passwordFieldFr.setBounds(355, 121, 251, 28);
		
		add(passwordFieldFr);
		
		passwordFieldRe = new JPasswordField();
		passwordFieldRe.setHorizontalAlignment(SwingConstants.LEFT);
		passwordFieldRe.setBounds(353, 182, 251, 28);
		
		add(passwordFieldRe);
		
		txt_phonefr = new JTextField();
		txt_phonefr.setHorizontalAlignment(SwingConstants.CENTER);
		txt_phonefr.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		txt_phonefr.setColumns(10);
		txt_phonefr.setBounds(355, 336, 54, 28);
		add(txt_phonefr);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(0, -25, 179, 720);
		lblNewLabel.setOpaque(true);
		add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setOpaque(true);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(845, -25, 179, 720);
		add(label);
		
		JLabel label_9 = new JLabel("\uC774 \uB984");
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_9.setBounds(213, 219, 64, 28);
		add(label_9);
		
		text_name = new JTextField();
		text_name.setHorizontalAlignment(SwingConstants.LEFT);
		text_name.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		text_name.setColumns(10);
		text_name.setBounds(355, 226, 89, 28);
		add(text_name);

		startEvent();
	}
	private void startEvent() {
		EditCustomerListener listener = new EditCustomerListener(this);
		btn_Cancel.addActionListener(listener);
		btn_UpdateCommit.addActionListener(listener);
		
	}
	public EditCustomer(MainFrame mainFrame) {
		this();
		frame = mainFrame;

		memberSelect();
	}
	public void memberSelect(){
		MemeberService service = new MemeberServiceimpl();
	    MemberDTO memberdetail = service.memberSelect(frame.ID);
//	    String memberid = "campion3";
	    if(memberdetail==null){
	    	JOptionPane.showMessageDialog(this, "¿À·ù ¹ß»ý");
	    } else {
	    	lbl_customId.setText(memberdetail.getMemId());
	    	text_name.setText(memberdetail.getMemName());
	    	String[] birth = memberdetail.getBirth().split("/");
	    	txt_BirthYY.setText(birth[0]);
	    	txt_BirthMM.setText(birth[1]);
	    	txt_BirthDD.setText(birth[2]);
	    	if(memberdetail.getGender().equals("³²")){
	    		rdo_GenderM.setSelected(true);
	    	} else {
	    		rdo_GenderW.setSelected(true);
	    	}
	    	String[] tell = memberdetail.getMemTel().split("-");
	    	txt_phonefr.setText(tell[0]);
	    	txt_PhoneMid.setText(tell[1]);
	    	txt_PhoneBt.setText(tell[2]);
	    	txt_EmailPr.setText(memberdetail.getEmail());
	    	if(memberdetail.getEmailCheck().equals("Y")){
	    		chck_Email_agree.setSelected(true);
	    	} else {
	    		chck_Email_agree.setSelected(false);
	    	}
	    	comboBox_local.setSelectedItem(memberdetail.getLoc());
	    }
	    	
	}
}
