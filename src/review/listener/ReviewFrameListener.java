package review.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dto.ReviewDTO;
import review.service.ReviewService;
import review.service.ReviewServiceImpl;
import review.view.ReviewFrame;

public class ReviewFrameListener implements ActionListener {
	ReviewFrame mainView;
	
	public ReviewFrameListener(ReviewFrame mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btnWriteReview){
			String review = mainView.taReview.getText();

			if (!review.equals("")) {

				ReviewService service = new ReviewServiceImpl();
				int ans = service.reviewInsert(new ReviewDTO(0, 
						mainView.menuNoList.get(mainView.comMenu.getSelectedIndex()), 
						5 - mainView.comPoint.getSelectedIndex(), review));
				if (ans > 0) {
					JOptionPane.showMessageDialog(null, "������ �ı� �����մϴ�!");
					mainView.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "��Ͻ��� �Ф� �ٽ� �õ����ּ���");
				}
			} else {
				JOptionPane.showMessageDialog(null, "�������� �ۼ����� �ʾҽ��ϴ�");
			}
		} else if (e.getSource() == mainView.btnCancle) {
			mainView.dispose();
		}

	}

}
