package reservation.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import reservation.view.ReservationListToRest;

public class ReservationListToRestListener implements ActionListener {
	ReservationListToRest mainView;

	public ReservationListToRestListener(ReservationListToRest reservationListToRest) {
		mainView = reservationListToRest;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (mainView.alReserIndex.contains(e.getSource())){
			mainView.bookList.show(mainView.cardlayoutBookList, "pReserList"+e.getActionCommand());
		}

	}

}
