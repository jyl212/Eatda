package reservation.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.swing.JOptionPane;

import dto.ReservationDTO;
import reservation.view.ReservationInfoToRest;
import reservation.view.ReservationListToRest;
import table.view.TableButton;
import utill.NaverMail;

public class ReservationInfoToRestListener implements ActionListener {

	ReservationInfoToRest mainView;
	
	public ReservationInfoToRestListener(ReservationInfoToRest bookInfoPanelToRest) {
		mainView = bookInfoPanelToRest;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btnCheckResv) {
			//메뉴정보 모조리 가져다가
			//posmain으로 넣기
			//tableno로 식별, men리스트 뽑은거 넘기기
			ArrayList<TableButton> buttons = mainView.page.frame.posMain.panel.tableButtons;
			int size = buttons.size();
			TableButton button = null;
			int tableNum = mainView.reser.getTableNo();
			for (int i = 0; i < size; i++) {
				button = buttons.get(i);
				if(button.table.getIdNumber() == tableNum){
					if (mainView.menuList != null)
						button.setMenuList(mainView.menuList);
					button.dto = mainView.reser;
					button.doClick(); //버튼 클릭
					button.guestIn();
				}
			}
			
			mainView.page.frame.mainCardLayout.show(mainView.page.frame.mainPanel, "posMain");

			ReservationListToRest reservationListToRest = new ReservationListToRest(mainView.page.frame);
			mainView.page.frame.mainPanel.add(reservationListToRest,"reservationInfoToRest");
		} else if (e.getSource() == mainView.btnSendMail) {
			//http://mkil.tistory.com/339
			ReservationInfoToRest reser = mainView;
			try {
				new NaverMail(reser);
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(mainView, "메일 전송 완료!");
		}

	}
}
