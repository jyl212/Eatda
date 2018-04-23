package review.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import menu.service.MenuService;
import menu.service.MenuServiceImpl;
import review.listener.ReviewFrameListener;

public class ReviewFrame extends JFrame {

	public JPanel contentPane;
	public JButton btnWriteReview;
	public JTextArea taReview;
	public JComboBox comPoint;
	public JComboBox comMenu;
	public Vector<Integer> menuNoList;
	public JButton btnCancle;

	/**
	 * Create the frame.
	 */
	public ReviewFrame(String restID) {
		//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 225, 191));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnWriteReview = new JButton("\uB4F1\uB85D\uD558\uAE30");
		btnWriteReview.setBounds(89, 216, 130, 35);
		contentPane.add(btnWriteReview);
		btnWriteReview.setForeground(Color.WHITE);
		btnWriteReview.setBorderPainted(false);
		btnWriteReview.setBackground(new Color(243, 132, 11));

		taReview = new JTextArea();
		contentPane.add(taReview);

		JScrollPane scrollPane = new JScrollPane(taReview);
		scrollPane.setBounds(79, 105, 344, 101);
		contentPane.add(scrollPane);

		Vector<ImageIcon> stars = new Vector<ImageIcon>();

		for (int i = 5; i >= 1; i--) {
			ImageIcon imageIcon = new ImageIcon("src/image/"+i+"star.png");
			stars.add(new ImageIcon(
					imageIcon.getImage()
					.getScaledInstance(
							(imageIcon.getIconWidth()*14)/imageIcon.getIconHeight(), 
							14, 
							Image.SCALE_SMOOTH)));
		}

		comPoint = new JComboBox(stars);
		comPoint.setBackground(Color.WHITE);
		comPoint.setBounds(304, 65, 119, 30);
		contentPane.add(comPoint);

		MenuService service = new MenuServiceImpl();
		Vector<Vector<String>> nameNoList = service.getNameANDNo(restID);

		if (nameNoList != null){
			Vector<String> nameList = new Vector<String>();
			menuNoList = new Vector<Integer>();

			int size = nameNoList.size();
			for (int i = 0; i < size; i++) {
				nameList.addElement(nameNoList.get(i).get(0));
				menuNoList.addElement(Integer.parseInt(nameNoList.get(i).get(1)));
			}

			comMenu = new JComboBox(nameList);
		} else {
			comMenu = new JComboBox();
		}

		comMenu.setBackground(Color.WHITE);
		comMenu.setBounds(79, 65, 171, 30);
		contentPane.add(comMenu);

		JLabel label = new JLabel("\uBA54\uB274");
		label.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(243, 132, 11));
		label.setBounds(10, 65, 57, 30);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\uBCC4\uC810");
		label_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(new Color(243, 132, 11));
		label_1.setBounds(235, 65, 57, 30);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\uD55C\uC904\uD3C9");
		label_2.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(new Color(243, 132, 11));
		label_2.setBounds(11, 105, 57, 15);
		contentPane.add(label_2);

		JLabel lblNewLabel = new JLabel("\uB9DB\uC788\uAC8C \uB4DC\uC168\uB098\uC694?");
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(243, 132, 11));
		lblNewLabel.setBounds(10, 10, 412, 45);
		contentPane.add(lblNewLabel);

		btnCancle = new JButton("\uCDE8\uC18C");
		btnCancle.setForeground(Color.WHITE);
		btnCancle.setBorderPainted(false);
		btnCancle.setBackground(new Color(243, 132, 11));
		btnCancle.setBounds(292, 216, 130, 35);
		contentPane.add(btnCancle);

		ReviewFrameListener listener = new ReviewFrameListener(this);
		btnWriteReview.addActionListener(listener);
		btnCancle.addActionListener(listener);
	}
}
