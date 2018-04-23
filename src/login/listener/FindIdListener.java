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
			
			if (type.equals("개인회원")){
				MemeberService memeberService = new MemeberServiceimpl();
				result = memeberService.findID(name,email,tel);
			} else if (type.equals("업체회원")){
				RestService restService = new RestServiceImpl();
				result = restService.findID(name,email,tel);
				
			}
			
			if (result != null){
				mainView.lblFindResult.setText("ID는 "+result+" 입니다.");
			} else {
				mainView.lblFindResult.setText("찾으시는 ID가 없습니다.");
			}
		}

	}

}
