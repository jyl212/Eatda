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
					JOptionPane.showMessageDialog(null, "소중한 후기 감사합니다!");
					mainView.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "등록실패 ㅠㅠ 다시 시도해주세요");
				}
			} else {
				JOptionPane.showMessageDialog(null, "한줄평이 작성되지 않았습니다");
			}
		} else if (e.getSource() == mainView.btnCancle) {
			mainView.dispose();
		}

	}

}
