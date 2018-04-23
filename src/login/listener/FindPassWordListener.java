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

			if (type.equals("����ȸ��")) {
				MemeberService memeberService = new MemeberServiceimpl();
				result = memeberService.findPW(id, name, email, tel);
				this.type = false;
			} else if (type.equals("��üȸ��")) {
				RestService restService = new RestServiceImpl();
				result = restService.findPW(id, name, email, tel);
				this.type = true;
			}

			if (result) {
				JOptionPane.showMessageDialog(mainView, "��й�ȣ�� �������ּ���.");
				mainView.pEditPW.setVisible(true);
				mainView.btnOk.setVisible(true);
				mainView.txtid.setEditable(false);
			} else {
				JOptionPane.showMessageDialog(mainView, "�ش� ȸ���� �������� �ʽ��ϴ�.");
			}
		} else if (e.getSource() == mainView.btnOk) {
			String pw = mainView.txtNewPW.getText();

			if (pw.equals(mainView.txtNewPWcf.getText())) {
				if (pw.length() < 10) {
					JOptionPane.showMessageDialog(mainView, "��й�ȣ�� 10�ڸ� �̻� �����ּ���.");
				} else {
					int result = 0;
					if (type) { // ��ü
						RestService restService = new RestServiceImpl();
						result = restService.updatePW(id,pw);

					} else { // ����
						MemeberService memeberService = new MemeberServiceimpl();
						result = memeberService.updatePW(id,pw);
					}

					if (result > 0) {
						JOptionPane.showMessageDialog(mainView, "��й�ȣ ����Ϸ�! �α������ּ���!");
						mainView.txtid.setEditable(true);
						mainView.pEditPW.setVisible(false);
						mainView.btnOk.setVisible(false);
						mainView.frame.logInPage.txtId.setText(id);
						mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "logInPage");
					} else {
						JOptionPane.showMessageDialog(mainView, "��й�ȣ ���濡 �����Ͽ����ϴ�.");
					}
				}
			} else {
				JOptionPane.showMessageDialog(mainView, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
		}

	}

}
