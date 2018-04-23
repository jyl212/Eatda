package restaurant.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import dto.RestDTO;
import login.view.MainFrame;
import restaurant.listener.RestaurantDetailInfoListener;
import review.service.ReviewService;
import review.service.ReviewServiceImpl;
import review.view.ReviewTableModel;
import review.view.ReviewTableRowData;
import ui.PrevNextPanel;

public class RestaurantDetailInfo extends JPanel {
	public MainFrame frame;
	public JButton btnBookingRestaurant;
	public PrevNextPanel prevNextPanel;
	RestDTO dto;

	public RestDTO getDto() {
		return dto;	
	}

	/**
	 * Create the panel.
	 * @param dto2 
	 */
	/**
	 * @wbp.parser.constructor
	 */
	public RestaurantDetailInfo(RestDTO dto) {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1024, 690);
		this.dto = dto;

		JLabel lblRestaurantIMG = new JLabel();
		lblRestaurantIMG.setBounds(12, 76, 589, 276);
		lblRestaurantIMG.setIcon(new ImageIcon(dto.getRestImg1()));
		add(lblRestaurantIMG);


		btnBookingRestaurant = new JButton();
		btnBookingRestaurant.setText("\uC608\uC57D\uD558\uAE30");
		btnBookingRestaurant.setBounds(887, 38, 108, 28);

		btnBookingRestaurant.setForeground(Color.WHITE);
		btnBookingRestaurant.setFont(new Font("±º∏≤", Font.BOLD, 14));
		btnBookingRestaurant.setBorderPainted(false);
		btnBookingRestaurant.setBackground(new Color(243, 50, 11));

		add(btnBookingRestaurant);

