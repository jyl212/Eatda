package pos.service;

import java.util.Vector;

import dto.MenuDTO;
import reservation.dao.ReservationDAO;
import reservation.dao.ReservationDAOImpl;

public class OrderMenuEditServiceImple implements OrderMenuEditService{

	@Override
	public int countMenuType(String restId) {
		ReservationDAO dao=new ReservationDAOImpl();
		int count=dao.countMenuType(restId);
		return count;
	}

	@Override
	public Vector<MenuDTO> select(String restId,String menuType) {
		ReservationDAO dao=new ReservationDAOImpl();
		Vector<MenuDTO> v=dao.select(restId,menuType);
		return v;
	}
	@Override
	public Vector<String> selectMenuType(String restId) {
		ReservationDAO dao=new ReservationDAOImpl();
		Vector<String> v=dao.selectMenuType(restId);
		return v;
	}

	@Override
	public int countMenuDetail(String restId, String menuType) {
		ReservationDAO dao=new ReservationDAOImpl();
		int count=dao.countMenuDetail(restId,menuType);
		return count;
	}

	@Override
	public int menuNoSelect(String restId, String menuName) {
		ReservationDAO dao=new ReservationDAOImpl();
		int menuid=dao.menuNoSelect(restId, menuName);
		return menuid;
	}

	@Override
	public Vector<Vector<String>> selectTableInfo(String restId) {
		ReservationDAO dao=new ReservationDAOImpl();
		Vector<Vector<String>> vvs=dao.selectTableInfo(restId);
		return vvs;
	}

}
