package reservation.view;

import java.util.Vector;

import javax.swing.JComboBox;

public class TableData {
	Vector<JComboBox<String>> comboarr=new Vector<JComboBox<String>>();//�Ľ�Ÿ ���� �޺����ڰ� ����� ����
	int row;//������ row�� ��ȣ
	String value;//������ �޺������� ������
	boolean isNew;//����
	public Vector<JComboBox<String>> getComboarr() {
		return comboarr;
	}
	public void setting(int row,Object value){
		this.row = row;
		this.value = (String)value;
		comboarr.get(row).setSelectedItem(value);
	}
	
	public boolean isNew() {
		return isNew;
	}
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	public void setComboarr(Vector<JComboBox<String>> comboarr) {
		this.comboarr = comboarr;
	}
	public int calc(Vector<Vector<String>> list){
		int sum=0;

		for(int i=0;i<list.size();i++){
			sum+=Integer.parseInt(list.get(i).get(2))*
					Integer.parseInt((String)comboarr.get(i).getSelectedItem());
		}
		return sum;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
