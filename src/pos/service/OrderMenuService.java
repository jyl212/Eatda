package pos.service;

import java.util.Vector;

import dto.MenuDTO;

public interface OrderMenuService {
	int countMenuType(String restId);
	Vector<MenuDTO> select(String restId,String menuType);
	Vector<String> selectMenuType(String restId);
	int countMenuDetail(String restId,String menuType);
	int menuNoSelect(String restId,String menuName);
	Vector<Vector<String>> selectTableInfo(String restId);
}
