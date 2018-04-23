package menu.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import login.view.MainFrame;
import menu.listener.MenuListener;

public class Menu extends JPanel {
	public JTextField txtMenuImgRoute;
	public MainFrame frame;
	public JTextField txt_menuName;
	public JTextField txt_menuPrice;
	public JCheckBox chkmenu;
	public JLabel lbl_image;
	public JButton btn_image;
	public JTextArea txt_menuDetail;
	public JTextField txt_menutype;
	private int menuNo;
    private String restId;
    private String menuName;
    private int menuPrice;
    private String menuDetail;
    private String menuType;
    private String menuImg; 

	public Menu(int menuNo, String restId, String menuName, int menuPrice, String menuDetail, String menuType,
			String menuImg) {
		this();
		this.menuNo = menuNo;
		this.restId = restId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuDetail = menuDetail;
		this.menuType = menuType;
		this.menuImg = menuImg;
		
		txt_menuName.setText(menuName);
		txt_menuPrice.setText(menuPrice+"");
		txt_menutype.setText(menuType);
		txt_menuDetail.setText(menuDetail);
		txtMenuImgRoute.setText(menuImg);
		
		ImageIcon originlIcon = new ImageIcon(menuImg);
		Image originImg = originlIcon.getImage(); 
		Image changedimg = originImg.getScaledInstance(110, 80, Image.SCALE_SMOOTH );
		ImageIcon icon = new ImageIcon(changedimg);
		lbl_image.setIcon(icon);
	}
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public String getRestId() {
		return restId;
	}
	public void setRestId(String restId) {
		this.restId = restId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public String getMenuDetail() {
		return menuDetail;
	}
	public void setMenuDetail(String menuDetail) {
		this.menuDetail = menuDetail;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getMenuImg() {
		return menuImg;
	}
	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}
	
	@Override
	public String toString() {
		return "Menu [menuNo=" + menuNo + ", restId=" + restId + ", menuName=" + menuName + ", menuPrice=" + menuPrice
				+ ", menuDetail=" + menuDetail + ", menuType=" + menuType + ", menuImg=" + menuImg + "]";
	}
	/**
	 * Create the panel.
	 */
	public Menu() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBackground(Color.ORANGE);
		setLayout(null);
		
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);//평면에 끌로 판듯이 외곽선 효과를 내는 것이고 양각의 효과를 준다.
		lbl_image = new JLabel("NO\r\n IMAGE");
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_image.setFont(new Font("함초롬바탕", Font.BOLD, 12));
		lbl_image.setBackground(Color.DARK_GRAY);
		lbl_image.setBounds(37, 5, 100, 80);
		lbl_image.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(lbl_image);
		
		txtMenuImgRoute = new JTextField();
		txtMenuImgRoute.setBounds(257, 5, 302, 23);
		add(txtMenuImgRoute);
		txtMenuImgRoute.setColumns(10);
		
		btn_image = new JButton("\uC774\uBBF8\uC9C0\uCCA8\uBD80");
		btn_image.setForeground(Color.WHITE);
		btn_image.setBackground(SystemColor.desktop);
		btn_image.setFont(new Font("함초롬돋움", Font.BOLD, 10));
		btn_image.setBounds(149, 4, 104, 26);
		add(btn_image);
		
		JLabel lblNewLabel_1 = new JLabel("\uC0C1\uC138\uC124\uBA85");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(564, 5, 57, 15);
		add(lblNewLabel_1);
		
		txt_menuDetail = new JTextArea();
		txt_menuDetail.setLineWrap(true);
		JScrollPane scroll=new JScrollPane(txt_menuDetail);//스크롤에 텍스트 에어리아를 넣어 스크롤 바를 생성합니다.
		scroll.setBounds(564, 20, 392, 63);
		add(scroll);
		
		chkmenu = new JCheckBox("");
		chkmenu.setBackground(Color.ORANGE);
		chkmenu.setBounds(8, 37, 21, 23);
		add(chkmenu);
		
		JLabel lblNewLabel_2 = new JLabel("\uBA54\uB274\uC774\uB984");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2.setBounds(149, 35, 57, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uB2E8\uAC00");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3.setBounds(149, 60, 34, 15);
		add(lblNewLabel_3);
		
		txt_menuName = new JTextField();
		txt_menuName.setBounds(207, 33, 139, 21);
		add(txt_menuName);
		txt_menuName.setColumns(10);
		
		txt_menuPrice = new JTextField();
		txt_menuPrice.setColumns(10);
		txt_menuPrice.setBounds(207, 60, 139, 21);
		add(txt_menuPrice);
		
		JLabel label = new JLabel("\uBA54\uB274\uD0C0\uC785");
		label.setFont(new Font("굴림", Font.BOLD, 12));
		label.setBounds(358, 33, 57, 15);
		add(label);
		
		txt_menutype = new JTextField();
		txt_menutype.setColumns(10);
		txt_menutype.setBounds(414, 33, 145, 21);
		add(txt_menutype);
		
		
		startEvent();
		
	}
	private void startEvent(){
		MenuListener listener = new MenuListener(this);
		btn_image.addActionListener(listener);
	}

	public Menu(MainFrame mainFrame) {
		this();
		frame = mainFrame;
	}
}
