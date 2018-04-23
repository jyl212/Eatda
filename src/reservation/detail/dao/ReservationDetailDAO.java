package reservation.detail.dao;

import java.util.Vector;


/*SQL> desc RESERVATION_DETAIL;
Name                                      Null?    Type
----------------------------------------- -------- --------------------------
RESER_NO                                  NOT NULL NUMBER
MENU_NO                                   NOT NULL NUMBER
MENU_COUNT                                NOT NULL NUMBER

SQL> desc menu;
Name                                      Null?    Type
----------------------------------------- -------- --------------------------
MENU_NO                                   NOT NULL NUMBER
REST_ID                                   NOT NULL VARCHAR2(40)
MENU_NAME                                 NOT NULL VARCHAR2(150)
MENU_PRICE                                NOT NULL NUMBER
MENU_DETAIL                               NOT NULL VARCHAR2(1500)
MENU_TYPE                                 NOT NULL VARCHAR2(40)
MENU_IMG                                  NOT NULL VARCHAR2(40)*/
public interface ReservationDetailDAO {

	Vector<Vector<String>> getReservationMenuInfo(int reserNo);
	int reservationDetailDelete(int reserNo);

}

