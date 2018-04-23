package customer.query;
//SQL만 정의하는 클래스 - 프레임워크 기반으로 하는 경우 XML형식으로 sql을 관리
/* member
 MEM_ID			NOT NULL VARCHAR2(40)
 MEM_PW			NOT NULL VARCHAR2(20)
 MEM_NAME		NOT NULL VARCHAR2(20)
 BIRTH			NOT NULL VARCHAR2(20)
 GENDER			NOT NULL VARCHAR2(3)
 MEM_TEL		NOT NULL VARCHAR2(40)
 EMAIL			NOT NULL VARCHAR2(40)
 EMAIL_CHECK	NOT NULL VARCHAR2(2)
 SIGN_DATE		NOT NULL DATE
 LOC			NOT NULL VARCHAR2(30)
 */
public class MemberQuery {
	public static String MEM_LOCGu_Select =
				"select gugun from zip where sido='?' order by gugun asc";
	public static String MEM_INSERT =  //회원가입 조건 칼럼 10개의!! 
				"insert into member values(?,?,?,?,?,?,?,?,sysdate,?)";
	public static String MEM_SELECT_BY_ID = "select * from member where MEM_ID = ?";
	public static String MEM_ID_CHEACK=
			"select mem_id from member where mem_id = ? ";
	public static String MEM_GET_NAME = "select MEM_NAME from member where MEM_ID = ?";
	public static String MEMBER_SELECT = 
			"select * from member where mem_id= ? ";
	public static String MEMBER_UPDATE =
			"update member set mem_pw = ?, mem_name = ?,birth = ?,gender = ?, "
			+ "mem_tel = ?, email = ?, email_check = ?,loc = ? where mem_id = ?";

    public static String LOGIN_MEMBER = "select * from member where mem_id = ? and mem_pw = ?";
    public static String MEM_FIND_ID = "select MEM_ID from member where MEM_NAME = ? and EMAIL = ? and MEM_TEL = ?";
	public static String MEM_FIND_PW = "select * from member where MEM_ID = ? and MEM_NAME = ? and EMAIL = ? and MEM_TEL = ?";
	public static String MEM_UPDATE_PW = "update member set mem_pw = ? where mem_id = ?";
}
	
