package reservation.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import reservation.service.ReservationService;
import reservation.service.ReservationServiceImpl;
import reservation.view.MenuSelect;

public class MenuSelectListener implements ActionListener{
	MenuSelect mainView;
	int count;
	
	public MenuSelectListener(MenuSelect mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UIManager.put("OptionPane.background", Color.white);
		UIManager.put("Panel.background",Color.white);
		if (e.getSource() == mainView.btnPre) {
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "tableSelect");
		}else if(e.getSource()==mainView.btnOrder){
			ReservationService service=new ReservationServiceImpl();
			for(int i=0;i<mainView.menudata.size();i++){
				int reserno=service.reservationSelect()-1;
				int menuno=service.menuNoSelect(mainView.restId,mainView.menudata.get(i).get(0));
				service.insertMenu(reserno,menuno,Integer.parseInt(mainView.menudata.get(i).get(1)));
			}
			JOptionPane.showMessageDialog( mainView, "전송 되었습니다.","전송",JOptionPane.INFORMATION_MESSAGE);
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel,"selectRestaurantPage");
			
		}else if(e.getSource()==mainView.btnCancel){
			int result=JOptionPane.showConfirmDialog( mainView, "취소 하시겠습니까?","취소",JOptionPane.OK_CANCEL_OPTION);
			if(result==JOptionPane.OK_OPTION){
				mainView.frame.mainCardLayout.show(mainView.frame.mainPanel,"selectRestaurantPage");
			}
		}
	}

}
