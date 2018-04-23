package reservation.dao;

import java.sql.Date;
import java.util.Vector;

import dto.MenuDTO;
import dto.ReservationDTO;

public interface ReservationDAO {
	/*   reservation
 RESER_NO			NOT NULL NUMBER
 MEM_ID				NOT NULL VARCHAR2(40)
 TABLE_NO			NOT NULL NUMBER
 REST_ID			NOT NULL VARCHAR2(40)
 RESER_DATE		NOT NULL DATE
 RESER_TIME		NOT NULL VARCHAR2(20)
 RESER_PERSON	NOT NULL NUMBER
 RESER_NAME		NOT NULL VARCHAR2(20)
 RESER_TEL			NOT NULL VARCHAR2(20)
 RESER_EMAIL		NOT NULL VARCHAR2(80)
 RESER_MISC		NOT NULL VARCHAR2(900)
	 */

	int reservationInsert(ReservationDTO dto);
	Vector<ReservationDTO> reservationSelectDaily (String restID, Date reserDate);
	Vector<ReservationDTO> reservationSelectMemID (String memID);
	Vector<ReservationDTO> reservationSelectRestID (String restID);
	int reservationDelete (int reserNo);
	int reservationUpdate (ReservationDTO dto);
	
	/*********************************************************************/
	int countMenuType(String restId);
	Vector<MenuDTO> select(String restId,String menuType);
	Vector<String> selectMenuType(String restId);
	int countMenuDetail(String restId,String menuType);
	void insertMenu(int reserno,int menuId,int count);
	int menuNoSelect(String restId,String menuName);
	Vector<Vector<String>> selectTableInfo(String restId);
	int reservationSelect();
	
}
