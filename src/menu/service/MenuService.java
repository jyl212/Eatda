package menu.service;
import java.util.ArrayList;
import java.util.Vector;

import dto.MenuDTO;
import menu.view.Menu;

public interface MenuService {
	Vector<Vector<String>> getNameANDNoByReserNO (int reserNo);
	Vector<Vector<String>> getNameANDNo (String restID);
	int menuInsert(ArrayList<Menu> menulist, String restID);

	ArrayList<Menu> menuSelectFindByRestId (String restID);
	
	int menuUpdate(ArrayList<Menu> menus, 
			ArrayList<Menu> deleteMenus, 
			String restID);
	
}
