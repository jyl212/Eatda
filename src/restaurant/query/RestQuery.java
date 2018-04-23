package restaurant.query;

public class RestQuery {

	/*          REST
 REST_ID		NOT NULL VARCHAR2(40)
 REST_PW		NOT NULL VARCHAR2(20)
 REST_NAME		NOT NULL VARCHAR2(60)
 ORNER_NAME		NOT NULL VARCHAR2(20)
 ORNER_NUM		NOT NULL VARCHAR2(40)
 ADDR			NOT NULL VARCHAR2(100)
 REST_X			NOT NULL VARCHAR2(20)
 REST_Y			NOT NULL VARCHAR2(20)
 REST_TEL		NOT NULL VARCHAR2(20)
 REST_EMAIL		NOT NULL VARCHAR2(40)
 OPEN_TIME		NOT NULL VARCHAR2(20)
 CLOSE_TIME		NOT NULL VARCHAR2(20)
 REST_TYPE		NOT NULL VARCHAR2(30)
 REST_DETAIL	NOT NULL VARCHAR2(250)
 REST_IMG1		NOT NULL VARCHAR2(50)
 REST_IMG2		NOT NULL VARCHAR2(50)
*/
	public static String REST_SELECT_ALL = "select * from REST";
	public static String REST_SELECT_TYPE = "select distinct REST_TYPE from REST";
	public static String REST_SELECT_LOC = "select distinct substr(ADDR,1,instr(ADDR,' ')-1) from REST";
	public static String REST_SELECT_BY_NAME = "select * from REST where REST_NAME like ?";
	public static String REST_SELECT_BY_LOC = "select * from REST where ADDR like ?";
	public static String REST_SELECT_BY_TYPE = "select * from REST where REST_TYPE = ?";
	public static String REST_SELECT_BY_MINCOST = 
			"select r.REST_ID, REST_PW, REST_NAME,ORNER_NAME,ORNER_NUM,ADDR,REST_X,REST_Y,REST_TEL,REST_EMAIL,OPEN_TIME,CLOSE_TIME,REST_TYPE,REST_DETAIL,REST_IMG1, REST_IMG2 "
			+ "from REST r, "
			    + "(select REST_ID, floor(min(menu_price)/10000) c "
			    + "from menu "
			    + "group by REST_ID) iv "
			+ "where r.REST_ID = iv.REST_ID "
			+     "and c = ?";
	public static String REST_SELECT_BY_MINCOST_OVER = 
			"select r.REST_ID, REST_PW, REST_NAME,ORNER_NAME,ORNER_NUM,ADDR,REST_X,REST_Y,REST_TEL,REST_EMAIL,OPEN_TIME,CLOSE_TIME,REST_TYPE,REST_DETAIL,REST_IMG1, REST_IMG2 "
			+ "from REST r, "
			    + "(select REST_ID, floor(min(menu_price)/10000) c "
			    + "from menu "
			    + "group by REST_ID) iv "
			+ "where r.REST_ID = iv.REST_ID "
			+     "and c >= ?";
	public static String REST_SELECT_BY_MAXCOST = 
			"select r.REST_ID, REST_PW, REST_NAME,ORNER_NAME,ORNER_NUM,ADDR,REST_X,REST_Y,REST_TEL,REST_EMAIL,OPEN_TIME,CLOSE_TIME,REST_TYPE,REST_DETAIL,REST_IMG1, REST_IMG2 "
			+ "from REST r, "
			    + "(select REST_ID, floor(max(menu_price)/10000) c "
			    + "from menu "
			    + "group by REST_ID) iv "
			+ "where r.REST_ID = iv.REST_ID "
			+     "and c = ?";
	public static String REST_SELECT_BY_MAXCOST_OVER = 
			"select r.REST_ID, REST_PW, REST_NAME,ORNER_NAME,ORNER_NUM,ADDR,REST_X,REST_Y,REST_TEL,REST_EMAIL,OPEN_TIME,CLOSE_TIME,REST_TYPE,REST_DETAIL,REST_IMG1, REST_IMG2 "
			+ "from REST r, "
			    + "(select REST_ID, floor(max(menu_price)/10000) c "
			    + "from menu "
			    + "group by REST_ID) iv "
			+ "where r.REST_ID = iv.REST_ID "
			+     "and c >= ?";
	public static String REST_SELECT_TIME = "select OPEN_TIME, CLOSE_TIME from REST where REST_ID = ?";

	public static String REST_SIGN_UP = 
			"insert into rest values(?,?,?,?,?,?,'流立涝仿','流立涝仿',?,?,?,?,?,?,?,?)";
	public static String REST_DISTINCT_CHEACK = 
			"select rest_id from rest where rest_id = ? ";
	
	public static String REST_GET_NAME_IMG = "select REST_NAME, REST_IMG1 from REST where REST_ID = ?";

    public static String LOGIN_REST = "select * from rest where rest_id = ? and rest_pw = ?";
    
    public static String MEM_LOCGu_Select =
			"select gugun from zip where sido= ? order by gugun asc";
    public static String REST_SELECT = 
			"select * from rest where rest_id= ? ";
    public static String REST_UPDATE =
			"update rest set rest_pw = ?, rest_name = ?,orner_name = ?,orner_num = ?, "
			+ "addr = ?, rest_tel = ? , rest_email = ?, open_time = ?, "
			+ "close_time = ? , rest_type = ? , rest_detail = ?, rest_img1 = ? , rest_img2 = ?  where rest_id = ?";
    public static String REST_GET_NAME_BYID = "select rest_name from rest where rest_id = ?";

    public static String REST_FIND_ID = "select rest_id from rest where rest_name = ? and rest_email = ? and rest_tel = ?";
	public static String REST_FIND_PW = "select * from member where rest_id = ? and rest_name = ? and rest_email = ? and rest_tel = ?";
	public static String REST_UPDATE_PW = "update rest set rest_pw = ? where rest_id = ?";
}
