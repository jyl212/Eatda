package table.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menu.view.AddMenu;
import menu.view.EditMenu;
import restaurant.service.RestService;
import restaurant.service.RestServiceImpl;
import table.service.TableService;
import table.service.TableServiceImpl;
import table.view.ChangeTableModel;
import table.view.ChangeTableNameFrame;

public class ChangeTableNameFrameListener implements ActionListener {
	ChangeTableNameFrame mainView;
	
	
	public ChangeTableNameFrameListener(ChangeTableNameFrame mainView) {
		super();
		this.mainView = mainView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btnOk){
			
			if (mainView.insertPanel != null){
				mainView.insertPanel.panel.setTableNameAndComent(
						((ChangeTableModel)mainView.table.getModel()).getData()
						);
				
				mainView.dispose();
				
				AddMenu addMenu  = new AddMenu(
						mainView.insertPanel.frame,
						mainView.insertPanel.panel.tables,
						mainView.insertPanel.restInfo
						);
				
				mainView.insertPanel.frame.mainPanel.add(addMenu,"addMenu");
				mainView.insertPanel.frame.mainCardLayout.show(mainView.insertPanel.frame.mainPanel, "addMenu");	
				
			} else {
				if (mainView.editPanel != null){

					mainView.editPanel.panel.setTableNameAndComent(
							((ChangeTableModel)mainView.table.getModel()).getData()
							);

					EditMenu editMenu = new EditMenu(
							mainView.editPanel.frame,
							mainView.editPanel.panel.tables,
							mainView.editPanel.panel.deleteTableList, 
							mainView.editPanel.panel.updateTableList, 
							mainView.editPanel.restInfo
							);

					mainView.editPanel.frame.mainPanel.add(editMenu,"editMenu");
					mainView.editPanel.frame.mainCardLayout.show(mainView.editPanel.frame.mainPanel, "editMenu");

					mainView.dispose();	

//					TableService service = new TableServiceImpl();
//					//TODO 에러처리
//					service.tableUpdate(
//							mainView.editPanel.panel.tables, 
//							mainView.editPanel.panel.deleteTableList, 
//							mainView.editPanel.panel.updateTableList, 
//							mainView.editPanel.frame.ID
//							);
//					
//					RestService service2 = new RestServiceImpl();
//					service2.restUpdate(mainView.editPanel.restInfo);
				}
			}
		} else if (e.getSource() == mainView.btnCancle) {
			mainView.dispose();
		}

	}	

}
