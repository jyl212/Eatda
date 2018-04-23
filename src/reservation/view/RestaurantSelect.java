package reservation.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import dto.RestDTO;
import login.view.MainFrame;
import reservation.listener.RestaurantSelectListener;
import restaurant.service.RestService;
import restaurant.service.RestServiceImpl;
import restaurant.view.RestInfoButton;
import ui.EatdaButton;
import ui.EatdaTextField;

public class RestaurantSelect extends JPanel {
	
	public Vector<EatdaButton> btnResOfFindPages = new Vector<EatdaButton>();
	public Vector<RestInfoButton> btnResOfFind = new Vector<RestInfoButton>();
	Vector<RestDTO> restList = null;

	public EatdaTextField txtFindRestaurant;
	public EatdaButton btnFindRestaurant;
	public MainFrame frame;
	private JPanel pPageNavi;
	public JPanel pResOfFind;
	public CardLayout cardLayoutResOfFind;
	public JComboBox comLocation;
	public JComboBox comType;
	public JComboBox comCost;
	public JRadioButton radioMinimun;
	public JRadioButton radioMaximun;

	/**
	 * Create the panel.
	 */
	public RestaurantSelect() {	
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1024, 690);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1024, 160);
		add(panel);
		panel.setLayout(null);
		
		JPanel pFindRestaurant = new JPanel();
		pFindRestaurant.setBounds(0, 25, 1024, 80);
		pFindRestaurant.setBackground(Color.WHITE);
		panel.add(pFindRestaurant);
		pFindRestaurant.setLayout(null);
		
		txtFindRestaurant = new EatdaTextField();
		txtFindRestaurant.setBounds(308, 10, 398, 60);
		txtFindRestaurant.setBackground(Color.WHITE);
		pFindRestaurant.add(txtFindRestaurant);
		
		btnFindRestaurant = new EatdaButton(new ImageIcon("src/image/find.png"));
		btnFindRestaurant.setBounds(719, 10, 72, 60);
		pFindRestaurant.add(btnFindRestaurant);
		
		JLabel lblunderline = new JLabel("");
		lblunderline.setIcon(new ImageIcon("src/image/line_1.png"));
		lblunderline.setBounds(308, 69, 398, 11);
		pFindRestaurant.add(lblunderline);
		
		JPanel pCondition = new JPanel();
		pCondition.setBounds(0, 125, 1024, 33);
		pCondition.setBackground(Color.WHITE);
		panel.add(pCondition);
		
		RestService restService = new RestServiceImpl();
		Vector<String> result = null;
		

		result = restService.getRestLocList();
		result.add(0, "지역");
		comLocation = new JComboBox<String>(result);
		pCondition.add(comLocation);

		result = restService.getRestTypeList();
		result.add(0, "종류");
		comType = new JComboBox<String> (result);
		pCondition.add(comType);

		String[] dataCost = {"금액", "1 만원 미만", "1 만원대", "2 만원대", "3 만원대", "4 만원대", "5 만원 이상"};
		comCost = new JComboBox<String>(dataCost);
		pCondition.add(comCost);
		
		ButtonGroup group = new ButtonGroup();
		
		radioMinimun = new JRadioButton("최소금액");
		group.add(radioMinimun);
		pCondition.add(radioMinimun);
		radioMinimun.setContentAreaFilled(false);
		radioMinimun.setSelected(true);
		
		radioMaximun = new JRadioButton("최대금액");
		group.add(radioMaximun);
		pCondition.add(radioMaximun);
		radioMaximun.setContentAreaFilled(false);
		
		pPageNavi = new JPanel();
		pPageNavi.setBounds(0, 610, 1024, 30);
		pPageNavi.setBackground(Color.WHITE);
		add(pPageNavi);
		
		pResOfFind = new JPanel();
		pResOfFind.setBounds(40, 195, 930, 390);
		add(pResOfFind);
		pResOfFind.setBackground(Color.WHITE);
		cardLayoutResOfFind = new CardLayout(0, 0);
		pResOfFind.setLayout(cardLayoutResOfFind);
		
		restList = new RestServiceImpl().restSelectAll();
		setFindResult(restList);
		
		startEvent();

	}


	private void startEvent() {
		RestaurantSelectListener listener = new RestaurantSelectListener(this);
		
		comCost.addActionListener(listener);
		comLocation.addActionListener(listener);
		comType.addActionListener(listener);
		
		btnFindRestaurant.addActionListener(listener);

		radioMaximun.addItemListener(listener);
		radioMinimun.addItemListener(listener);

		for (int i = 0; i < btnResOfFindPages.size(); i++) {
			btnResOfFindPages.get(i).addActionListener(listener);
		}

		for (int i = 0; i < btnResOfFind.size(); i++) {
			btnResOfFind.get(i).addActionListener(listener);
		}
	}

	public void deleteAll() {
		pResOfFind.removeAll();
		pPageNavi.removeAll();
		btnResOfFind.clear();
		btnResOfFindPages.clear();
	}

	public void setFindResult(Vector<RestDTO> restList2) {
		RestInfoButton button = null;
		JPanel pFindPage = null;
		EatdaButton page;
		RestaurantSelectListener listener = new RestaurantSelectListener(this);
		int i = 0;
		for (i = 0; i < restList2.size(); i++) {
			int pageIndex = (i+6) / 6;
			if ((i+6) % 6 == 0 ){
				pFindPage = new JPanel();
				pResOfFind.add(pFindPage, pageIndex+"");
				page = new EatdaButton(pageIndex+"");
				pPageNavi.add(page);
				btnResOfFindPages.add(page);
				page.addActionListener(listener);
				pFindPage.setBackground(Color.WHITE);
				pFindPage.setLayout(new GridLayout(2, 3, 40, 40));				
			}
			button = new RestInfoButton(restList2.get(i));
			button.setBorderPainted(false);
			button.addActionListener(listener);
			btnResOfFind.add(button);
			pFindPage.add(button);
			if (i % 2 == 0)
				button.setBackground(new Color(243, 132, 11));
			else
				button.setBackground(new Color(243, 50, 11));
		}
		
		while ((i%6) != 0){
			button = new RestInfoButton();
			pFindPage.add(button);
			if (i % 2 == 0)
				button.setBackground(new Color(243, 132, 11));
			else
				button.setBackground(new Color(243, 50, 11));
			i++;
		}
		
	}

	public RestaurantSelect(MainFrame mainFrame) {
		this();
		frame = mainFrame;
	}
}
