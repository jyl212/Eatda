package reservation.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import login.view.MainFrame;
import reservation.listener.ReservateRestaurantListener;
import restaurant.service.RestService;
import restaurant.service.RestServiceImpl;
import ui.EatdaTextField;
import ui.PrevNextPanel;

public class ReservateRestaurant extends JPanel {

	public MainFrame frame;
	public PrevNextPanel prevNextPanel;
	String restID;
	public JCheckBox chkUseMemberInfo;
	public EatdaTextField txtName;
	public EatdaTextField txtTel;
	public EatdaTextField txtEmail;
	public EatdaTextField txtCount;
	public JDateChooser cldBookdate;
	public JComboBox comTime;
	public JTextArea taMisc;

	public String getRestID() {
		return restID;
	}

	/**
	 * Create the panel.
	 */
	/**
	 * @wbp.parser.constructor
	 */
	public ReservateRestaurant(String restID) {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1024, 690);
		
		this.restID = restID;
//		this.restID = "aaaa001";
		
		JLabel lblBookIcon = new JLabel("");
		lblBookIcon.setBounds(60, 32, 64, 64);
		lblBookIcon.setIcon(new ImageIcon("src/image/iconBook.png"));
		add(lblBookIcon);

		JLabel lblBookTitle = new JLabel("\uC608\uC57D\uD558\uAE30");
		lblBookTitle.setFont(new Font("±¼¸²", Font.BOLD, 24));
		lblBookTitle.setForeground(new Color(243, 50, 11));
		lblBookTitle.setBounds(44, 87, 192, 64);
		add(lblBookTitle);
		/*
		 * java Swing ¿ë ´Þ·Â ÄÄÆ÷³ÍÆ® Jcalendar
		 * https://enigmacube.blogspot.kr/2015/10/java-swing-jcalendar.html
		 */

		chkUseMemberInfo = new JCheckBox("\uD68C\uC6D0 \uC815\uBCF4\uC640 \uB3D9\uC77C");
		chkUseMemberInfo.setBounds(44, 146, 192, 23);
		chkUseMemberInfo.setContentAreaFilled(false);
		add(chkUseMemberInfo);

		prevNextPanel = new PrevNextPanel();
		prevNextPanel.setBounds(0, 610, 1024, 43);
		prevNextPanel.setOpaque(false);
		add(prevNextPanel);

		JPanel panel = new JPanel();
		panel.setBounds(227, 32, 494, 342);
		panel.setBackground(new Color(255, 225, 191));
		add(panel);
		panel.setLayout(null);

		JLabel lblTel = new JLabel("\uC804\uD654\uBC88\uD638");
		lblTel.setBounds(12, 94, 123, 28);
		panel.add(lblTel);
		lblTel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		lblTel.setForeground(new Color(243, 132, 11));
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);

		txtTel = new EatdaTextField();
		txtTel.setBackground(Color.WHITE);
		txtTel.setBounds(153, 94, 258, 24);
		panel.add(txtTel);

		JLabel lblEmail = new JLabel("\uC774\uBA54\uC77C");
		lblEmail.setBounds(12, 155, 123, 28);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("±¼¸²", Font.BOLD, 14));
		lblEmail.setForeground(new Color(243, 132, 11));
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);

		txtEmail = new EatdaTextField();
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(153, 155, 258, 24);
		panel.add(txtEmail);

		JLabel lblCount = new JLabel("\uC778\uC6D0");
		lblCount.setBounds(12, 216, 123, 28);
		panel.add(lblCount);
		lblCount.setFont(new Font("±¼¸²", Font.BOLD, 14));
		lblCount.setForeground(new Color(243, 132, 11));
		lblCount.setHorizontalAlignment(SwingConstants.RIGHT);

		txtCount = new EatdaTextField();
		txtCount.setBackground(Color.WHITE);
		txtCount.setBounds(153, 216, 258, 24);
		panel.add(txtCount);

		JLabel lblBookDate = new JLabel("\uB0A0\uC9DC");
		lblBookDate.setBounds(12, 277, 123, 28);
		panel.add(lblBookDate);
		lblBookDate.setFont(new Font("±¼¸²", Font.BOLD, 14));
		lblBookDate.setForeground(new Color(243, 132, 11));
		lblBookDate.setHorizontalAlignment(SwingConstants.RIGHT);
		cldBookdate = new JDateChooser();
		cldBookdate.setBounds(153, 277, 124, 24);
		panel.add(cldBookdate);
		cldBookdate.setBorder(BorderFactory.createEmptyBorder());
		
		comTime = new JComboBox(new RestServiceImpl().getOperationTime(restID));
		comTime.setBackground(Color.WHITE);
		comTime.setBounds(299, 277, 112, 24);
		panel.add(comTime);
		comTime.setBorder(BorderFactory.createEmptyBorder());

		JLabel label = new JLabel("\uC608\uC57D\uC790 \uC774\uB984");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(243, 132, 11));
		label.setFont(new Font("±¼¸²", Font.BOLD, 14));
		label.setBounds(12, 33, 123, 28);
		panel.add(label);

		txtName = new EatdaTextField();
		txtName.setBackground(Color.WHITE);
		txtName.setBounds(153, 33, 258, 24);
		panel.add(txtName);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 132, 106));
		panel_1.setBounds(361, 327, 470, 252);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMisc = new JLabel("\uD2B9\uC774\uC0AC\uD56D");
		lblMisc.setBounds(336, 20, 111, 17);
		panel_1.add(lblMisc);
		lblMisc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMisc.setForeground(Color.WHITE);
		lblMisc.setFont(new Font("±¼¸²", Font.BOLD, 14));

		taMisc = new JTextArea();
		taMisc.setBounds(22, 60, 425, 170);
		panel_1.add(taMisc);
		
		startEvent();

	}

	private void startEvent() {
		ReservateRestaurantListener listener = new ReservateRestaurantListener(this);
		prevNextPanel.btnNext.addActionListener(listener);
		prevNextPanel.btnPrev.addActionListener(listener);
		prevNextPanel.btnCancle.addActionListener(listener);
		chkUseMemberInfo.addItemListener(listener);
		
	}

	public ReservateRestaurant(MainFrame mainFrame,String restID) {
		this(restID);
		frame = mainFrame;
	}
}
