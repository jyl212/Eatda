package login.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import login.view.SelectRegisteration;

public class SelectRegisterationListener implements ActionListener {

	SelectRegisteration mainView;
	
	public SelectRegisterationListener(SelectRegisteration loginPageSelectView) {
		mainView = loginPageSelectView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btnCustomer) {
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "registrierenView1");
		} else if (e.getSource() == mainView.btncompany){
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "registrierenView2");
		}

	}

}
