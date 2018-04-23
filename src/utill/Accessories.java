package utill;

import java.io.File;
import javax.swing.*;

public class Accessories {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFileChooser fileChooser = new JFileChooser();
				LabelAccessory accessory = new LabelAccessory(fileChooser);
				fileChooser.setAccessory(accessory);
				fileChooser.addPropertyChangeListener(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY, accessory);
				int status = fileChooser.showOpenDialog(null);
				if (status == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
				}
				System.exit(0);
			}
		});
	}
}
