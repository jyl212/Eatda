package pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import pos.veiw.POSMain;

public class POSMainListener implements ActionListener {

	POSMain mainView;

	public POSMainListener(POSMain mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.moneycal) {
			JOptionPane.showMessageDialog(mainView, "���� �����Ǿ����ϴ�.");
		    }else if (e.getSource() == mainView.cardcalc) {
				JOptionPane.showMessageDialog(mainView, "ī�� �����Ǿ����ϴ�.");
			} else if (e.getSource() == mainView.order) {
				mainView.frame.nocustomer.tablename.setText(mainView.tfTableName.getText());
				DefaultTableModel model = (DefaultTableModel)mainView.MainPostable.getModel();
				mainView.frame.nocustomer.menudata = model.getDataVector();
				mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "nocustomer");
			} else if (e.getSource() == mainView.orderEdit) {
				mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "pos_2");
			} else if (e.getSource() == mainView.eatdaButton) {
				mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "pos_3");
			} else if (e.getSource() == mainView.eatdaButton_1) {
				mainView.frame.topPanel.setVisible(false);
				mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "logInPage");
			}

		}

	}

