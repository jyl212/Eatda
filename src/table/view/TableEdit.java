package table.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dto.RestDTO;
import login.view.MainFrame;
import table.listener.TableEditListener;
import table.service.TableService;
import table.service.TableServiceImpl;

public class TableEdit extends JPanel {

	public MainFrame frame;
	
	public TableInsertPanel panel;
	
	public JButton btn1Seat;
	public JButton btn2Seat;
	public JButton btn4Seat;
	public JButton btn6Seat;
	public JButton btnMISCSeat;
	
	public JButton btnWindow;
	public JButton btnDoor;
	public JButton btnPartition;
	public JButton btnToilet;
	
	public JButton btnPrev;
	public JButton btnNext;
	
	public RestDTO restInfo;

	/**
	 * Create the panel.
	 */

	public TableEdit(MainFrame mainFrame,RestDTO restInfo) {
		frame = mainFrame;
		setBackground(Color.WHITE);
		setSize(1008,653);
		setLayout(null);

		this.restInfo = restInfo;
		
		panel = new TableInsertPanel();
		panel.setBounds(375, 15, 600, 600);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("\uD14C\uC774\uBE14 \uC218\uC815");
		lblTitle.setFont(new Font("±¼¸²", Font.BOLD, 24));
		lblTitle.setBounds(12, 15, 337, 39);
		lblTitle.setForeground(new Color(243,50,11));
		add(lblTitle);
		
		JPanel pTables = new JPanel();
		pTables.setBounds(12, 199, 118, 416);
		add(pTables);
		pTables.setLayout(new GridLayout(4, 0, 0, 0));
		
		btn1Seat = new JButton("1\uC778");
		pTables.add(btn1Seat);
		
		btn2Seat = new JButton("2\uC778");
		pTables.add(btn2Seat);
		
		btn4Seat = new JButton("4\uC778");
		pTables.add(btn4Seat);
		
		btn6Seat = new JButton("6\uC778");
		pTables.add(btn6Seat);
		
//		btnMISCSeat = new JButton("\uAE30\uD0C0");
//		pTables.add(btnMISCSeat);
		
		JPanel pObjects = new JPanel();
		pObjects.setBounds(158, 199, 118, 416);
		add(pObjects);
		pObjects.setLayout(new GridLayout(4, 0, 0, 0));
		
		btnWindow = new JButton("\uCC3D\uBB38");
		pObjects.add(btnWindow);
		
		btnDoor = new JButton("\uCD9C\uC785\uBB38");
		pObjects.add(btnDoor);
		
		btnPartition = new JButton("\uD30C\uD2F0\uC158");
		pObjects.add(btnPartition);
		
		btnToilet = new JButton("\uD654\uC7A5\uC2E4");
		pObjects.add(btnToilet);
		
		btnPrev = new JButton("\uC774\uC804");
		btnPrev.setBounds(12, 76, 118, 33);
		add(btnPrev);
		
		btnNext = new JButton("\uB2E4\uC74C");
		btnNext.setBounds(158, 76, 118, 33);
		add(btnNext);
	
	    startEvent();
	    
	    setTables();
		
	}

	private void setTables() {		
		TableService service = new TableServiceImpl();
		panel.tables = service.findTablesByRestID(frame.ID);
		
		panel.validate();
		panel.repaint();
		
	}
	
	private void startEvent() {
		TableEditListener listener = new TableEditListener(this);
		
		btn1Seat.addActionListener(listener);
		btn2Seat.addActionListener(listener);
		btn4Seat.addActionListener(listener);
		btn6Seat.addActionListener(listener);
//		btnMISCSeat.addActionListener(listener);

		btnWindow.addActionListener(listener);
		btnDoor.addActionListener(listener);
		btnPartition.addActionListener(listener);
		btnToilet.addActionListener(listener);
		
		btnNext.addActionListener(listener);
		btnPrev.addActionListener(listener);
	}
}
