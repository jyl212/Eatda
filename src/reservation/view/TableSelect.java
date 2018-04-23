package reservation.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import dto.ReservationDTO;
import login.view.MainFrame;
import reservation.listener.TableSelectListener;
import table.view.Table;
import table.view.TableShowPanel;
import ui.EatdaButton;

public class TableSelect extends JPanel {
	public EatdaButton btnPre;
	public EatdaButton btnNext;
	public EatdaButton btnCancel;
	public JPanel panelBtn;
	public MainFrame frame;
	private ReservationDTO dto;
	public JList list;
	public TableShowPanel pTableArea;
	public ArrayList<Table> selectedTable;
	public JTextArea taTableInfo;
	

	public ReservationDTO getDto() {
		return dto;
	}

	/**
	 * Create the panel.
	 */
	/**
	 * @wbp.parser.constructor
	 */
	public TableSelect(ReservationDTO dto) {
		Color co=new Color(243,50,11);
		setSize(1008,653);
		setLayout(null);
		setBackground(Color.white);
		
		JLabel lblTableSelect = new JLabel("\uD14C\uC774\uBE14 \uC120\uD0DD");
		lblTableSelect.setFont(new Font("±¼¸²", Font.BOLD, 24));
		lblTableSelect.setBounds(0, 0, 517, 62);
		add(lblTableSelect);
		
		this.dto = dto;
		pTableArea = new TableShowPanel(dto.getRestId(),dto.getReserDate(), dto.getReserTime());
				 
		pTableArea.setBounds(10, 69, 600, 540);
		pTableArea.setBorder(new LineBorder(Color.black));
		pTableArea.setLayout(null);
		for (int i = 0; i < pTableArea.tableButtons.size(); i++) {
			pTableArea.tableButtons.get(i).setToolTipText();
		}
		add(pTableArea);
		
		taTableInfo = new JTextArea();
		JScrollPane scroll=new JScrollPane(taTableInfo);
		scroll.setBorder(new LineBorder(co));
		scroll.setBounds(741, 69, 255, 258);
		add(scroll);
		
		panelBtn = new JPanel();
		panelBtn.setBounds(0, 613, 1008, 28);
		add(panelBtn);
		panelBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelBtn.setBackground(Color.white);
		
		btnPre = new EatdaButton("\uC774\uC804");
		btnPre.setSize(50, 10);
		panelBtn.add(btnPre);
		
		btnNext = new EatdaButton("\uB2E4\uC74C");
		panelBtn.add(btnNext);
		
		btnCancel = new EatdaButton("\uCDE8\uC18C");
		panelBtn.add(btnCancel);
		
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(TableSelect.class.getResource("/image/logo_3.PNG")));
		lblLogo.setBounds(619, 400, 384, 242);
		add(lblLogo);
		
		list = new JList();
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		DefaultListModel<String> defaultListModel = new DefaultListModel<>();
		list.setModel(defaultListModel);
		list.setBounds(622, 101, 107, 226);
		add(list);
		
		JLabel lblNewLabel = new JLabel("\uD14C\uC774\uBE14 \uBAA9\uB85D");
		lblNewLabel.setBounds(622, 69, 193, 28);
		add(lblNewLabel);
		startEvent();
	}
	

	private void startEvent() {
		TableSelectListener listener = new TableSelectListener(this);
		btnNext.addActionListener(listener);
		btnPre.addActionListener(listener);
		list.addListSelectionListener(listener);
		list.addMouseListener(listener);
		
		for (int i = 0; i < pTableArea.tableButtons.size(); i++) {
			pTableArea.tableButtons.get(i).addActionListener(listener);
		}
	}

	public TableSelect(MainFrame mainFrame, ReservationDTO dto) {
		this(dto);
		frame = mainFrame;
	}
}
