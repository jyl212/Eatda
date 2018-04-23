package reservation.view;

import java.awt.BorderLayout;
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
import login.view.MainFrame;
import reservation.detail.service.ReservationDetailService;
import reservation.detail.service.ReservationDetailServiceImpl;
import reservation.listener.ReservationInfoToRestListener;
import restaurant.service.RestService;
import restaurant.service.RestServiceImpl;
import table.service.TableService;
import table.service.TableServiceImpl;

public class ReservationInfoToRest extends JPanel {
	public String strRestaurant;
	public String strCount;
	public String strDate;
	public String strHour;
	public String strTable;
	public String strMenu;
	public String strCost;
	public String strMisc;
	public JButton btnCheckResv;
	public JButton btnSendMail;
	public ReservationListToRest page;
	public JPanel pButton;
	public JTable tbMenu;
	public int reserNo;
	public ReservationDTO reser;
	private String imgRestaurant;
	public Vector<Vector<String>> menuList;

	/**
	 * Create the panel.
	 */
	/**
	 * @wbp.parser.constructor
	 */

	public ReservationInfoToRest(ReservationDTO reser) {
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
			strMisc = tableIdxs[0];
		} else {
			strMisc = temp;
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
		
		JPanel pBookInfo = new JPanel();
		pBookInfo.setBackground(Color.WHITE);
		add(pBookInfo, BorderLayout.CENTER);
		pBookInfo.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel lblBookDate = new JLabel("\uB0A0\uC9DC / \uC2DC\uAC04 : "+strDate+" / "+strHour);
		lblBookDate.setFont(new Font("±¼¸²", Font.BOLD, 14));
		pBookInfo.add(lblBookDate);
		
		JLabel lblCount = new JLabel("\uC778\uC6D0 : "+strCount);
		lblCount.setFont(new Font("±¼¸²", Font.BOLD, 14));
		pBookInfo.add(lblCount);
		
		JLabel lblTable = new JLabel("\uD14C\uC774\uBE14 : "+strTable);
		lblTable.setFont(new Font("±¼¸²", Font.BOLD, 14));
		pBookInfo.add(lblTable);
		
		JLabel lblMisc = new JLabel("\uD2B9\uC774\uC0AC\uD56D : "+strMisc);
		lblMisc.setFont(new Font("±¼¸²", Font.BOLD, 14));
		pBookInfo.add(lblMisc);
		
		
		ReservationDetailService detailService = new ReservationDetailServiceImpl();		
		menuList = detailService.getReservationMenuInfo(reser.getReserNo());
		Vector<String> colName = new Vector<String>();
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
			add(scrollPane, BorderLayout.EAST);
		}
		
		pButton = new JPanel();
		pButton.setBackground(Color.WHITE);
		add(pButton, BorderLayout.EAST);
		pButton.setLayout(new GridLayout(4, 1, 10, 10));
		
		JPanel panel_2 = new JPanel();
		pButton.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		
		btnCheckResv = new JButton("\uC608\uC57D\uD655\uC778");
		pButton.add(btnCheckResv);
		btnCheckResv.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnCheckResv.setForeground(Color.WHITE);
		btnCheckResv.setBorderPainted(false);
		btnCheckResv.setBackground(new Color(127, 127, 127));
		
		btnSendMail = new JButton("\uBA54\uC77C\uBCF4\uB0B4\uAE30");
		pButton.add(btnSendMail);
		btnSendMail.setForeground(Color.WHITE);
		btnSendMail.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnSendMail.setBorderPainted(false);
		btnSendMail.setBackground(new Color(127, 127, 127));
		
		JPanel panel_3 = new JPanel();
		pButton.add(panel_3);
		panel_3.setBackground(Color.WHITE);
		
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
		
		ReservationInfoToRestListener listener = new ReservationInfoToRestListener(this);
		btnSendMail.addActionListener(listener);
		btnCheckResv.addActionListener(listener);
		
	}

	public ReservationInfoToRest(ReservationListToRest reservationListToRest, ReservationDTO reser) {
		this(reser);
		page = reservationListToRest;
	}

}
