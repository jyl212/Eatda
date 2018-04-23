package reservation.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import reservation.service.ReservationService;
import reservation.service.ReservationServiceImpl;
import reservation.view.MenuSelect;
import reservation.view.TableSelect;
import table.view.Table;
import table.view.TableButton;

public class TableSelectListener implements ActionListener, ListSelectionListener, MouseListener {
	TableSelect mainView;
	

	
	public TableSelectListener(TableSelect mainView) {
		super();
		this.mainView = mainView;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btnPre) {
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "reservateRestaurant");
		} else if (e.getSource() == mainView.btnNext){
			int count = 0;
			int size = mainView.selectedTable.size();
			for (int i = 0; i <size ; i++) {
				count += mainView.selectedTable.get(i).getSeat();
			}
			
			if (mainView.getDto().getReserPerson() > count){
				JOptionPane.showMessageDialog(mainView, "인원수보다 좌석수가 적습니다.");
			
			} else {
				//특이사항 컬럼에 덧붙힘 구분자 ==> /**/
				mainView.getDto().setTableNo(mainView.selectedTable.get(0).getIdNumber());
				StringBuffer buffer = new StringBuffer(mainView.getDto().getReserMisc());
				for (int i = 1; i < size; i++) {
					buffer.append("/**/"+mainView.selectedTable.get(i).getIdNumber());
				}
				mainView.getDto().setReserMisc(buffer.toString());
				
				ReservationService reservationService = new ReservationServiceImpl();
				reservationService.reservationInsert(mainView.getDto());
				int ans = JOptionPane.showConfirmDialog(mainView, "예약완료! 메뉴를 선택하시겠습니까?","예약완료",JOptionPane.YES_NO_OPTION);

				if (ans == JOptionPane.YES_OPTION) {
					String restID = mainView.getDto().getRestId();
					MenuSelect menuSelect = new MenuSelect(mainView.frame, restID);
					mainView.frame.mainPanel.add(menuSelect,"menuSelect");
					mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "menuSelect");
				} else if (ans == JOptionPane.NO_OPTION) {
					mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "selectRestaurantPage");
				}
			}
		} else if (mainView.pTableArea.tableButtons.contains((TableButton)e.getSource())){
			TableButton tableButton = (TableButton)e.getSource();
			if (tableButton.isResevated()){
				JOptionPane.showMessageDialog(mainView, "이미 예약이 완료된 좌석입니다 :(");
			} else {
				Table table = tableButton.table;
				if (mainView.selectedTable == null)
					mainView.selectedTable = new ArrayList<Table>();
				if (!mainView.selectedTable.contains(table)){
					DefaultListModel<String> listModel = (DefaultListModel<String>) mainView.list.getModel();
					listModel.addElement(table.getName());
					mainView.list.setModel(listModel);
					mainView.selectedTable.add(table);
					mainView.list.validate();
					mainView.list.repaint();
				}
			}
		}
		

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == mainView.list){
			if (e.getValueIsAdjusting()){
				int index = mainView.list.getSelectedIndex();
				mainView.taTableInfo.setText(mainView.selectedTable.get(index).getComment());
			}
		}
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == mainView.list) {
			if (e.getButton() == MouseEvent.BUTTON3) {
				JList list = (JList)e.getSource();
				int row = list.locationToIndex(e.getPoint());
				
				if (row >= 0) {
					DefaultListModel<String> defaultListModel = (DefaultListModel<String>) mainView.list.getModel();
					defaultListModel.remove(row);
					mainView.list.setModel(defaultListModel);
					mainView.selectedTable.remove(row);
					mainView.list.validate();
					mainView.list.repaint();

					mainView.taTableInfo.setText("");
				}

			}
		}
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
