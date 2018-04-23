package customer.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import customer.service.MemeberService;
import customer.service.MemeberServiceimpl;
import customer.view.NewCustomer;
import dto.MemberDTO;

/*ptmt.setString(1, mem.getMemId());
ptmt.setString(2, mem.getMemPw());
ptmt.setString(3, mem.getMemName());
ptmt.setString(4, mem.getBirth()+"");
ptmt.setString(5, mem.getGender());
ptmt.setString(6, mem.getMemTel());
ptmt.setString(7, mem.getEmail());
ptmt.setString(8, mem.getEmailCheck());
ptmt.setString(9, mem.getSignDate()+"");
ptmt.setString(10, mem.getLoc());*/

public class NewCustomerListener implements ActionListener {
	NewCustomer mainView;
	String memch="";
	String memberid="";
	

	public NewCustomerListener(NewCustomer mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btnCancel) {
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "loginPageSelectView");
		} else if (e.getSource() == mainView.btnSignUpCommit) {
			if(!memch.equals(memberid)&&memberid.length()>=4){
				String memId = mainView.txtCustomerId.getText();
				String pwch1 = new String(mainView.passwordFieldFr.getPassword());
				String pwch2 = new String(mainView.passwordFieldRe.getPassword());
				if(pwch1.equals(pwch2)&&mainView.passwordFieldFr.getPassword().length>=10){
					String memPw = new String(mainView.passwordFieldFr.getPassword());
					String memName = mainView.txtcustomername.getText();
					String birth = mainView.txt_BirthYY.getText() + "/" + mainView.txt_BirthMM.getText() + "/"
							+ mainView.txt_BirthDD.getText();
					String gender;
					if (mainView.rdo_GenderM.isSelected()) {
						gender = "남";
					} else {
						gender = "여";
					}
					String memTel = mainView.txt_Phonefr.getText() + "-" + mainView.txt_PhoneMid.getText() + "-"
							+ mainView.txt_PhonePos.getText();
					String email = mainView.txt_EmailPr.getText();
					String emailCheck;
					if (mainView.chck_Email_agree.isSelected()) {
						emailCheck = "Y";
					} else {
						emailCheck = "N";
					}
					String loc = (String) mainView.comboBox_local.getSelectedItem();
					MemberDTO meminfo = new MemberDTO(memId, memPw, memName, birth, gender, memTel, email, emailCheck, null,
							loc);
					MemeberService service = new MemeberServiceimpl();
					int result = service.memberInsert(meminfo);
					if (result <= 0) {
						JOptionPane.showMessageDialog(mainView, "입력한 자료를 확인해 주세요");
					} else {
						JOptionPane.showMessageDialog(mainView, "와!!! 축하드립니다!! 가입되었습니다!! 우리 다함께 먹쟁이가 되어 보아요!!");
						mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "logInPage");
					}
				}else{
					JOptionPane.showMessageDialog(mainView, "비밀번호가 같지않거나 10자리 이하로 작성하셨네요!! 다시 작성하세요!");
				}
			}else{
				JOptionPane.showMessageDialog(mainView, "아무리 바빠도 중복체크는 해주셔야죠?!");
			}

		}else if(e.getSource()==mainView.btnCheckDupel){
			memberid = mainView.txtCustomerId.getText();
			MemeberService service = new MemeberServiceimpl();
			memch = service.memberIdCheack(memberid);
			if(memberid.equals("")){
				JOptionPane.showMessageDialog(mainView, "아이디를 입력해주세요");
			}else if(memberid.equals(memch)){
				JOptionPane.showMessageDialog(mainView, "동일한 아이디가 존재합니다. 창의성을 좀더 키우세요.");
				mainView.txtCustomerId.setText("");
			}else if(memberid.length()<=3 ){
				JOptionPane.showMessageDialog(mainView, "아이디는 최소 4자리이상 입력해주시기 바랍니다.");
				mainView.txtCustomerId.setText("");
			}else{
				JOptionPane.showMessageDialog(mainView, "사용가능한 아이디 입니다! 굿!");
			}
		}

	}

}
