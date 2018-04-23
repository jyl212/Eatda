package login.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import board.veiw.NoticeBoardPage;
import customer.view.NewCustomer;
import login.listener.MainFrameListener;
import menu.view.Menu;
import pos.veiw.Order;
import pos.veiw.OrderEdit;
import pos.veiw.POSMain;
import pos.veiw.SalesView;
import reservation.view.RestaurantSelect;
import restaurant.view.NewRestaurant;
import ui.EatdaButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public CardLayout mainCardLayout;
	public JPanel mainPanel;
	public JPanel topPanel;
	public JButton btnlogo;
	public EatdaButton btnEditMyInfo;
	public EatdaButton btnBoard;
	public EatdaButton btnShowReserList;
	public POSMain posMain;
	public OrderEdit pos_2;
	public Order nocustomer;
	public LogInPage logInPage;
	public FindPassWord findIPass;
	public String ID;
	public boolean type;
	/*	type
	 * false : 회원, 고객, 손님
	 * true : 업체, 식당, 밥집
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		topPanel = new JPanel();
		topPanel.setBounds(0, 0, 1008, 30);
		contentPane.add(topPanel);
		topPanel.setLayout(new BorderLayout(0, 0));
		topPanel.setBackground(Color.WHITE);
		topPanel.setVisible(false);
		
		
		//로고버튼
		btnlogo = new JButton();
		topPanel.add(btnlogo, BorderLayout.WEST);
		btnlogo.setIcon(new ImageIcon("src/image/logo_small.png"));
		btnlogo.setBorder(BorderFactory.createEmptyBorder());
		MainFrameListener listener = new MainFrameListener(this);
		btnlogo.addActionListener(listener);
		
		JPanel pButton = new JPanel();
		FlowLayout fl_pButton = (FlowLayout) pButton.getLayout();
		fl_pButton.setAlignment(FlowLayout.RIGHT);
		pButton.setOpaque(false);
		topPanel.add(pButton, BorderLayout.CENTER);

		//상단고정버튼
		btnShowReserList = new EatdaButton("");
		btnShowReserList.setText("\uC608\uC57D\uC870\uD68C");
		pButton.add(btnShowReserList);
		
		btnEditMyInfo = new EatdaButton("");
		btnEditMyInfo.setText("\uC815\uBCF4\uC218\uC815");
		pButton.add(btnEditMyInfo);
		/*
		btnBoard = new EatdaButton("");
		btnBoard.setText("\uAC8C\uC2DC\uD310");
		pButton.add(btnBoard);
		*/
		//btnBoard.addActionListener(listener);
		btnEditMyInfo.addActionListener(listener);
		btnShowReserList.addActionListener(listener);
		
		
		//사전 생성 패널
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 30, 1024, 690);

		contentPane.add(mainPanel);
		mainCardLayout = new CardLayout(0, 0);
		mainPanel.setLayout(mainCardLayout);
		
		logInPage = new LogInPage(this);
		mainPanel.add(logInPage, "logInPage");		
		
		RestaurantSelect selectRestaurantPage = new RestaurantSelect(this);
		mainPanel.add(selectRestaurantPage, "selectRestaurantPage");	
		
		SelectRegisteration loginPageSelectView = new SelectRegisteration(this);
		mainPanel.add(loginPageSelectView, "loginPageSelectView");
		
		NewCustomer registrierenView1 = new NewCustomer(this);
		mainPanel.add(registrierenView1, "registrierenView1");
		
		NewRestaurant registrierenView2 = new NewRestaurant(this);
		mainPanel.add(registrierenView2, "registrierenView2");
		
		Menu menuPlus = new Menu(this);
		mainPanel.add(menuPlus, "menuPlus");			
		
		SalesView pos_3 = new SalesView(this);
		mainPanel.add(pos_3, "pos_3");
		
		NoticeBoardPage noticeBoardPage = new NoticeBoardPage(this);
		mainPanel.add(noticeBoardPage, "noticeBoardPage");
				
		findIPass = new FindPassWord(this); 
		mainPanel.add(findIPass, "findIPass");
		
		FindId findId = new FindId(this);		
		mainPanel.add(findId, "findId");
		
		mainCardLayout.show(mainPanel, "logInPage");
	}
}
