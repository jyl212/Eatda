package reservation.view;

import java.awt.Component;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import reservation.view.TableData;;

public class MyDefaultTable extends DefaultTableCellRenderer{
	JComboBox<String> comboBox ;
	TableData tableData;
	int count;
	public MyDefaultTable(TableData tableData){
		this.tableData = tableData;
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, 
			Object value, boolean isSelected,
			boolean hasFocus,
			int row, int column) {
		
		if(isSelected){//�޺��ڽ��� �����͸� �����Ҷ� �۾�
			comboBox = tableData.getComboarr().get(row);
			comboBox.setSelectedItem(value);
			tableData.setting(row, value);
		}else{
			count++;
			Vector<String> itemlist=new Vector<String>();
		    for(int i=0;i<10;i++){
			     itemlist.add(i+1+"");
			}
			comboBox = new JComboBox<String>(itemlist);
			DefaultCellEditor editor=new DefaultCellEditor(comboBox);
			TableColumn combocolumn = table.getColumn("����");
			combocolumn.setCellEditor(editor);
			comboBox.setSelectedItem(value);
		}
		return comboBox;
	}	
}
