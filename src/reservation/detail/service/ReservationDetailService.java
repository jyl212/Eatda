package reservation.detail.service;

import java.util.Vector;

public interface ReservationDetailService {

	Vector<Vector<String>> getReservationMenuInfo(int reserNo);
	int reservationDetailDelete(int reserNo);

}
