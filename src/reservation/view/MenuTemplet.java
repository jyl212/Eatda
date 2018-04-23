package reservation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import dto.MenuDTO;
import reservation.dao.ReservationDAOImpl;
import reservation.listener.ListenerTemplet;
import reservation.service.ReservationService;
import reservation.service.ReservationServiceImpl;

public class MenuTemplet extends JPanel {
	public JCheckBox[] chkarr;
	public JLabel[] lblmenuarr;
	public JLabel[] lblpricearr;
	public JPanel[] panelarr;
	public MenuSelect mainView;
	public int sum;
	public String menuType;
	public Vector<MenuDTO> dto;
	public int count;
	public int row;
	/**
	 * Create the panel.
	 */
	public MenuTemplet(MenuSelect mainView,String menuType) {
		this.mainView=mainView;
		ReservationService service=new ReservationServiceImpl();
		dto=service.select(this.mainView.restId,menuType);
		count=service.countMenuDetail(this.mainView.restId,menuType);
		panelarr=new JPanel[count];
		lblmenuarr=new JLabel[count];
		chkarr=new JCheckBox[count];
		lblpricearr=new JLabel[count];
		Color co=new Color(243, 50, 11);
		setSize(1000,400);
		if(count<6){
			row=3;
		}else{
			row=count/2;
		}
		setLayout(new GridLayout(row, 2, 0, 0));		
		
		for(int i=0;i<panelarr.length;i++){
			panelarr[i]=new JPanel();
			add(panelarr[i]);
			panelarr[i].setLayout(new BorderLayout());
			panelarr[i].setBackground(Color.white);
			JPanel menuDetail1=new JPanel();
			JPanel menuImage1=new JPanel();
			menuImage1.setLayout(new BorderLayout());
			
			JLabel lblImage1=new JLabel(new ImageIcon(dto.get(i).getMenuImg()));
			menuImage1.add(lblImage1,BorderLayout.CENTER);
			lblmenuarr[i]=new JLabel(dto.get(i).getMenuName());
			lblmenuarr[i].setFont(new Font("±¼¸²", Font.BOLD, 12));
			lblmenuarr[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblmenuarr[i].setForeground(Color.white);
			menuImage1.setBackground(co);
			menuImage1.add(lblmenuarr[i], BorderLayout.SOUTH);
			JPanel panelmenu1Info = new JPanel();
			menuDetail1.add(panelmenu1Info);
			panelmenu1Info.setLayout(new BorderLayout(0, 0));
			ScrollPane scroll=new ScrollPane();
			JTextArea menuInfo=new JTextArea(dto.get(i).getMenuDetail());
			menuInfo.setLineWrap(true);
			scroll.add(menuInfo);
			panelmenu1Info.add(scroll);
			menuDetail1.setLayout(new GridLayout(1,2));
			menuDetail1.add(menuImage1);
			menuDetail1.add(panelmenu1Info);
			chkarr[i]=new JCheckBox();
			chkarr[i].setBounds(0, 85, 115, 23);
			panelarr[i].add(chkarr[i],BorderLayout.WEST);
			panelarr[i].add(menuDetail1, BorderLayout.CENTER);
			JPanel panelPrice1=new JPanel();
			panelPrice1.setLayout(new GridLayout(1,1));
			panelPrice1.setBackground(co);
			lblpricearr[i]=new JLabel("\\"+dto.get(i).getMenuPrice());
			lblpricearr[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblpricearr[i].setFont(new Font("±¼¸²", Font.BOLD, 12));
			lblpricearr[i].setForeground(Color.white);
			panelPrice1.add(lblpricearr[i]);
			panelmenu1Info.add(panelPrice1, BorderLayout.SOUTH);
		}
		if(count<6){
			for(int i=0;i<6-count;i++){
				JPanel panel=new JPanel();
				add(panel);
			}
		}
	}
}
