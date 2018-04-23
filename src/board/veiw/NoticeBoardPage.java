package board.veiw;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

import board.listener.NBMListener;
import login.view.MainFrame;

public class NoticeBoardPage extends JPanel {
	public JPanel btnpanel;
	public JPanel listpanel;	

	public JButton btn1;
	public JButton btn2;
	public JButton btn3;
	public JButton btn4;

	public Notice page1;
	public Qa page2;
	public Faq page3;
	public Write page4;

	public CardLayout card;
	public MainFrame frame;
	public Notice notice;
	public Faq faq;
	public Write write;
	public NoticeContent noticeContent;
	/**
	 * Create the panel.
	 */
	public NoticeBoardPage() {
		setBackground(Color.WHITE);

		setBounds(0, 0, 1000, 640);
		setLayout(null);

		JPanel btnpanel = new JPanel();
		btnpanel.setBackground(Color.WHITE);
		btnpanel.setBounds(12, 10, 1012, 30);
		add(btnpanel);
		btnpanel.setLayout(null);

		NBMListener listener = new NBMListener(this);


		btn1 = new JButton("Notice");
		btn1.setBackground(Color.RED);
		btn1.setForeground(Color.WHITE);
		btn1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btn1.setBounds(61, 8, 125, 20);
		btn1.addActionListener(listener);
		btnpanel.add(btn1);

		btn2 = new JButton("Q/A");
		btn2.setForeground(Color.WHITE);
		btn2.setBackground(Color.RED);
		btn2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btn2.setBounds(198, 8, 125, 20);
		btn2.addActionListener(listener);
		btnpanel.add(btn2);

		btn3 = new JButton("FAQ");
		btn3.setForeground(Color.WHITE);
		btn3.setBackground(Color.RED);
		btn3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btn3.setBounds(335, 8, 125, 20);
		btn3.addActionListener(listener);
		btnpanel.add(btn3);

		btn4 = new JButton("Write");
		btn4.setBackground(Color.RED);
		btn4.setForeground(Color.WHITE);
		btn4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		btn4.setBounds(835, 8, 125, 20);
		btn4.addActionListener(listener);
		btnpanel.add(btn4);

		listpanel = new JPanel();
		listpanel.setBackground(Color.WHITE);
		listpanel.setBounds(12, 50, 1000, 640);
		add(listpanel);
		card = new CardLayout(0, 0);
		listpanel.setLayout(card);

		notice = new Notice();
		notice.setBackground(Color.WHITE);
		listpanel.add(notice, "page1");
		notice.table.addMouseListener(listener);

		Qa qa = new Qa();
		qa.setBackground(Color.WHITE);
		listpanel.add(qa, "page2");

		faq = new Faq();
		faq.setBackground(Color.WHITE);
		listpanel.add(faq, "page3");
		faq.btnNewButton.addActionListener(listener);

		write = new Write();
		write.setBackground(Color.WHITE);
		listpanel.add(write, "page4");

		write.btnCancle.addActionListener(listener);		
		write.btnOk.addActionListener(listener);
		
		noticeContent = new NoticeContent();
		noticeContent.setBackground(Color.WHITE);
		listpanel.add(noticeContent, "noticeContent");
		
		noticeContent.btnNewButton.addActionListener(listener);
		
	}
	public NoticeBoardPage(MainFrame mainFrame) {
		this();
		frame = mainFrame;
		
	}

}
