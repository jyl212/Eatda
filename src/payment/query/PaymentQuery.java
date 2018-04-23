package payment.query;

public class PaymentQuery {
	public static String PAYMENT_SELECT_ALL = 
			"select (select '\"'||mn.menu_name||'\"'||'¿Ü  '||(select count(out.menu_no)-1 "
			                                                 + "from order_detail out "
			                                                 + "where out.order_no = p.order_no)||'°Ç' "
		           + "from menu mn "
	               + "where mn.menu_no = (select max(od.menu_no) "
	                                   + "from order_detail od "
		                               + "where od.order_no =p.order_no)) menuinfo, p.TOTAL_PRICE, p.PAYMENT_DATE, p.PAYMENT_TYPE, m.gender, p.mem_id "
		    + "from payment p "
		    + "left join member m on p.mem_id = m.mem_id "
		    + "inner join rest_order o on p.order_no = o.order_no "
		    + "where o.rest_id = ?";
	public static String PAYMENT_SELECT_GENDER = PAYMENT_SELECT_ALL+" and m.gender = ?";
	public static String PAYMENT_SELECT_STARTDAY = PAYMENT_SELECT_ALL+" and p.PAYMENT_DATE >= ?";
	public static String PAYMENT_SELECT_ENDDAY = PAYMENT_SELECT_ALL+" and p.PAYMENT_DATE <= ?";
	public static String PAYMENT_SELECT_TYPE = PAYMENT_SELECT_ALL+" and p.PAYMENT_TYPE = ?";
}
