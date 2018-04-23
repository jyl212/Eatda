package reservation.view.db;

public class ReservationQuery {
	public static String MENUTYPE_COUNT="select count(distinct menu_type) from menu m,rest r where m.rest_id=r.rest_id and m.rest_id=?";
	public static String MENUTYPE_SELECT="select distinct menu_type from menu m,rest r where m.rest_id=r.rest_id and m.rest_id=?";
	public static String MENU_SELECT="select * from menu m,rest r where m.rest_id=r.rest_id and m.rest_id=? and m.menu_type=?";
	public static String MENU_DETAIL_COUNT="select count(*) from menu m,rest r where m.rest_id=r.rest_id and m.rest_id=? and m.menu_type=?";
	public static String MENU_INSERT="insert into reservation_detail values(?,?,?)";
	public static String MENU_NO_SELECT="select menu_no from menu m,rest r where m.rest_id=r.rest_id and m.rest_id=? and m.menu_name=?";
	public static String TABLE_SELECT="select table_name,table_coment from rest_table t,rest r where t.rest_id=r.rest_id and t.rest_id=? and t.table_state='Y'";
	public static String RESERNO_SELELCT="select LAST_NUMBER from user_sequences where SEQUENCE_NAME = 'RESER_SEQUENCE'";
}
