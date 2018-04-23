package menu.query;
/*
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
public class MenuQuery {
	public static String MENU_GET_NAME_BY_RESER_NO = 
			"select m.MENU_NAME, m.MENU_NO "
			+ "from menu m, RESERVATION_DETAIL r "
			+ "where r.MENU_NO = m.MENU_NO "
			+ "and r.RESER_NO = ?";
	public static String MENU_GET_NAME = 
			"select m.MENU_NAME, m.MENU_NO "
			+ "from menu m, REST r "
			+ "where r.REST_ID = ?";
	public static String MENU_INSERT = "insert into menu values(MENU_SEQ.nextval,?,?,?,?,?,?)"; 

	public static String MENU_SELECT = "select * from menu where rest_id = ?";
	public static String MENU_UPDATE = 
			"update menu set menu_name = ?, menu_price = ?, menu_detail = ?, menu_type = ?, menu_img = ?"
			+ " where menu_no = ? ";
	public static String MENU_DELETE = "delete from menu where menu_no = ?";


}
