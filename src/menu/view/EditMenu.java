package menu.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Rectangle2D.Float;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dto.RestDTO;
import login.view.MainFrame;
import menu.listener.EditMenuListener;
import menu.service.MenuService;
import menu.service.MenuServiceImpl;

public class EditMenu extends JPanel {
	public MainFrame frame;
	public JButton btnpre;
	public JButton btnmenuplus;
	public JPanel panel;
	public JButton btndelete;
	public JScrollPane scroll;

	public ArrayList<Menu> menuList = new ArrayList<Menu>();
	public JButton butaltercommit;
	public ArrayList<Float> tables;
	public RestDTO restInfo;
	public ArrayList<Integer> deleteTableList;
	public ArrayList<Integer> updateTableList;

	/**
	 * Create the panel.
	 */
//ArrayList<Float> tables, RestDTO restInfo
	public EditMenu(MainFrame frame) {
		this.frame=frame;
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1008, 652);
		
		JLabel label = new JLabel("\uBA54\uB274 \uC218\uC815");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("»ﬁ∏’øæ√º", Font.BOLD, 26));
		label.setBounds(12, 10, 120, 34);
		add(label);
		
		panel = new JPanel();
		scroll=new JScrollPane(panel);
		scroll.setBounds(12, 72, 984, 524);
//		panel.setBounds(12, 72, 984, 524);
//		scroll.setOpaque(true);
//		panel.setPreferredSize(new Dimension(965, 10000));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll);
		

		panel.setLayout(null);
		
		
		btnmenuplus = new JButton("\uBA54\uB274\uCD94\uAC00");
		btnmenuplus.setBounds(790, 48, 97, 23);
		add(btnmenuplus);
		
		butaltercommit = new JButton("\uC218\uC815\uC644\uB8CC");
		butaltercommit.setToolTipText("");
		butaltercommit.setFont(new Font("πŸ≈¡", Font.BOLD, 16));
		butaltercommit.setBounds(635, 600, 109, 42);
		add(butaltercommit);
		
		
		btnpre = new JButton("\uC774\uC804\uB2E8\uACC4");
		btnpre.setToolTipText("");
		btnpre.setFont(new Font("πŸ≈¡", Font.BOLD, 16));
		btnpre.setBounds(263, 600, 109, 42);
		add(btnpre);
		
		btndelete = new JButton("\uBA54\uB274\uC0AD\uC81C");
		btndelete.setBounds(899, 48, 97, 23);
		add(btndelete);
		
		
		startEvent();
		setMenu();
		
	}
	public void setMenu(){
		MenuService service = new MenuServiceImpl();
		menuList = service.menuSelectFindByRestId(frame.ID);
		if(menuList!=null){
			for (int i = 0; i < menuList.size(); i++) {
				panel.add(menuList.get(i));

			}
			setAllBounds();

	    }

	}
	private void setAllBounds() {
		int len = menuList.size();
		
		for (int i = 0; i < len; i++) {
			menuList.get(i).setBounds(1, i*88, 965, 88);
		}
		
	}

	private void startEvent() {

		EditMenuListener listener = new EditMenuListener(this);
		btnpre.addActionListener(listener);
		btnmenuplus.addActionListener(listener);
		btndelete.addActionListener(listener);
		butaltercommit.addActionListener(listener);

	}
	public void setData(ArrayList<Float> tables, RestDTO restInfo){
		this.tables = tables;
		this.restInfo = restInfo;
	}

	public EditMenu(MainFrame mainFrame, ArrayList<Float> tables, ArrayList<Integer> deleteTableList,
			ArrayList<Integer> updateTableList, RestDTO restInfo) {
		this(mainFrame);
		this.tables = tables;
		this.deleteTableList = deleteTableList;
		this.updateTableList = updateTableList;
		this.restInfo = restInfo;
	}
}
