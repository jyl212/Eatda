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
import reservation.view.EditReservation;
import reservation.view.EditTableSelect;
import reservation.view.ReservationListToCust;
import reservation.view.TableSelect;
import restaurant.view.EditRestaurant;
import table.view.Table;
import table.view.TableButton;

public class EditTableSelectListener implements ActionListener, ListSelectionListener, MouseListener {
	EditTableSelect mainView;
	

	
	public EditTableSelectListener(EditTableSelect mainView) {
		super();
		this.mainView = mainView;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btnPre) {
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "editReservation");
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
				String temp = mainView.getDto().getReserMisc();
				StringBuffer buffer;
				if (temp.indexOf("/**/")>=0){
					buffer = new StringBuffer(temp.split("/\\*\\*/")[0]);
				} else {
					buffer = new StringBuffer(temp);
				}
				for (int i = 1; i < size; i++) {
					buffer.append("/**/"+mainView.selectedTable.get(i).getIdNumber());
				}
				mainView.getDto().setReserMisc(buffer.toString());

				ReservationService reservationService = new ReservationServiceImpl();
				reservationService.reservationUpdate(mainView.getDto());

				//할수 있다면 메뉴수정도...는 힘들꺼야 아마

				JOptionPane.showMessageDialog(null, "수정완료");
				
				ReservationListToCust reservationListToCust = new ReservationListToCust(mainView.frame, mainView.frame.ID);
				mainView.frame.mainPanel.add(reservationListToCust,"reservationListToCust");
				mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "reservationListToCust");
			}
		} else if (mainView.pTableArea.tableButtons.contains((TableButton)e.getSource())){
			Table table = ((TableButton)e.getSource()).table;
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
