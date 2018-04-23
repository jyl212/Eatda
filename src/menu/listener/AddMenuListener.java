package menu.listener;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import menu.service.MenuService;
import menu.service.MenuServiceImpl;
import menu.view.AddMenu;
import menu.view.Menu;
import restaurant.service.RestService;
import restaurant.service.RestServiceImpl;
import table.service.TableService;
import table.service.TableServiceImpl;

public class AddMenuListener implements ActionListener {

	AddMenu mainView;
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public AddMenuListener(AddMenu menuInsert) {
		mainView = menuInsert;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.btnpre){ //�����ܰ�
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "tableInsert");
		} else if (e.getSource() == mainView.btnmenuplus){//�޴��߰�
			Menu menuPlus = new Menu();
			mainView.panel.add(menuPlus);
			mainView.menuList.add(menuPlus);
			
			setAllBounds();
			
			paintPanel();
			
		} else if(e.getSource()== mainView.btndelete){//�޴����� üũ�ڽ� ���� ���Ѽ� ��� ���־ߵɱ...? �ƹ��� ã�ƺ��� ���ϰ���..��

			int len = mainView.menuList.size();//��̸���Ʈ�ȿ� ����ִ� �޴��÷���!
			int i = 0;//�ʱ�ȭ
			
			while ( i < len) {
				Menu menuPlus = mainView.menuList.get(i);//��̸���Ʈ�� i��° �޴��÷����� �����´�
				if (menuPlus.chkmenu.isSelected()) {
					mainView.menuList.remove(i);
					i=0;
					len = mainView.menuList.size();
					continue;
				}
				i++;
			}
				
			setAllBounds();
			
			//���� �����
			mainView.panel.removeAll();
			
			//�ٽ� �г� �߰�
			len = mainView.menuList.size();
			
			for (int j = 0; j < len; j++) {
				mainView.panel.add(mainView.menuList.get(j));
			}
			
			paintPanel();
			
		} else if (e.getSource() == mainView.btn_commit) {
			RestService restService = new RestServiceImpl();
			TableService tableService = new TableServiceImpl();
			MenuService menuservice = new MenuServiceImpl();
			//�޴� ���� ����
			
			restService.restInsert(mainView.restInfo);
			tableService.TableInsert(mainView.tables, mainView.restInfo.getRestId());
			menuservice.menuInsert(mainView.menuList, mainView.restInfo.getRestId());
			//�޴� �߰��ϱ�
			
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "logInPage");
		}

	}

	private void paintPanel() {

		mainView.panel.setPreferredSize(new Dimension(965, mainView.menuList.size()*88));//setPreferredSize �����г� ������ ���� -> Dimensionũ�����

		mainView.panel.validate(); //�̰� ��ȿ�Ѱ����?? �ϰ� �׽�Ʈ �ϴ� �޼ҵ�
		mainView.panel.repaint(); //���α׸���

		mainView.scroll.validate();
		mainView.scroll.repaint();
		
		//��ũ���� ���ϴ����� ���߱�
		mainView.scroll.getVerticalScrollBar().setValue(mainView.scroll.getVerticalScrollBar().getMaximum());

	}

	private void setAllBounds() {
		int len = mainView.menuList.size();
		
		for (int i = 0; i < len; i++) {
			mainView.menuList.get(i).setBounds(1, i*88, 965, 88);
		}
		
	}

}
