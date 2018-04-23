package login.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import customer.view.EditCustomer;
import login.view.MainFrame;
import reservation.view.ReservationListToCust;
import reservation.view.ReservationListToRest;
import restaurant.view.EditRestaurant;

public class MainFrameListener implements ActionListener {
	
	MainFrame mainView;
	
	public MainFrameListener(MainFrame mainView) {
		super();
		this.mainView = mainView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btnlogo) {
			mainView.mainCardLayout.show(mainView.mainPanel, "logInPage");
			mainView.topPanel.setVisible(false);
		} else if (e.getSource() == mainView.btnEditMyInfo) {
			mainView.topPanel.setVisible(true);		
			if (mainView.type) { // ��ü��� ��ü ���� ȭ�� �����ְ�
				EditRestaurant editRestaurant = new EditRestaurant(mainView);
				mainView.mainPanel.add(editRestaurant, "editRestaurant");
				mainView.mainCardLayout.show(mainView.mainPanel, "editRestaurant");
				
			} else { // �ƴ϶�� ���� ���� ȭ�� ������!
				EditCustomer editCustomer = new EditCustomer(mainView);
				mainView.mainPanel.add(editCustomer, "editCustomer");
				mainView.mainCardLayout.show(mainView.mainPanel, "editCustomer");
			}
		} else if (e.getSource() == mainView.btnBoard){
			mainView.topPanel.setVisible(true);
			mainView.mainCardLayout.show(mainView.mainPanel, "noticeBoardPage");
		} else if (e.getSource() == mainView.btnShowReserList) {
			mainView.topPanel.setVisible(true);
			if (mainView.type) {
				ReservationListToRest reservationListToRest = new ReservationListToRest(mainView);
				mainView.mainPanel.add(reservationListToRest, "reservationListToRest");
				mainView.mainCardLayout.show(mainView.mainPanel, "reservationListToRest");
				
			} else {
				ReservationListToCust reservationListToCust = new ReservationListToCust(mainView, mainView.ID);
				mainView.mainPanel.add(reservationListToCust, "reservationListToCust");
				mainView.mainCardLayout.show(mainView.mainPanel, "reservationListToCust");
			}
			
		}
		
	}

}
