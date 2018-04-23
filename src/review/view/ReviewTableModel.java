package review.view;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class ReviewTableModel extends AbstractTableModel {
	//�÷��� ����� �̸��� �����Ѵ�. ����� ǥ�õ� ���̴�.
	final String[] columnNames = {"�޴�", "����", "������"};
	//��ü�� ������ �����͸� �����Ѵ�. ReviewTableRowData�� ������ ���ƾ� ��
	final Class [] columnClasses = {String.class, Integer.class, String.class};
	Vector<ReviewTableRowData> data;	

	public ReviewTableModel() {
		super();
		data = new Vector<ReviewTableRowData>();	
	}
	
	public ReviewTableModel(Vector<ReviewTableRowData> data) {
		super();
		this.data = data;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	//�����Ͱ� ���̺� ǥ���� �� �ֵ��� getValueAt�޼ҵ带 �����Ѵ�. 
	//�Ʒ��� ���� �ش� ��//�� �÷��� �ش��ϴ� ���� ���� ���ָ� �ȴ�.
	public Object getValueAt(int row, int col){
		ReviewTableRowData rowData = data.elementAt(row);
		switch (col) {
		case 0:
			return rowData.getMenuName();
			
		case 1:
			return new Integer(rowData.getReveiewPoint());
			
		case 2:
			return rowData.getReview();

		default:
			return null;
		}
	}
	
	@Override
	public String getColumnName(int i) {
		return columnNames[i];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	    return false;
	}

}
