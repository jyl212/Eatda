package order.query;

/*SQL> desc rest_order;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------
 ORDER_NO                                  NOT NULL NUMBER
 REST_ID                                   NOT NULL VARCHAR2(40)
 TABLE_NO                                  NOT NULL NUMBER
 ORDER_DATE                                NOT NULL DATE
 ORDER_PRICE                               NOT NULL NUMBER
 */

public class OrderQuery {
	public static String ORDER_INSERT = "insert into rest_order values(ORDER_SEQUENCE.nextval,?,?,sysdate,?)"; 
	public static String ORDER_LAST_SEQ = "select LAST_NUMBER from user_sequences where SEQUENCE_NAME = 'ORDER_SEQUENCE'";
	//LAST_NUMBER : 다음에 들어갈 번호 현재번호 +1

}
