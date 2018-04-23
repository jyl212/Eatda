package table.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menu.view.AddMenu;
import table.view.ChangeTableNameFrame;
import table.view.Objects;
import table.view.TableInsert;

public class TableInsertListener implements ActionListener {

	TableInsert mainView;
	
	public TableInsertListener(TableInsert drawTest) {
		mainView = drawTest;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btn1Seat){
			mainView.panel.drawTableMode(1);
		} else if (e.getSource() == mainView.btn2Seat) {
			mainView.panel.drawTableMode(2);
		} else if (e.getSource() == mainView.btn4Seat) {
			mainView.panel.drawTableMode(4);
		} else if (e.getSource() == mainView.btn6Seat) {
			mainView.panel.drawTableMode(6);
		} else if (e.getSource() == mainView.btnWindow) {
			mainView.panel.drawObjectMode(Objects.WINDOW);
		} else if (e.getSource() == mainView.btnDoor) {
			mainView.panel.drawObjectMode(Objects.DOOR);
		} else if (e.getSource() == mainView.btnPartition) {
			mainView.panel.drawObjectMode(Objects.PARTITION);
		} else if (e.getSource() == mainView.btnToilet) {
			mainView.panel.drawObjectMode(Objects.TOILET);
		} else if (e.getSource() == mainView.btnPrev) {
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "registrierenView2");
		} else if (e.getSource() == mainView.btnNext) {
			ChangeTableNameFrame nameFrame = new ChangeTableNameFrame(mainView,null);
			nameFrame.setVisible(true);
						
			
		}


	}

}
