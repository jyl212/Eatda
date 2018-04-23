package board.veiw;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

public class Faq extends JPanel {
	public JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public Faq() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1000, 640);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 10, 1000, 640);
		add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		tabbedPane.setBackground(Color.RED);
		tabbedPane.setBounds(0, 10, 965, 561);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\uC804\uCCB4", null, panel_1, null);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnNewButton = new JButton("Q.회원 가입시 사용 가능한 메일은?");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBorder(new LineBorder(Color.BLACK));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		panel_1.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("로그인이 안되는데 어떻게 하죠?");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBorder(new LineBorder(Color.BLACK));
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		panel_1.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("예약완료후에 연락이안와요.");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBorder(new LineBorder(Color.BLACK));
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("예약취소에 따른 불이익이 있나요?");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBorder(new LineBorder(Color.BLACK));
		btnNewButton_3.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("개인정보처리방침은 어디나와있나요?");
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBorder(new LineBorder(Color.BLACK));
		btnNewButton_4.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("불만사항 신고는 어디서하죠?");
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setBorder(new LineBorder(Color.BLACK));
		btnNewButton_5.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		panel_1.add(btnNewButton_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("\uC774\uC6A9\uC548\uB0B4", null, panel_2, null);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setBackground(Color.WHITE);
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setBackground(Color.WHITE);
		panel_2.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setBackground(Color.WHITE);
		panel_2.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.setBackground(Color.WHITE);
		panel_2.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("");
		btnNewButton_10.setBackground(Color.WHITE);
		panel_2.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.setBackground(Color.WHITE);
		panel_2.add(btnNewButton_11);
		
		

	}
}
