package login.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import customer.service.MemeberService;
import customer.service.MemeberServiceimpl;
import login.view.FindPassWord;
import restaurant.service.RestService;
import restaurant.service.RestServiceImpl;

public class FindPassWordListener implements ActionListener {
	FindPassWord mainView;
	String id;
	boolean type;

	public FindPassWordListener(FindPassWord mainView) {
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btnCancle) {
			if (id != null)
				mainView.frame.logInPage.txtId.setText(id);
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "logInPage");
		} else if (e.getSource() == mainView.btnFind) {
			id = mainView.txtid.getText();
			String name = mainView.txtname.getText();
			String email = mainView.txtemail.getText();
			String tel = mainView.txttel0.getText() + "-" + mainView.txttel1.getText() + "-"
					+ mainView.txttel2.getText();
			String type = (String) mainView.comType.getSelectedItem();
			boolean result = false;

			if (type.equals("개인회원")) {
				MemeberService memeberService = new MemeberServiceimpl();
				result = memeberService.findPW(id, name, email, tel);
				this.type = false;
			} else if (type.equals("업체회원")) {
				RestService restService = new RestServiceImpl();
				result = restService.findPW(id, name, email, tel);
				this.type = true;
			}

			if (result) {
				JOptionPane.showMessageDialog(mainView, "비밀번호를 변경해주세요.");
				mainView.pEditPW.setVisible(true);
				mainView.btnOk.setVisible(true);
				mainView.txtid.setEditable(false);
			} else {
				JOptionPane.showMessageDialog(mainView, "해당 회원이 존재하지 않습니다.");
			}
		} else if (e.getSource() == mainView.btnOk) {
			String pw = mainView.txtNewPW.getText();

			if (pw.equals(mainView.txtNewPWcf.getText())) {
				if (pw.length() < 10) {
					JOptionPane.showMessageDialog(mainView, "비밀번호는 10자리 이상 적어주세요.");
				} else {
					int result = 0;
					if (type) { // 업체
						RestService restService = new RestServiceImpl();
						result = restService.updatePW(id,pw);

					} else { // 개인
						MemeberService memeberService = new MemeberServiceimpl();
						result = memeberService.updatePW(id,pw);
					}

					if (result > 0) {
						JOptionPane.showMessageDialog(mainView, "비밀번호 변경완료! 로그인해주세요!");
						mainView.txtid.setEditable(true);
						mainView.pEditPW.setVisible(false);
						mainView.btnOk.setVisible(false);
						mainView.frame.logInPage.txtId.setText(id);
						mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "logInPage");
					} else {
						JOptionPane.showMessageDialog(mainView, "비밀번호 변경에 실패하였습니다.");
					}
				}
			} else {
				JOptionPane.showMessageDialog(mainView, "비밀번호가 일치하지 않습니다.");
			}
		}

	}

}
