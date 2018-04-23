package reservation.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import reservation.view.ReservationListToCust;

public class ReservationListToCustListener implements ActionListener {

	ReservationListToCust mainView;
	
	public ReservationListToCustListener(ReservationListToCust mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btnShowBookList) {
			mainView.bookList.show(mainView.cardlayoutBookList, "pReserList1");
			mainView.pageList.show(mainView.pPageList,"pReserIndex");
			mainView.btnShowBookList.setBackground(new Color(243, 50, 11));
			mainView.btnShowPrevBookList.setBackground(new Color(127, 127, 127));
		} else if (e.getSource() == mainView.btnShowPrevBookList) {
			mainView.bookList.show(mainView.cardlayoutBookList, "pPrevList1");
			mainView.pageList.show(mainView.pPageList,"pPrevIndex");
			mainView.btnShowPrevBookList.setBackground(new Color(243, 50, 11));
			mainView.btnShowBookList.setBackground(new Color(127, 127, 127));
		} else if (mainView.alReserIndex.contains(e.getSource())){
			mainView.bookList.show(mainView.cardlayoutBookList, "pReserList"+e.getActionCommand());
		} else if (mainView.alPrevIndex.contains(e.getSource())){
			mainView.bookList.show(mainView.cardlayoutBookList, "pPrevList"+e.getActionCommand());			
		}

	}

}
