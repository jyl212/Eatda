package customer.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import customer.service.MemeberService;
import customer.service.MemeberServiceimpl;
import customer.view.EditCustomer;
import dto.MemberDTO;

public class EditCustomerListener implements ActionListener {

	EditCustomer mainView;
	
	public EditCustomerListener(EditCustomer editCustomer) {
		mainView = editCustomer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btn_Cancel) {
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "logInPage");
			
		} else if (e.getSource() == mainView.btn_UpdateCommit){
			String pwch1 = new String(mainView.passwordFieldFr.getPassword());
			String pwch2 = new String(mainView.passwordFieldRe.getPassword());
			if(pwch1.equals(pwch2)&&mainView.passwordFieldFr.getPassword().length>=10){

				String memId = mainView.lbl_customId.getText();
				String memPw = new String(mainView.passwordFieldFr.getPassword());
				String memName = mainView.text_name.getText();
				String birth = mainView.txt_BirthYY.getText()+"/"+mainView.txt_BirthMM.getText()+"/"+
								mainView.txt_BirthDD.getText();
				String gender = "";
				if(mainView.rdo_GenderM.isSelected()){
					gender = "남";
				}else{
					gender = "여";
				}
				String memTel = mainView.txt_phonefr.getText()+"-"+mainView.txt_PhoneMid.getText()+"-"+mainView.txt_PhoneBt.getText();
				String email = mainView.txt_EmailPr.getText();
				String emailCheck = "";
				if(mainView.chck_Email_agree.isSelected()){
					emailCheck = "Y";
				} else {
					emailCheck = "N";
				}
				String loc = (String)mainView.comboBox_local.getSelectedItem();
				MemeberService service = new MemeberServiceimpl();
				MemberDTO meminfo = new MemberDTO(memId, memPw, memName, birth, gender, memTel, email, emailCheck, null, loc);
				service.memberUpdate(meminfo);
				
				JOptionPane.showMessageDialog(mainView, "감축드립옵니다. 정보는 잘 수정되었습니다. 오늘도 즐거운 먹쟁가 되어주세요.");
				mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "customerMenuPage");
			}else{
				JOptionPane.showMessageDialog(mainView, "비밀번호가 일치하지 않거나 10자리 이하입니다.");
			}
		} 

	}

}
