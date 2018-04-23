package restaurant.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import dto.RestDTO;
import restaurant.view.EditRestaurant;
import table.view.TableEdit;
import utill.LabelAccessory;
import zip.service.ZipService;
import zip.service.ZipServiceImpl;

public class EditRestaurantListener implements ActionListener {

	EditRestaurant mainView;

	public EditRestaurantListener(EditRestaurant companyInfoAltView2) {
		mainView = companyInfoAltView2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btnNext) {
			String restName = mainView.txt_Mutual.getText();
			String ornerName = mainView.txt_Agent.getText();
			String ornerNum = mainView.txt_BusinessNumPr.getText() + "-" + mainView.txt_BusinessNummid.getText() + "-"
					+ mainView.txt_BusinessNumPos.getText();
			String addr = (String) mainView.cbo_sido.getSelectedItem() + " "
					+ (String) mainView.cbo_gungu.getSelectedItem() + " " + mainView.txt_CompanyAddr.getText();
			String restTel = mainView.txtphonefr.getText() + "-" + mainView.txt_PhoneMid.getText() + "-"
					+ mainView.txt_PhonePos.getText();
			String restEmail = mainView.txt_EmailPr.getText();
			String openTime = mainView.txt_OperatingTimeSt.getText();
			String closeTime = mainView.txt_OperatingTimeEnd.getText();
			String restType = (String) mainView.comboBox_Category.getSelectedItem();
			String restDetail = mainView.taMISC.getText();
			String restImg1 = mainView.txt_CompanyImage1.getText();
			String restImg2 = mainView.txt_CompanyImage2.getText();

			String pwch1 = new String(mainView.passwordFieldFr.getPassword());
			String pwch2 = new String(mainView.passwordFieldRe.getPassword());

			if (pwch1.equals(pwch2) && mainView.passwordFieldFr.getPassword().length >= 10) {
				RestDTO dto = mainView.restinfo;
				// restidwr, pwch1, restName, ornerName, ornerNum, addr,
				// restTel, restEmail, openTime, closeTime, restType,
				// restDetail, restImg1, restImg2);
				dto.setRestPw(pwch1);
				dto.setRestName(restName);
				dto.setOrnerName(ornerName);
				dto.setOrnerNum(ornerNum);
				dto.setAddr(addr);
				dto.setRestTel(restTel);
				dto.setRestEmail(restEmail);
				dto.setOpenTime(openTime);
				dto.setCloseTime(closeTime);
				dto.setRestType(restType);
				dto.setRestDetail(restDetail);
				dto.setRestImg1(restImg1);
				dto.setRestImg2(restImg2);

				TableEdit tableEdit = new TableEdit(mainView.frame, dto);

				mainView.frame.mainPanel.add(tableEdit, "tableEdit");
				mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "tableEdit");
			} else {
				JOptionPane.showMessageDialog(mainView, "비밀번호가 일치하지 않거나 10자리 이하입니다.");
			}

		} else if (e.getSource() == mainView.btnCancel) {
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "round_Button");
		} else if (e.getSource() == mainView.cbo_sido) {
			String si = (String) mainView.cbo_sido.getSelectedItem();
			ZipService service = new ZipServiceImpl();
			mainView.cbo_gungu.setModel(new DefaultComboBoxModel<String>(service.getGUGUN(si)));
		} else if (e.getSource() == mainView.btn_CompanyimgUpload1) {//
			JFileChooser fileChooser = new JFileChooser("src/image");
			LabelAccessory accessory = new LabelAccessory(fileChooser);
			fileChooser.setAccessory(accessory);
			fileChooser.addPropertyChangeListener(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY, accessory);
			int status = fileChooser.showOpenDialog(null);
			if (status == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				mainView.txt_CompanyImage1.setText("src/image/" + selectedFile.getName());
			}
		} else if (e.getSource() == mainView.btn_CompanyimgUpload2) {
			JFileChooser fileChooser = new JFileChooser("src/image");
			LabelAccessory accessory = new LabelAccessory(fileChooser);
			fileChooser.setAccessory(accessory);
			fileChooser.addPropertyChangeListener(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY, accessory);
			int status = fileChooser.showOpenDialog(null);
			if (status == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				mainView.txt_CompanyImage2.setText("src/image/" + selectedFile.getName());
			}
		}
	}
}
