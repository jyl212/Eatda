package restaurant.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import dto.RestDTO;
import login.view.MainFrame;
import restaurant.listener.EditRestaurantListener;
import restaurant.service.RestService;
import restaurant.service.RestServiceImpl;
import zip.service.ZipService;
import zip.service.ZipServiceImpl;

import javax.swing.JTextArea;

public class EditRestaurant extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPanel contentPane;
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
	public JTextField txtphonefr;
	public JTextArea taMISC;
	public JComboBox comboBox_Category;
	public JScrollPane scroll;
	String[] category = {"ÇÑ½Ä","Áß½Ä","¾ç½Ä","ÀÌÅ»¸®¾Æ ·¹½ºÅä¶û"};
	public JButton btn_CompanyimgUpload1;
	public JButton btn_CompanyimgUpload2;
	public JComboBox cbo_sido;
	public JComboBox cbo_gungu;
	public JLabel lbl_id;
	public RestDTO restinfo;
	public EditRestaurant() {
		setSize(1008, 653);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC5C5\uCCB4\uC815\uBCF4 \uC218\uC815");
		lblNewLabel.setFont(new Font("ÈÞ¸Õ¿¾Ã¼", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(174, 10, 215, 34);
		add(lblNewLabel);
		
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
		label_20.setBounds(122, 243, 70, 25);
		add(label_20);
		
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
		
		txtphonefr = new JTextField();
		txtphonefr.setHorizontalAlignment(SwingConstants.CENTER);
		txtphonefr.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 12));
		txtphonefr.setColumns(10);
		txtphonefr.setBounds(263, 357, 54, 25);
		add(txtphonefr);
		
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
		
		cbo_sido = new JComboBox();
		cbo_sido.setBounds(264, 315, 64, 25);
		add(cbo_sido);
		
		cbo_gungu = new JComboBox();
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
		
		lbl_id = new JLabel("\uC218\uC815\uBD88\uAC00");
		lbl_id.setBounds(264, 74, 261, 23);
		add(lbl_id);
		
		startEvent();
	}

	private void startEvent() {
		EditRestaurantListener listener = new EditRestaurantListener(this);
		btnCancel.addActionListener(listener);
		btnNext.addActionListener(listener);
		btn_CompanyimgUpload1.addActionListener(listener);
		btn_CompanyimgUpload2.addActionListener(listener);
		cbo_sido.addActionListener(listener);
		
	}

	public EditRestaurant(MainFrame mainFrame) {
		this();
		frame = mainFrame;
		restSelect();
	}
	public void restSelect(){
		RestService service = new RestServiceImpl();
		restinfo = service.restselect(frame.ID);
		if(restinfo==null){
			JOptionPane.showMessageDialog(this, "¿À·ù¹ß»ý");
		} else {
			lbl_id.setText(restinfo.getRestId());
			txt_Mutual.setText(restinfo.getRestName());
			txt_Agent.setText(restinfo.getOrnerName());
			String[] cpnum = restinfo.getOrnerNum().split("-");
			txt_BusinessNumPr.setText(cpnum[0]);
			txt_BusinessNummid.setText(cpnum[1]);
			txt_BusinessNumPos.setText(cpnum[2]);
			ZipService zipService = new ZipServiceImpl();
			String[] addr = restinfo.getAddr().split(" ");
			cbo_sido.setModel(new DefaultComboBoxModel<String>(zipService.getSIDO()));
			cbo_sido.setSelectedItem(addr[0]);
			cbo_gungu.setModel(new DefaultComboBoxModel<String>(zipService.getGUGUN(addr[0])));
			cbo_gungu.setSelectedItem(addr[1]);
			StringBuffer buffer = new StringBuffer();
			for (int i = 2; i < addr.length; i++) {
				buffer.append(addr[i]+ " ");
			}
			txt_CompanyAddr.setText(buffer.toString());
			String[] phone = restinfo.getRestTel().split("-");
			txtphonefr.setText(phone[0]);
			txt_PhoneMid.setText(phone[1]);
			txt_PhonePos.setText(phone[2]);
			txt_EmailPr.setText(restinfo.getRestEmail());
			txt_OperatingTimeSt.setText(restinfo.getOpenTime());
			txt_OperatingTimeEnd.setText(restinfo.getCloseTime());
			comboBox_Category.setSelectedItem(restinfo.getRestType());
			txt_CompanyImage1.setText(restinfo.getRestImg1());
			txt_CompanyImage2.setText(restinfo.getRestImg2());
			taMISC.setText(restinfo.getRestDetail());
		}
	}
}
