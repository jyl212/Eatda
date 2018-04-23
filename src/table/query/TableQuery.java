package table.query;

public class TableQuery {
/*             REST_TABLE 
	TABLE_NO			NOT NULL NUMBER ==> TABLE_SEQUENCE
	REST_ID				NOT NULL VARCHAR2(40)
	TABLE_NAME		NOT NULL VARCHAR2(40)
	TABLE_STATE		NOT NULL VARCHAR2(20)
	TABLE_X				NOT NULL NUMBER
	TABLE_Y				NOT NULL NUMBER
	TABLE_W			NOT NULL NUMBER
	TABLE_H				NOT NULL NUMBER
	TABLE_TYPE		NOT NULL NUMBER
	PER_COUNT			NOT NULL NUMBER
	TABLE_COMENT	NOT NULL VARCHAR2(20)
*/
	
	public static String TABLE_INSERT = "insert into REST_TABLE values(TABLE_SEQUENCE.nextval,?,?,?,?,?,?,?,?,?,?)"; 
	public static String RESTID_SELECT = "select * from REST_TABLE where REST_ID=?";
	public static String TABLE_DELETE = "delete from REST_TABLE where TABLE_NO = ?";
	public static String TABLE_UPDATE = "update REST_TABLE set TABLE_NAME=?, TABLE_X=?, TABLE_Y=?, TABLE_COMENT=? where TABLE_NO=?";
	public static String OBJECT_UPDATE = "update REST_TABLE set TABLE_X=?, TABLE_Y=?, TABLE_W=?, TABLE_H=? where TABLE_NO=?";
	public static String TABLE_GET_NAME = "select TABLE_NAME from REST_TABLE where TABLE_NO = ?";

}
