package table.service;

import java.awt.geom.Rectangle2D.Float;
import java.util.ArrayList;
import java.util.Vector;

import dto.RestTableDTO;
import table.dao.TableDAO;
import table.dao.TableDAOImpl;
import table.view.Objects;
import table.view.Table;

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

public class TableServiceImpl implements TableService {

	@Override
	public int TableInsert(ArrayList<Float> tables,String restID){
		int rowNum = 0;
		RestTableDTO dto = null;
		
		TableDAO dao = new TableDAOImpl();
		
		for (int i = 0; i < tables.size(); i++) {
			Float temp = tables.get(i);
			
			if (temp instanceof Table) {
				Table table = (Table) temp;
				dto = new RestTableDTO(0,restID,table.getName(),"Y",(int)table.x,(int)table.y,(int)table.width,(int)table.height,0,table.getSeat(),table.getComment());
			} else if (temp instanceof Objects){
				Objects object = (Objects) temp;
				
				switch (object.getObjectType()) {
				case Objects.WINDOW:
					
					dto = new RestTableDTO(0,restID,"창문","N",(int)object.x,(int)object.y,(int)object.width,(int)object.height,object.getObjectType(),0,"창문");
					
					break;
				case Objects.DOOR:
					
					dto = new RestTableDTO(0,restID,"출입문","N",(int)object.x,(int)object.y,(int)object.width,(int)object.height,object.getObjectType(),0,"출입문");
					
					break;
				case Objects.PARTITION:
					
					dto = new RestTableDTO(0,restID,"파티션","N",(int)object.x,(int)object.y,(int)object.width,(int)object.height,object.getObjectType(),0,"파티션");
					
					break;
				case Objects.TOILET:
					
					dto = new RestTableDTO(0,restID,"화장실","N",(int)object.x,(int)object.y,(int)object.width,(int)object.height,object.getObjectType(),0,"화장실");
					
					break;

				default:
					break;
				}
			}
			
			rowNum += dao.tableInsert(dto);
			
		}
		
		return rowNum;
	}

	@Override
	public ArrayList<Float> findTablesByRestID(String restID) {
		
		TableDAO dao = new TableDAOImpl();
		Vector<RestTableDTO> result = dao.findTablesByRestID(restID);
		ArrayList<Float> tables = null;
		RestTableDTO dto = null;
		Float table = null;
		
		if (result != null){
			tables = new ArrayList<Float>();
			
			for (int i = 0; i < result.size(); i++) {
				dto = result.get(i);
				int type = dto.getTableType(); 
				
				if (type == Objects.NOTOBJECT){
					table = new Table(dto.getTableX(), dto.getTableY(), dto.getTableW(), dto.getTableH(), dto.getPerCount(), dto.getTableName(), dto.getTableComment(),dto.getTableNo());
				} else {
					table = new Objects(dto.getTableX(), dto.getTableY(), dto.getTableW(), dto.getTableH(), type, dto.getTableNo());
				}
				tables.add(table);
			}
			
		}
		
		return tables;
	}

	@Override
	public int tableUpdate(ArrayList<Float> tables, ArrayList<Integer> deleteTables, ArrayList<Integer> updateTables,String restID) {
		int rowNum = 0;
		TableDAO dao = new TableDAOImpl();
		
		if (deleteTables != null) {
			for (int i = 0; i < deleteTables.size(); i++) {
				rowNum += dao.tableDelete(deleteTables.get(i));
			}
		}
		
		int tableNo = 0;
		Float table = null;
		
		for (int i = 0; i < tables.size(); i++) {
			table = tables.get(i);
			
			if (table instanceof Table) {
				Table temp = (Table)table;
				tableNo = temp.getIdNumber();
				if (tableNo == 0) {
					RestTableDTO dto =  new RestTableDTO(0,restID,temp.getName(),"Y",(int)table.x,(int)table.y,(int)table.width,(int)table.height,0,temp.getSeat(),temp.getComment()); 
					rowNum += dao.tableInsert(dto);
//				}else if(updateTables !=null) {
//					if (updateTables.contains(tableNo))
				} else {
						rowNum += dao.tableUpdate(((Table) table).getName(),(int)table.x,(int)table.y, ((Table) table).getComment(), tableNo);
				}
			} else if (table instanceof Objects) {
				Objects temp = (Objects)table;
				tableNo = temp.getIdNumber();	
				if (tableNo == 0) {
					RestTableDTO dto = null;
					switch (temp.getObjectType()) {
					case Objects.WINDOW:
						
						dto = new RestTableDTO(0,restID,"창문","N",(int)temp.x,(int)temp.y,(int)temp.width,(int)temp.height,temp.getObjectType(),0,"창문");
						
						break;
					case Objects.DOOR:
						
						dto = new RestTableDTO(0,restID,"출입문","N",(int)temp.x,(int)temp.y,(int)temp.width,(int)temp.height,temp.getObjectType(),0,"출입문");
						
						break;
					case Objects.PARTITION:
						
						dto = new RestTableDTO(0,restID,"파티션","N",(int)temp.x,(int)temp.y,(int)temp.width,(int)temp.height,temp.getObjectType(),0,"파티션");
						
						break;
					case Objects.TOILET:
						
						dto = new RestTableDTO(0,restID,"화장실","N",(int)temp.x,(int)temp.y,(int)temp.width,(int)temp.height,temp.getObjectType(),0,"화장실");
						
						break;

					default:
						break;
					} 
					rowNum += dao.tableInsert(dto);
				} else if(updateTables !=null) {
					if (updateTables.contains(tableNo))
						rowNum += dao.objectUpdate((int)temp.x,(int)temp.y,(int)temp.width,(int)temp.height, tableNo);
				}			
			}
			
			
		}
		
		return rowNum;
	}

	@Override
	public String getTableName(int tableNo) {
		TableDAO dao = new TableDAOImpl();
		return dao.getTableName(tableNo);
	}



}
