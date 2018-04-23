package reservation.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dto.ReservationDTO;
import login.view.MainFrame;
import reservation.listener.ReservationListToRestListener;
import reservation.service.ReservationServiceImpl;
import restaurant.service.RestServiceImpl;
import ui.EatdaButton;

public class ReservationListToRest extends JPanel {

	public MainFrame frame;
	public JPanel cardlayoutBookList;
	public CardLayout bookList;
	public JPanel pPageList;
	public CardLayout pageList;

	public ArrayList<EatdaButton> alReserIndex;
	/**
	 * Create the panel.
	 */
	public ReservationListToRest(MainFrame mainFrame) {
		frame = mainFrame;
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1024, 690);
		
		JLabel lblLine1 = new JLabel();
		lblLine1.setBounds(0, 70, 1024, 4);
		lblLine1.setIcon(new ImageIcon("src/image/Line.png"));
		add(lblLine1);
		
		JLabel lblHello = new JLabel("\uC548\uB155\uD558\uC138\uC694. <"+new RestServiceImpl().getRestName(frame.ID)+"> \uAD00\uB9AC\uC790\uB2D8!");
		lblHello.setHorizontalAlignment(SwingConstants.CENTER);
		lblHello.setBounds(84, 10, 864, 64);
		lblHello.setFont(new Font("굴림", Font.BOLD, 24));
		lblHello.setForeground(new Color(243, 50, 11));
		add(lblHello);
		
		JPanel pPageList = new JPanel();
		pPageList.setBounds(0, 610, 1014, 43);
		pPageList.setBackground(Color.WHITE);
		add(pPageList);	

		showReserList();

	}

	private void showReserList() {
		Vector<ReservationDTO> reserList = new ReservationServiceImpl().reservationSelectRestID(frame.ID);
//		Collections.sort(reserList);
		
		JLabel lblPoint = new JLabel("\uC624\uB298\uC758 \uC608\uC57D "+reserList.size()+"\uAC74");
		lblPoint.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoint.setForeground(new Color(243, 50, 11));
		lblPoint.setFont(new Font("굴림", Font.BOLD, 24));
		lblPoint.setBounds(73, 79, 864, 64);
		add(lblPoint);
		
		JPanel pReserIndex = new JPanel();
		pReserIndex.setBackground(Color.WHITE);
		pReserIndex.setBounds(0, 610, 1024, 43);
		add(pReserIndex);
		
		cardlayoutBookList = new JPanel();
		cardlayoutBookList.setBackground(Color.WHITE);
		cardlayoutBookList.setBounds(73, 153, 875, 447);
		add(cardlayoutBookList);
		bookList = new CardLayout(0, 0);
		cardlayoutBookList.setLayout(bookList);
		
		int numReserList = 0;

		int numReserIndex = 0;
		
		ReservationDTO reser = null;
		
		JPanel pReserList = null;

		ReservationInfoToRest bookInfo = null;
		
		if (reserList != null) { 

			for (int i = 0; i < reserList.size(); i++) {
				reser = reserList.get(i);

				numReserIndex = (numReserList+2) / 2;
				if (numReserList % 2 == 0){
					if (alReserIndex == null)
						alReserIndex = new ArrayList<EatdaButton>();
					pReserList = new JPanel();
					pReserList.setBackground(Color.WHITE);
					cardlayoutBookList.add(pReserList, "pReserList"+numReserIndex);
					EatdaButton button = new EatdaButton(numReserIndex+"");
					pReserIndex.add(button);
					alReserIndex.add(button);
					pReserList.setLayout(new GridLayout(2, 0, 20, 20));
				}

				//////현재 예약 리스트임
				bookInfo = new ReservationInfoToRest(this,reser);
				bookInfo.setBorder(new LineBorder(new Color(243, 50, 11)));
				pReserList.add(bookInfo);

				numReserList++;
			
			}
			ReservationListToRestListener listener = new ReservationListToRestListener(this);
			
			if (alReserIndex != null){
				for (int i = 0; i < alReserIndex.size(); i++) {
					alReserIndex.get(i).addActionListener(listener);
				}
			}

		}
		bookList.show(cardlayoutBookList, "pReserList1");
		
	}

}
