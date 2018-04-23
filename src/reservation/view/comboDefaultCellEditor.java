package reservation.view;

import java.awt.Component;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class comboDefaultCellEditor extends DefaultCellEditor {
	  public comboDefaultCellEditor() {
	   super(new JComboBox<String>());
	  }

	  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {   
	   Vector<Integer> itemlist=new Vector<Integer>();
       for(int i=0;i<10;i++){
	        itemlist.add(i+1);
	    }
       JComboBox<Integer> editor = new JComboBox<Integer>(itemlist);

	   if (value != null){
	    editor.setSelectedItem(value);
	   }else{
		   editor.setSelectedItem(1);
	   }
	   
	   return editor;
	  }
}
