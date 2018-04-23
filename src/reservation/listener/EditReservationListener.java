package reservation.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import reservation.view.EditReservation;
import reservation.view.EditTableSelect;

public class EditReservationListener implements ActionListener {
	EditReservation mainView;

	public EditReservationListener(EditReservation editReservationPage) {
		mainView = editReservationPage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.prevNextPanel.btnCancle){
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "reservationListToCust");
		} else if (e.getSource() == mainView.prevNextPanel.btnNext) {
			getReservationInfo();
			EditTableSelect editTableSelect = new EditTableSelect(mainView.frame,mainView.reser);
			mainView.frame.mainPanel.add(editTableSelect,"editTableSelect");
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "editTableSelect");
		}

	}



	private void getReservationInfo() {
		
		String reserName = mainView.txtName.getText();
		String reserTel = mainView.txtTel.getText();
		String reserEmail = mainView.txtEmail.getText();
		int reserPerson = Integer.parseInt(mainView.txtCount.getText());
		String reserMisc = mainView.taMisc.getText();
		Date reserDate = new Date(mainView.cldBookdate.getDate().getTime());
		String reserTime = ((String)mainView.comTime.getSelectedItem()).split(" ~ ")[0];
		
		StringBuffer buffer = new StringBuffer(reserMisc);
		String string = mainView.reser.getReserMisc();
		if (string.indexOf("/**/")>=0){
			String[] strings = string.split("/\\*\\*/");
			for (int j = 1; j < strings.length; j++) {
				buffer.append("/**/"+strings[j]);				
			}
		}
		
		mainView.reser.setReserDate(reserDate);
		mainView.reser.setReserEmail(reserEmail);
		mainView.reser.setReserMisc(buffer.toString());
		mainView.reser.setReserName(reserName);
		mainView.reser.setReserPerson(reserPerson);
		mainView.reser.setReserTel(reserTel);
		mainView.reser.setReserTime(reserTime);

	}

}
