package login.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import customer.service.MemeberService;
import customer.service.MemeberServiceimpl;
import login.view.LogInPage;
import pos.veiw.Order;
import pos.veiw.OrderEdit;
import pos.veiw.POSMain;
import restaurant.service.RestService;
import restaurant.service.RestServiceImpl;

public class LogInPageListener implements ActionListener {
	LogInPage mainView;

	public LogInPageListener(LogInPage mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btnlog_in) {
			String memId = mainView.txtId.getText();
			String memPw = new String(mainView.passwordField.getPassword());
			MemeberService service1 = new MemeberServiceimpl();
			RestService service2 = new RestServiceImpl();
			boolean login = service1.TryMemberLog(memId, memPw);
			boolean login2 = service2.TryRestLog(memId, memPw);

			if (login) {
				mainView.frame.ID = memId;
				mainView.frame.type = false;
				mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "selectRestaurantPage");
				mainView.frame.topPanel.setVisible(true);
			} else {
				if (login2) {
					mainView.frame.ID = memId;
					mainView.frame.type = true;
					mainView.frame.posMain = new POSMain(mainView.frame);
					mainView.frame.mainPanel.add(mainView.frame.posMain,"posMain");
					mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "posMain");
					
					mainView.frame.nocustomer = new Order(mainView.frame);
					mainView.frame.mainPanel.add(mainView.frame.nocustomer, "nocustomer");

					mainView.frame.pos_2 = new OrderEdit(mainView.frame);
					mainView.frame.mainPanel.add(mainView.frame.pos_2, "pos_2");
					
					mainView.frame.topPanel.setVisible(true);
				} else {
					JOptionPane.showConfirmDialog(mainView, "ID와 비밀번호를 정확히 입력바랍니다.");

				}
			}
		} else if (e.getSource() == mainView.btnSign_Up) {
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "loginPageSelectView");
		} else if (e.getSource() == mainView.btnFindID) {
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "findId");
		} else if (e.getSource() == mainView.btnFindPW) {
			mainView.frame.findIPass.txtid.setText(mainView.txtId.getText());
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "findIPass");
		}

	}

}
