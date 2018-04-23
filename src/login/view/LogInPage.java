package login.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import login.listener.LogInPageListener;
import ui.EatdaButton;
import ui.EatdaTextField;

public class LogInPage extends JPanel {
	public EatdaTextField txtId;
	public EatdaButton btnlog_in;
	public MainFrame frame;
	public EatdaButton btnSign_Up;
	public EatdaButton btnFindID;
	public EatdaButton btnFindPW;
	public JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public LogInPage() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1024, 690);
					
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(LogInPage.class.getResource("/image/logo_3.PNG")));
		lblNewLabel.setBounds(251, 69, 511, 266);
		add(lblNewLabel);
		
		JLabel lblIDimage = new JLabel("");
		lblIDimage.setHorizontalAlignment(SwingConstants.CENTER);
		lblIDimage.setIcon(new ImageIcon(LogInPage.class.getResource("/image/id_1.png")));
		lblIDimage.setBounds(261, 327, 76, 85);
		add(lblIDimage);
		
		JLabel lblPassImage = new JLabel("");
		lblPassImage.setIcon(new ImageIcon(LogInPage.class.getResource("/image/password_1.png")));
		lblPassImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassImage.setBounds(261, 431, 76, 85);
		add(lblPassImage);
		
		JLabel lblIDLine = new JLabel("");
		lblIDLine.setIcon(new ImageIcon(LogInPage.class.getResource("/image/Line.png")));
		lblIDLine.setBounds(349, 388, 320, 4);
		add(lblIDLine);
		
		JLabel lblPassLine = new JLabel("");
		lblPassLine.setIcon(new ImageIcon(LogInPage.class.getResource("/image/Line.png")));
		lblPassLine.setBounds(349, 504, 320, 4);
		add(lblPassLine);
		
		txtId = new EatdaTextField();
		txtId.setBounds(351, 345, 318, 43);
		add(txtId);
		txtId.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(351, 461, 318, 43);
		add(passwordField);
		passwordField.setColumns(10);
		passwordField.setBorder(BorderFactory.createEmptyBorder());
		
		btnSign_Up = new EatdaButton("회원가입");
		btnSign_Up.setBounds(218, 559, 110, 32);
		add(btnSign_Up);
		
		btnlog_in = new EatdaButton("로그인");
		btnlog_in.setBounds(360, 559, 110, 32);
		add(btnlog_in);
		
		btnFindID = new EatdaButton("비밀번호 찾기");
		btnFindID.setText("ID \uCC3E\uAE30");
		btnFindID.setBounds(496, 559, 169, 32);
		add(btnFindID);
		
		btnFindPW = new EatdaButton("비회원");
		btnFindPW.setText("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		btnFindPW.setBounds(677, 559, 126, 32);
		add(btnFindPW);
		
		
		StartEvent();
	}
	public void StartEvent(){
		LogInPageListener listener=new LogInPageListener(this);
		btnSign_Up.addActionListener(listener);
		btnlog_in.addActionListener(listener);
		btnFindID.addActionListener(listener);
		btnFindPW.addActionListener(listener);
	}

	public LogInPage(MainFrame mainFrame) {
		this();
		frame=mainFrame;
//		frame.topPanel.setVisible(false);
	}
}
