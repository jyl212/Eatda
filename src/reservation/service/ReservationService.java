package reservation.service;

import java.sql.Date;
import java.util.Vector;

import dto.MenuDTO;
import dto.ReservationDTO;

public interface ReservationService {
	int reservationInsert(ReservationDTO dto);
	Vector<ReservationDTO> reservationSelectDaily (String restID, Date reserDate);
	Vector<ReservationDTO> reservationSelectMemID (String memID);
	Vector<ReservationDTO> reservationSelectRestID (String restID);
	int reservationDelete (int reserNo);
	int reservationUpdate (ReservationDTO dto);
	
	/*******************************************************************************/
	int countMenuType(String restId);
	Vector<MenuDTO> select(String restId,String menuType);
	Vector<String> selectMenuType(String restId);
	int countMenuDetail(String restId,String menuType);
	void insertMenu(int reserno,int menuId,int count);
	int menuNoSelect(String restId,String menuName);
	Vector<Vector<String>> selectTableInfo(String restId);
	int reservationSelect();
}
