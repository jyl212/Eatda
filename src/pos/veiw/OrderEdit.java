package pos.veiw;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;
import javax.swing.plaf.synth.SynthSeparatorUI;

import java.awt.GridLayout;
import java.util.Vector;

import dto.MenuDTO;
import login.view.MainFrame;
import pos.listener.OrderEditListener;
import pos.listener.OrderListenerTemplet;
import pos.listener.PosTableSelectListener;
import reservation.listener.ListenerTemplet;
import reservation.service.ReservationService;
import reservation.service.ReservationServiceImpl;
import reservation.view.MenuTemplet;

public class OrderEdit extends JPanel {
	public JTextField tablename;
	public JTextField totalPrice;
	public JTable resarOdertable;
	public JButton eatdaButton;
	public JButton eatdaButton_1;
	public MainFrame frame;
	public TableModel model;
	public Vector<String> colName;
	public JComboBox<String> comboBox;
	public Vector<Vector<String>> menudata;
	public OrderEditTemplet[] menuPanelarr;
	public int count;
	public Vector<MenuDTO> menu;
	public String restId;
	public Vector<String> menuType;
	String selecttableName;
	OrderListenerTemplet menulitener;
	
	/**
	 * Create the panel.
	 */
	public OrderEdit(MainFrame frame) {
		this.frame = frame;
		restId=frame.ID;
		ReservationService service=new ReservationServiceImpl();
		count=service.countMenuType(restId);
		menuType=service.selectMenuType(restId);
		Color co=new Color(243,50,11);
		setBackground(Color.WHITE);
		setSize(1008,653);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(31, 52, 597, 547);
		add(tabbedPane);
		
		menuPanelarr=new OrderEditTemplet[count];
		for(int i=0;i<menuPanelarr.length;i++){
			menuPanelarr[i]=new OrderEditTemplet(this,menuType.get(i));
			tabbedPane.addTab(menuType.get(i), null,  menuPanelarr[i], null);
		}

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 128));
		panel.setBounds(669, 80, 299, 250);
		add(panel);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
				);
		
		dataSetting();
		model=new DefaultTableModel(null,colName);
		
		resarOdertable = new JTable(model);
		resarOdertable.setEnabled(true);
		resarOdertable.getColumnModel().getColumn(0).setPreferredWidth(160);
		resarOdertable.getColumnModel().getColumn(1).setPreferredWidth(62);
		resarOdertable.getColumnModel().getColumn(2).setPreferredWidth(97);
		resarOdertable.setRowHeight(30);
	    
		
		
		scrollPane.setViewportView(resarOdertable);
		panel.setLayout(gl_panel);

		
		tablename = new JTextField();
		tablename.setColumns(10);
		tablename.setBounds(669, 52, 299, 29);
		add(tablename);

		JLabel label = new JLabel("\uAE08\uC561:");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label.setBackground(new Color(243, 50, 11));
		label.setBounds(811, 339, 52, 29);
		add(label);

		
		
		menudata=new Vector<Vector<String>>();
		totalPrice = new JTextField();
		totalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		totalPrice.setBorder(new LineBorder(co));
		totalPrice.setColumns(10);
		totalPrice.setText("");
		totalPrice.setBounds(868, 339, 100, 29);
		add(totalPrice);
		totalPrice.setColumns(10);

		eatdaButton = new JButton();
		eatdaButton.setText("\uC218 \uC815");
		eatdaButton.setForeground(Color.WHITE);
		eatdaButton.setFont(new Font("±¼¸²", Font.BOLD, 23));
		eatdaButton.setFocusPainted(false);
		eatdaButton.setBackground(new Color(243, 50, 11));
		eatdaButton.setBounds(696, 446, 111, 89);
		add(eatdaButton);

		eatdaButton_1 = new JButton();
		eatdaButton_1.setText("\uCDE8 \uC18C");
		eatdaButton_1.setForeground(Color.WHITE);
		eatdaButton_1.setFont(new Font("±¼¸²", Font.BOLD, 23));
		eatdaButton_1.setFocusPainted(false);
		eatdaButton_1.setBackground(new Color(243, 50, 11));
		eatdaButton_1.setBounds(837, 446, 111, 89);
		add(eatdaButton_1);
    	setEvent();
    
	}

	public void setTableName(String selecttableName){
		this.selecttableName = selecttableName;
	}
	public String getTableName(){
		return selecttableName;
	}
	private void dataSetting() {
		colName=new Vector<String>();
		colName.add("¸Þ´º");
		colName.add("¼ö·®");
		colName.add("°¡°Ý");	
	}

	private void setEvent() {
		OrderEditListener listener = new OrderEditListener(this);
		eatdaButton.addActionListener(listener);
		eatdaButton_1.addActionListener(listener);
		menulitener=new OrderListenerTemplet(this);
	      for(int i=0;i<menuPanelarr.length;i++){
	         for(int j=0;j<menuPanelarr[i].chkarr.length;j++){
	            menuPanelarr[i].chkarr[j].addItemListener(menulitener);
	         }
	      }
	}

}