		JPanel panel = new JPanel();
		panel.setBounds(12, 362, 388, 238);
		add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(255, 132, 106));

		JPanel pRestaurantInfo = new JPanel();
		pRestaurantInfo.setBounds(25, 20, 338, 137);
		panel.add(pRestaurantInfo);
		pRestaurantInfo.setLayout(new GridLayout(5, 1, 0, 0));
		pRestaurantInfo.setOpaque(false);

		JPanel pAddr = new JPanel();
		pAddr.setBackground(Color.WHITE);
		pRestaurantInfo.add(pAddr);
		pAddr.setLayout(new BorderLayout(0, 0));
		pAddr.setOpaque(false);

		JLabel lblAddr = new JLabel(" Addr  ");
		pAddr.add(lblAddr, BorderLayout.WEST);
		lblAddr.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblAddr.setForeground(Color.WHITE);
		lblAddr.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblAddrData = new JLabel(dto.getAddr());
		lblAddrData.setForeground(Color.WHITE);
		pAddr.add(lblAddrData, BorderLayout.CENTER);
		lblAddrData.setFont(new Font("±º∏≤", Font.BOLD, 14));

		JPanel pType = new JPanel();
		pRestaurantInfo.add(pType);
		pType.setLayout(new BorderLayout(0, 0));
		pType.setOpaque(false);

		JLabel lblType = new JLabel(" Type  ");
		pType.add(lblType, BorderLayout.WEST);
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblTypeData = new JLabel(dto.getRestType());
		lblTypeData.setForeground(Color.WHITE);
		pType.add(lblTypeData, BorderLayout.CENTER);
		lblTypeData.setFont(new Font("±º∏≤", Font.BOLD, 14));

		JPanel pTel = new JPanel();
		pTel.setBackground(Color.WHITE);
		pRestaurantInfo.add(pTel);
		pTel.setLayout(new BorderLayout(0, 0));
		pTel.setOpaque(false);

		JLabel lblTel = new JLabel("   Tel  ");
		pTel.add(lblTel, BorderLayout.WEST);
		lblTel.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblTel.setForeground(Color.WHITE);
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblTelData = new JLabel(dto.getRestTel());
		lblTelData.setForeground(Color.WHITE);
		pTel.add(lblTelData, BorderLayout.CENTER);
		lblTelData.setFont(new Font("±º∏≤", Font.BOLD, 14));

		JPanel pOpen = new JPanel();
		pOpen.setBackground(Color.WHITE);
		pRestaurantInfo.add(pOpen);
		pOpen.setLayout(new BorderLayout(0, 0));
		pOpen.setOpaque(false);

		JLabel lblOpen = new JLabel("Open  ");
		pOpen.add(lblOpen, BorderLayout.WEST);
		lblOpen.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblOpen.setForeground(Color.WHITE);
		lblOpen.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblOpenData = new JLabel(dto.getOpenTime());
		lblOpenData.setForeground(Color.WHITE);
		pOpen.add(lblOpenData, BorderLayout.CENTER);
		lblOpenData.setFont(new Font("±º∏≤", Font.BOLD, 14));

		JPanel pClose = new JPanel();
		pClose.setBackground(Color.WHITE);
		pRestaurantInfo.add(pClose);
		pClose.setLayout(new BorderLayout(0, 0));
		pClose.setOpaque(false);

		JLabel lblClose = new JLabel("Close  ");
		pClose.add(lblClose, BorderLayout.WEST);
		lblClose.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblClose.setForeground(Color.WHITE);
		lblClose.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblCloseData = new JLabel(dto.getCloseTime());
		lblCloseData.setForeground(Color.WHITE);
		pClose.add(lblCloseData, BorderLayout.CENTER);
		lblCloseData.setFont(new Font("±º∏≤", Font.BOLD, 14));
		
		JLabel lblMISC = new JLabel(dto.getRestDetail());
		lblMISC.setVerticalAlignment(SwingConstants.TOP);
		lblMISC.setForeground(Color.WHITE);
		lblMISC.setBounds(25, 167, 338, 61);
		lblMISC.setFont(new Font("±º∏≤", Font.BOLD, 14));
		panel.add(lblMISC);

		JLabel lblRestaurantName = new JLabel(dto.getRestName());
		lblRestaurantName.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurantName.setFont(new Font("±º∏≤", Font.BOLD, 24));
		lblRestaurantName.setForeground(new Color(243, 50, 11));
		lblRestaurantName.setBounds(12, 10, 1000, 56);
		add(lblRestaurantName);

		MapPanel lblRestuarangMap = new MapPanel(dto.getRestX(),dto.getRestY(), 382, 276);
		lblRestuarangMap.setBounds(613, 76, 382, 276);
		add(lblRestuarangMap);

		prevNextPanel = new PrevNextPanel();
		prevNextPanel.setBounds(0, 610, 1012, 43);
		prevNextPanel.setOpaque(false);
		add(prevNextPanel);

		prevNextPanel.btnCancle.setVisible(false);

		JPanel pReview = new JPanel();
		pReview.setBounds(412, 362, 583, 238);
		pReview.setBackground(new Color(255, 225, 191));
		add(pReview);
		pReview.setLayout(null);
		
		Vector<String> colums = new Vector<String>();
		colums.add("∏ﬁ¥∫");
		colums.add("∫∞¡°");
		colums.add("«—¡Ÿ∆Ú");
		
		ReviewService reviewService = new ReviewServiceImpl();
		
		Vector<ReviewTableRowData> reviewDatas = reviewService.reviewSelectByRestID(this.dto.getRestId());

		JTable tbReviews ;
		if (reviewDatas != null ) {
			tbReviews = new JTable(new ReviewTableModel(reviewDatas));
			tbReviews.getColumnModel().getColumn(1).setCellRenderer(new StarImageRenderer());
		} else {
			tbReviews = new JTable();
		}
		tbReviews.setShowGrid(false);
		tbReviews.setBackground(Color.WHITE);
		resizeColumnWidth(tbReviews);

		JScrollPane scrollPane = new JScrollPane(tbReviews);
		scrollPane.setBounds(12, 35, 559, 193);
		pReview.add(scrollPane);
		scrollPane.setEnabled(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setBackground(Color.WHITE);

		JLabel lblReview = new JLabel("\uD6C4\uAE30");
		lblReview.setBounds(12, 10, 397, 17);
		pReview.add(lblReview);
		lblReview.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblReview.setForeground(new Color(243, 132, 11));

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

		RestaurantDetailInfoListener listener = new RestaurantDetailInfoListener(this);
		btnBookingRestaurant.addActionListener(listener);
		prevNextPanel.btnNext.addActionListener(listener);
		prevNextPanel.btnPrev.addActionListener(listener);
		
	}

	public RestaurantDetailInfo(MainFrame mainFrame, RestDTO dto) {
		this(dto);
		frame = mainFrame;
	}
}

