package reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dto.MenuDTO;
import login.view.MainFrame;
import reservation.listener.ListenerTemplet;
import reservation.listener.MenuSelectListener;
import reservation.service.ReservationService;
import reservation.service.ReservationServiceImpl;
import ui.EatdaButton;
import ui.EatdaTextField;

public class MenuSelect extends JPanel{
	public EatdaTextField tfTotalPrice;
	public MainFrame frame;
	public EatdaButton btnPre;
	public EatdaButton btnOrder;
	public EatdaButton btnCancel;
	public JTable tbOrder;
	public TableModel model;
	public Vector<String> colName;
	public JComboBox<String> comboBox;
	public Vector<Vector<String>> menudata;
	public MenuTemplet[] menuPanelarr;
	public int count;
	public Vector<MenuDTO> menu;
	public String restId;
	public Vector<String> menuType;
	public ListenerTemplet menulitener;

	/**
	 * Create the panel.
	 */
	public MenuSelect(String restId) {
		this.restId=restId;
		ReservationService service=new ReservationServiceImpl();
		count=service.countMenuType(restId);
		menuType=service.selectMenuType(restId);
		Color co=new Color(243,50,11);
		setBackground(Color.WHITE);
		setSize(1008,653);
		setLayout(null);
		
		JLabel lblMenuSelect = new JLabel("\uBA54\uB274 \uC120\uD0DD");
		lblMenuSelect.setFont(new Font("±¼¸²", Font.BOLD, 24));
		lblMenuSelect.setBounds(401, 0, 121, 71);
		add(lblMenuSelect);		
		
		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(0, 613, 1008, 28);
		btnPanel.setBackground(Color.white);
		add(btnPanel);
		
		btnPre = new EatdaButton("\uC774\uC804");
		btnPanel.add(btnPre);
		
		btnOrder = new EatdaButton("\uC8FC\uBB38");
		btnPanel.add(btnOrder);
		
		btnCancel = new EatdaButton("\uCDE8\uC18C");
		btnPanel.add(btnCancel);
		menudata=new Vector<Vector<String>>();
		tfTotalPrice = new EatdaTextField();
		tfTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		tfTotalPrice.setFont(new Font("±¼¸²", Font.BOLD, 18));
		tfTotalPrice.setText("");
		tfTotalPrice.setBorder(new LineBorder(co));
		tfTotalPrice.setBounds(889, 312, 107, 39);
		add(tfTotalPrice);
		tfTotalPrice.setColumns(10);
		
		JLabel lblTotalPrice = new JLabel("\uAE08\uC561:");
		lblTotalPrice.setOpaque(true);
		lblTotalPrice.setBackground(co);
		lblTotalPrice.setForeground(Color.white);
		lblTotalPrice.setFont(new Font("±¼¸²", Font.BOLD, 18));
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPrice.setBounds(823, 312, 64, 39);
		add(lblTotalPrice);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(27, 81, 653, 520);
		add(tabbedPane);
		
		menuPanelarr=new MenuTemplet[count];
		for(int i=0;i<menuPanelarr.length;i++){
			menuPanelarr[i]=new MenuTemplet(this,menuType.get(i));
			tabbedPane.addTab(menuType.get(i), null, menuPanelarr[i], null);
		}
		
		JPanel panelOrder = new JPanel();
		panelOrder.setBounds(692, 101, 304, 201);
		add(panelOrder);
		
		JScrollPane scrollOrder = new JScrollPane();
		GroupLayout gl_panelOrder = new GroupLayout(panelOrder);
		gl_panelOrder.setHorizontalGroup(
			gl_panelOrder.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollOrder, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
		);
		gl_panelOrder.setVerticalGroup(
			gl_panelOrder.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollOrder, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
		);
		
		dataSetting();
		model=new DefaultTableModel(null,colName);
		tbOrder = new JTable(model);
		tbOrder.setEnabled(true);
		tbOrder.setRowHeight(30);
		tbOrder.getColumnModel().getColumn(1).setPreferredWidth(50);

		scrollOrder.setViewportView(tbOrder);
		
		
		panelOrder.setLayout(gl_panelOrder);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(MenuSelect.class.getResource("/image/logo_4.png")));
		lblLogo.setLayout(new GridLayout(1,1));
		lblLogo.setBounds(692, 362, 316, 237);		
		add(lblLogo);
		StartEvent();	
	}
	public void StartEvent(){
		MenuSelectListener litener=new MenuSelectListener(this);
		btnCancel.addActionListener(litener);
		btnOrder.addActionListener(litener);
		btnPre.addActionListener(litener);
		menulitener=new ListenerTemplet(this);
		for(int i=0;i<menuPanelarr.length;i++){
			for(int j=0;j<menuPanelarr[i].chkarr.length;j++){
				menuPanelarr[i].chkarr[j].addItemListener(menulitener);
			}
		}
	}
	public void dataSetting(){
		colName=new Vector<String>();
		colName.add("¸Þ´º");
		colName.add("¼ö·®");
		colName.add("°¡°Ý");
	}

	public MenuSelect(MainFrame mainFrame,String restID) {
		this(restID);
		frame = mainFrame;
	}
}
