package reservation.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import customer.service.MemeberServiceimpl;
import dto.ReservationDTO;
import login.view.MainFrame;
import reservation.listener.ReservationListToCustListener;
import reservation.service.ReservationServiceImpl;
import ui.EatdaButton;

public class ReservationListToCust extends JPanel {

	public MainFrame frame;
	public JButton btnShowBookList;
	public JButton btnShowPrevBookList;
	public JPanel cardlayoutBookList;
	public CardLayout bookList;
	private String memID;
	public JPanel pPageList;
	public CardLayout pageList;

	public ArrayList<EatdaButton> alReserIndex;
	public ArrayList<EatdaButton> alPrevIndex;
	/**
	 * Create the panel.
	 */
	/**
	 * @wbp.parser.constructor
	 */
	public ReservationListToCust(String memID) {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1024, 690);

		this.memID = memID;

		JLabel lblLine1 = new JLabel();
		lblLine1.setBounds(0, 70, 1024, 4);
		lblLine1.setIcon(new ImageIcon("src/image/Line.png"));
		add(lblLine1);

		JLabel lblHello = new JLabel("\uC548\uB155\uD558\uC138\uC694. "+new MemeberServiceimpl().getMemberName(memID)+" \uD68C\uC6D0\uB2D8!");
		lblHello.setHorizontalAlignment(SwingConstants.CENTER);
		lblHello.setBounds(0, 10, 1012, 44);
		lblHello.setFont(new Font("굴림", Font.BOLD, 24));
		lblHello.setForeground(new Color(243, 50, 11));
		add(lblHello);


		btnShowBookList = new JButton("\uBC29\uBB38 \uC608\uC815 \uC608\uC57D");
		btnShowBookList.setForeground(Color.WHITE);
		btnShowBookList.setFont(new Font("굴림", Font.BOLD, 14));
		btnShowBookList.setBounds(117, 125, 279, 44);
		btnShowBookList.setBorderPainted(false);
		btnShowBookList.setBackground(new Color(243, 50, 11));
		add(btnShowBookList);

		btnShowPrevBookList = new JButton("\uC9C0\uB09C \uBC29\uBB38 \uC608\uC57D");
		btnShowPrevBookList.setForeground(Color.WHITE);
		btnShowPrevBookList.setFont(new Font("굴림", Font.BOLD, 14));
		btnShowPrevBookList.setBorderPainted(false);
		btnShowPrevBookList.setBackground(new Color(127, 127, 127));
		btnShowPrevBookList.setBounds(624, 125, 279, 44);
		add(btnShowPrevBookList);

		showReserList();
		startEvent();

	}

	private void showReserList() {
		Vector<ReservationDTO> reserList = new ReservationServiceImpl().reservationSelectMemID(memID);
		if (reserList!=null)
			Collections.sort(reserList);

		pPageList = new JPanel();
		pPageList.setBounds(0, 610, 1024, 43);
		pPageList.setBackground(Color.WHITE);
		add(pPageList);
		pageList = new CardLayout(0, 0);
		pPageList.setLayout(pageList);

		JPanel pReserIndex = new JPanel();
		pReserIndex.setBackground(Color.WHITE);
		pPageList.add(pReserIndex,"pReserIndex");
		JPanel pPrevIndex = new JPanel();
		pPrevIndex.setBackground(Color.WHITE);
		pPageList.add(pPrevIndex,"pPrevIndex");

		cardlayoutBookList = new JPanel();
		cardlayoutBookList.setBackground(Color.WHITE);
		cardlayoutBookList.setBounds(73, 179, 875, 421);
		add(cardlayoutBookList);
		bookList = new CardLayout(0, 0);
		cardlayoutBookList.setLayout(bookList);

		int numReserList = 0;
		int numPrevList = 0;

		int numReserIndex = 0;
		int numPrevIndex = 0;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = dateFormat.format(new Date());
		ReservationDTO reser = null;

		JPanel pReserList = null;
		JPanel pPrevList = null;

		ReservationInfoToCust bookInfo = null;

		if (reserList != null) { 

			for (int i = 0; i < reserList.size(); i++) {
				reser = reserList.get(i);

				int comp = reser.getReserDate().toString().compareTo(today);

				if (comp >= 0){
					numReserIndex = (numReserList+2) / 2;
					if ((numReserList % 2) == 0){
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
					bookInfo = new ReservationInfoToCust(this,reser);
					bookInfo.setBorder(new LineBorder(new Color(243, 50, 11)));
					bookInfo.cdLayoutButtons.show(bookInfo.pButton, "pEditButton");
					pReserList.add(bookInfo);

					numReserList++;
				} else {
					numPrevIndex = (numPrevList+2) / 2;
					if ((numPrevList % 2) == 0){
						if (alPrevIndex == null)
							alPrevIndex = new ArrayList<EatdaButton>();
						pPrevList = new JPanel();
						pPrevList.setBackground(Color.WHITE);
						cardlayoutBookList.add(pPrevList, "pPrevList"+numPrevIndex);
						EatdaButton button = new EatdaButton(numPrevIndex+"");
						pPrevIndex.add(button);
						alPrevIndex.add(button);
						pPrevList.setLayout(new GridLayout(2, 0, 20, 20));
					}

					/////지나간 예약리스트임
					bookInfo = new ReservationInfoToCust(this,reser);
					bookInfo.setBorder(new LineBorder(new Color(243, 50, 11)));
					bookInfo.cdLayoutButtons.show(bookInfo.pButton, "pWirteReview");
					pPrevList.add(bookInfo);

					numPrevList++;
				}

			}

			ReservationListToCustListener listener = new ReservationListToCustListener(this);

			if (alReserIndex != null){
				for (int i = 0; i < alReserIndex.size(); i++) {
					alReserIndex.get(i).addActionListener(listener);
				}
			}

			if (alPrevIndex != null){
				for (int i = 0; i < alPrevIndex.size(); i++) {
					alPrevIndex.get(i).addActionListener(listener);
				}
			}

		}
		bookList.show(cardlayoutBookList, "pReserList1");
		pageList.show(pPageList,"pReserIndex");

	}

	private void startEvent() {
		ReservationListToCustListener listener = new ReservationListToCustListener(this);
		btnShowBookList.addActionListener(listener);
		btnShowPrevBookList.addActionListener(listener);		
	}

	public ReservationListToCust(MainFrame mainFrame,String memID) {
		this(memID);
		frame = mainFrame;
	}
}
