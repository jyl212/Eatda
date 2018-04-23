package order.detail.query;
/*
SQL> desc order_detail;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------
 ORDER_NO                                  NOT NULL NUMBER
 MENU_NO                                   NOT NULL NUMBER
 MENU_COUNT                                NOT NULL NUMBER
 */
public class OrderDetailQuery {
	public static String ORDER_INSERT = "insert into order_detail values(?,?,?)"; 
}
