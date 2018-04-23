package pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import pos.veiw.OrderEdit;
import table.view.TableButton;

public class OrderEditListener implements ActionListener {

	OrderEdit mainView;
	
	
	
	public OrderEditListener(OrderEdit mainView) {
		super();
		this.mainView = mainView;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.eatdaButton){

			ArrayList<TableButton> buttons = mainView.frame.posMain.panel.tableButtons;
			int size = buttons.size();
			TableButton button = null;
			
			for (int i = 0; i < size; i++) {
				button = buttons.get(i);
				if (button.table.getIdNumber() == mainView.frame.posMain.selectedtablenumber) {
					button.doClick();
				}
			}
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "posMain");
		} else if(e.getSource() == mainView.eatdaButton_1) {
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "posMain");
		}

	}

}
