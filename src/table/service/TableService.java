package table.service;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.util.ArrayList;

public interface TableService {
	int TableInsert (ArrayList<Rectangle2D.Float>tables,String restID);
	ArrayList<Rectangle2D.Float> findTablesByRestID(String restID);
	int tableUpdate(ArrayList<Float> tables, ArrayList<Integer> deleteTables, ArrayList<Integer> updateTables,String restID);
	String getTableName (int tableNo);

}
