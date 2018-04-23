package restaurant.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import reservation.view.ReservateRestaurant;
import restaurant.view.RestaurantDetailInfo;

public class RestaurantDetailInfoListener implements ActionListener {
	RestaurantDetailInfo mainView;
	

	public RestaurantDetailInfoListener(RestaurantDetailInfo mainView) {
		super();
		this.mainView = mainView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btnBookingRestaurant
				| e.getSource() == mainView.prevNextPanel.btnNext){
			ReservateRestaurant reservateRestaurant = new ReservateRestaurant(mainView.frame,mainView.getDto().getRestId()) ;
			mainView.frame.mainPanel.add(reservateRestaurant, "reservateRestaurant");
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "reservateRestaurant");
		} else if (e.getSource() == mainView.prevNextPanel.btnPrev){
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "selectRestaurantPage");
		}

	}

}
