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
		if (e.getSource() == mainView.btnpre){ //이전단계
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "tableInsert");
		} else if (e.getSource() == mainView.btnmenuplus){//메뉴추가
			Menu menuPlus = new Menu();
			mainView.panel.add(menuPlus);
			mainView.menuList.add(menuPlus);
			
			setAllBounds();
			
			paintPanel();
			
		} else if(e.getSource()== mainView.btndelete){//메뉴삭제 체크박스 적용 시켜서 어떻게 없애야될까나...? 아무리 찾아봐도 못하겠음..ㅠ

			int len = mainView.menuList.size();//어레이리스트안에 들어있는 메뉴플러스!
			int i = 0;//초기화
			
			while ( i < len) {
				Menu menuPlus = mainView.menuList.get(i);//어레이리스트에 i번째 메뉴플러스를 가져온다
				if (menuPlus.chkmenu.isSelected()) {
					mainView.menuList.remove(i);
					i=0;
					len = mainView.menuList.size();
					continue;
				}
				i++;
			}
				
			setAllBounds();
			
			//몽땅 지우고
			mainView.panel.removeAll();
			
			//다시 패널 추가
			len = mainView.menuList.size();
			
			for (int j = 0; j < len; j++) {
				mainView.panel.add(mainView.menuList.get(j));
			}
			
			paintPanel();
			
		} else if (e.getSource() == mainView.btn_commit) {
			RestService restService = new RestServiceImpl();
			TableService tableService = new TableServiceImpl();
			MenuService menuservice = new MenuServiceImpl();
			//메뉴 서비스 생성
			
			restService.restInsert(mainView.restInfo);
			tableService.TableInsert(mainView.tables, mainView.restInfo.getRestId());
			menuservice.menuInsert(mainView.menuList, mainView.restInfo.getRestId());
			//메뉴 추가하기
			
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "logInPage");
		}

	}

	private void paintPanel() {

		mainView.panel.setPreferredSize(new Dimension(965, mainView.menuList.size()*88));//setPreferredSize 엄마패널 사이즈 고정 -> Dimension크기관리

		mainView.panel.validate(); //이게 유효한가요오?? 하고 테스트 하는 메소드
		mainView.panel.repaint(); //새로그리기

		mainView.scroll.validate();
		mainView.scroll.repaint();
		
		//스크롤을 최하단으로 맞추기
		mainView.scroll.getVerticalScrollBar().setValue(mainView.scroll.getVerticalScrollBar().getMaximum());

	}

	private void setAllBounds() {
		int len = mainView.menuList.size();
		
		for (int i = 0; i < len; i++) {
			mainView.menuList.get(i).setBounds(1, i*88, 965, 88);
		}
		
	}

}
