package review.view;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class ReviewTableModel extends AbstractTableModel {
	//컬럼에 사용할 이름을 지정한다. 헤더에 표시될 것이다.
	final String[] columnNames = {"메뉴", "별점", "한줄평"};
	//객체를 저장할 데이터를 선언한다. ReviewTableRowData와 구조가 같아야 함
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
	//데이터가 테이블에 표현될 수 있도록 getValueAt메소드를 구현한다. 
	//아래와 같이 해당 열//과 컬럼에 해당하는 값을 리턴 해주면 된다.
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
