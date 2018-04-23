package login.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import customer.service.MemeberService;
import customer.service.MemeberServiceimpl;
import login.view.FindId;
import restaurant.service.RestService;
import restaurant.service.RestServiceImpl;

public class FindIdListener implements ActionListener {

	FindId mainView;
	String result = null;
	
	public FindIdListener(FindId mainView) {
		this.mainView = mainView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mainView.btnok){
			if (result != null){
				mainView.frame.logInPage.txtId.setText(result);
			}
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "logInPage");
		} else if (e.getSource() == mainView.btnFind){
			String name = mainView.txtname.getText();
			String email = mainView.txtemail.getText();
			String tel = mainView.txttel0.getText() + "-" +mainView.txttel1.getText()+"-"+mainView.txttel2.getText();
			String type = (String) mainView.comType.getSelectedItem();
			
			if (type.equals("����ȸ��")){
				MemeberService memeberService = new MemeberServiceimpl();
				result = memeberService.findID(name,email,tel);
			} else if (type.equals("��üȸ��")){
				RestService restService = new RestServiceImpl();
				result = restService.findID(name,email,tel);
				
			}
			
			if (result != null){
				mainView.lblFindResult.setText("ID�� "+result+" �Դϴ�.");
			} else {
				mainView.lblFindResult.setText("ã���ô� ID�� �����ϴ�.");
			}
		}

	}

}
