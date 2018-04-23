package menu.dao;

import java.util.Vector;

import dto.MenuDTO;

public interface MenuDAO {
	Vector<Vector<String>> getNameANDNoByReserNO (int reserNo);
	Vector<Vector<String>> getNameANDNo (String restID);
	int menuInsert (MenuDTO dto);
	Vector<MenuDTO> menuSelectFindByRestId(String restId);
	int menuUpdate(MenuDTO dto);
	int menuDelete (int menuNo);
}
