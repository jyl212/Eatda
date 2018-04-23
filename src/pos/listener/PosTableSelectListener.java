package pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import pos.veiw.POSMain;
import table.view.Table;
import table.view.TableButton;
import table.view.TableShowPanel;

public class PosTableSelectListener implements ActionListener {
	TableShowPanel mainView;
	POSMain postable;

	public PosTableSelectListener(TableShowPanel mainView, POSMain postable) {
		super();
		this.mainView = mainView;
		this.postable = postable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = 0;

		if (mainView.tableButtons.contains((TableButton)e.getSource())){
			TableButton tableButton = (TableButton)e.getSource();

			Table table1 = tableButton.table;
			int tableNum = table1.getIdNumber();
			postable.selectedtablenumber = tableNum;
			postable.tfTableName.setText("Table "+table1.getName());
			
			Vector<Vector<String>> menuList = tableButton.getMenuList();
			
			int size = menuList.size();
			int total = 0;
			for (int j = 0; j < size; j++) {
				Vector<String> info = menuList.get(j);
				total += Integer.parseInt(info.get(1))*Integer.parseInt(info.get(2));
			}
			Vector<String> colNames = getColumn();
			shoewdata(tableButton.getMenuList(),colNames);
			postable.tfTotalPrice.setText(total+"");
		}

	}

	public void shoewdata(Vector<Vector<String>> table, Vector<String> colNames) {
		DefaultTableModel model = new DefaultTableModel();
		model.setDataVector(table, colNames);
		postable.MainPostable.setModel(model);		  
	}

	public Vector<String> getColumn() {
		Vector<String> colNames = new Vector<String>();
		colNames.addElement("메뉴");
		colNames.addElement("수량");
		colNames.addElement("가격");
		return colNames;
	}
}
