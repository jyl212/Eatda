package restaurant.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import login.view.MainFrame;
import restaurant.listener.NewRestaurantListener;
import zip.service.ZipService;
import zip.service.ZipServiceImpl;

public class NewRestaurant extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPanel contentPane;
	public JTextField txt_CompanyId;
	public JTextField txt_BusinessNummid;
	public JTextField txt_PhoneMid;
	public JTextField txt_BusinessNumPr;
	public JTextField txt_PhonePos;
	public JTextField txt_EmailPr;
	public JTextField txt_Mutual;
	public JTextField txt_BusinessNumPos;
	public JTextField txt_OperatingTimeSt;
	public JTextField txt_OperatingTimeEnd;
	public JTextField txt_Agent;
	public JPasswordField passwordFieldFr;
	public JPasswordField passwordFieldRe;
	public JTextField txt_CompanyAddr;
	public JTextField txt_CompanyImage1;
	public JTextField txt_CompanyImage2;
	public JButton btnCancel;
	public JButton btnNext;
	public MainFrame frame;
	public JTextField textField;
	public JTextArea taMISC;
	public JComboBox comboBox_Category;
	public JScrollPane scroll;
	String[] category = {"ÇÑ½Ä","Áß½Ä","¾ç½Ä","ÀÌÅ»¸®¾Æ ·¹½ºÅä¶û"};
	public JButton btn_OverlapCheack;
	public JButton btn_CompanyimgUpload1;
	public JButton btn_CompanyimgUpload2;
	public JComboBox cbo_sido;
	public JComboBox cbo_gungu;
	public NewRestaurant() {
		setSize(1008, 653);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC5C5\uCCB4\uB4F1\uB85D");
		lblNewLabel.setFont(new Font("ÈÞ¸Õ¿¾Ã¼", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(174, 10, 120, 34);
		add(lblNewLabel);
		
		JLabel label = new JLabel("* \uB294 \uD544\uC218\uC785\uB825\uC785\uB2C8\uB2E4.");
		label.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label.setForeground(Color.RED);
		label.setBounds(574, 29, 135, 15);
		add(label);
		
		JLabel lblNewLabel_1 = new JLabel("\uC5C5\uCCB4 ID");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(122, 74, 70, 25);
		add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_1.setBounds(122, 112, 92, 25);
		add(label_1);
		
		JLabel label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_2.setBounds(122, 167, 130, 25);
		add(label_2);
		
		JLabel label_3 = new JLabel("\uC0C1 \uD638");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_3.setBounds(122, 205, 48, 25);
		add(label_3);
		
		JLabel label_4 = new JLabel("\uC0AC\uC5C5\uC790\uBC88\uD638");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_4.setBounds(122, 280, 109, 25);
		add(label_4);
		
		JLabel label_5 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_5.setBounds(122, 357, 81, 25);
		add(label_5);
		
		JLabel label_6 = new JLabel("\uC774\uBA54\uC77C");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_6.setBounds(122, 395, 64, 25);
		add(label_6);
		
		JLabel lblopen = new JLabel("\uB9E4\uC7A5\uC6B4\uC601\uC2DC\uAC04");
		lblopen.setForeground(Color.BLACK);
		lblopen.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		lblopen.setBounds(122, 433, 120, 25);
		add(lblopen);
		
		JLabel label_8 = new JLabel("\uC2DD\uB2F9\uC720\uD615");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_8.setBounds(122, 471, 81, 28);
		add(label_8);
		
		JLabel label_9 = new JLabel("*");
		label_9.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_9.setForeground(Color.RED);
		label_9.setBounds(201, 77, 10, 28);
		add(label_9);
		
		JLabel label_10 = new JLabel("*");
		label_10.setForeground(Color.RED);
		label_10.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_10.setBounds(210, 115, 10, 28);
		add(label_10);
		
		JLabel label_11 = new JLabel("*");
		label_11.setForeground(Color.RED);
		label_11.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_11.setBounds(253, 170, 10, 28);
		add(label_11);
		
		JLabel label_12 = new JLabel("*");
		label_12.setForeground(Color.RED);
		label_12.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_12.setBounds(170, 208, 10, 28);
		add(label_12);
		
		JLabel label_13 = new JLabel("*");
		label_13.setForeground(Color.RED);
		label_13.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_13.setBounds(232, 283, 10, 28);
		add(label_13);
		
		JLabel label_14 = new JLabel("*");
		label_14.setForeground(Color.RED);
		label_14.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_14.setBounds(204, 360, 10, 28);
		add(label_14);
		
		JLabel label_15 = new JLabel("*");
		label_15.setForeground(Color.RED);
		label_15.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_15.setBounds(188, 398, 10, 28);
		add(label_15);
		
		JLabel label_17 = new JLabel("*");
		label_17.setForeground(Color.RED);
		label_17.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_17.setBounds(207, 474, 10, 28);
		add(label_17);
		
		txt_CompanyId = new JTextField();
		txt_CompanyId.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		txt_CompanyId.setBounds(264, 74, 261, 25);
		add(txt_CompanyId);
		txt_CompanyId.setColumns(10);
		
		btn_OverlapCheack = new JButton("\uC911\uBCF5\uCCB4\uD06C");
		btn_OverlapCheack.setBounds(537, 74, 92, 25);
		add(btn_OverlapCheack);
		
		JLabel lblNewLabel_2 = new JLabel("\uC601\uBB38 \uB300\uC18C\uBB38\uC790/\uC22B\uC790/\uD2B9\uC218\uBB38\uC790 \uC911 2\uAC00\uC9C0 \uC774\uC0C1 \uC870\uD569, 10~16\uC790 \uC774\uB0B4");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 10));
		lblNewLabel_2.setBounds(264, 142, 304, 15);
		add(lblNewLabel_2);
		
		txt_BusinessNummid = new JTextField();
		txt_BusinessNummid.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		txt_BusinessNummid.setHorizontalAlignment(SwingConstants.CENTER);
		txt_BusinessNummid.setColumns(10);
		txt_BusinessNummid.setBounds(347, 280, 42, 25);
		add(txt_BusinessNummid);
		
		JLabel label_21 = new JLabel("-");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setForeground(Color.BLACK);
		label_21.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		label_21.setBounds(312, 357, 26, 25);
		add(label_21);
		
		txt_PhoneMid = new JTextField();
		txt_PhoneMid.setHorizontalAlignment(SwingConstants.CENTER);
		txt_PhoneMid.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		txt_PhoneMid.setColumns(10);
		txt_PhoneMid.setBounds(335, 357, 54, 25);
		add(txt_PhoneMid);
		
		txt_BusinessNumPr = new JTextField();
		txt_BusinessNumPr.setHorizontalAlignment(SwingConstants.CENTER);
		txt_BusinessNumPr.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		txt_BusinessNumPr.setColumns(10);
		txt_BusinessNumPr.setBounds(264, 280, 64, 25);
		add(txt_BusinessNumPr);
		
		txt_PhonePos = new JTextField();
		txt_PhonePos.setHorizontalAlignment(SwingConstants.CENTER);
		txt_PhonePos.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		txt_PhonePos.setColumns(10);
		txt_PhonePos.setBounds(416, 357, 48, 25);
		add(txt_PhonePos);
		
		JLabel label_22 = new JLabel("-");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setForeground(Color.BLACK);
		label_22.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		label_22.setBounds(389, 357, 26, 25);
		add(label_22);
		
		txt_EmailPr = new JTextField();
		txt_EmailPr.setHorizontalAlignment(SwingConstants.LEFT);
		txt_EmailPr.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		txt_EmailPr.setColumns(10);
		txt_EmailPr.setBounds(264, 395, 261, 25);
		add(txt_EmailPr);
		
		comboBox_Category = new JComboBox(category);

		comboBox_Category.setBackground(Color.WHITE);
		comboBox_Category.setBounds(264, 471, 135, 25);
		add(comboBox_Category);
		
		
		btnNext = new JButton("\uB2E4\uC74C\uB2E8\uACC4");
		btnNext.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		btnNext.setToolTipText("");
		btnNext.setBounds(493, 599, 109, 40);
		add(btnNext);
		
		btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.setToolTipText("");
		btnCancel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		btnCancel.setBounds(328, 599, 89, 40);
		add(btnCancel);
		
		txt_Mutual = new JTextField();
		txt_Mutual.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		txt_Mutual.setColumns(10);
		txt_Mutual.setBounds(264, 205, 261, 25);
		add(txt_Mutual);
		
		JLabel label_16 = new JLabel("-");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setForeground(Color.BLACK);
		label_16.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		label_16.setBounds(323, 280, 26, 25);
		add(label_16);
		
		JLabel label_18 = new JLabel("-");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setForeground(Color.BLACK);
		label_18.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		label_18.setBounds(388, 280, 26, 25);
		add(label_18);
		
		txt_BusinessNumPos = new JTextField();
		txt_BusinessNumPos.setHorizontalAlignment(SwingConstants.CENTER);
		txt_BusinessNumPos.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		txt_BusinessNumPos.setColumns(10);
		txt_BusinessNumPos.setBounds(410, 280, 90, 25);
		add(txt_BusinessNumPos);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_7.setBounds(242, 436, 10, 28);
		add(label_7);
		
		txt_OperatingTimeSt = new JTextField();
		txt_OperatingTimeSt.setHorizontalAlignment(SwingConstants.CENTER);
		txt_OperatingTimeSt.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		txt_OperatingTimeSt.setColumns(10);
		txt_OperatingTimeSt.setBounds(264, 433, 64, 25);
		add(txt_OperatingTimeSt);
		
		JLabel label_19 = new JLabel("~");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setForeground(Color.BLACK);
		label_19.setFont(new Font("¸¼Àº °íµñ Semilight", Font.BOLD, 20));
		label_19.setBounds(325, 433, 26, 25);
		add(label_19);
		
		txt_OperatingTimeEnd = new JTextField();
		txt_OperatingTimeEnd.setHorizontalAlignment(SwingConstants.CENTER);
		txt_OperatingTimeEnd.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		txt_OperatingTimeEnd.setColumns(10);
		txt_OperatingTimeEnd.setBounds(350, 433, 64, 25);
		add(txt_OperatingTimeEnd);
		
		JLabel label_20 = new JLabel("\uB300\uD45C\uC790");
		label_20.setForeground(Color.BLACK);
		label_20.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_20.setBounds(122, 243, 76, 25);
		add(label_20);
		
		JLabel label_24 = new JLabel("*");
		label_24.setForeground(Color.RED);
		label_24.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_24.setBounds(188, 246, 10, 28);
		add(label_24);
		
		txt_Agent = new JTextField();
		txt_Agent.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		txt_Agent.setColumns(10);
		txt_Agent.setBounds(264, 243, 261, 25);
		add(txt_Agent);
		
		JLabel label_25 = new JLabel("\uC774\uBBF8\uC9C0");
		label_25.setForeground(Color.BLACK);
		label_25.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_25.setBounds(122, 509, 64, 25);
		add(label_25);
		
		JLabel label_26 = new JLabel("*");
		label_26.setForeground(Color.RED);
		label_26.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_26.setBounds(188, 512, 10, 28);
		add(label_26);
		
		passwordFieldFr = new JPasswordField();
		passwordFieldFr.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		passwordFieldFr.setBounds(264, 112, 261, 25);
		add(passwordFieldFr);
		
		passwordFieldRe = new JPasswordField();
		passwordFieldRe.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		passwordFieldRe.setBounds(264, 167, 261, 25);
		add(passwordFieldRe);
		
		JLabel label_27 = new JLabel("\uC18C\uC7AC\uC9C0");
		label_27.setForeground(Color.BLACK);
		label_27.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_27.setBounds(122, 314, 64, 25);
		add(label_27);
		
		txt_CompanyAddr = new JTextField();
		txt_CompanyAddr.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		txt_CompanyAddr.setColumns(10);
		txt_CompanyAddr.setBounds(518, 315, 152, 25);
		add(txt_CompanyAddr);
		
		txt_CompanyImage1 = new JTextField();
		txt_CompanyImage1.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		txt_CompanyImage1.setBounds(264, 512, 261, 25);
		add(txt_CompanyImage1);
		txt_CompanyImage1.setColumns(10);
		
		btn_CompanyimgUpload1 = new JButton("\uC5C5\uCCB4\uC0AC\uC9C4 \uC5C5\uB85C\uB4DC1");
		btn_CompanyimgUpload1.setBounds(537, 512, 145, 25);
		add(btn_CompanyimgUpload1);
		
		txt_CompanyImage2 = new JTextField();
		txt_CompanyImage2.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		txt_CompanyImage2.setColumns(10);
		txt_CompanyImage2.setBounds(264, 544, 261, 25);
		add(txt_CompanyImage2);
		
		btn_CompanyimgUpload2 = new JButton("\uC5C5\uCCB4\uC0AC\uC9C4 \uC5C5\uB85C\uB4DC2");
		btn_CompanyimgUpload2.setBounds(537, 544, 145, 25);
		add(btn_CompanyimgUpload2);
		
		JLabel label_28 = new JLabel("*");
		label_28.setForeground(Color.RED);
		label_28.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		label_28.setBounds(188, 318, 10, 28);
		add(label_28);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(263, 357, 54, 25);
		add(textField);
		
		JLabel label_29 = new JLabel("\uC5C5\uCCB4\uC18C\uAC1C");
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setForeground(Color.BLACK);
		label_29.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_29.setBounds(637, 98, 109, 25);
		add(label_29);
		
		taMISC = new JTextArea();
		taMISC.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		scroll = new JScrollPane(taMISC);
		scroll.setBounds(637, 129, 320, 176);
		taMISC.setBackground(Color.LIGHT_GRAY);
		add(scroll);
		
		ZipService zipService = new ZipServiceImpl();
		
		cbo_sido = new JComboBox(zipService.getSIDO());
		cbo_sido.setBounds(264, 315, 64, 25);
		add(cbo_sido);
		
		cbo_gungu = new JComboBox(zipService.getGUGUN((String) cbo_sido.getItemAt(0)));
		cbo_gungu.setBounds(360, 315, 120, 25);
		add(cbo_gungu);
		
		JLabel lblNewLabel_3 = new JLabel("\uC2DC/\uB3C4");
		lblNewLabel_3.setBounds(328, 315, 42, 25);
		add(lblNewLabel_3);
		
		JLabel label_23 = new JLabel("\uAD70/\uAD6C");
		label_23.setBounds(485, 315, 42, 25);
		add(label_23);
		
		JLabel label_30 = new JLabel("\uB098\uBA38\uC9C0 \uC8FC\uC18C");
		label_30.setBounds(671, 315, 83, 25);
		add(label_30);
		
		startEvent();
	}
	private void startEvent() {

		NewRestaurantListener listener = new NewRestaurantListener(this);
		btnNext.addActionListener(listener);
		btnCancel.addActionListener(listener);
		btn_OverlapCheack.addActionListener(listener);
		btn_CompanyimgUpload1.addActionListener(listener);
		btn_CompanyimgUpload2.addActionListener(listener);
		cbo_sido.addActionListener(listener);
		
	}
	public NewRestaurant(MainFrame mainFrame) {
		this();
		frame = mainFrame;
	}
}
