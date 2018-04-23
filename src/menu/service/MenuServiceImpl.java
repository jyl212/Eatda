package menu.service;

import java.util.ArrayList;
import java.util.Vector;

import dto.MenuDTO;
import menu.dao.MenuDAO;
import menu.dao.MenuDAOImpl;
import menu.view.Menu;

public class MenuServiceImpl implements MenuService {

	@Override
	public Vector<Vector<String>> getNameANDNoByReserNO(int reserNo) {
		MenuDAO dao = new MenuDAOImpl();
		return dao.getNameANDNoByReserNO(reserNo);
	}

	@Override
	public Vector<Vector<String>> getNameANDNo(String restID) {
		MenuDAO dao = new MenuDAOImpl();
		return dao.getNameANDNo(restID);
	}
	
	@Override
	public int menuInsert(ArrayList<Menu> menulist, String restID) {
		int rowNum = 0;
		MenuDTO dto = null;
		MenuDAO dao = new MenuDAOImpl();
		for (int i = 0; i < menulist.size(); i++) {
			Menu menu = menulist.get(i);
			dto = new MenuDTO(0, restID, menu.txt_menuName.getText(), Integer.parseInt(menu.txt_menuPrice.getText()), 
								menu.txt_menuDetail.getText(), menu.txt_menutype.getText(), menu.txtMenuImgRoute.getText());
			rowNum += dao.menuInsert(dto);
		}
		
		return rowNum;
	}

	@Override
	public ArrayList<Menu> menuSelectFindByRestId(String restID) {
		MenuDAO dao = new MenuDAOImpl();
		Vector<MenuDTO> menulist = dao.menuSelectFindByRestId(restID); //레스토랑에 메뉴들을 디비에서 전부 받아서 나옴!
		ArrayList<Menu> menules = null;
		MenuDTO dto = null;
		Menu menu = null;
		
		if(menulist != null){
			menules = new ArrayList<Menu>();
			for (int i = 0; i < menulist.size(); i++) {
				dto = menulist.get(i); 
				menu = new Menu(dto.getMenuNo(),dto.getRestId(),dto.getMenuName(),dto.getMenuPrice(),
								dto.getMenuDetail(),dto.getMenuType(),dto.getMenuImg());
				
				menules.add(menu);//ArrayList<Menu> 완성한다!
			}
		}
		return menules;//넘겨줌!!
	}

	@Override
	public int menuUpdate(ArrayList<Menu> menus, ArrayList<Menu> deleteMenus, String restID) {
		int rowNum = 0;
		MenuDAO dao = new MenuDAOImpl();
		
		if(deleteMenus != null){
			for (int i = 0; i < deleteMenus.size(); i++) {
				rowNum += dao.menuDelete(deleteMenus.get(i).getMenuNo());
			}
		}
		
		int menuNo = 0;
		Menu menu = null;
		
		for (int i = 0; i < menus.size(); i++) {
			menu = menus.get(i);
			menuNo = menu.getMenuNo();
			if(menuNo == 0) {
				MenuDTO dto1 = new MenuDTO(0, 
						restID, 
						menu.txt_menuName.getText(), 
						Integer.parseInt(menu.txt_menuPrice.getText()), 
						menu.txt_menuDetail.getText(), 
						menu.txt_menutype.getText(),
						menu.txtMenuImgRoute.getText());
				rowNum += dao.menuInsert(dto1);
			}else {
				MenuDTO dto2 = new MenuDTO(
						menu.getMenuNo(), 
						restID, 
						menu.txt_menuName.getText(), 
						Integer.parseInt(menu.txt_menuPrice.getText()), 
						menu.txt_menuDetail.getText(), 
						menu.txt_menutype.getText(),
						menu.txtMenuImgRoute.getText());
				rowNum += dao.menuUpdate(dto2);
			}
			
			
		}
		return rowNum;
	}

}
