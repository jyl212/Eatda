package reservation.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import reservation.detail.service.ReservationDetailService;
import reservation.detail.service.ReservationDetailServiceImpl;
import reservation.service.ReservationService;
import reservation.service.ReservationServiceImpl;
import reservation.view.EditReservation;
import reservation.view.ReservationInfoToCust;
import reservation.view.ReservationListToCust;
import review.view.ReviewFrame;

public class ReservationInfoToCustListener implements ActionListener {
	ReservationInfoToCust mainView;
	

	public ReservationInfoToCustListener(ReservationInfoToCust mainView) {
		super();
		this.mainView = mainView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mainView.btnEditBook){
			EditReservation editReservation = new EditReservation(mainView.page.frame, mainView.reser);
			mainView.page.frame.mainPanel.add(editReservation,"editReservation");
			mainView.page.frame.mainCardLayout.show(mainView.page.frame.mainPanel, "editReservation");
		} else if (e.getSource() == mainView.btnCancel){
			int type = JOptionPane.showConfirmDialog( mainView, "취소하시겠습니까?","예약취소" ,JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (type == JOptionPane.OK_OPTION) {

				ReservationService service = new ReservationServiceImpl();
				service.reservationDelete(mainView.reserNo);
				
				ReservationDetailService detailService = new ReservationDetailServiceImpl();
				detailService.reservationDetailDelete(mainView.reserNo);

				JOptionPane.showMessageDialog(mainView, "취소되었습니다.");
				ReservationListToCust reservationListToCust = new ReservationListToCust(mainView.page.frame, mainView.page.frame.ID);
				mainView.page.frame.mainPanel.add(reservationListToCust,"reservationListToCust");
				mainView.page.frame.mainCardLayout.show(mainView.page.frame.mainPanel, "reservationListToCust");
			}
		} else if (e.getSource() == mainView.btnWirteReview){
			ReviewFrame reviewFrame =  new ReviewFrame(mainView.reser.getRestId());
			reviewFrame.setVisible(true);
		}

	}

}
