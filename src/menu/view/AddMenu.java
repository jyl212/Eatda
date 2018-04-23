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
import menu.listener.AddMenuListener;
import menu.service.MenuService;
import menu.service.MenuServiceImpl;

public class AddMenu extends JPanel {
	public MainFrame frame;
	public JButton btnpre;
	public JButton btnmenuplus;
	public JPanel panel;
	public JButton btndelete;
	public JScrollPane scroll;

	public ArrayList<Menu> menuList = new ArrayList<Menu>();
	public JButton btn_commit;
	public ArrayList<Float> tables;
	public RestDTO restInfo;
	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public AddMenu(ArrayList<Float> tables, RestDTO restInfo) {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1008, 652);
		this.tables = tables;
		this.restInfo = restInfo;
		
		JLabel label = new JLabel("\uBA54\uB274 \uB4F1\uB85D");
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
		
		btn_commit = new JButton("\uAC00\uC785\uC644\uB8CC");
		btn_commit.setToolTipText("");
		btn_commit.setFont(new Font("πŸ≈¡", Font.BOLD, 16));
		btn_commit.setBounds(635, 600, 109, 42);
		add(btn_commit);
		
		
		btnpre = new JButton("\uC774\uC804\uB2E8\uACC4");
		btnpre.setToolTipText("");
		btnpre.setFont(new Font("πŸ≈¡", Font.BOLD, 16));
		btnpre.setBounds(263, 600, 109, 42);
		add(btnpre);
		
		btndelete = new JButton("\uBA54\uB274\uC0AD\uC81C");
		btndelete.setBounds(899, 48, 97, 23);
		add(btndelete);
		
		startEvent();
		
	}
	

	private void startEvent() {

		AddMenuListener listener = new AddMenuListener(this);
		btnpre.addActionListener(listener);
		btnmenuplus.addActionListener(listener);
		btndelete.addActionListener(listener);
		btn_commit.addActionListener(listener);

	}

	public AddMenu(MainFrame mainFrame, ArrayList<Float> tables, RestDTO restInfo) {
		this(tables,restInfo);
		frame = mainFrame;
	}

}
