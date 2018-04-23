package pos.query;

/*CREATE TABLE payment (
       PAYMENT_NO	NUMBER			NOT NULL, 
       MEM_ID		VARCHAR2(20)	NOT NULL, 
       ORDER_NO		NUMBER			NOT NULL, 
       RESER_NO		NUMBER			NOT NULL, 
       PAYMENT_DATE	DATE			NOT NULL, 
       TOTAL_PRICE	NUMBER			NOT NULL, 
       PAYMENT_TYPE	VARCHAR2(20)	NOT NULL 
);
*/

public class PosQuery {
	public static String TABLE_SELECTM_INFO =  "select menu_name m,menu_count d, menu_price m from menu m ,reservation_detail d, RESERVATION r "
			+ "where m.menu_no = d.menu_no and d.reser_no = r.reser_no and table_no = ?";
    
	public static String PAYMENY_INFO = "insert into payment values(payment_SEQ.nextval,?,?,?,sysdate,?,'현금')";
	public static String PAYMENY_INFO2 = "insert into payment values(payment_SEQ.nextval,?,?,?,sysdate,?,'카드')";
	public static String MENUTYPE_COUNT="select count(distinct menu_type) from menu m,rest r where m.rest_id=r.rest_id and m.rest_id=?";
	public static String MENUTYPE_SELECT="select distinct menu_type from menu m,rest r where m.rest_id=r.rest_id and m.rest_id=?";
	public static String MENU_SELECT="select * from menu m,rest r where m.rest_id=r.rest_id and m.rest_id=? and m.menu_type=?";
	public static String MENU_DETAIL_COUNT="select count(*) from menu m,rest r where m.rest_id=r.rest_id and m.rest_id=? and m.menu_type=?";
	public static String MENU_INSERT="insert into reservation_detail values('1',?,?)";
	public static String MENU_NO_SELECT="select menu_no from menu m,rest r where m.rest_id=r.rest_id and m.rest_id=? and m.menu_name=?";
	public static String TABLE_SELECT="select table_name,table_coment from rest_table t,rest r where t.rest_id=r.rest_id and t.rest_id=? and t.table_state='Y'";
	public static String PAYMENT_SELECT = "select m.mem_id,  sum(d.menu_count*u.menu_price), r.rest_id "
                                          +"from member m, RESERVATION r, RESERVATION_DETAIL d, MENU u "
                                          +"where m.mem_id = r.mem_id and r.reser_no = d.reser_no and u.menu_no = d.menu_no and r.table_no = ? "
                                          +"group by m.mem_id, r.rest_id ";
	
	public static String SALES_MENU_SELECT_ALL="select m.menu_name,p.total_price,p.payment_date,p.payment_type,c.gender,r.reser_name from MEMBER c,PAYMENT p,RESERVATION r,menu m where c.mem_id=p.mem_id and p.rest_id=m.rest_id and r.mem_id=p.mem_id and m.rest_id=?";
	public static String SALES_MENU_SELECT_MAN="select m.menu_name,p.total_price,p.payment_date,p.payment_type,c.gender,r.reser_name from MEMBER c,PAYMENT p,RESERVATION r,menu m where c.mem_id=p.mem_id and p.rest_id=m.rest_id and r.mem_id=p.mem_id and m.rest_id=? and c.gender='남'";
	public static String SALES_MENU_SELECT_WOMAN="select m.menu_name,p.total_price,p.payment_date,p.payment_type,c.gender,r.reser_name from MEMBER c,PAYMENT p,RESERVATION r,menu m where c.mem_id=p.mem_id and p.rest_id=m.rest_id and r.mem_id=p.mem_id and m.rest_id=? and c.gender='여'";
	public static String SALES_MENU_SELECT_ALL_TMP="select distinct p.payment_no,p.total_price,p.payment_date,p.payment_type,c.gender,r.reser_name from MEMBER c,PAYMENT p,RESERVATION r,menu m where c.mem_id=p.mem_id and p.rest_id=m.rest_id and r.mem_id=p.mem_id and m.rest_id=?";
	public static String SALES_MENU_SELECT_MAN_TMP="select distinct p.payment_no,p.total_price,p.payment_date,p.payment_type,c.gender,r.reser_name from MEMBER c,PAYMENT p,RESERVATION r,menu m where c.mem_id=p.mem_id and p.rest_id=m.rest_id and r.mem_id=p.mem_id and m.rest_id=? and c.gender='남'";
	public static String SALES_MENU_SELECT_WOMAN_TMP="select distinct p.payment_no,p.total_price,p.payment_date,p.payment_type,c.gender,r.reser_name from MEMBER c,PAYMENT p,RESERVATION r,menu m where c.mem_id=p.mem_id and p.rest_id=m.rest_id and r.mem_id=p.mem_id and m.rest_id=? and c.gender='여'";
}
