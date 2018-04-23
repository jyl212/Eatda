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
			//�޴����� ������ �����ٰ�
			//posmain���� �ֱ�
			//tableno�� �ĺ�, men����Ʈ ������ �ѱ��
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
					button.doClick(); //��ư Ŭ��
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
			JOptionPane.showMessageDialog(mainView, "���� ���� �Ϸ�!");
		}

	}
}
