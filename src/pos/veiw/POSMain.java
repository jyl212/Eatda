package pos.veiw;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import login.view.MainFrame;
import pos.listener.POSMainListener;
import pos.listener.PosTableSelectEditListener;
import pos.listener.PosTableSelectListener;
import pos.listener.TableCardCalcListener;
import pos.listener.TableMoneyCalcListener;
import table.view.TableButton;
import table.view.TableShowPanel;

public class POSMain extends JPanel {
	public JTextField tfTableName;
	public JTextField tfTotalPrice;
	public JButton eatdaButton;
	public JButton eatdaButton_1;
	public JButton order;
	public JButton orderEdit;
	public JButton moneycal;
	public JButton cardcalc;
	public MainFrame frame;
	public TableShowPanel panel;
	public JTable MainPostable;
	public OrderEdit orderedit;
	public int selectedtablenumber;

	/**
	 * Create the panel.
	 */


	public POSMain(MainFrame mainFrame) {
		this.frame = mainFrame;
		Color co = new Color(243, 50, 11);
		setBackground(Color.WHITE);
		setSize(1008, 653);
		setLayout(null);
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH");

		panel = new TableShowPanel(frame.ID, dateFormat.format(Calendar.getInstance().getTime()));
		panel.setBounds(26, 10, 600, 600);
		add(panel);
		panel.setLayout(null);

		order = new JButton();
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		order.setForeground(Color.WHITE);
		order.setFont(new Font("±¼¸²", Font.BOLD, 23));
		order.setText("\uC8FC \uBB38");
		order.setBackground(new Color(243, 50, 11));
		order.setBounds(720, 414, 111, 89);
		add(order);
		order.setFocusPainted(false);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 128));
		panel_1.setBounds(673, 107, 323, 239);
		add(panel_1);

		JScrollPane scrollPaneMenu = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(scrollPaneMenu, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(21, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(scrollPaneMenu,
				GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE));

		MainPostable = new JTable();
		scrollPaneMenu.setViewportView(MainPostable);
		panel_1.setLayout(gl_panel_1);
		tfTableName = new JTextField();
		tfTableName.setBounds(673, 79, 323, 29);
		add(tfTableName);
		tfTableName.setColumns(10);

		JLabel lblTotalPrice = new JLabel("\uAE08\uC561:");
		lblTotalPrice.setOpaque(true);
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPrice.setForeground(Color.WHITE);
		lblTotalPrice.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lblTotalPrice.setBackground(new Color(243, 50, 11));
		lblTotalPrice.setBounds(815, 355, 57, 29);
		add(lblTotalPrice);

		tfTotalPrice = new JTextField();
		tfTotalPrice.setBounds(873, 355, 123, 29);
		tfTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		tfTotalPrice.setBorder(new LineBorder(co));
		add(tfTotalPrice);
		tfTotalPrice.setColumns(10);

		eatdaButton = new JButton();
		eatdaButton.setText("\uB9E4\uCD9C\uAD00\uB9AC");
		eatdaButton.setForeground(Color.WHITE);
		eatdaButton.setFont(new Font("±¼¸²", Font.BOLD, 16));
		eatdaButton.setBackground(new Color(243, 50, 11));
		eatdaButton.setBounds(771, 10, 123, 39);
		eatdaButton.setFocusPainted(false);
		add(eatdaButton);

		moneycal = new JButton();
		moneycal.setText("\uD604 \uAE08");
		moneycal.setForeground(Color.WHITE);
		moneycal.setFont(new Font("±¼¸²", Font.BOLD, 23));
		moneycal.setBackground(new Color(243, 50, 11));
		moneycal.setBounds(720, 527, 111, 89);
		moneycal.setFocusPainted(false);
		add(moneycal);

		cardcalc = new JButton();
		cardcalc.setBackground(new Color(243, 50, 11));
		cardcalc.setText("<html>\uC2E0 \uC6A9<br>\uCE74 \uB4DC");
		cardcalc.setForeground(Color.WHITE);
		cardcalc.setFont(new Font("±¼¸²", Font.BOLD, 23));
		cardcalc.setBounds(861, 527, 111, 89);
		cardcalc.setFocusPainted(false);
		add(cardcalc);

		eatdaButton_1 = new JButton();
		eatdaButton_1.setText("\uB098\uAC00\uAE30");
		eatdaButton_1.setForeground(Color.WHITE);
		eatdaButton_1.setFont(new Font("±¼¸²", Font.BOLD, 16));
		eatdaButton_1.setFocusPainted(false);
		eatdaButton_1.setBackground(new Color(243, 50, 11));
		eatdaButton_1.setBounds(906, 10, 90, 39);
		add(eatdaButton_1);

		orderEdit = new JButton();
		orderEdit.setText("<html>\uC8FC \uBB38<br>\uC218 \uC815");
		orderEdit.setForeground(Color.WHITE);
		orderEdit.setFont(new Font("±¼¸²", Font.BOLD, 23));
		orderEdit.setFocusPainted(false);
		orderEdit.setBackground(new Color(243, 50, 11));
		orderEdit.setBounds(861, 414, 111, 89);
		add(orderEdit);
		startcard();
		setTable();

	}

	private void setTable() {
		int size = panel.tableButtons.size();
		TableButton button;
		for (int i = 0; i < size; i++) {
			button = panel.tableButtons.get(i);
			Vector<Vector<String>> table = new Vector<Vector<String>>();
			button.setMenuList(table);
		}
		
	}

	private void startcard() {
		POSMainListener listener = new POSMainListener(this);
		order.addActionListener(listener);
		moneycal.addActionListener(listener);
		cardcalc.addActionListener(listener);
		orderEdit.addActionListener(listener);
		eatdaButton.addActionListener(listener);
		eatdaButton_1.addActionListener(listener);

		PosTableSelectListener listerner2 = new PosTableSelectListener(panel, this);
		for (int i = 0; i < panel.tableButtons.size(); i++) {
			panel.tableButtons.get(i).addActionListener(listerner2);
		}
		orderedit  = new OrderEdit(frame);
		orderedit.setTableName(tfTableName.getText());
		PosTableSelectEditListener listerner3 =
				new PosTableSelectEditListener(panel, this, orderedit);
		orderEdit.addActionListener(listerner3);


		TableMoneyCalcListener listener3 = new TableMoneyCalcListener(this);
		moneycal.addActionListener(listener3);

		TableCardCalcListener  listener4 = new TableCardCalcListener(this);
		cardcalc.addActionListener(listener4);

	}
}


