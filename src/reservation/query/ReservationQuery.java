package reservation.query;

public class ReservationQuery {
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
	 
	public static String RESERVATION_INSERT = "insert into reservation values(RESER_SEQUENCE.nextval,?,?,?,?,?,?,?,?,?,?)"; 
	public static String RESERVATION_SELECT_TIME_BY_DAY = "select * from reservation where REST_ID = ? and RESER_DATE = ?";
	public static String RESERVATION_SELECT_BY_MEMID = "select * from reservation where MEM_ID = ?";
	public static String RESERVATION_SELECT_BY_RESTID = "select * from reservation where REST_ID = ? and to_char( RESER_DATE, 'yyyymmdd' ) = to_char( sysdate, 'yyyymmdd')";
	public static String RESERVATION_DELETE = "delete from reservation where RESER_NO = ?";
	public static String RESERVATION_UPDATE = "update reservation set "
			+ "MEM_ID = ?, "
			+ "TABLE_NO = ?, "
			+ "REST_ID = ?, "
			+ "RESER_DATE = ?, "
			+ "RESER_TIME = ?, "
			+ "RESER_PERSON = ?, "
			+ "RESER_NAME = ?, "
			+ "RESER_TEL = ?, "
			+ "RESER_EMAIL = ?, "
			+ "RESER_MISC = ? "
			+ "where RESER_NO = ?";

}
