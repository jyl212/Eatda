package menu.listener;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import menu.view.Menu;
import utill.LabelAccessory;

public class MenuListener implements ActionListener {
	Menu mainView;
	
	public MenuListener(Menu mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mainView.btn_image){
			JFileChooser fileChooser = new JFileChooser("src/image");
			LabelAccessory accessory = new LabelAccessory(fileChooser);
			fileChooser.setAccessory(accessory);
			fileChooser.addPropertyChangeListener(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY, accessory);
			int status = fileChooser.showOpenDialog(null);
			if (status == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				String imgPath = "src/image/" + selectedFile.getName();
				mainView.txtMenuImgRoute.setText(imgPath); 
				ImageIcon originlIcon = new ImageIcon(imgPath);
				Image originImg = originlIcon.getImage(); 
				Image changedimg = originImg.getScaledInstance(110, 80, Image.SCALE_SMOOTH );
				ImageIcon icon = new ImageIcon(changedimg);
				mainView.lbl_image.setIcon(icon);
			}
		}
		
	}
	

}
