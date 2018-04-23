package reservation.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import dto.ReservationDTO;
import reservation.detail.service.ReservationDetailService;
import reservation.detail.service.ReservationDetailServiceImpl;
import reservation.listener.ReservationInfoToCustListener;
import restaurant.service.RestService;
import restaurant.service.RestServiceImpl;
import table.service.TableService;
import table.service.TableServiceImpl;

public class ReservationInfoToCust extends JPanel{
	String strRestaurant;
	String strCount;
	public String strDate;
	public String strHour;
	String strTable;
	String imgRestaurant;
	public JButton btnEditBook;
	public JButton btnCancel;
	public ReservationListToCust page;
	public JButton btnWirteReview;
	public CardLayout cdLayoutButtons;
	public JPanel pButton;
	public JTable tbMenu;
	public int reserNo;
	public ReservationDTO reser;
	

	/**
	 * Create the panel.
	 */
	/**
	 * @wbp.parser.constructor
	 */

	public ReservationInfoToCust(ReservationDTO reser) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(10, 10));
		
		this.reser = reser;
		
		reserNo = reser.getReserNo();		
		
		TableService service = new TableServiceImpl();
		StringBuffer buffer = new StringBuffer(service.getTableName(reser.getTableNo()));
		
		String temp = reser.getReserMisc();
		if (temp.indexOf("/**/") >= 0) {
			String[] tableIdxs = temp.split("/\\*\\*/");
			
			for (int i = 1; i < tableIdxs.length; i++) {
				buffer.append(", ");
				buffer.append(service.getTableName(Integer.parseInt(tableIdxs[i])));
			}
		}
		strTable = buffer.toString();
		
		strCount = reser.getReserPerson()+"¸í";

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy³â MM¿ù ddÀÏ");
		strDate = dateFormat.format(reser.getReserDate());
		strHour = reser.getReserTime();
		
		RestService restService = new RestServiceImpl();
		Vector<String> nameAimg = restService.getNameAndImg(reser.getRestId());
		
		strRestaurant = nameAimg.get(0);
		imgRestaurant = nameAimg.get(1);
				
		JLabel lblRestaurantIMG = new JLabel();
		lblRestaurantIMG.setIcon(new ImageIcon(new ImageIcon(imgRestaurant).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		add(lblRestaurantIMG, BorderLayout.WEST);


		pButton = new JPanel();
		pButton.setBackground(Color.WHITE);
		add(pButton, BorderLayout.EAST);
		cdLayoutButtons = new CardLayout(0, 0);
		pButton.setLayout(cdLayoutButtons);
		
		
		JPanel pEditButton = new JPanel();
		pButton.add(pEditButton, "pEditButton");
		pEditButton.setLayout(new GridLayout(4, 1, 10, 10));
		pEditButton.setOpaque(false);
		
		JPanel panel_2 = new JPanel();
		pEditButton.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		
		btnEditBook = new JButton("\uC608\uC57D\uBCC0\uACBD");
		pEditButton.add(btnEditBook);
		btnEditBook.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnEditBook.setForeground(Color.WHITE);
		btnEditBook.setBorderPainted(false);
		btnEditBook.setBackground(new Color(127, 127, 127));
		
		btnCancel = new JButton("\uC608\uC57D\uCDE8\uC18C");
		pEditButton.add(btnCancel);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnCancel.setBorderPainted(false);
		btnCancel.setBackground(new Color(127, 127, 127));
		
		JPanel panel_3 = new JPanel();
		pEditButton.add(panel_3);
		panel_3.setBackground(Color.WHITE);
		
		JPanel pWirteReview = new JPanel();
		pButton.add(pWirteReview, "pWirteReview");
		pWirteReview.setLayout(new GridLayout(5, 1, 10, 10));
		pWirteReview.setOpaque(false);
		
		JPanel panel = new JPanel();
		pWirteReview.add(panel);
		panel.setOpaque(false);
		
		JPanel panel_1 = new JPanel();
		pWirteReview.add(panel_1);
		panel_1.setOpaque(false);
		
		btnWirteReview = new JButton("\uB9AC\uBDF0\uB0A8\uAE30\uAE30");
		pWirteReview.add(btnWirteReview);
		btnWirteReview.setForeground(Color.WHITE);
		btnWirteReview.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnWirteReview.setBorderPainted(false);
		btnWirteReview.setBackground(new Color(127, 127, 127));
		
		JPanel panel_4 = new JPanel();
		pWirteReview.add(panel_4);
		panel_4.setOpaque(false);
		
		JPanel panel_5 = new JPanel();
		pWirteReview.add(panel_5);
		panel_5.setOpaque(false);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel pBookInfo = new JPanel();
		panel_6.add(pBookInfo, BorderLayout.CENTER);
		pBookInfo.setBackground(Color.WHITE);
		pBookInfo.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel lblRestaurant = new JLabel("\uB9E4\uC7A5\uBA85 : "+strRestaurant);
		lblRestaurant.setFont(new Font("±¼¸²", Font.BOLD, 14));
		pBookInfo.add(lblRestaurant);
		
		JLabel lblCount = new JLabel("\uC778\uC6D0 : "+strCount);
		lblCount.setFont(new Font("±¼¸²", Font.BOLD, 14));
		pBookInfo.add(lblCount);
		JLabel lblBookDate = new JLabel("\uB0A0\uC9DC / \uC2DC\uAC04 : "+strDate+" / "+strHour);
		lblBookDate.setFont(new Font("±¼¸²", Font.BOLD, 14));
		pBookInfo.add(lblBookDate);
		
		JLabel lblTable = new JLabel("\uD14C\uC774\uBE14 : "+strTable);
		lblTable.setFont(new Font("±¼¸²", Font.BOLD, 14));
		pBookInfo.add(lblTable);
		
		
		ReservationDetailService detailService = new ReservationDetailServiceImpl();
		
		Vector<Vector<String>> menuList = detailService.getReservationMenuInfo(reser.getReserNo());
		Vector<String> colName = new Vector<>();
		colName.add("¸Þ´º");
		colName.add("¼ö·®");
		colName.add("´Ü°¡");
		
		if (menuList != null) {		
			tbMenu = new JTable(menuList,colName);
			tbMenu.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			tbMenu.setOpaque(false);

			resizeColumnWidth(tbMenu);
			JScrollPane scrollPane = new JScrollPane(tbMenu);
			scrollPane.setPreferredSize(tbMenu.getPreferredSize());
			scrollPane.setBackground(Color.WHITE);
			panel_6.add(scrollPane, BorderLayout.EAST);
		}

		startEvent();

	}
	private void resizeColumnWidth(JTable table) { 
		final TableColumnModel columnModel = table.getColumnModel(); 
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 50; // Min width 
			for (int row = 0; row < table.getRowCount(); row++) { 
				TableCellRenderer renderer = table.getCellRenderer(row, column); 
				Component comp = table.prepareRenderer(renderer, row, column); 
				width = Math.max(comp.getPreferredSize().width +1 , width); 
			} 
			columnModel.getColumn(column).setPreferredWidth(width); 
		} 
	}

	private void startEvent() {
		ReservationInfoToCustListener listener = new ReservationInfoToCustListener(this);
		
		btnCancel.addActionListener(listener);
		btnEditBook.addActionListener(listener);
		btnWirteReview.addActionListener(listener);
	}

	public ReservationInfoToCust(ReservationListToCust showBookListPage, ReservationDTO reser) {
		this(reser);
		page = showBookListPage;
	}

}
