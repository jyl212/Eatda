package table.view;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

//http://www.codejava.net/java-se/swing/editable-jtable-example

public class ChangeTableModel extends AbstractTableModel {
	final String[] colNames = {"이름", "설명"};
	final Class[] columnClasses = {String.class,String.class};
	Vector<Vector<String>> data;

	public ChangeTableModel() {
		data = new Vector<Vector<String>>();
		/*
		for (int i = 0; i < 4; i++) {

			Vector<String> vector = new Vector<String>();
			vector.add("22");
			vector.add("33");
			data.add(vector);
		}//*/
	}

	public ChangeTableModel(Vector<Vector<String>> data) {
		super();
		this.data = data;
	}

	public Vector<Vector<String>> getData() {
		return data;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return colNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Vector<String> rowData = data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return rowData.get(0);

		case 1:
			return rowData.get(1);

		default:
			return null;
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Vector<String> rowData = data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			rowData.set(0,(String) aValue);
			return;

		case 1:
			rowData.set(1,(String) aValue);
			return;

		default:
			return;
		}

	}

	@Override
	public String getColumnName(int i) {
		return colNames[i];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	    return true;
	}

}
