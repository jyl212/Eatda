package review.query;

/*SQL> desc review;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 REVIEW_NO                                 NOT NULL NUMBER
 MENU_NO                                   NOT NULL NUMBER
 REVIEW_POINT                              NOT NULL NUMBER
 ONELINE_REV                               NOT NULL VARCHAR2(900)*/

public class ReviewQuery {
	public static String REVIEW_INSERT = "insert into review values(review_sequence.nextval,?,?,?)";
	public static String REVIEW_SELECT_BY_RESTID = 
			"select m.MENU_NAME, rv.REVIEW_POINT, rv.ONELINE_REV "
			+ "from review rv, menu m, REST rs "
			+ "where rv.MENU_NO = m.MENU_NO "
			+ "and rs.REST_ID = m.REST_ID "
			+ "and rs.REST_ID = ?";
}
