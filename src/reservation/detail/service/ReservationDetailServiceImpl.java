package reservation.detail.service;

import java.util.Vector;

import reservation.detail.dao.ReservationDetailDAO;
import reservation.detail.dao.ReservationDetailDAOImpl;

public class ReservationDetailServiceImpl implements ReservationDetailService {

	@Override
	public Vector<Vector<String>> getReservationMenuInfo(int reserNo) {
		ReservationDetailDAO dao = new ReservationDetailDAOImpl();
		return dao.getReservationMenuInfo(reserNo);
	}

	@Override
	public int reservationDetailDelete(int reserNo) {
		ReservationDetailDAO dao = new ReservationDetailDAOImpl();
		return dao.reservationDetailDelete(reserNo);
	}

}
