package restaurant.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import dto.RestDTO;
import menu.view.AddMenu;
import restaurant.service.RestService;
import restaurant.service.RestServiceImpl;
import restaurant.view.NewRestaurant;
import table.view.TableInsert;
import utill.LabelAccessory;
import zip.service.ZipService;
import zip.service.ZipServiceImpl;

public class NewRestaurantListener implements ActionListener {
	NewRestaurant mainView;
	AddMenu subView;
	String restidch = "";//--------
	String restidwr = "";
	String pwch1 = "";
	String pwch2 = "";//-------------
	String restId = "";
	String restPw = "";
	String restName = "";
	String ornerName = "";
	String ornerNum = "";
	String addr = "";
	String restTel = "";
	String restEmail = "";
	String openTime	= "";
	String closeTime = "";
	String restType = "";
	String restDetail = "";
	String restImg1 = "";
	String restImg2 = "";
	public NewRestaurantListener(NewRestaurant registrierenView2) {
		mainView = registrierenView2;
	}
	public NewRestaurantListener(AddMenu subView) {
		super();
		this.subView = subView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == mainView.btnNext) {
			restName = mainView.txt_Mutual.getText();
			ornerName = mainView.txt_Agent.getText();
			ornerNum = mainView.txt_BusinessNumPr.getText()+"-"+mainView.txt_BusinessNummid.getText()+"-"+
					mainView.txt_BusinessNumPos.getText();
			addr = (String)mainView.cbo_sido.getSelectedItem()+" "+(String)mainView.cbo_gungu.getSelectedItem()+" "+mainView.txt_CompanyAddr.getText();
			restTel = mainView.textField.getText()+"-"+mainView.txt_PhoneMid.getText()+"-"+mainView.txt_PhonePos.getText();
			restEmail = mainView.txt_EmailPr.getText();
			openTime  = mainView.txt_OperatingTimeSt.getText();
			closeTime = mainView.txt_OperatingTimeEnd.getText();
			restType = (String)mainView.comboBox_Category.getSelectedItem();
			restDetail = mainView.taMISC.getText();
			restImg1 = mainView.txt_CompanyImage1.getText();
			restImg2 = mainView.txt_CompanyImage2.getText();
			pwch1 = new String(mainView.passwordFieldFr.getPassword());
			pwch2 = new String(mainView.passwordFieldRe.getPassword());
			if (!restidch.equals(restidwr)) {
				if (restidwr.equals("")) {
					JOptionPane.showMessageDialog(mainView, "id를 입력하지 않으셨습니다.");
				} else if (!pwch1.equals(pwch2) || pwch1.length() < 10 || pwch1.length() > 16) {
					JOptionPane.showMessageDialog(mainView, "비밀번호가 일치하지 않거나 , 입력형식이 잘못되었습니다.");
				} else if (restName.equals("")) {
					JOptionPane.showMessageDialog(mainView, "상호명이 입력되지 않았습니다.");
				} else if (ornerName.equals("")) {
					JOptionPane.showMessageDialog(mainView, " 대표자가 입력되지 않았습니다.");
				} else if (mainView.txt_BusinessNumPr.getText().equals("")
						|| mainView.txt_BusinessNummid.getText().equals("")
						|| mainView.txt_BusinessNumPos.getText().equals("")) {
					JOptionPane.showMessageDialog(mainView, "사업자번호가 입력되지 않았습니다.");
				} else if (mainView.txt_PhoneMid.getText().equals("") || mainView.txt_PhonePos.getText().equals("")) {
					JOptionPane.showMessageDialog(mainView, "전화번호가 입력되지 않았습니다.");
				} else if (restEmail.equals("")) {
					JOptionPane.showMessageDialog(mainView, "이메일 번호가 입력되지 않았습니다.");
				} else if (openTime.equals("")
						|| closeTime.equals("")) {
					JOptionPane.showMessageDialog(mainView, "매장운영 시간이 입력되지 않았습니다.");
				} else if (restType.equals("")) {
					JOptionPane.showMessageDialog(mainView, "식당유형 선택이 되지 않았습니다.");
				} else if (restImg1.equals("")
						|| mainView.txt_CompanyImage1.getText().equals("")) {
					JOptionPane.showMessageDialog(mainView, "이미지가 등록되지 않았습니다.");
				} else if (restDetail.equals("")) {
					JOptionPane.showMessageDialog(mainView, "업체 소개글이 입력되지 않았습니다.");
				} else{
					RestDTO restinfo = new RestDTO(restidwr, pwch1, restName, ornerName, ornerNum, addr, restTel, restEmail, openTime, closeTime, restType, restDetail, restImg1, restImg2);
					JOptionPane.showMessageDialog(subView, ornerName+"님의 1단계 가입 완료!.");

					TableInsert tableInsert = new TableInsert(mainView.frame,restinfo); // 새로 페이지 만들어서, 새로 만든 페이지에 restinfo를 넘겨준다
					mainView.frame.mainPanel.add(tableInsert,"tableInsert"); // mainFrame에 있는 카드페널에 추가하고
					mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "tableInsert"); // 해당 페널 불러줘요!!!

					//					}

				}
			} else {
				JOptionPane.showMessageDialog(mainView, "아이디 중복체크 해주셔야죠?^^");
			}

		} else if (e.getSource() == mainView.btnCancel) {
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "loginPageSelectView");

		} else if (e.getSource() == mainView.btn_OverlapCheack) {
			restidwr = mainView.txt_CompanyId.getText();
			RestService service = new RestServiceImpl();
			restidch = service.restIdCheack(restidwr);
			if (restidch.equals(restidwr)) {
				JOptionPane.showMessageDialog(mainView, "동일한 아이디가 존재하거나 입력하지 않으셨네요!");
				mainView.txt_CompanyId.setText("");
			} else if (restidwr.length() <= 3) {
				JOptionPane.showMessageDialog(mainView, "아이디는 최소 4자리 이상 입력해주셔야되요!");
			} else {
				JOptionPane.showMessageDialog(mainView, "사용가능한 아이디 입니다요!!!");
			}

		} else if (e.getSource()==mainView.btn_CompanyimgUpload1){//
			JFileChooser fileChooser = new JFileChooser("src/image");
			LabelAccessory accessory = new LabelAccessory(fileChooser);
			fileChooser.setAccessory(accessory);
			fileChooser.addPropertyChangeListener(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY, accessory);
			int status = fileChooser.showOpenDialog(null);
			if (status == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				mainView.txt_CompanyImage1.setText("src/image/" + selectedFile.getName()); 
			}
		} else if (e.getSource() == mainView.btn_CompanyimgUpload2){
			JFileChooser fileChooser = new JFileChooser("src/image");
			LabelAccessory accessory = new LabelAccessory(fileChooser);
			fileChooser.setAccessory(accessory);
			fileChooser.addPropertyChangeListener(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY, accessory);
			int status = fileChooser.showOpenDialog(null);
			if (status == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				mainView.txt_CompanyImage2.setText("src/image/" + selectedFile.getName()); 
			}
		} else if (e.getSource() == mainView.cbo_sido){
			String si = (String)mainView.cbo_sido.getSelectedItem();
			ZipService service = new ZipServiceImpl();
			mainView.cbo_gungu.setModel(new DefaultComboBoxModel<String>(service.getGUGUN(si)));
			
		}
	}
}

