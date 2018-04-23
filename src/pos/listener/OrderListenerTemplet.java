package pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import pos.veiw.OrderEdit;
import reservation.view.MyDefaultTable;
import reservation.view.TableData;

public class OrderListenerTemplet implements ItemListener, ActionListener {
	OrderEdit frame;

	int check = 0;
	int uncheck = 0;
	public int sum;
	int count;
	int row = 0;
	TableData tableData;

	public OrderListenerTemplet() {
		// TODO Auto-generated constructor stub
	}

	public OrderListenerTemplet(OrderEdit frame) {
		super();
		this.frame = frame;
		tableData = new TableData();
	}

	// 체크박스가 눌려질때 - 처음 테이블에 체크박스를 추가할때
	public void showData(Vector<Vector<String>> list, Vector<String> colNames) {
		DefaultTableModel model = new DefaultTableModel();
		model.setDataVector(list, colNames);
		frame.resarOdertable.setModel(model);
	}

	void changeCellEditor(JTable table, TableColumn column) {
		MyDefaultTable renderer = new MyDefaultTable(tableData);
		column.setCellRenderer(renderer);
		JComboBox<String> combo = (JComboBox<String>) renderer.getTableCellRendererComponent(table, 1, false, false,
				check, 1);
		// tableData.getComboarr().add(combo);
		tableData.getComboarr().add(combo);
		combo.addActionListener(this);
	}

	public void setPrice(Vector<Vector<String>> list) {
		int sum = tableData.calc(list);
		frame.totalPrice.setText(sum + "");
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			for (int j = 0; j < frame.menuPanelarr.length; j++) {
				for (int i = 0; i < frame.menuPanelarr[j].chkarr.length; i++) {
					if (e.getSource() == frame.menuPanelarr[j].chkarr[i]) {
						check = i;
						row = j;
					}
				}
			}
			Vector<String> data = new Vector<String>();
			data.add(frame.menuPanelarr[row].lblmenuarr[check].getText());
			data.add("1");
			data.add(frame.menuPanelarr[row].lblpricearr[check].getText().substring(1));

			Vector<String> temp = null;
			int size = frame.menudata.size();
			for (int i = 0; i < size; i++) {
				if (frame.menudata.get(i).get(0).equals(data.get(0))) { // 만약 같은
																		// 메뉴라면
					temp = frame.menudata.get(i);
					break;
				}
			}
			if (temp == null)
				frame.menudata.add(data);
			else
				temp.set(1, (Integer.parseInt(temp.get(1)) + 1) + "");
		} else {
			for (int row = 0; row < frame.menuPanelarr.length; row++) {
				for (int i = 0; i < frame.menuPanelarr[row].chkarr.length; i++) {
					if (e.getSource() == frame.menuPanelarr[row].chkarr[i]) {
						String menuname = frame.menuPanelarr[row].lblmenuarr[i].getText();
						for (int j = 0; j < frame.menudata.size(); j++) {
							Vector<String> menu = frame.menudata.get(j);
							if (menu.get(0).equals(menuname)) {
								uncheck = j;
							}
						}
					}
				}
			}
			frame.menudata.remove(uncheck);

		}
		showData(frame.menudata, frame.colName);
		changeCellEditor(frame.resarOdertable, frame.resarOdertable.getColumn("수량"));
		setPrice(frame.menudata);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tableData.getComboarr().get(tableData.getRow())) {
			frame.menudata.get(tableData.getRow()).set(1, tableData.getValue());
			setPrice(frame.menudata);
		}
	}
}
