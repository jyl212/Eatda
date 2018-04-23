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
						gender = "��";
					} else {
						gender = "��";
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
						JOptionPane.showMessageDialog(mainView, "�Է��� �ڷḦ Ȯ���� �ּ���");
					} else {
						JOptionPane.showMessageDialog(mainView, "��!!! ���ϵ帳�ϴ�!! ���ԵǾ����ϴ�!! �츮 ���Բ� �����̰� �Ǿ� ���ƿ�!!");
						mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "logInPage");
					}
				}else{
					JOptionPane.showMessageDialog(mainView, "��й�ȣ�� �����ʰų� 10�ڸ� ���Ϸ� �ۼ��ϼ̳׿�!! �ٽ� �ۼ��ϼ���!");
				}
			}else{
				JOptionPane.showMessageDialog(mainView, "�ƹ��� �ٺ��� �ߺ�üũ�� ���ּž���?!");
			}

		}else if(e.getSource()==mainView.btnCheckDupel){
			memberid = mainView.txtCustomerId.getText();
			MemeberService service = new MemeberServiceimpl();
			memch = service.memberIdCheack(memberid);
			if(memberid.equals("")){
				JOptionPane.showMessageDialog(mainView, "���̵� �Է����ּ���");
			}else if(memberid.equals(memch)){
				JOptionPane.showMessageDialog(mainView, "������ ���̵� �����մϴ�. â�Ǽ��� ���� Ű�켼��.");
				mainView.txtCustomerId.setText("");
			}else if(memberid.length()<=3 ){
				JOptionPane.showMessageDialog(mainView, "���̵�� �ּ� 4�ڸ��̻� �Է����ֽñ� �ٶ��ϴ�.");
				mainView.txtCustomerId.setText("");
			}else{
				JOptionPane.showMessageDialog(mainView, "��밡���� ���̵� �Դϴ�! ��!");
			}
		}

	}

}
