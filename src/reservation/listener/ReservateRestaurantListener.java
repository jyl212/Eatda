package reservation.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;

import customer.service.MemeberService;
import customer.service.MemeberServiceimpl;
import dto.MemberDTO;
import dto.ReservationDTO;
import reservation.view.ReservateRestaurant;
import reservation.view.TableSelect;

public class ReservateRestaurantListener implements ActionListener ,ItemListener{
	ReservateRestaurant mainView;

	
	
	public ReservateRestaurantListener(ReservateRestaurant mainView) {
		super();
		this.mainView = mainView;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.prevNextPanel.btnPrev) {
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "restaurantDetailPage");
		} else if (e.getSource() == mainView.prevNextPanel.btnNext){
			TableSelect tableSelect = new TableSelect(mainView.frame, getReservationInfo()); 
			mainView.frame.mainPanel.add(tableSelect, "tableSelect");
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "tableSelect");
		} else if (e.getSource() == mainView.prevNextPanel.btnCancle){
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "selectRestaurantPage");			
		}
	}



	private ReservationDTO getReservationInfo() {
		
		String reserName = mainView.txtName.getText();
		String reserTel = mainView.txtTel.getText();
		String reserEmail = mainView.txtEmail.getText();
		//TODO 여유가 된다면 스피너로 처리
		int reserPerson = Integer.parseInt(mainView.txtCount.getText());
		String reserMisc = mainView.taMisc.getText();
		if (reserMisc.equals("")){
			reserMisc = "없음";
		}
		Date reserDate = new Date(mainView.cldBookdate.getDate().getTime());
		String reserTime = ((String)mainView.comTime.getSelectedItem()).split(" ~ ")[0];
		
		return new ReservationDTO(0, mainView.frame.ID, 0, mainView.getRestID(), reserDate, reserTime, reserPerson, reserName, reserTel, reserEmail, reserMisc);

	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		if (mainView.chkUseMemberInfo.isSelected()){
			MemeberService service = new MemeberServiceimpl();
			MemberDTO dto = service.memberSelect(mainView.frame.ID);
			if (dto != null) {
				//정보 집어넣기
				mainView.txtName.setText(dto.getMemName());
				mainView.txtEmail.setText(dto.getEmail());
				mainView.txtTel.setText(dto.getMemTel());
			}
		}
		
	}

}
