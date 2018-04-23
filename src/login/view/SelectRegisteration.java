package login.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import login.listener.SelectRegisterationListener;

public class SelectRegisteration extends JPanel {
	public JButton btnCustomer;
	public JButton btncompany;
	public MainFrame frame;

	public SelectRegisteration() {
		setBackground(Color.WHITE);

		setSize(1008, 652);
		setLayout(null);
		
		btnCustomer = new JButton("\uACE0\uAC1D\uAC00\uC785");
		btnCustomer.setForeground(Color.BLACK);
		btnCustomer.setBackground(new Color(243,50,11));
		btnCustomer.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 28));
		btnCustomer.setBounds(219, 237, 180, 174);
		add(btnCustomer);
		
		btncompany = new JButton("\uC5C5\uCCB4\uAC00\uC785");
		btncompany.setForeground(Color.BLACK);
		btncompany.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 28));
		btncompany.setBackground(new Color(243, 50, 11));
		btncompany.setBounds(657, 237, 180, 174);
		add(btncompany);
		
		startEvent();
		
	}
	public SelectRegisteration(MainFrame mainFrame){
		this();
		frame = mainFrame;
	}
	public void startEvent(){
		SelectRegisterationListener listener = new SelectRegisterationListener(this);
		btnCustomer.addActionListener(listener);
		btncompany.addActionListener(listener);
	}
}
