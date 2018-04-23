package table.dao;

import java.util.Vector;

import dto.RestTableDTO;

/*             REST_TABLE 
	TABLE_NO			NOT NULL NUMBER ==> TABLE_SEQUENCE
	REST_ID				NOT NULL VARCHAR2(40)
	TABLE_NAME		NOT NULL VARCHAR2(40)
	TABLE_STATE		NOT NULL VARCHAR2(20) "Y"/"N"
	TABLE_X				NOT NULL NUMBER
	TABLE_Y				NOT NULL NUMBER
	TABLE_W			NOT NULL NUMBER
	TABLE_H				NOT NULL NUMBER
	TABLE_TYPE		NOT NULL NUMBER
	PER_COUNT			NOT NULL NUMBER
	TABLE_COMENT	NOT NULL VARCHAR2(20)
*/
public interface TableDAO {
	int tableInsert (RestTableDTO dto);
	Vector<RestTableDTO> findTablesByRestID(String restID);
	int tableDelete (int tableNo);
	int tableUpdate (String tableName, int tableX, int tableY, String tableComent, int tableNo);
	int objectUpdate (int tableX, int tableY, int tableW, int tableH, int tableNo);
	String getTableName (int tableNo);

}
