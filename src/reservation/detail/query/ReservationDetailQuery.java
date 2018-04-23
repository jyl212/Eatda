package reservation.detail.query;

public class ReservationDetailQuery {
	public static String RESER_MENU_INFO = 
			"select m.MENU_NAME, r.MENU_COUNT, m.MENU_PRICE "
			+ "from RESERVATION_DETAIL r, menu m "
			+ "where r.MENU_NO = m.MENU_NO "
			+ "and r.RESER_NO = ?";
	public static String RESER_DETAIL_DELETE = "delete from RESERVATION_DETAIL where RESER_NO = ?";

}
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